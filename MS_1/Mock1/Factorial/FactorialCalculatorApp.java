

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FactorialCalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter an integer: ");
                    int n = scanner.nextInt();
                    System.out.println("Factorial of " + n + " is " + calculateFactorial(n));
                    break;

                case 2:
                    System.out.print("Enter an integer: ");
                    int n1 = scanner.nextInt();
                    Map<Integer, Long> map = getFactorialSequence(n1);

                    for(Map.Entry<Integer,Long> entr : map.entrySet()){
                         System.out.println("Factorial of " + entr.getKey() + " is " + entr.getValue());
                    }
                    break;

                    

                case 3:
                    System.out.print("Enter an integer: ");
                    int n2 = scanner.nextInt();
                    System.out.println("Sum of factorials up to " + n2 + " is: " + calculateFactorialSum(n2) );

                case 4:
                    System.out.print("Enter the first integer (m): ");
                    int m = scanner.nextInt();
                    System.out.print("Enter the second integer (n): ");
                    int n3 = scanner.nextInt();

                    System.out.println(m+"! / " + n3 + "! = " + calculateFactorialDivision(m,n3));

                case 5:
                    
                    System.out.println("Goodbye!");
                    scanner.close();
                    break;

                    

                // complete the implementation here and call below given function respectively
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Calculate Factorial");
        System.out.println("2. Factorial Sequence");
        System.out.println("3. Factorial Sum");
        System.out.println("4. Factorial Division");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static long calculateFactorial(int n) {

        // calculate factorial

        int factorial = 1;
        
        for(int i = 1; i<=n; i++){
            factorial = factorial * i;

        }
          return factorial;
    }

    public static Map<Integer, Long> getFactorialSequence(int n) {
        // calculate factorial sequence and return map
        // key is number and value is factorial of that number
    

        // Map<Integer, Long> map = new HashMap<>();
        
        
        // for(int i = 1; i<=n; i++){
            
        //     map.put(i, calculateFactorial(i));
            

        // }
        //   return map;

            Map<Integer, Long> map = new HashMap<>();

            for(int i = 1; i<=n; i++){
                map.put(i, calculateFactorial(i));
            }

            return map;

















    }

    public static long calculateFactorialSum(int n) {
        // calculate factorial sum
        // int factorial = 1;
        int sum = 0;
        for(int i = 1; i<=n; i++){
            
            sum += calculateFactorial(i);

        }
          return sum;
    }

    public static double calculateFactorialDivision(int m, int n) {
        double div = 0.0;
        // 1: throw new IllegalArgumentException when input m or n is incorrect to calculate factorial division
            if(m < 0 || n < 0 || m < n){
                throw new IllegalArgumentException("Enter the correct number.");
            }else{
                div = calculateFactorial(m)/ calculateFactorial(n);
                
            }
        // 2:  calculate factorial division

        return div;
    }
}
