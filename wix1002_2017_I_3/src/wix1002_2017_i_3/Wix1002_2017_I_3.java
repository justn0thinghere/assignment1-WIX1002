
package wix1002_2017_i_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Wix1002_2017_I_3 {

    public static void main(String[] args) {
        Random r = new Random();
        char[]strings = new char[6];
        String line = "";
        for(int i = 0;i<6;){
            int cc = r.nextInt(122-65+1)+65;
            if((cc>=65&&cc<=90)||(cc>=97&&cc<=122)){
                strings[i] = (char)cc;
                line+=strings[i];
                i++;
            }
        }
        try{
            PrintWriter write = new PrintWriter(new FileOutputStream("data.txt"));
            write.print(line);
            write.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("The string generated is: " + line);
        System.out.print("String sorted in ascending order: ");
        sort(strings,'>');
        System.out.print("String sorted in descending order: ");
        sort(strings,'<');
        System.out.print("Original string from file: ");
        try{
            Scanner sc = new Scanner(new FileInputStream("data.txt"));
            System.out.println(sc.nextLine());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void sort(char[]strings,char s){
        if(s == '>'){
            for(int i = 0;i<strings.length-1;i++){
                for(int j = 0;j<strings.length-1-i;j++){
                    if(strings[j]>strings[j+1]){
                        char temp = strings[j];
                        strings[j]=strings[j+1];
                        strings[j+1]=temp;
                    }
                }
            }
        }
        else if(s == '<'){
            for(int i = 0;i<strings.length-1;i++){
                for(int j = 0;j<strings.length-1-i;j++){
                    if(strings[j]<strings[j+1]){
                        char temp = strings[j];
                        strings[j]=strings[j+1];
                        strings[j+1]=temp;
                    }
                }
            }
        }
        String fin = "";
        for(int i = 0;i<strings.length;i++){
            fin+=strings[i];
        }
        System.out.println(fin);
    }
    
}
