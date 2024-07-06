package Java.Comp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

public class Compe implements Comparable<Compe>, Comparator<Compe> {
    Scanner sc = new Scanner(System.in);

    int id ;
    String name; 
    double salary;

    public Compe(int id, String name, double salary){
        this.id  = id;
        this.name = name;
        this.salary = salary;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Compe(){

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Compe> arr = new ArrayList<Compe>();

        System.out.println("ENter the number of records:");
        int n =  sc.nextInt();
        for(int i = 0;  i<n; i++){
            int id = sc.nextInt();
            String name = sc.next();
            double salary = sc.nextDouble();
            Compe com = new Compe(id, name, salary);
            arr.add(com);
        }

        System.out.println(arr);

        Collections.sort(arr);
        
        System.out.println("Sorted by name");
        System.out.println(arr);

        Compe  com  = new Compe();
        arr.sort(com);
        System.out.println("Sorted by slary");
        System.out.println(arr);
    }

    @Override
    public int compareTo(Compe e){
        // 
        
        return this.name.compareTo(e.name);
        
        // return String.compareTo(this.name, e.name);
        

    }

    @Override
    public int compare(Compe arg0, Compe arg1) {
        
        // if(arg0.salary == arg1.salary){
        //     return 0;
        // }else if(arg0.salary > arg1.salary){
        //     return 1;
        // }else{
        //     return -1;
        // }

        return Double.compare(arg1.getSalary(), arg0.getSalary());
    }

    @Override
    public String toString() {
        return "Compe [" + id + name + salary + "]";
    }

    
    
}

// class sortBySalar implements Comparator<Compe>{

//     @Override
//     public int compare(Compe arg0, Compe arg1) {
//         // TODO Auto-generated method stub
//         if(arg0.salary == arg1.salary){
//             return 0;
//         }
//     }


