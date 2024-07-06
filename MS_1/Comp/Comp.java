package Java.Comp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class TourPackage implements Comparable<TourPackage> {
    int packageID;
    String destination;
    float price;

    public TourPackage(int packageID, String destination, float price) {
        this.packageID = packageID;
        this.destination = destination;
        this.price = price;
    }

    public int compareTo(TourPackage tp) {
        return destination.compareTo(tp.destination);
    }
}

class comparePrice implements Comparator<TourPackage> {
    public int compare(TourPackage o1, TourPackage o2) {
        TourPackage t1 = (TourPackage) o1;
        TourPackage t2 = (TourPackage) o2;
        if (t1.price == t2.price) {
            return 0;
        } else if (t1.price > t2.price) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Comp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<TourPackage> arr = new ArrayList<TourPackage>();
        System.out.println("Enter the no of tour package:");
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            System.out.println("Enter package Id:");
            int packageID = sc.nextInt();
            System.out.println("Enter Destination:");
            sc.nextLine();
            String destination = sc.nextLine();
            System.out.println("Enter price:");
            float price = sc.nextFloat();
            TourPackage tp = new TourPackage(packageID, destination, price);
            arr.add(tp);
        }
        Collections.sort(arr);
        Iterator<TourPackage> it = arr.iterator();
        System.out.println("Sorting by comparable method:");
        while (it.hasNext()) {
            TourPackage tp = (TourPackage) it.next();
            System.out.println("Package Id:" + tp.packageID);
            System.out.println("Destination:" + tp.destination);
            System.out.println("Price:" + tp.price);
        }
        Collections.sort(arr, new comparePrice());
        Iterator<TourPackage> it1 = arr.iterator();
        System.out.println("Sorting by Comparator method");
        while (it1.hasNext()) {
            TourPackage tp = (TourPackage) it1.next();
            System.out.println("Package Id:" + tp.packageID);
            System.out.println("Destination:" + tp.destination);
            System.out.println("Price:" + tp.price);
        }
    }
}
