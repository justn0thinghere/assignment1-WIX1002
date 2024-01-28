
package wix1002_2016_ii_1;

import java.util.Scanner;

public class Wix1002_2016_II_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number in pounds: ");
        double pound = input.nextDouble();
        double kilogram = pound * 0.454;
        System.out.printf("%.3f pounds is %.3f kilograms",pound,kilogram);
    }
    
}
