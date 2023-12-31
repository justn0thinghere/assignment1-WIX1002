
package javaapplication94;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaApplication94 {

    public static void main(String[] args) {
        int i = 0;
        Scanner input = new Scanner(System.in);
        boolean success = false;
        ArrayList<String> user = new ArrayList<String>();
        ArrayList<String> password = new ArrayList<String>();
        ArrayList<String> securityQuestion = new ArrayList<String>();
        ArrayList<String> securityAnswer = new ArrayList<String>();
        ArrayList<ArrayList<String>>cart = new ArrayList<ArrayList<String>>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\usernames.csv"));
            BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\passwords.csv"));
            BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\user\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\securityQuestion.csv"));
            BufferedReader br4 = new BufferedReader(new FileReader("C:\\Users\\user\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\securityAnswer.csv"));
            BufferedReader br5 = new BufferedReader(new FileReader("C:\\Users\\user\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\cart.csv"));
            String line = "";
            while((line = br.readLine())!= null){
                user.add(line);
            }
            while((line = br2.readLine())!= null){
                password.add(line);
            }
            while((line = br3.readLine())!= null){
                securityQuestion.add(line);
            }
            while((line = br4.readLine())!= null){
                securityAnswer.add(line);
            }
            while((line = br5.readLine())!= null){
                String[]c = line.split(",");
                ArrayList<String>www = new ArrayList<String>();
                for(int j = 0;j<c.length;j++){
                    www.add(c[j]);
                }
                cart.add(www);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        while(true){
        System.out.print("Are you an existing user? Yes - 1. No - 2, Exit - 3: ");
        int exist = input.nextInt();
        if (exist == 1){
            userdefine:
            while(true){
            System.out.print("Please enter username: ");
            String username = input.next();
            System.out.println(" ");
            
            boolean loop1 = true;
            
            for(i = 0;i<user.size();i++){
                if(username.equals(user.get(i))){
                    System.out.print("Please enter password: ");
                    String pass_word = input.next();
                    System.out.println(" ");
                    if(pass_word.equals(password.get(i))){
                        success = true;
                        break userdefine;
                    }else{
                        System.out.println("Password incorrect");
                        System.out.println("Forgot password? YES-1,NO-any other number: ");
                        int yesno = input.nextInt();
                        if(yesno == 1){
                            accsettings.forgotpassword(user,password,securityQuestion,securityAnswer,i);
                            break;
                        }else{
                            break;
                        }
                    }
                }
            }
            if(i == user.size()){
                System.out.println("User not exist.Retry-1/Back-any other number");
                int g;
                g = input.nextInt();
                if(g!=1){
                    break;
                }
            }
        }
        }
        else if(exist == 2){ //add new user
            System.out.print("Please enter new username(no spaces between): ");
            String username = input.next();
            System.out.print("Please enter new password(no spaces between): ");
            String pass_word = input.next();
            System.out.println("");
            int count = 0;
            for(int x=0;x<user.size();x++){
                if(username.equals(user.get(x))){
                    count++;
                    break;
                }
            }
            if(count == 1){
                System.out.println("Username existed");
            }else{
                user.add(username);
                password.add(pass_word);
                deter:
                while(true){
                System.out.println("Please choose one security question: ");
                System.out.print("1.What is the name of your primary school? \n2.What is your hobby? \n3.What is your favourite food? \nYour choice(1/2/3): ");
                int securityQues = input.nextInt();
                input.nextLine();
                String line = null;
                switch(securityQues) {
                    case 1: 
                        line = "What is the name of your primary school?";
                        securityQuestion.add(line);
                        break;
                    case 2:
                        line = "What is your hobby?";
                        securityQuestion.add(line);
                        break;
                    case 3:
                        line = "What is your favourite food?";
                        securityQuestion.add(line);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                if(line!=null){
                    break;
                }
                }
                System.out.print("\nEnter your security answer: ");
                String ans = input.nextLine();
                securityAnswer.add(ans);
                System.out.println("new user successfully created");
                ArrayList<String>kkk = new ArrayList<String>();
                kkk.add("nt");
                cart.add(kkk);
            }
        }   
        else if(exist == 3){
            break;
        }
        else{
            System.out.println("Not a valid option");
        }
        if(success){
            System.out.println("Login successful");
            theprogram(user,password,securityQuestion,securityAnswer,i,cart);
            success = false;
        }
        }
        System.out.println("Program ended, thank you for using this program.");
        try{
        File usernames = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\usernames.csv");
        File passwords = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\passwords.csv");
        File secques = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\securityQuestion.csv");
        File secans = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\securityAnswer.csv");
        File crt = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\cart.csv");
        PrintWriter user_names = new PrintWriter(usernames);
        PrintWriter pass_words = new PrintWriter(passwords);
        PrintWriter ques = new PrintWriter(secques);
        PrintWriter ans = new PrintWriter(secans);
        PrintWriter cct = new PrintWriter(crt);
        int k;
        for(k = 0;k<user.size()-1;k++){
            user_names.print(user.get(k)+"\n");
            pass_words.print(password.get(k)+"\n");
            ques.print(securityQuestion.get(k)+"\n");
            ans.print(securityAnswer.get(k)+"\n");
            int w;
            for(w = 0;w<cart.get(k).size()-1;w++){
                cct.print(cart.get(k).get(w)+",");
            }
            cct.print(cart.get(k).get(w)+"\n");
        }
        user_names.print(user.get(k));
        pass_words.print(password.get(k));
        ques.print(securityQuestion.get(k));
        ans.print(securityAnswer.get(k));
        int w;
        for(w = 0;w<cart.get(k).size()-1;w++){
            cct.print(cart.get(k).get(w)+",");
        }
        cct.print(cart.get(k).get(w));
        user_names.close();
        pass_words.close();
        ques.close();
        ans.close();
        cct.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }  
    public static void theprogram(ArrayList<String>user,ArrayList<String>password,ArrayList<String>securityQuestion,ArrayList<String>securityAnswer,int userid,ArrayList<ArrayList<String>>cart){
        boolean tf = true;
        while(tf){
            item iteems = new item();
            premise goes = new premise();
            price goer = new price();
            int [] count = {0}; //declare and initialize a count that will be used later
            iteems.counteritem(count); //to change the value of count[0] and build an array for lookupitems
            System.out.println("number of items is: " + count[0]);
            ArrayList<String[]>items = iteems.call(); //declared and stored in the heed/stack
            count[0] = 0;//reinitialize to be used again
            goes.counterpremise(count); //to change the value of count[0] and build an array for lookup items;
            System.out.println("number of premises is: " +count[0]);
            ArrayList<String[]>premise = goes.calling(); //declare and stored in heed/stack
            count[0]=0;//reinitialize
            goer.countprice(count); //to change the value of count[0] and build an array for pricecatcher;
            System.out.println("number of prices is: " + count[0]);
            ArrayList<String[]>pricecatcher = goer.call(); //same explanation as other 2
            ArrayList<String[]>newitem = new ArrayList<String[]>();
            ArrayList<String[]>newpremise = new ArrayList<String[]>();
            ArrayList<String[]>newprice = new ArrayList<String[]>();
            System.out.println("PriceTracker - Track Prices with Ease\n");
            System.out.println("Welcome to Product Search and Selection\n");
            System.out.println("1. Import Data");
            System.out.println("2. Browse by categories");
            System.out.println("3. Search for a product");
            System.out.println("4. View Shopping Cart");
            System.out.println("5. Account Settings");
            System.out.println("6. Exit\n");
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your choice (1/2/3/4/5/6) : ");
            int choice = input.nextInt();
            if(choice == 1){
            importing.importdata(newitem,newpremise,newprice,items,premise,pricecatcher);
            }else if(choice == 2){
            chooseitem.browse(items,premise,pricecatcher,cart,userid);
            }else if(choice == 3){
            chooseitem.search(items,premise,pricecatcher,cart,userid);
            }else if(choice == 4){
            shopcarts.shopcart(items,premise,pricecatcher,cart,userid);
            }else if(choice == 5){
            accsettings.account(user,password,securityQuestion,securityAnswer,userid);
            }else if(choice == 6){
            tf = false;
            }else{
                System.out.println("Invalid choice, please enter number 1-6");
            }
            try{
        File item_s = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\lookup_item.csv");
        File premise_s = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\lookup_premise.csv");
        File price_caaatch = new File("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\pricecatcher_2023-08.csv");
        PrintWriter ite_ms = new PrintWriter(item_s);
        PrintWriter premis_es = new PrintWriter(premise_s);
        PrintWriter price_caatch = new PrintWriter(price_caaatch);
        ite_ms.printf("%s,%s,%s,%s,%s\n",items.get(0)[0],items.get(0)[1],items.get(0)[2],items.get(0)[3],items.get(0)[4]);
        for(int x = 1;x<items.size();x++){
            item go = new item(items.get(x));
            ite_ms.print(go.getCode()+","+go.getItem()+","+go.getUnit()+","+go.getGroup()+","+go.getCat());
            ite_ms.println("");
        }
        for(int x = 0;x<newitem.size();x++){
            int y;
            for(y = 0;y<4;y++){
            int countcoma = 0;
                for(int z = 0;z<newitem.get(x)[y].length();z++){
                    if(newitem.get(x)[y].charAt(z)==','){
                        countcoma++;
                        break;
                    }
                }
                if(countcoma==0){
                ite_ms.print(newitem.get(x)[y]+",");
                }else{
                    ite_ms.print("\"" + newitem.get(x)[y] +  "\",");
                }
            }
            int countcoma = 0;
                for(int z = 0;z<newitem.get(x)[y].length();z++){
                    if(newitem.get(x)[y].charAt(z)==','){
                        countcoma++;
                        break;
                    }
                }
                if(countcoma==0){
                ite_ms.print(newitem.get(x)[y]);
                }else{
                    ite_ms.print("\"" + newitem.get(x)[y] +  "\"");
                }
            ite_ms.println("");
        }
        
        premis_es.printf("%s,%s,%s,%s,%s,%s\n",premise.get(0)[0],premise.get(0)[1],premise.get(0)[2],premise.get(0)[3],premise.get(0)[4],premise.get(0)[5]);
        for(int x = 1;x<premise.size();x++){
            premise go = new premise(premise.get(x));
            premis_es.print(go.getCode()+","+go.getPremise()+","+go.getAddress()+","+go.getType()+","+go.getState()+","+go.getDistrict());
            premis_es.println("");
        }
        for(int x = 0;x<newpremise.size();x++){
            int y;
            for(y=0;y<5;y++){
                int countcoma = 0;
                for(int z = 0;z<newpremise.get(x)[y].length();z++){
                    if(newpremise.get(x)[y].charAt(z)==','){
                        countcoma++;
                        break;
                    }
                }
                if(countcoma==0){
                premis_es.print(newpremise.get(x)[y]+",");
                }else{
                    premis_es.print("\"" + newpremise.get(x)[y] +  "\",");
                }
            }
            int countcoma = 0;
                for(int z = 0;z<newpremise.get(x)[y].length();z++){
                    if(newpremise.get(x)[y].charAt(z)==','){
                        countcoma++;
                        break;
                    }
                }
                if(countcoma==0){
                premis_es.print(newpremise.get(x)[y]);
                }else{
                    premis_es.print("\"" + newpremise.get(x)[y] +  "\"");
                }
            premis_es.println("");
        }
        
        price_caatch.printf("%s,%s,%s,%s\n",pricecatcher.get(0)[0],pricecatcher.get(0)[1],pricecatcher.get(0)[2],pricecatcher.get(0)[3]);
        for(int x = 1;x<pricecatcher.size();x++){
            price go = new price(pricecatcher.get(x));
            price_caatch.print(go.getDate()+","+go.getPremise()+","+go.getItem()+","+go.getPrice());
            price_caatch.println("");
        }
        for(int x = 0;x<newprice.size();x++){
            int y;
            for(y = 0;y<3;y++){
            price_caatch.print(newprice.get(x)[y]+",");
            }
            price_caatch.print(newprice.get(x)[y]);
            price_caatch.println("");
        }
        
        ite_ms.close();
        premis_es.close();
        price_caatch.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        }
        
    }    
}
