
package wix1002_2016_i_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Wix1002_2016_I_4 {

    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new FileInputStream("Q4.txt"));
            while(sc.hasNextLine()){
                int upc = 0;
                int lowc = 0;
                int digit = 0;
                int spec = 0;
                String password = sc.nextLine();
                if(password.length()<8){
                    System.out.println("Not a strong password");
                }else{
                    for(int i = 0;i<password.length();i++){
                        if(password.charAt(i)<='Z'&&password.charAt(i)>='A'){
                            upc++;
                        }else if(password.charAt(i)<='z'&&password.charAt(i)>='a'){
                            lowc++;
                        }else if(password.charAt(i)<='9'&&password.charAt(i)>='0'){
                            digit++;
                        }else if(password.charAt(i)!=' '){
                            spec++;
                        }
                    }
                    if(upc!=0&&lowc!=0&&digit!=0&&spec!=0){
                        System.out.println("Strong password");
                    }else{
                        System.out.println("Not a strong password");
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
