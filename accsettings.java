
package javaapplication94;

import java.util.ArrayList;
import java.util.Scanner;

public class accsettings {
    public static void account(ArrayList<String>user,ArrayList<String>password,ArrayList<String>securityQuestion,ArrayList<String>securityAnswer,int userid){
        Scanner input=new Scanner(System.in);
        boolean success=false;
        boolean success1=false;
        boolean success2 = false;
        loginforsettings:
        while(true){
            System.out.print("Enter your password: ");
            String password1=input.next();
            if(password1.equals(password.get(userid))){
                success=true;
                success1=true;
                success2 = true;
                break loginforsettings;
            }else{
                System.out.println("Password incorrect");
                System.out.println("Forgot password? YES-1,NO-any other number: ");
                int yesno = input.nextInt();
                input.nextLine();
                if(yesno == 1){
                    forgotpassword(user,password,securityQuestion,securityAnswer,userid);
                }
            }
        }
        if(success){
            System.out.print("Do you want to change your  username.1-YES.2-NO: ");
            int ans=input.nextInt();
            while(ans==1){
                System.out.print("Enter new username: ");
                String user2=input.next();
                int count = 0;
                for(int x=0;x<user.size();x++){
                    if(user2.equals(user.get(x))){
                        count++;
                        break;
                    }
                }
                if(count == 1){
                    System.out.println("Username existed");
                }else{
                    user.set(userid,user2);
                    System.out.println("Changes username successfully");
                    success=false;
                    break;
                   
            }
            }
        }
        if(success1){
            System.out.print("Do you want to change your  password.1-YES.2-NO: ");
            int ans=input.nextInt();
            while(ans==1){
                System.out.print("Enter new password(no spaces between and cannot be the same as previous password): ");
                String password2=input.next();
                if(password2.equals(password.get(userid))){
                    System.out.println("Same as the previous password");
                }else{
                    password.set(userid,password2);
                    System.out.println("Changes password successfully");
                    success1=false;
                    break;
                }   
            }
        }
        if(success2){
            System.out.print("Do you want to change your security password and answer?1-YES,2-NO: ");
            int ans = input.nextInt();
            while(ans==1){
            deter:
            while(true){
            System.out.println("\nChoose a new question: ");
            System.out.print("\n1.What is the name of your primary school? \n2.What is your hobby? \n3.What is your favourite food? \nYour choice(1/2/3): ");    
            int securityQues = input.nextInt();
            input.nextLine();
            boolean tf = false;
            switch(securityQues) {
                case 1: 
                    securityQuestion.set(userid,"What is the name of your primary school?");
                    tf = true;
                    break;
                case 2:
                    securityQuestion.set(userid,"What is your hobby?");
                    tf = true;
                    break;
                case 3:
                    securityQuestion.set(userid,"What is your favourite food?");
                    tf = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                }
            if(tf){
                break deter;
            }
            }
            
            System.out.print("\nEnter your security answer: ");
            String answer = input.nextLine();
            securityAnswer.set(userid,answer);
            break;
            }
        }
    }
    
    
    public static void forgotpassword(ArrayList<String>user,ArrayList<String>password,ArrayList<String>securityQuestion,ArrayList<String>securityAnswer,int userid){
        all:
        while(true){
        Scanner input = new Scanner(System.in);
        System.out.println(securityQuestion.get(userid));
        System.out.print("Please enter your answer: ");
        String ans = input.nextLine();
        if(ans.equals(securityAnswer.get(userid))){
            while(true){
            System.out.print("Please enter new password(no spcaes between): ");
            String pass = input.next();
            if(pass.equals(password.get(userid))){
                System.out.println("Same as the previous password");
            }else{
                password.set(userid,pass);
                break all;
            }
            }
        }else{
            System.out.print("Incorrect security answer. Try again-1,Go back-any other number: ");
            int yesno = input.nextInt();
            if(yesno!=1){
                break all;
            }
        }
        }
    }
}
