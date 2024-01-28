
package wix1002_2018_i_2;
import java.util.Random;
import java.util.Scanner;

public class Wix1002_2018_I_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = 0;
        int AA = 0;
        int AAA = 0;
        Random r = new Random();
        System.out.print("Enter N number: ");
        int N = input.nextInt();
        System.out.print("The random numbers are: ");
        for(int i = 0;i<N;i++){
            int num = r.nextInt(101)+50;
            System.out.print(num + " ");
            if(num%10<=3){
                AAA++;
            }else if(num%10<=6){
                AA++;
            }else{
                A++;
            }
        }
        System.out.println("\nGroup AAA: " + AAA);
        System.out.println("Group AA: " + AA);
        System.out.println("Group A: " + A);
    }
    
}
