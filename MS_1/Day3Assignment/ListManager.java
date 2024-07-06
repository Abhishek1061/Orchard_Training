import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManager {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Read integers from the user
        System.out.println("Enter integers (enter -1 to stop):");
        while (true) {
            try {
                int num = scanner.nextInt();
                if (num == -1) {
                    break;
                }
                if (!numberList.contains(num)) {
                    numberList.add(num);
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        // Print the final list without duplicates
        System.out.println("Final list without duplicates:");
        System.out.println(numberList);

        // Search and update the list
        System.out.print("Enter an integer to search: ");
        try {
            int searchNum = scanner.nextInt();
            if (numberList.contains(searchNum)) {
                numberList.remove(Integer.valueOf(searchNum));
                System.out.println(searchNum + " removed from the list.");
            } else {
                numberList.add(searchNum);
                System.out.println(searchNum + " added to the list.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer.");
        }

        // Print the updated list
        System.out.println("Updated list:");
        System.out.println(numberList);
    }
}
