package Java.Day1Assignment;

import java.util.Scanner;

 class battleshipGame {

    private boolean[][] seaGrid;

    public battleshipGame(int size){
        seaGrid = new  boolean[size][size];
    }

    public void placeShip(int x, int y) {
        if (x < 0 || x >= seaGrid.length || y < 0 || y >= seaGrid[0].length) {
            System.out.println("Error: Coordinate out of bound.");
            return;

        }
        seaGrid[x][y] = true;
        System.out.println("Ship placed at (" + x + ", " + y + ").");

    }

    public boolean attack(int x, int y) {
        if (x < 0 || x >= seaGrid.length || y < 0 || y >= seaGrid[0].length) {
            System.out.println("Error: Coordinates out of bounds,");
            return false;
        }
        if (seaGrid[x][y]) {
            System.out.println("Hit at (" + x + ", " + y + ")!");
            return false;
        } else {
            System.out.println("Miss at (" + x + ", " + y + ").");
            return false;
        }
    }
 }
public class Main{

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        System.out.println("Enter the size of the sea grid: ");
        int size = sc.nextInt();
        battleshipGame game = new battleshipGame(size);

        game.placeShip(2, 3);
        game.placeShip(1, 1);
        game.placeShip(3, 4);

        game.attack(0, 0);
        game.attack(3, 3);
        game.attack(3, 3);
        sc.close();
        
    }
}

