import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    String description;
    double amount;
    String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
}

class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(String description, double amount, String category) {
        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);
    }

    public void displayExpenses() {
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.description);
            System.out.println("Amount: $" + expense.amount);
            System.out.println("Category: " + expense.category);
            System.out.println("--------------------------");
        }
    }

    public double calculateTotalExpenses() {
        double totalExpenses = 0;
        for (Expense expense : expenses) {
            totalExpenses += expense.amount;
        }
        return totalExpenses;
    }

    // Add more methods for category-wise expenses, time period summaries, etc. as needed.
}

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Expense Description: ");
                    scanner.nextLine(); // Consume the newline character left by nextInt()
                    String description = scanner.nextLine();
                    System.out.print("Enter Expense Amount: $");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter Expense Category: ");
                    String category = scanner.next();
                    expenseTracker.addExpense(description, amount, category);
                    System.out.println("Expense added successfully!");
                    break;
                case 2:
                    expenseTracker.displayExpenses();
                    break;
                case 3:
                    System.out.println("Total Expenses: $" + expenseTracker.calculateTotalExpenses());
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
