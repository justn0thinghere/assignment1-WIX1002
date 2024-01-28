
package wix1002_2017_i_2;

import java.util.Scanner;

public class Wix1002_2017_I_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the initial tution fee (i.e year 1): ");
        double ini = input.nextDouble();
        System.out.print("Enter the yearly rate of increment(e.g enter 5.2 for 5.2%): ");
        double rate = input.nextDouble();
        System.out.print("Enter the year for which you wish to compute the tution fee for: ");
        int year = input.nextInt();
        computeFee(ini,rate,year);
    }
    public static void computeFee(double ini,double rate,int year){
        double fin = ini;
        for(int i = 1;i<year;i++){
            fin = fin*(1+rate/100);
        }
        System.out.println("The computed fee for year 3 is: " + fin);
    }
}
