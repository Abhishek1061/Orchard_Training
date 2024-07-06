package Java.Day1Assignment;

import java.util.Scanner;

public class SubscriptionChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Subscription Checker!");
        System.out.println("Enter the number of days left until the internet subscription ends and it should be between 0 to 30:");

        int daysLeft = sc.nextInt();
        if(daysLeft > 0 && daysLeft <= 30){
            if(daysLeft == 0){
                System.out.println("Your subscription has ended. Please renew.");
            }
            else if(daysLeft > 0 && daysLeft <= 5){
                System.out.println("Your subscription is about to end. Please consider renewing.");
            }else if (daysLeft > 5){
                System.out.println("Your subscription is active.");
            }
        }else{
            System.out.println("Invaild Input");
        }
        System.out.println("Goodbye!");
    }
}
