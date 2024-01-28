
package wix1002_2016_ii_4;

import java.util.Scanner;

public class Wix1002_2016_II_4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of n for a regular polygon, n: ");
        int n = input.nextInt();
        System.out.print("Enter the length of a particular side of the regular polygon: ");
        double s = input.nextDouble();
        System.out.printf("The area is: %.2f squared meters",area(n,s));
    }
    public static double area(int n, double s){
        double step1 = n*s*s;
        double step2 = 4*Math.tan((180/(double)n)*Math.PI/180);
        double area = step1/step2;
        return area;
    }
}
