package Java.Day6Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDoperationMovie {
    Scanner sc = new Scanner(System.in);
    MovieBean mb = new MovieBean();

    void getData() {
        System.out.println("Enter the number of movie record you wanted to enter:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the movie name: ");
            // sc.next();
            mb.setMovieName(sc.next());
            System.out.println("Enter movie release date: ");
            mb.setMovieReleasedYear(sc.next());
            this.insertData();
        }

    }

    void insertData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AssignmentDay6", "root",
                    "root");

            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO Movies(MovieName,MovieReleasedYear) VALUES(?,?);");

            ps.setString(1, mb.getMovieName());
            ps.setString(2, mb.getMovieReleasedYear());

            int res = ps.executeUpdate();

            if (res > 0) {
                System.out.println("Insertion of movie sucessfull");
            } else {
                System.out.println("Insertion failed!");
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

    void retireveData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AssignmentDay6", "root",
                    "root");

            PreparedStatement ps = connection.prepareStatement(
                    " SELECT  MovieId,MovieName,MovieReleasedYear FROM Movies WHERE YEAR(MovieReleasedYear) = ?;");
            System.out.println("Enter the year for getting the list of movies: ");
            String year = sc.next();
            ps.setString(1, year);
            ResultSet res = ps.executeQuery();

            while (res.next()) {

                System.out.println("Movie Id:" + res.getInt("MovieId"));
                System.out.println("Movie Name:" + res.getString("MovieName"));
                System.out.println("Movie Year:" + res.getString("MovieReleasedYear"));
                System.out.println("********Next record*******");

            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

    public static void main(String[] args) {
        CRUDoperationMovie cd = new CRUDoperationMovie();
        System.out.println("Enter the choice: \n 1 - Insert \n 2 - Retrive");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                cd.getData();
                // cd.insertData();
                break;
            case 2:
                cd.retireveData();
                break;
            default:
                System.out.println("Number entered is out of range!");
                break;
        }

    }
}
