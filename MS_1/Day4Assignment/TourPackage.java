package Java.Day4Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class TourPackage implements Comparable<TourPackage> {
    int packageId;
    String destination;
    double price;

    static Scanner sc = new Scanner(System.in);
    ArrayList<TourPackage> arrList = new ArrayList<>();

    public void getData() {
        System.out.print("Enter the Number of Input: ");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            TourPackage tp = new TourPackage();
            System.out.print("Enter package Id: ");
            tp.packageId = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter destination name: ");
            tp.destination = sc.next();
            System.out.print("Enter price of package: ");
            tp.price = sc.nextDouble();
            
            arrList.add(tp);
            sc.nextLine();

        }
    }

    public void printDetails(ArrayList<TourPackage> arrayList) {
        for (TourPackage tp : arrayList) {
            System.out.println("Package Id: " + tp.packageId);
            System.out.println("Package Desitnation: " + tp.destination);
            System.out.println("Package Price: " + tp.price);
        }
    }

    public static void displaySortByDestination(ArrayList<TourPackage> arrayList) {
        System.out.println("***List sorted on the basis of Destination***");
        Collections.sort(arrayList);

        Iterator<TourPackage> itr = arrayList.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Override
    public int compareTo(TourPackage o) {

        return this.destination.compareToIgnoreCase(o.destination);
    }

    public static void displaySortByPrice(ArrayList<TourPackage> arrayList) {
        System.out.println("***List sorted on the basis of Salary***");
        Collections.sort(arrayList, new SortByPrice());

        Iterator<TourPackage> itr = arrayList.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Override
    public String toString(){
        return "Package Id: " + packageId + ", " +  "Package Destination: " + destination + ", " +  "Package price: " + price;
    }

    public static void main(String[] args) {
        TourPackage tp = new TourPackage();

        tp.getData();
        tp.printDetails(tp.arrList);
        displaySortByDestination(tp.arrList);
        displaySortByPrice(tp.arrList);
    }

}

class SortByPrice implements Comparator<TourPackage> {

    @Override
    public int compare(TourPackage tp1, TourPackage tp2) {

        if (tp1.price == tp2.price) {
            return 0;
        } else if (tp1.price > tp2.price) {
            return 1;
        } else {
            return -1;
        }
    }

}
