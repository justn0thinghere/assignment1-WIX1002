
package wix1002_2016_ii_3;

import java.util.Scanner;

public class Wix1002_2016_II_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines(1-15): ");
        int lines = input.nextInt();
        if(lines>=1&&lines<=15){
            for(int i = 1;i<=lines;i++){
                int length = 2*lines-1;
                for(int x = lines;x>i;x--){
                    System.out.print("  ");
                }
                for(int x = i;x>1;x--){
                    System.out.print(x + " ");
                }
                for(int x = 1;x<=i;x++){
                    System.out.print(x + " ");
                }
                for(int x = i+1;x<=length;x++){
                    System.out.print("  ");
                }
                System.out.println("");
            }  
        }else{
            System.out.println("Invalid number");
        }
    }
    
}
