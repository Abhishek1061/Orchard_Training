
public class LibraryBookApplication {

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);

        // Task1: append the book title below in given line
        System.out.println("Book 1 Title: " + book1.getBookTitle()); // get book title here);

        // Task2: append the book author below in given line
        System.out.println("Book 1 Author: " + book1.getBookAuthor());// get book author here);

        // Task3: append the book publish year below in given line
        System.out.println("Book 1 Publish year: " + book1.getPublishYear());// get book publish year);

        // Task4: append the book availablity below in given line
        System.out.println("Book 1 availability: " + book1.checkAvailability());// get book availablity here);

        // Task5: borrow book in below line

        book1.borrowBook();

        // Task6: append the book availablity below in given line
        System.out.println("Book 1 availability: " + book1.checkAvailability());// get book availablity here);

        // Task7: return book in below line
        book1.returnBook();

        // Task8: append the book availablity below in given line
        System.out.println("Book 1 availability: " + book1.checkAvailability() );// get book availablity here);
    }
}
