package Java.Mock1_Practice;

public class Factorial {

    static int Factorial(int n) {
        int fact = 1;
        if (n == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) {

        // Choice1
        System.out.println(Factorial(6));

        // chocie2
        int n = 6;
        for(int i = 1; i<=n; i++){
            System.out.println("Factorial of " + i + " is "+ Factorial(i));
        }

        int n1 = 6;
        int sum = 0;
        for(int i = 1; i<=n1; i++){
            sum += Factorial(i);
        }
        
        System.out.println("the sum of Factorials till range form 1 to " + n1 + "is " + sum);
    }

}
