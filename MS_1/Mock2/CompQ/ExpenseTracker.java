package Java.Mock2.CompQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseTracker {

    private List<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        // add expense to the list
        expenses.add(expense);
    }

    public List<Expense> getExpensesSortedByCategory() {
        // get expenses sorted by name
        Collections.sort(expenses);
        return expenses;
    }

    public List<Expense> getExpensesSortedByAmount() {
        // get expenses sorted by amount
        Expense exp  = new Expense();
        expenses.sort(exp);
        return expenses;
    }
}
 