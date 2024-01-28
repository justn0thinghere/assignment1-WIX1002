package wix1002_2020_i_3;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;



public class Wix1002_2020_I_3 {

    public static void main(String[] args) {
        int c2 = 0;
        int c4 = 0;
        int c6 = 0;
        int c8 = 0;
        int c10 = 0;
        try{
            Scanner sc = new Scanner(new FileInputStream("raw.txt"));
            while(sc.hasNext()){
                int input = sc.nextInt();
                if(input == 2){
                    c2++;
                }else if(input == 4){
                    c4++;
                }else if(input == 6){
                    c6++;
                }else if(input == 8){
                    c8++;
                }else if(input == 10){
                    c10++;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Frequency Distribution Table");
        System.out.println("2: " + c2);
        System.out.println("4: " + c4);
        System.out.println("6: " + c6);
        System.out.println("8: " + c8);
        System.out.println("10: " + c10);
        int[]count = {c2,c4,c6,c8,c10};
        int max = c2;
        for(int i = 1;i<count.length;i++){
            if(count[i]>max){
                max = count[i];
            }
        }
        System.out.print("The mode of the dataset is: ");
        for(int i = 0;i<count.length;i++){
            if(count[i]==max){
                System.out.print(2*(i+1) + " "); // i is 01234, +1 will become 12345, and times 2 will represent the count of 2 4 6 8 10
            }
        }
    }
    
}
