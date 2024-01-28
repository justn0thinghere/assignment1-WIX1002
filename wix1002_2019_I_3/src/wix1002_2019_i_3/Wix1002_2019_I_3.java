
package wix1002_2019_i_3;

import java.util.Scanner;

public class Wix1002_2019_I_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String in = "";
        while(!(in.equals("quit"))){
        System.out.print("Enter genome string: ");
        in = input.nextLine();
        if(in.equals("quit")){
            break;
        }
        String gene = "";
        
        for(int i = 0;i<in.length()-2;i++){   
            String code = "";
            if(in.charAt(i)=='A'&&in.charAt(i+1)=='T'&&in.charAt(i+2)=='G'){
                boolean detect=false;
                for(int j=i+3;j<in.length()-2;j++){
                    if((in.charAt(j)=='A'&&in.charAt(j+1)=='T'&&in.charAt(j+2)=='G')||(in.charAt(j)=='T'&&in.charAt(j+1)=='G'&&in.charAt(j+2)=='A')||(in.charAt(j)=='T'&&in.charAt(j+1)=='A'&&in.charAt(j+2)=='A')||(in.charAt(j)=='T'&&in.charAt(j+1)=='A'&&in.charAt(j+2)=='G')){
                        detect = true;
                        break;
                    }
                }
                if(detect){
                    for(int j=i+3;j<in.length()-2;j++){
                        if(!((in.charAt(j)=='A'&&in.charAt(j+1)=='T'&&in.charAt(j+2)=='G')||(in.charAt(j)=='T'&&in.charAt(j+1)=='G'&&in.charAt(j+2)=='A')||(in.charAt(j)=='T'&&in.charAt(j+1)=='A'&&in.charAt(j+2)=='A')||(in.charAt(j)=='T'&&in.charAt(j+1)=='A'&&in.charAt(j+2)=='G'))){
                            code+=in.charAt(j);
                        }else{
                            break;
                        }
                    }
                    if(code.length()%3==0){
                        gene = code;
                        System.out.println(gene);
                    }
                }
            }
        }
        if(gene.equals("")){
            System.out.println("No gene is found");
        }
        }
    }
    
}
