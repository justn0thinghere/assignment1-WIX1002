
package wix1002_2019_i_1;

import java.util.Random;

public class Wix1002_2019_I_1 {

    public static void main(String[] args) {
        System.out.println("This program shows the odd and even number from 10 random numbers. The random numbers must be from 0 - 100");
        int num, odd = 0, even = 0;
        Random r = new Random();
        for(int i = 1;i<=5;i++){
            num = r.nextInt(101);
            System.out.print(num + " ");
            if(isEven(num)){
                ++even;
            }else{
                ++odd;
            }
        }
        System.out.println("\nNumber of odd number: " + odd);
        System.out.println("Number of even number: " + even);
    }
    
    public static boolean isEven(int a){
        if(a%2==0)
            return true;
        else
            return false;
    }
    
}
