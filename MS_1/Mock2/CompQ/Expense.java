package Java.Mock2.CompQ;

import java.util.Comparator;

public class Expense implements Comparable<Expense>, Comparator<Expense> {
    private int expenseID;
    private String category;
    private double amount;

    public Expense(){
        
    }
    public Expense(int expenseID, String category, double amount) {
        this.expenseID = expenseID;
        this.category = category;
        this.amount = amount;
    }
    public int getExpenseID() {
        return expenseID;
    }
    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public int compare(Expense arg0, Expense arg1) {
        
        return Double.compare(arg0.getAmount(), arg1.getAmount());
    }
    @Override
    public int compareTo(Expense o) {
        
        return this.category.compareTo(o.category);

    }

    // complete the implementation
    
}