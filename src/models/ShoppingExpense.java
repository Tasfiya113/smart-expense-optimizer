package models;

public class ShoppingExpense extends Expense {

    public ShoppingExpense(double amount, String date) {
        super(amount, "Shopping", date);
    }

    @Override
    public String getDetails() {
        return "Shopping Expense → Amount: " + getAmount() + " | Date: " + getDate();
    }
}
