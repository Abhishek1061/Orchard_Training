import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PacticeHashMap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String > hm = new HashMap<>();

        hm.put(1, "Abhi");
        hm.put(2, "Prasad");
        hm.put(3, "Vedanti");

    

    
        Iterator<Map.Entry<Integer, String>> itr = hm.entrySet().iterator();
        System.out.println("ENter the check key value: ");
        int checkKey  = sc.nextInt();

        boolean isKeyPresent = false;

        while(itr.hasNext()){
            Map.Entry<Integer, String> map  = itr.next();
            if(checkKey == map.getKey()){
                isKeyPresent = true;
            }
            
        }
    
        System.out.println("Entered key " + checkKey + ": " + isKeyPresent);    
    }
}
