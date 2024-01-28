
package wix1002_2017_i_5;

import java.util.Scanner;

public class Wix1002_2017_I_5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int grammar;
        int spelling;
        int length;
        int content;
        while(true){
            System.out.print("Enter the marks for Grammar (maximum 30 marks): " );
            grammar = input.nextInt();
            if(grammar<=30&&grammar>=0){
                break;
            }else{
                System.out.println("Invalid marks");
            }
        }
        while(true){
            System.out.print("Enter the marks for Spelling (maximum 20 marks): " );
            spelling = input.nextInt();
            if(spelling<=20&&spelling>=0){
                break;
            }else{
                System.out.println("Invalid marks");
            }
        }
        while(true){
            System.out.print("Enter the marks for Length (maximum 20 marks): " );
            length = input.nextInt();
            if(length<=20&&length>=0){
                break;
            }else{
                System.out.println("Invalid marks");
            }
        }
        while(true){
            System.out.print("Enter the marks for Content (maximum 30 marks): " );
            content = input.nextInt();
            if(content<=30&&content>=0){
                break;
            }else{
                System.out.println("Invalid marks");
            }
        }
        Essay e = new Essay(grammar,spelling,length,content);
        System.out.println(e.toString());
    }
    
}
