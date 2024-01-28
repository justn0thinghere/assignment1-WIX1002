
package wix1002_2017_i_4;

import java.util.Scanner;

public class Wix1002_2017_I_4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("First complex number. Enter a number for the real part: ");
        double a1 = input.nextDouble();
        System.out.print("First complex number. Enter a number for the imaginary part: ");
        double a2 = input.nextDouble();
        System.out.print("Second complex number. Enter a number for the real part: ");
        double b1 = input.nextDouble();
        System.out.print("Second complex number. Enter a number for the imaginary part: ");
        double b2 = input.nextDouble();
        Complex num1 = new Complex(a1,a2);
        Complex num2 = new Complex(b1,b2);
        System.out.println("First complex number: " + num1.toString());
        System.out.println("Second complex number: " + num2.toString());
        num1.addComplexNum(num2);
        num1.subtractComplexNum(num2);
    }
    
}
