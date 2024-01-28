
package wix1002_2016_i_3;

import java.util.Random;
import java.util.Scanner;


public class Wix1002_2016_I_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of random integer: ");
        int x = input.nextInt();
        int[]num = new int[x];
        Random r = new Random();
        for(int i = 0;i<num.length;i++){
            num[i] = r.nextInt(1001);
        }
        display(num);
        max(num);
        approx(num);
        reverse(num);
    }
    public static void display(int[]num){
        System.out.print("The random integer: ");
        for(int i = 0;i<num.length;i++){
            System.out.print(num[i] + " ");
        }
        System.out.println("");
    }
    public static void max(int[]num){
        int max = num[0];
        for(int i = 1;i<num.length;i++){
            if(max<num[i]){
                max = num[i];
            }
        }
        System.out.println("Maximum number: "+max);
    }
    public static void approx(int[]num){
        int[]num2 = new int[num.length];
        for(int i = 0;i<num2.length;i++){
            num2[i] = num[i];
        }
        System.out.print("The approximation of the integer to the nearest tenth: ");
        for(int i = 0;i<num2.length;i++){
            if(num2[i]%10<5){
                num2[i]=num2[i]-(num2[i]%10);
            }else{
                num2[i]=num2[i]-(num2[i]%10)+10;
            }
            System.out.print(num2[i]+ " ");
        }
        System.out.println("");
    }
    
    public static void reverse(int[]num){
        System.out.print("The random integer in reverse order: ");
        for(int i = 0;i<num.length;i++){
            int cnt = 0;
            int temp = num[i];
            int temp2 = num[i];
            int x = 0;
            while(temp>0){
                temp=temp/10;
                cnt++;
            }
            int[]next = new int[cnt];
            for(int j = 0;j<next.length;j++){
                next[j]=temp2%10;
                temp2=temp2/10;
            }
            for(int j = 0;j<next.length;j++){
                x+= next[j]*Math.pow(10,next.length-j-1);
            }
            num[i]=x;
            System.out.print(num[i]+" ");
        }
    }
}
