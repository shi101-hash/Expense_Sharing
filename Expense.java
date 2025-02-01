package com.example.Expense.Sharing;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "expenses")
public class Expense {
    @Id
    private String id;
    private String description;
    private double amount;
    private String paidBy; // User who paid
    private List<String> participants; // User IDs
    private Map<String, Double> splitAmount; // Who owes how much
}
