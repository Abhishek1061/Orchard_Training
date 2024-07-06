package Java.Mock2.CompQ;


import java.util.List;

public class FinancialManagementApp {

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();

        Expense expense1 = new Expense(1, "Utilities", 50.0);
        Expense expense2 = new Expense(2, "Food", 30.0);
        Expense expense3 = new Expense(3, "Transport", 20.0);

        expenseTracker.addExpense(expense1);
        expenseTracker.addExpense(expense2);
        expenseTracker.addExpense(expense3);

        System.out.println("Expenses sorted by category");
        List<Expense> sortedByCategory = expenseTracker.getExpensesSortedByCategory();
        for (Expense expense : sortedByCategory) {
            System.out.println("ExpenseID: " + expense.getExpenseID() +
                    ", Category: " + expense.getCategory() +
                    ", Amount: " + expense.getAmount());
        }

        System.out.println("Expenses sorted by amount");
        List<Expense> sortedByAmount = expenseTracker.getExpensesSortedByAmount();
        for (Expense expense : sortedByAmount) {
            System.out.println("ExpenseID: " + expense.getExpenseID() +
                    ", Category: " + expense.getCategory() +
                    ", Amount: " + expense.getAmount());
        }
    }
}
