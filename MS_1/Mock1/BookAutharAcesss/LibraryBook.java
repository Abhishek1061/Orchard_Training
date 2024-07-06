package Java.Mock1.BookAutharAcesss;

public public class LibraryBook {

    private String bookTitle;
    private String bookAuthor;
    private int publishYear;
    private boolean isAvailable = true;

    
    public LibraryBook(String bookTitle, String bookAuthor, int publishYear) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.publishYear = publishYear;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
    public int getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean checkAvailability(){
        return isAvailable;
    }

    public void borrowBook(){
        isAvailable = false;
   
    }

    public void returnBook(){
        isAvailable = true;

    }

    // implement the library book class here
    
} 