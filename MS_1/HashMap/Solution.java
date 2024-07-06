import java.io.*;
import java.util.*;
import java.lang.Math;


public class Solution {
     Scanner sc = new Scanner(System.in);
    public void demo() {
        // Write your code here
        Map<Integer, Integer> hashMap = new HashMap<>();

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int key = i+1;
            int value = sc.nextInt();
            hashMap.put(key, value);
        }

        int checkKey = sc.nextInt();

        if(hashMap.containsKey(checkKey)){
            System.out.println(checkKey + "-->" + hashMap.get(checkKey));
        }else{
            System.out.println("-1");
        }

        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }

    public static void main(String[] args) {
       Solution sol=new Solution();
       sol.demo();
    
    }
}