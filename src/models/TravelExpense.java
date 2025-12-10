package models;

public class TravelExpense extends Expense {

    public TravelExpense(double amount, String date) {
        super(amount, "Travel", date);
    }

    @Override
    public String getDetails() {
        return "Travel Expense → Amount: " + getAmount() + " | Date: " + getDate();
    }
}
