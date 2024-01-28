
package wix1002_2018_i_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Wix1002_2018_I_4 {

    public static void main(String[] args) {
        String[]name = new String[4];
        double[]scores = new double[4];
        try{
            Scanner sc = new Scanner(new FileInputStream("Q4.txt"));
            int i = 0;
            while(sc.hasNext()){
                name[i] = sc.next();
                double[]marks = {sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble()};
                int diff = sc.nextInt();
                double max = marks[0];
                double min = marks[0];
                for(int j = 0;j<marks.length-1;j++){
                    for(int k = 0;k<marks.length-j-1;k++){
                        if(marks[k]>marks[k+1]){
                            double temp = marks[k];
                            marks[k] = marks[k+1];
                            marks[k+1] = temp;
                        }
                    }
                }
                scores[i] = (marks[1]+marks[2]+marks[3])*diff;
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        for(int i = 0;i<name.length;i++){
            System.out.printf("%s scored %.2f\n",name[i],scores[i]);
        }
        double high = scores[0];
        for(int i = 0;i<scores.length;i++){
            if(scores[i]>high){
                high = scores[i];
            }
        }
        for(int i = 0;i<scores.length;i++){
            if(scores[i]==high){
                System.out.println(name[i] + " is the winner");
            }
        }
    }
    
}
