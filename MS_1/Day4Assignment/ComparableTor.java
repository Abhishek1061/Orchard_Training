package Java.Day4Assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class ComparableTor implements Comparable<ComparableTor>{
    int age;
    String name;
    ComparableTor(int age, String name){
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        ArrayList<ComparableTor> arr = new ArrayList<>();
        
        // sortByAge ag = new sortByAge();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enetrr num");
        int n = sc.nextInt();
        for(int i  = 0; i < n ; i ++){
            System.out.println("Eneter name");
            String name = sc.next();
            sc.nextLine();
            System.out.println("Eneter age");
            int age = sc.nextInt();
            ComparableTor cp  = new ComparableTor(age, name);
            arr.add(cp);
        }

        for( ComparableTor ctp : arr){
            System.out.println(ctp);
        }

        System.out.println("Sorted by Age");
        compareByAge(arr);

        System.out.println("Sort by name");
        compareByName(arr);


    }

    public static void compareByName(ArrayList<ComparableTor> arr){

        Collections.sort(arr);
        Iterator<ComparableTor> itr = arr.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        

    }

    public static void compareByAge(ArrayList<ComparableTor> arr){

        Collections.sort(arr, new sortByAge());
        Iterator<ComparableTor> itr = arr.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        

    }

    @Override
    public int compareTo(ComparableTor ctp){

        return this.name.compareToIgnoreCase(ctp.name);
    }

    @Override
    public String toString() {
        return "age=" + age + ", name=" + name;
    }

}

class sortByAge implements Comparator<ComparableTor>{

    @Override
    public int compare(ComparableTor ctr1, ComparableTor ctr2){

        if(ctr1.age == ctr2.age){
            return 0;
        }else if (ctr1.age > ctr2.age){
            return 1;
        }else{
            return -1;
        }
        
    }
}
