
package wix1002_2016_i_2;

import java.util.Random;
import java.util.Scanner;

public class Wix1002_2016_I_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        int pwin = 0;
        int cwin = 0;
        while(pwin<3&&cwin<3){
            System.out.print("Enter 1.Paper 2.Scissor 3.Rock: ");
            int x = input.nextInt();
            int ran = r.nextInt(3)+1;
            System.out.println("Player: " + psc(x) + "----- Computer: " + psc(ran));
            if(x!=ran && !psc(x).equals("Invalid number")){
                if(WL(psc(x),psc(ran))){
                    pwin++;
                    System.out.println("Player win "+ pwin + " time(s)");
                }else{
                    cwin++;
                    System.out.println("Computer win "+ cwin + " time(s)");
                }
            }
        }
        if(pwin > cwin){
            System.out.println("Player wins the game");
        }else{
            System.out.println("Computer wins the game");
        }
    }
    public static String psc(int a){
        if(a == 1){
            return "Paper";
        }else if(a==2){
            return "Scissor";
        }else if(a==3){
            return "Rock";
        }else{
            return "Invalid number";
        }
    }
    public static boolean WL(String a,String b){
        if(a.equals("Paper")&&b.equals("Scissor")){
            return false;
        }else if(a.equals("Scissor")&&b.equals("Rock")){
            return false;
        }else if(a.equals("Rock")&&b.equals("Paper")){
            return false;
        }else{
            return true;
        }
    }
}
