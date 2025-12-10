package service;

import java.util.*;
// import models.Expense;
import models.*;
// import models.FoodExpense;
// import models.TravelExpense;
// import models.ShoppingExpense;

public class ExpenseManager {

    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense exp) {
        expenses.add(exp);
    }

    public void showExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet!");
            return;
        }

        System.out.println("\n--- All Expenses ---");
        for (Expense e : expenses) {
            System.out.println(e.getDetails());
        }
    }

    public void showSummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses available for summary.");
            return;
        }

        double total = 0;
        Map<String, Double> map = new HashMap<>();

        for (Expense e : expenses) {
            total += e.getAmount();
            map.put(e.getCategory(), map.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }

        System.out.println("\n--- Monthly Summary ---");
        System.out.println("Total Spending: " + total);

        for (String category : map.keySet()) {
            System.out.println(category + ": " + map.get(category));
        }

        System.out.println("\n--- Smart Suggestions ---");
        if (map.getOrDefault("Food", 0.0) > total * 0.4)
            System.out.println("⚠ Try reducing Food expenses.");

        if (map.getOrDefault("Travel", 0.0) > total * 0.3)
            System.out.println("⚠ Travel expenses are on the higher side.");

        if (map.getOrDefault("Shopping", 0.0) > total * 0.2)
            System.out.println("⚠ Reduce unnecessary shopping to save more.");
    }
}

