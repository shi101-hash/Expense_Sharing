package com.example.Expense.Sharing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserRepository userRepository;

    public Expense addExpense(Expense expense) {
        // Calculate how much each person owes
        double perPerson = expense.getAmount() / expense.getParticipants().size();
        Map<String, Double> splitAmount = new HashMap<>();

        for (String participant : expense.getParticipants()) {
            if (!participant.equals(expense.getPaidBy())) {
                splitAmount.put(participant, perPerson);
            }
        }
        expense.setSplitAmount(splitAmount);
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
