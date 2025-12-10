import java.util.Scanner;

import models.FoodExpense;
import models.ShoppingExpense;
import models.TravelExpense;
import service.ExpenseManager;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n===== Smart Expense Optimizer =====");
            System.out.println("1. Add Expense");
            System.out.println("2. Show All Expenses");
            System.out.println("3. Show Summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category (food/travel/shopping): ");
                    String category = sc.nextLine().toLowerCase();

                    System.out.print("Enter date (DD/MM/YYYY): ");
                    String date = sc.nextLine();

                    switch (category) {
                        case "food":
                            manager.addExpense(new FoodExpense(amount, date));
                            break;
                        case "travel":
                            manager.addExpense(new TravelExpense(amount, date));
                            break;
                        case "shopping":
                            manager.addExpense(new ShoppingExpense(amount, date));
                            break;
                        default:
                            System.out.println("Invalid category!");
                    }
                    break;

                case 2:
                    manager.showExpenses();
                    break;

                case 3:
                    manager.showSummary();
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
