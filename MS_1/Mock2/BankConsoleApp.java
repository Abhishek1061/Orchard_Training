package Java.Mock2;


import java.util.HashMap;
import java.util.Scanner;

public class BankConsoleApp {
    public static HashMap<String, Double> accountDetails = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        accountDetails.put("Abhi", 1000.0);
        accountDetails.put("Suraj", 2000.0);

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // complete the implementation here and call below given function repectively
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNo = scanner.next();
                    System.out.println("Account balance: " + getAccountBalance(accountNo));
                    break;

                case 2:
                    System.out.print("Enter source account number: ");
                    String str1 = scanner.next();                    
                    System.out.print("Enter destination account number: ");
                    String str2 = scanner.next();
                    System.out.println("Enter amount to transfer: " );
                    double amount = scanner.nextDouble();

                    if(performFundTransfer(str1, str2, amount) == true){
                        System.out.println("Funds transferred successfully");
                    }else{
                        System.out.println("Fund transferred failed");
                    }
                    break;

                case 3:
                    System.out.print("Enter account details: ");
                    String acountDetails = scanner.next();
                    System.out.println("Converted details to upper case: " + convertToUpperCase(acountDetails) );
                    break;
                case 4:
                    System.out.print("Enter account details: ");
                    String acountDetails1 = scanner.next();
                    System.out.println("Converted details to lower case: " + convertToLowerCase(acountDetails1) );
                    break;
                    
                case 5:
                    System.out.println("Goodbye!");
                    break;
                    


            }

        } while (choice != 5);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Account Balance Inquiry");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Convert Account Details to Upper Case");
        System.out.println("4. Convert Account Details to Lower Case");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static double getAccountBalance(String accountNumber) {
        // retrun account balance.
        // return 0.0 if account not found
       if(accountDetails.containsKey(accountNumber)){
            return accountDetails.get(accountNumber);
       }else{
            return 0.0;
       }
        
    }

    public static boolean performFundTransfer(String sourceAccount, String destinationAccount, double amount) {

        if(accountDetails.containsKey(destinationAccount) && accountDetails.containsKey(sourceAccount) && accountDetails.get(sourceAccount) >= amount){

            double transfer = accountDetails.get(sourceAccount) - amount;
            double transferred = accountDetails.get(destinationAccount) + amount;
            accountDetails.replace(sourceAccount, transfer);
            accountDetails.replace(destinationAccount, transferred);
            return true;
        }
        else{
            return false;
        }
        // perform fund transfer  
    }

    public static String convertToUpperCase(String accountDetailsInput) {
        // convert to upper case
        return accountDetailsInput.toUpperCase();
    }

    public static String convertToLowerCase(String accountDetailsInputToLower) {
        // convert to lower case
        return accountDetailsInputToLower.toLowerCase();
    }
}
