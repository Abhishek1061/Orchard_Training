
import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            
            System.out.print("Enter the first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter the second number: ");
            int num2 =  sc.nextInt();

           
            int result = num1 / num2;
            System.out.println("Result of division: " + result);

        }
        catch(ArithmeticException ae){
            System.out.println("Error! Entered number is divided by zero");
        }catch(NumberFormatException nfe){
            System.out.println("Please enter valid numeric values.");
        }catch(Exception ex){
            System.out.println("Please enter appropriate values");
        }
    }
}
