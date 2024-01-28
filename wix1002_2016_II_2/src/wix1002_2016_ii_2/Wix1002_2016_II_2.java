
package wix1002_2016_ii_2;

import java.util.Scanner;

public class Wix1002_2016_II_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000: ");
        int total = 0;
        int num = input.nextInt();
        if(num>=0 &&num<=1000){
            while(num>0){
                total+=num%10;
                num = num/10;
            }
            System.out.println("The sum of the digits is " + total);
        }else{
            System.out.println("Invalid number");
        }
        
    }
    
}
