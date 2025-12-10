package models;

public class FoodExpense extends Expense {

    public FoodExpense(double amount, String date) {
        super(amount, "Food", date);
    }

    @Override
    public String getDetails() {
        return "Food Expense → Amount: " + getAmount() + " | Date: " + getDate();
    }
}
