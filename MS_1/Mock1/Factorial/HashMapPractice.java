package Java.Mock1.Factorial;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class HashMapPractice {

    private static  Map<Integer,String> map = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        addData();
        printData();
        
    }
    
    public static void addData(){

        System.out.println("Enter the number of record to enter: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Enter the Key and values: ");
            int key = sc.nextInt();
        
            String value = sc.next();
            map.put(key, value);
        }

    }

    public static void printData(){
        System.out.println(map);
        
        

        for(Map.Entry<Integer, String> itr : map.entrySet()){
            
            System.out.println("Key: " + itr.getKey() + "  Vlaues: " + itr.getValue());
        }
    }

    static boolean checkKey(int checkKey){
        return map.containsKey(checkKey);
        // Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
        // while(itr.hasNext()){
        //     if(map.containsKey(checkKey)){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // 
    }
}
