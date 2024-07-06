package Java.Day1Assignment;

// import java.util.*;

import java.util.Scanner;

public class InsuranceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("____Menu____");
            System.out.println("Enter 1 : Premium Calculation");
            System.out.println("Enter 2 : Maturity Amount Calculation");
            System.out.println("Enter 3 : Convert Policy Details to Upper Case");
            System.out.println("Enter 4 : Convert Policy Details to Lower Case");
            System.out.println("Enter 5 : Exit");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter customers Age: ");
                    int age = sc.nextInt();
                    double premium = 0;
                    System.out.println("Enter Sum Assured: ");
                    double sumAssured = sc.nextDouble();
                    if (age < 25) {
                        premium = 0.05 * sumAssured;
                        // System.out.println("Premium amount is : " + premium);
                    } else if (age > 25 && age < 40) {
                        premium = 0.10 * sumAssured;
                        // System.out.println("Premium amount is : " + premium);
                    } else if (age > 40) {
                        premium = 0.20 * sumAssured;
                        // System.out.println("Premium amount is : " + premium);
                    }
                    System.out.println("Premium amount is : " + premium);
                    break;

                case 2:
                    System.out.println("Maturity Amount Calculation");
                    System.out.println("Enter the Premium Percentage: ");
                    double pre = sc.nextDouble();
                    System.out.println("Enter the term: ");
                    double term = sc.nextDouble();
                    System.out.println("Enter the Interest Rate: ");
                    double IR = sc.nextDouble();

                    double maturityAmount = (pre * term * (1 + (IR / 100)));
                    System.out.println("The maturity amount is : " + maturityAmount);
                    break;

                case 3:
                    System.out.println(" Convert Policy Details to Upper Case");
                    System.out.println("Enter the the Policy Details: ");
                    String policyDetails = sc.nextLine();
                    String upperCase = policyDetails.toUpperCase();
                    System.out.println("Policy in upper case: " + upperCase);
                    break;

                case 4:
                    System.out.println(" Convert Policy Details to Lower Case");
                    System.out.println("Enter the the Policy Details: ");
                    String policyDetailsLower = sc.nextLine();
                    String lowerCase = policyDetailsLower.toLowerCase();
                    System.out.println("Policy in Lower case: " + lowerCase);
                    break;

                case 5:
                    System.out.println("Goodbye");
                    sc.close();
                    break;
            }

        } while (choice != 5);
        System.out.print("Invalid Input");
        sc.close();

    }

}