
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookDirectory
{
    public static void insertData(Connection con,Books b) throws SQLException{
        PreparedStatement ps = con.prepareStatement("insert into Books(bookID,bookName,bookReleaseDate,bookAuthor) values(?,?,?,?)");
        ps.setInt(1,b.bookID);
        ps.setString(2,b.bookName);
        ps.setString(3,b.bookReleaseDate);
        ps.setInt(4, b.bookAuthor);
        ps.executeUpdate();
    }
    
    public static void searchBookByName(Connection con,String bookNameToSearch)throws SQLException{
        PreparedStatement ps = con.prepareStatement("select b.bookID,b.bookName,b.bookReleaseDate,b.bookAuthor,a.authorName from Books b join Author a on b.bookAuthor = a.authorID where b.bookName LIKE ?;");
        ps.setString(1,bookNameToSearch);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("------------------------");
            System.out.println("Book ID: "+rs.getString("bookID"));
            System.out.println("Book Name: "+rs.getString("bookName"));
            System.out.println("Book Release Date: "+rs.getString("bookReleaseDate"));
            System.out.println("Book Author ID: "+rs.getInt("bookAuthor"));
            System.out.println("Book Author Name: "+rs.getString("authorName"));
            System.out.println("------------------------");
        }
    }

    public static void showBooks(Connection con) throws SQLException{
        PreparedStatement ps = con.prepareStatement("select * from Books");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("------------------------");
            System.out.println("Book ID: "+rs.getString("bookID"));
            System.out.println("Book Name: "+rs.getString("bookName"));
            System.out.println("Book Release Date: "+rs.getString("bookReleaseDate"));
            System.out.println("Book Author ID: "+rs.getInt("bookAuthor"));
            System.out.println("------------------------");
        }
    }

    public static void showAuthors(Connection con) throws SQLException{
        PreparedStatement ps = con.prepareStatement("select * from Author");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("------------------------");
            System.out.println("Author ID: "+rs.getInt("authorID"));
            System.out.println("Author Name: "+rs.getString("authorName"));
            System.out.println("------------------------");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookDB","root","root");
            boolean isTrue = true;
            while(isTrue){
        System.out.println("1-> Insert Data");
        System.out.println("2-> Search By Book Name");
        System.out.println("3-> Show Available Books");
        System.out.println("4 -> Show Authors");
        System.out.println("5-> Exit");
        int choice = sc.nextInt();
        if(choice==1){
        System.out.println("Enter Book ID");
        int bookID = sc.nextInt();
        System.out.println("Enter Book Name");
        String bookName = sc.next();
        System.out.println("Enter Book Release Date");
        String bookReleaseDate = sc.next();
        System.out.println("Enter Author ID");
        int bookAuthor = sc.nextInt();
        Books b = new Books(bookID,bookName,bookReleaseDate,bookAuthor);
            insertData(con,b);
        }
        else if(choice==2){
            System.out.println("Enter the BookName to Search");
            String bookNameToSearch = sc.next();
            searchBookByName(con,bookNameToSearch);
        }else if(choice==3){
            showBooks(con);
        }else if(choice==4){
            showAuthors(con);
        }else if(choice==5){
            isTrue = false;
        }
    }
    }catch(ClassNotFoundException c){
        System.out.println(c);
    }catch(SQLException s){
        System.out.println(s);
    }
    }
}



class Books{
    int bookID;
    String bookName;
    String bookReleaseDate;
    int bookAuthor;
    
    public Books(int bookID,String bookName,String bookReleaseDate,int bookAuthor){
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookReleaseDate = bookReleaseDate;
        this.bookAuthor = bookAuthor;
    }
}



