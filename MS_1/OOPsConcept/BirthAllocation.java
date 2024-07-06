package Java.OOPsConcept;

import java.util.Scanner;

public class BirthAllocation {
    Scanner sc = new Scanner(System.in);
    CustomerDetails cd = new CustomerDetails();
    

    void getDetails(){
        System.out.println("Enter your Name: ");
        cd.setName(sc.nextLine());
        System.out.println("Enter your Gender: ");
        cd.setGender(sc.nextLine());
        System.out.println("Enter your Age: ");
        cd.setAge(sc.nextInt());
        System.out.println("Enter your Mobile Number: ");
        cd.setMobileNumber(sc.nextLong());
    }

    void printDetails(){
        System.out.println("Name : " + cd.getName());
        System.out.println("Gender : " + cd.getGender());
        System.out.println("Age : " + cd.getAge());
        System.out.println("Mobile Number : " + cd.getMobileNumber());
    }
    void BirthAllocationStatus(){
        CustomerDetails cd1 = new CustomerDetails();
        int age = cd1.getAge();
        String gender = cd1.getGender();
        if(age > 60){
            if(gender.equals("Male") || gender.equals("male")){
                System.out.println("Middle Birth Allocated");
            }else if ( gender.equals("female") || gender.equals("Female")){
                System.out.println("Lower Birth Allocated");
            }else{
                System.out.println("Upper Birth Allocated");
            }
        }else{
            System.out.println("Upper Birth Allocated");
        }
    }
    
    public static void main(String[] args) {
        BirthAllocation bA = new BirthAllocation();
        bA.getDetails();
        bA.printDetails();
        bA.BirthAllocationStatus();
    
    }
    
}
