
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
                            forgotpassword(user,password,securityQuestion,securityAnswer,i);
                            break;
                        }else{
                            break;
                        }
                    }
                }
            }
            if(i == user.size()){
                System.out.println("User not exist");
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
            importdata(newitem,newpremise,newprice,items,premise,pricecatcher);
            }else if(choice == 2){
            browse(items,premise,pricecatcher,cart,userid);
            }else if(choice == 3){
            search(items,premise,pricecatcher,cart,userid);
            }else if(choice == 4){
            shopcart(items,premise,pricecatcher,cart,userid);
            }else if(choice == 5){
            account(user,password,securityQuestion,securityAnswer,userid);
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
    
    
    
    public static void importdata(ArrayList<String[]>newitem,ArrayList<String[]>newpremise,ArrayList<String[]>newprice,ArrayList<String[]>items,ArrayList<String[]>premise,ArrayList<String[]>pricecatcher){
        Scanner input = new Scanner(System.in);
        int ans=0;
        String line = "";
        
        while(ans!=2){
        String[]newit = new String[5];
        String[]newpre = new String[6];
        String[]newpri = new String[4];
        System.out.println("Do you want to import new data.YES-1,NO-2");
        ans=input.nextInt();
        if(ans==1){
            System.out.println("1.item"+"\n2.Premise"+"\n3.Price");
            System.out.print("Enter your choice: ");
            int choose=input.nextInt();
            
            switch(choose)
                    { case 1:
                        while (true){
                            int count = 0;
                            System.out.println("Enter the item code");
                            line=input.next();
                            input.nextLine();
                            checkitemcode:
                            for(int x = 1;x<items.size();x++){
                                item iteem = new item(items.get(x));
                                if(line.equals(iteem.getCode())){
                                    System.out.println("item code exists");
                                    count++;
                                    break;
                                }
                            }
                            for(int y = 0;y<newitem.size();y++){
                                item iteem = new item(newitem.get(y));
                                if(line.equals(iteem.getCode())){
                                    System.out.println("item code exists");
                                    count++;
                                    break;
                                }
                            }
                            if (count==0){
                                newit[0]=line;
                                break;
                            }
                        }
                        while (true){
                            int count = 0;
                            System.out.println("Enter the item");
                            line=input.nextLine();
                            checkitem:
                            for(int x = 1;x<items.size();x++){
                                item iteem = new item(items.get(x));
                                if(line.equals(iteem.getItem())){
                                    System.out.println("item exists");
                                    count++;
                                    break;
                                }        
                            }
                            for(int y = 0;y<newitem.size();y++){
                                item iteem = new item(newitem.get(y));
                                if(line.equals(iteem.getItem())){
                                    System.out.println("item exists");
                                    count++;
                                    break;
                                }
                            }
                            if (count==0){
                                newit[1]=line;
                                break;
                            }
                        }
                        System.out.println("Enter the unit of the item");
                        newit[2]=input.nextLine();
                        System.out.println("Enter the item group");
                        newit[3]=input.nextLine();
                        System.out.println("Enter the item category");
                        newit[4]=input.nextLine();
                        newitem.add(newit);
                        break;
            
            
                    case 2:
                        while (true){
                            int count = 0;
                            System.out.println("Enter the premise code");
                            line=input.next();
                            input.nextLine();
                            checkpremisecode:
                            for(int x = 1;x<premise.size();x++){
                                premise go = new premise(premise.get(x));
                                if(line.equals(go.getCode())){
                                    System.out.println("premise code exists");
                                    count++;
                                    break;
                                }
                            }
                            for(int y = 0;y<newpremise.size();y++){
                                premise go = new premise(newpremise.get(y));
                                if(line.equals(go.getCode())){
                                    System.out.println("premise code exists");
                                    count++;
                                    break;
                                }
                            }
                            if (count==0){
                                newpre[0]=line;
                                break;
                            }
                        }
                        while (true){
                            int count = 0;
                            System.out.println("Enter the premise");
                            line=input.nextLine();
                            checkpremise:
                            for(int x = 1;x<premise.size();x++){
                                premise go = new premise(premise.get(x));
                                if(line.equals(go.getPremise())){
                                    System.out.println("premise exists");
                                    count++;
                                    break;
                                }
                            }
                            for(int y = 0;y<newpremise.size();y++){
                                premise go = new premise(newpremise.get(y));
                                if(line.equals(go.getPremise())){
                                    System.out.println("premise exists");
                                    count++;
                                    break;
                                }
                            }
                            if (count==0){
                                newpre[1]=line;
                                break;
                            }
                        }
                        System.out.println("Enter the premise address");
                        newpre[2]=input.nextLine();
                        System.out.println("Enter the premise type");
                        newpre[3]=input.nextLine();
                        System.out.println("Enter the state");
                        newpre[4]=input.nextLine();
                        System.out.println("Enter the district");
                        newpre[5]=input.nextLine();
                        newpremise.add(newpre);
                        break;
            
                    case 3:
                        while(true){
                        int count = 0;
                        System.out.println("Enter the date(YYYY-MM-DD)");
                        String line1=input.next();
                        String line2 = "";
                        String line3 = "";
                        premiseloop:
                        while(true){
                        System.out.println("Enter the premise code");
                        line2=input.next();
                        int cf = 0;
                        for(int i=1;i<premise.size();i++){
                            premise p = new premise(premise.get(i));
                            if(p.getCode().equals(line2)){
                                cf++;
                                break;
                            }
                        }
                        if(cf==0){
                            System.out.println("Premise code does not exist");
                        }else{
                            break premiseloop;
                        }
                        }
                        itemloop:
                        while(true){
                        System.out.println("Enter the item code");
                        line3=input.next();
                        int cf = 0;
                        for(int i=1;i<items.size();i++){
                            item p = new item(items.get(i));
                            if(p.getCode().equals(line3)){
                                cf++;
                                break;
                            }
                        }
                        if(cf==0){
                            System.out.println("Item code does not exist");
                        }else{
                            break itemloop;
                        }
                        }
                        for(int x = 1;x<pricecatcher.size();x++){
                            price go = new price(pricecatcher.get(x));
                            if(line1.equals(go.getDate())&&line2.equals(go.getPremise())&&line3.equals(go.getItem())){
                                System.out.println("The combination of the date,premise code and item code entered already exists");
                                count++;
                                break;
                            }
                        }
                        for(int y = 0;y<newprice.size();y++){
                            price go = new price(newprice.get(y));
                            if(line1.equals(go.getDate())&&line2.equals(go.getPremise())&&line3.equals(go.getItem())){
                                System.out.println("The combination of the date,premise code and item code entered already exists");
                                count++;
                                break;
                            }
                        }
                        if(count==0){
                            newpri[0]=line1;
                            newpri[1]=line2;
                            newpri[2]=line3;
                            break;
                        }
                        }
                        System.out.println("Enter the price");
                        newpri[3]=input.next();
                        newprice.add(newpri);
                        break;
            }       
        }
     }
    }
    
    public static void browse(ArrayList<String[]>items,ArrayList<String[]>premise,ArrayList<String[]>pricecatcher,ArrayList<ArrayList<String>>cart,int userid){
        Scanner input = new Scanner(System.in);
        int count = 0;
        for(int i =1;i<items.size();i++){ //first line is title so start with 1
            item iteem = new item(items.get(i));
            String cat = iteem.getGroup();
            int check = 0;
            for(int j=1;j<i;j++){ //start with 1, same reason
                item iteeem = new item(items.get(j));
                if(cat.equals(iteeem.getGroup())){
                    check = 1;
                    break;
                }
            }
            if(check!=1){
                count++;
            }
        }
        String[][][]categories = new String[count][2][];
        int c = 0;
        for(int i = 0;i<count;i++){
            categories[i][0] = new String[1];
        }
        for(int i = 1;i<items.size();i++){ //first line is title so start with 1
            if(c<count){
            item iteem = new item(items.get(i));
            String cat = iteem.getGroup();
            int check = 0;
            for(int j=1;j<i;j++){ //start with 1, same reason
                item iteeem = new item(items.get(j));
                if(cat.equals(iteeem.getGroup())){
                    check = 1;
                    break;
                }
            }
            if(check!=1){
               categories[c][0][0] = cat;
               c++;
            }
        }
        }
        
        for(int i = 0;i<categories.length;i++){
            int subbs = 0;
            for(int j = 1;j<items.size();j++){
                item iteem = new item(items.get(j));
                if(iteem.getGroup().equals(categories[i][0][0])){
                    subbs++;
                }
            }
            String[][]sbbs = new String[subbs][5];
            for(int j = 0;j<subbs;){
                for(int k = 1;k<items.size();k++){
                    item iteem = new item(items.get(k));
                    if(iteem.getGroup().equals(categories[i][0][0])){
                        sbbs[j] = items.get(k);
                        j++;
                    }
                }
            }
            
            int countsub = 0;
            for(int j = 0;j<sbbs.length;j++){
                item iteem = new item(sbbs[j]);
                String subcat = iteem.getCat();
                int check = 0;
                for(int y=0;y<j;y++){ //start with 1, same reason
                    item iteeem = new item(sbbs[y]);
                    if(subcat.equals(iteeem.getCat())){
                        check = 1;
                        break;
                    }
                }
                if(check!=1){
                    countsub++;
                }       
            }
            
            categories[i][1] = new String[countsub];
            int sc = 0;
            for(int j = 0;j<sbbs.length;j++){
                if(sc<countsub){
                item iteem = new item(sbbs[j]);
                String subcat = iteem.getCat();
                int check = 0;
                for(int y=0;y<j;y++){ //start with 1, same reason
                    item iteeem = new item(sbbs[y]);
                    if(subcat.equals(iteeem.getCat())){
                        check = 1;
                        break;
                    }
                }
                if(check!=1){
                    categories[i][1][sc]=subcat;
                    sc++;
                }
            }
            }
        }
        
        System.out.printf("There are %d categories\n",count);
        while(true){
        System.out.println("Select a Category :");
        System.out.println();
        int a;
        for(a = 0;a<categories.length;a++){
            System.out.printf("%d. %s\n",a+1,categories[a][0][0]);
        }
        System.out.printf("%d. Back to Main Menu\n",a+1);
        
        System.out.print("\nEnter your choice : ");
        int choice = input.nextInt();
        String category = "";
        String subcategory = "";
        
        if(choice<=0){
            System.out.println("Invalid choice");
        }else if(choice<=a){
            while(true){
            category = categories[choice-1][0][0];
            System.out.println("Select sub category: ");
            int b;
            for(b = 0;b<categories[choice-1][1].length;b++){
                System.out.printf("%d. %s\n",b+1,categories[choice-1][1][b]);
            }
            System.out.printf("%d. Back to categories\n",b+1);
            System.out.print("\nEnter your choice: ");
            int sub = input.nextInt();
            if(sub<=0){
                System.out.println("Invalid choice");
            }else if(sub<=b){
                while(true){
                subcategory = categories[choice-1][1][sub-1];
                int its = 0;
                for(int i = 1;i<items.size();i++){
                    item go = new item(items.get(i));
                    if(category.equals(go.getGroup())&&subcategory.equals(go.getCat())){
                        its++;
                    }
                }
                System.out.println(its + " items found");
                String[][]it = new String[its][5];
                int couti = 0;
                for(int i = 1;i<items.size();i++){
                    item go = new item(items.get(i));
                    if(category.equals(go.getGroup())&&subcategory.equals(go.getCat())){
                        it[couti] = items.get(i);
                        couti++;
                    }
                }
                for(int i = 0;i<it.length;i++){
                    item go = new item(it[i]);
                    System.out.printf("%d. %s\n",i+1,go.getItem());
                }
                System.out.printf("%d. Back to sub categories\n",it.length+1);
                System.out.println("Please select one: ");
                int select = input.nextInt();
                if(select<=0){
                    System.out.println("Invalid choice");
                }else if(select<=it.length){
                    String[]selected = it[select-1];
                    selection(items,premise,pricecatcher,cart,selected,userid);
                }else if(select==it.length+1){
                    break;
                }else{
                    System.out.println("Invalid choice");
                }
                //you stopped here*****
                }
            }else if(sub == b+1){
                break;
            }else{
                System.out.println("Invalid choice");
            }
            }
        }else if(choice == a+1){
            break;
        }else{
            System.out.println("Invalid choice");
        }
        
        }
    }
    
    public static void search(ArrayList<String[]>items,ArrayList<String[]>premise,ArrayList<String[]>pricecatcher,ArrayList<ArrayList<String>>cart,int userid){
        all:
        while(true){
        System.out.println("Enter the product you want to search: ");
        Scanner input = new Scanner(System.in);
        String key = input.nextLine();
        if(key.replace(" ","").length()<4){
            System.out.println("Please enter more than 4 character");
            System.out.println("or do you want to exit?if yes enter 1,no enter any number other than 1: ");
            int yesno = input.nextInt();
            if(yesno == 1){
                break all;
            }
        }else{
        ArrayList<String[]>found = new ArrayList<String[]>();
        for(int i = 0;i<items.size();i++){
            item stuff = new item(items.get(i));
            String name = stuff.getItem().toLowerCase();
            if(name.equalsIgnoreCase(key)){
                found.add(items.get(i));
            }else{
                String keyL = key.toLowerCase();
                char ch;
                String keyLW = keyL.replace(" ","");
                String nameW = name.replace(" ", "");
                int keysize = keyLW.length();
                int namesize = nameW.length();
                int similar = 0;
                for(int j = 0;j<namesize;j++){
                    if(keyLW.charAt(0) == nameW.charAt(j)){
                        int x = 1;
                        similar++;
                        while(x<keysize && j+x<namesize){
                            if(keyLW.charAt(x)==nameW.charAt(j+x)){
                                similar++;
                            }
                        x++;
                        }
                    }
                    if(similar<keysize-1){
                        similar = 0;
                    }
                }
                if(similar>=keysize-1){
                    found.add(items.get(i));
                }
            }
        }
        found:
        while(true){
        System.out.printf("%d items found: \n",found.size());
        for(int i = 0;i<found.size();i++){
            item go = new item(found.get(i));
            System.out.printf("%d. %s\n",i+1,go.getItem());
        }
        System.out.printf("%d. Back to search: \n",found.size()+1);
        System.out.printf("%d. Back to menu: \n",found.size()+2);
        System.out.print("Please select one: ");
        int choice=input.nextInt();
        if(choice<=found.size()){
            String[]selected = found.get(choice-1);
            selection(items,premise,pricecatcher,cart,selected,userid);
        }else if(choice==found.size()+1){
            break found;
        }else if(choice==found.size()+2){
            break all;
        }else{
            System.out.println("Invalid choice");
        }
        }
        }
        }
    }
    
    public static void shopcart(ArrayList<String[]>items,ArrayList<String[]>premise,ArrayList<String[]>pricecatcher,ArrayList<ArrayList<String>>cart,int userid){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("\nShopping cart\n");
            System.out.println("Your items: ");
            if(cart.get(userid).size()==1){
                System.out.println("You have not selected any items yet.");
                System.out.print("Enter anything to go back: ");
                String xxx = input.nextLine();
                break;
            }else{
            int w;
            for(w = 1;w<cart.get(userid).size()-1;w++){
                System.out.print(cart.get(userid).get(w) + ",");
            }
            System.out.println(cart.get(userid).get(w));
            System.out.println("1. View cheapest seller for all selected items");
            System.out.println("2. Find shops to buy items in cart");
            System.out.println("3. Remove item from cart");
            System.out.println("Back - any other number");
            System.out.print("Your choice: ");
            int choice = input.nextInt();
            if(choice==1){
                System.out.print("View according to date-1,view according to average price-any other number: ");
                int c = input.nextInt();
                input.nextLine();
                if(c==1){
                    System.out.println("Enter date: ");
                    String dt = input.nextLine();
                    System.out.println("At date: " + dt);
                    for(int i = 1;i<cart.get(userid).size();i++){
                        String code = "";
                        int counters=0;
                        for(int j = 1;j<i;j++){
                            if(cart.get(userid).get(i).equals(cart.get(userid).get(j))){
                                counters++;
                                break;
                            }
                        }
                        if(counters==0){
                        System.out.println(cart.get(userid).get(i)+" : ");
                        for(int x = 0;x<items.size();x++){
                            item go = new item(items.get(x));
                            if(cart.get(userid).get(i).equals(go.getItem())){
                                code = go.getCode();
                                break;
                            }
                        }
                        ArrayList<String[]>thatday = new ArrayList<String[]>();
                        for(int y = 1;y<pricecatcher.size();y++){
                            price p = new price(pricecatcher.get(y));
                                if(dt.equals(p.getDate())&&code.equals(p.getItem())){
                                thatday.add(pricecatcher.get(y));
                            }
                        }
                        if(thatday.size()==0){
                            System.out.println("no records");
                        }else{
                        for(int y = 0;y<thatday.size()-1;y++){
                            for(int j = 0;j<thatday.size()-1-i;j++){
                                price p = new price(thatday.get(j));
                                price q = new price(thatday.get(j+1));
                                if(p.getPrice()>q.getPrice()){
                                    String[]temp = thatday.get(j);
                                    thatday.set(j,thatday.get(j+1));
                                    thatday.set(j+1,temp);
                                }
                            }
                        }
                        System.out.println("Cheapest seller at "+ dt + " is : ");
                        price p = new price(thatday.get(0));
                        for(int j = 0;j<premise.size();j++){
                        premise pr = new premise(premise.get(j));
                            if(p.getPremise().equals(pr.getCode())){
                                System.out.printf("%s\n",pr.getPremise());
                                System.out.printf("Price: %.2f\n",p.getPrice());
                                System.out.printf("Address: %s\n\n",pr.getAddress());
                                break;
                            }
                        }
                        }
                    }
                    }
                }else{
                    for(int i = 1;i<cart.get(userid).size();i++){
                        String code = "";
                        int counters = 0;
                        for(int j = 1;j<i;j++){
                            if(cart.get(userid).get(i).equals(cart.get(userid).get(j))){
                                counters++;
                                break;
                            }
                        }
                        if(counters==0){
                        System.out.println(cart.get(userid).get(i)+" : ");
                        for(int x = 0;x<items.size();x++){
                            item go = new item(items.get(x));
                            if(cart.get(userid).get(i).equals(go.getItem())){
                                code = go.getCode();
                                break;
                            }
                        }
                        ArrayList<String[]>thatitem = new ArrayList<String[]>();
                        ArrayList<String>retailers = new ArrayList<String>();
                        ArrayList<Double>retpr = new ArrayList<Double>();
                        for(int y = 1;y<pricecatcher.size();y++){
                            price p = new price(pricecatcher.get(y));
                            if(p.getItem().equals(code)){
                                thatitem.add(pricecatcher.get(y));
                            }
                        }
                        if(thatitem.size()==0){
                            System.out.println("no records");
                        }else{
                            for(int y = 0;y<thatitem.size();y++){
                                price p = new price(thatitem.get(y));
                                String pcode = p.getPremise();
                                int count = 0;
                                for(int j = 0;j<y;j++){
                                    price pn = new price(thatitem.get(j));
                                    if(pcode.equals(pn.getPremise())){
                                        count++;
                                        break;
                                    }
                                }
                                if(count==0){
                                    retailers.add(pcode);
                                }
                            }
                            for(int y = 0;y<retailers.size();y++){
                                double sum = 0;
                                double divider = 0;
                                double avg = 0;
                                for(int j = 0;j<thatitem.size();j++){
                                    price p = new price(thatitem.get(j));
                                    if(p.getPremise().equals(retailers.get(y))){
                                        sum+=p.getPrice();
                                        divider++;
                                    }
                                }
                                avg = sum/divider;
                                retpr.add(avg);
                            }
                            for(int y = 0;y<retpr.size()-1;y++){
                                for(int j = 0;j<retpr.size()-1-y;j++){
                                    if(retpr.get(j)>retpr.get(j+1)){
                                        double tempp = retpr.get(j);
                                        String tempr = retailers.get(j);
                                        retpr.set(j,retpr.get(j+1));
                                        retpr.set(j+1, tempp);
                                        retailers.set(j,retailers.get(j+1));
                                        retailers.set(j+1,tempr);
                                    }
                                }
                            }
                        System.out.println("On average, cheapest seller is: ");
                        for(int j = 0;j<premise.size();j++){
                            premise pr = new premise(premise.get(j));
                            if(pr.getCode().equals(retailers.get(0))){
                                System.out.printf("%s\n",pr.getPremise());
                                System.out.printf("Price: %.2f\n",retpr.get(0));
                                System.out.printf("Address: %s\n\n",pr.getAddress());
                                break;
                            }
                        }
                        }
                        }
                    }
                }
            }else if(choice==2){
                ArrayList<String[]>thatitem = new ArrayList<String[]>();
                ArrayList<String>themissing = new ArrayList<String>();
                ArrayList<ArrayList<String>>retailer = new ArrayList<ArrayList<String>>();
                ArrayList<ArrayList<String>>retailer2 = new ArrayList<ArrayList<String>>();
                ArrayList<Double>retpr = new ArrayList<Double>();
                System.out.print("Do you want to add filter?YES-1,NO-any other number: ");
                int ch = input.nextInt();
                if(ch==1){
                    
                }else{
                    for(int x = 1;x<cart.get(userid).size();x++){
                        String code = "";
                        for(int y = 1;y<items.size();y++){
                            item go = new item(items.get(y));
                            if(cart.get(userid).get(x).equals(go.getItem())){
                                code = go.getCode();
                                break;
                            }
                        }
                        for(int y = 1;y<pricecatcher.size();y++){
                            price p = new price(pricecatcher.get(y));
                            if(p.getItem().equals(code)){
                                thatitem.add(pricecatcher.get(y));
                            }
                        }
                    }
                    for(int y = 0;y<thatitem.size();y++){
                        price p = new price(thatitem.get(y));
                        String pcode = p.getPremise();
                        int count = 0;
                        for(int j = 0;j<y;j++){
                            price pn = new price(thatitem.get(j));
                            if(pcode.equals(pn.getPremise())){
                                count++;
                                break;
                            }
                        }
                        if(count==0){
                            ArrayList<String>ppp = new ArrayList<String>();
                            ppp.add(pcode);
                            retailer.add(ppp);
                        }
                    }
                    for(int y = 0;y<retailer.size();y++){
                        String premcd = retailer.get(y).get(0);
                        ArrayList<String>own = new ArrayList<String>();
                        own.add(premcd);
                        int inxx=1;
                        for(int z = 0;z<thatitem.size();z++){
                            price p = new price(thatitem.get(z));
                            if(p.getPremise().equals(premcd)){
                                String itemcode = p.getItem();
                                int count = 0;
                                String itemname = "";
                                for(int a = 1;a<items.size();a++){
                                    item it = new item(items.get(a));
                                    if(itemcode.equals(it.getCode())){
                                        itemname = it.getItem();
                                    }
                                }
                                for(int a = 1;a<inxx;a++){
                                    if(own.get(a).equals(itemname)){
                                        count++;
                                        break;
                                    }
                                }
                                if(count==0){
                                    own.add(itemname);
                                    inxx++;
                                }
                            }
                        }
                        retailer.set(y, own);
                    }
                    int max = 0;
                    for(int y =0;y<retailer.size();y++){
                        if(retailer.get(y).size()>max){
                            max = retailer.get(y).size();
                        }
                    }
                    
                    for(int y = 0;y<retailer.size();y++){
                        if(retailer.get(y).size()==max){
                            retailer2.add(retailer.get(y));
                        }
                    }
                    for(int y = 0;y<retailer2.size();y++){
                        double tot = 0;
                        for(int z = 1;z<retailer2.get(y).size();z++){
                            String premcd = retailer2.get(y).get(0);
                            String itemcd = "";
                            double sum = 0;
                            double avg = 0;
                            double div = 0;
                            for(int a = 1;a<items.size();a++){
                                item it = new item(items.get(a));
                                if(it.getItem().equals(retailer2.get(y).get(z))){
                                    itemcd = it.getCode();
                                }
                            }
                            for(int a = 0;a<thatitem.size();a++){
                                price p = new price(thatitem.get(a));
                                if(p.getItem().equals(itemcd)&&p.getPremise().equals(premcd)){
                                    sum+= p.getPrice();
                                    div+=1;
                                }
                            }
                            avg = sum/div;
                            tot+=avg;
                        }
                        retpr.add(tot);
                    }
                    double min = retpr.get(0);
                    int tgt =0 ;
                    for(int k = 0;k<retpr.size();k++){
                        if(retpr.get(k)<min){
                            min = retpr.get(k);
                        }
                    }
                    for(;tgt<retpr.size();tgt++){
                        if(retpr.get(tgt)==min){
                            break;
                        }
                    }
                    double[]toootal = {0};
                    System.out.print("You can find ");
                    for(int y = 1;y<retailer2.get(tgt).size()-1;y++){
                        System.out.print(retailer2.get(tgt).get(y)+", ");
                    }
                    System.out.print("and " + retailer2.get(tgt).get(retailer2.get(tgt).size()-1) + " in ");
                    for(int y = 0;y<premise.size();y++){
                        premise p = new premise(premise.get(y));
                        if(p.getCode().equals(retailer2.get(tgt).get(0))){
                            System.out.println(p.getPremise());
                            System.out.println("Adress: " + p.getAddress() + "\n");
                        }
                    }
                    for(int y = 1;y<retailer2.get(tgt).size();y++){
                        String premcd = retailer2.get(tgt).get(0);
                        String itemname = retailer2.get(tgt).get(y);
                        String itemcd = "";
                        double sum = 0;
                        double avg = 0;
                        double div = 0;
                        double mul = 0;
                        for(int a = 1;a<cart.get(userid).size();a++){
                            if(cart.get(userid).get(a).equals(itemname)){
                                mul++;
                            }
                        }
                        for(int a = 1;a<items.size();a++){
                            item it = new item(items.get(a));
                            if(it.getItem().equals(itemname)){
                                itemcd = it.getCode();
                           }
                        }
                        for(int a = 0;a<thatitem.size();a++){
                            price p = new price(thatitem.get(a));
                            if(p.getItem().equals(itemcd)&&p.getPremise().equals(premcd)){
                                sum+= p.getPrice();
                                div+=1;
                            }
                        }
                        avg = sum/div;
                        toootal[0]+=avg*mul;
                    }
                    if(max<cart.get(userid).size()-1){
                        for(int y = 1;y<cart.get(userid).size();y++){
                            int det = 0;
                            for(int z = 1;z<retailer2.get(tgt).size();z++){
                                if(cart.get(userid).get(y).equals(retailer2.get(tgt).get(z))){
                                    det++;
                                }
                            }
                            if(det==0){
                                themissing.add(cart.get(userid).get(y));
                            }
                        }
                        missing(themissing,toootal,thatitem,items,premise,cart.get(userid));
                    }
                    
                }
            }else if(choice==3){
                System.out.println("Which item do you want to remove?");
                int jjk = 0;
                ArrayList<String>remov = new ArrayList<String>();
                for(int x = 1;x<cart.get(userid).size();x++){
                    int countxx = 0;
                    for(int y = 1;y<x;y++){
                        if(cart.get(userid).get(x).equals(cart.get(userid).get(y))){
                            countxx++;
                            break;
                        }
                    }
                    if(countxx ==0){
                        remov.add(cart.get(userid).get(x));
                        System.out.println((jjk+1) + ". "+cart.get(userid).get(x));
                        jjk++;
                    }
                }
                System.out.println("Cancel-any other number.");
                System.out.print("Enter your choice: ");
                int cc = input.nextInt();
                if(cc<=remov.size()){
                    System.out.println("How many items of this kind do you want to remove?");
                    System.out.print("Enter your choice: ");
                    int times = input.nextInt();
                    int bbb = 0;
                    while(bbb<times){
                        String target = remov.get(cc-1);
                        for(int ccc = 0;ccc<cart.get(userid).size();ccc++){
                            if(target.equals(cart.get(userid).get(ccc))){
                                cart.get(userid).remove(ccc);
                                break;
                            }
                        }
                        bbb++;
                    }
                }
            }else{
                break;
            }
        }
        }
    }
    
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
    
    public static void selection(ArrayList<String[]>items,ArrayList<String[]>premise,ArrayList<String[]>pricecatcher,ArrayList<ArrayList<String>>cart,String[]selection,int userid){
        while(true){
        System.out.println("Selected: " + selection[1]);
        Scanner input = new Scanner(System.in);
        item go = new item(selection);
        System.out.println("Select actions: ");
        System.out.println("1.View item details");
        System.out.println("2.Modify item details");
        System.out.println("3.View top 5 cheapest seller");
        System.out.println("4.View price trend");
        System.out.println("5.Add to shopping cart");
        System.out.println("6.Back");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        if(choice == 1){
        System.out.println("Details: ");
        System.out.println("Item code: " + go.getCode());
        System.out.println("Item name: " + go.getItem());
        System.out.println("Item unit: " + go.getUnit());
        System.out.println("Item main category: " + go.getGroup());
        System.out.println("Item sub category: " + go.getCat());
        }else if(choice == 2){
            System.out.print("Do you want to change item code?YES-1,NO-any other number: ");
            int c = input.nextInt();
            input.nextLine();
            if(c==1){
                while(true){
                System.out.println("Enter new code: ");
                String code = input.next();
                input.nextLine();
                int sim = 0;
                for(int i = 1;i<items.size();i++){
                    item it = new item(items.get(i));
                    if(code.equals(it.getCode())){
                        sim++;
                        break;
                    }
                }
                if(sim == 0){
                    go.setCode(code);
                    item t = new item(selection);
                    for(int i = 1;i<pricecatcher.size();i++){
                        price p = new price(pricecatcher.get(i));
                        if(t.getCode().equals(p.getItem())){
                            p.setItem(code);
                            pricecatcher.set(i,p.newPrices());
                        }
                    }
                    selection[0]=code;
                    break;
                }else{
                    System.out.println("Code existed");
                }
                }
            }
            System.out.print("Do you want to change item name?YES-1,NO-any other number: ");
            c = input.nextInt();
            input.nextLine();
            if(c==1){
                while(true){
                System.out.println("Enter new name: ");
                String name = input.nextLine();
                int sim = 0;
                for(int i = 1;i<items.size();i++){
                    item it = new item(items.get(i));
                    if(name.equals(it.getItem())){
                        sim++;
                        break;
                    }
                }
                if(sim == 0){
                    go.setItem(name);
                    selection[1] = name;
                    break;
                }else{
                    System.out.println("Name existed");
                }
                }
            }
            System.out.print("Do you want to change item unit?YES-1,NO-any other number: ");
            c = input.nextInt();
            input.nextLine();
            if(c==1){
                System.out.println("Enter new group/main category: ");
                String unit = input.nextLine();
                go.setUnit(unit);
                selection[2]=unit;
            }
            System.out.print("Do you want to change item group/main category?YES-1,NO-any other number: ");
            c = input.nextInt();
            input.nextLine();
            if(c==1){
                System.out.println("Enter new group/main category: ");
                String group = input.nextLine();
                go.setGroup(group);
                selection[3]=group;
            }
            System.out.print("Do you want to change item sub category?YES-1,NO-any other number: ");
            c = input.nextInt();
            input.nextLine();
            if(c==1){
                System.out.println("Enter new group/main category: ");
                String sub = input.nextLine();
                go.setCat(sub);
                selection[4]=sub;
            }
            String[]newitems = go.newitem();
            item goes = new item(selection);
            for(int i = 1;i<items.size();i++){
                item j = new item(items.get(i));
                if(j.getCode().equals(goes.getCode())){
                    items.set(i,newitems);
                    break;
                }
            }
        }else if(choice == 3){
            System.out.println("View based on date-1,based on overall average price-any other number: ");
            int sel = input.nextInt();
            input.nextLine();
            if(sel == 1){
            System.out.println("Enter a date(YYYY-MM-DD): ");
            String dat = input.nextLine();
            ArrayList<String[]>thatday = new ArrayList<String[]>();
            for(int i = 1;i<pricecatcher.size();i++){
                price p = new price(pricecatcher.get(i));
                if(dat.equals(p.getDate())&&go.getCode().equals(p.getItem())){
                    thatday.add(pricecatcher.get(i));
                }
            }
            if(thatday.size()==0){
                System.out.println("no records");
            }else{
            for(int i = 0;i<thatday.size()-1;i++){
                for(int j = 0;j<thatday.size()-1-i;j++){
                    price p = new price(thatday.get(j));
                    price q = new price(thatday.get(j+1));
                    if(p.getPrice()>q.getPrice()){
                        String[]temp = thatday.get(j);
                        thatday.set(j,thatday.get(j+1));
                        thatday.set(j+1,temp);
                    }
                }
            }
            System.out.println("Top 5 cheapest sellers on "+ dat + ": ");
            for(int i =0;i<5;i++){
                if(i<thatday.size()){
                price p = new price(thatday.get(i));
                for(int j = 0;j<premise.size();j++){
                    premise pr = new premise(premise.get(j));
                    if(p.getPremise().equals(pr.getCode())){
                        System.out.printf("%d. %s\n",i+1,pr.getPremise());
                        System.out.printf("Price: %.2f\n",p.getPrice());
                        System.out.printf("Address: %s\n",pr.getAddress());
                        break;
                    }
                }
                }
            }
            }
            }
            else{
                ArrayList<String[]>thatitem = new ArrayList<String[]>();
                ArrayList<String>retailers = new ArrayList<String>();
                ArrayList<Double>retpr = new ArrayList<Double>();
                for(int i = 1;i<pricecatcher.size();i++){
                    price p = new price(pricecatcher.get(i));
                    if(p.getItem().equals(go.getCode())){
                        thatitem.add(pricecatcher.get(i));
                    }
                }
                if(thatitem.size()==0){
                    System.out.println("no records");
                }else{
                for(int i = 0;i<thatitem.size();i++){
                    price p = new price(thatitem.get(i));
                    String pcode = p.getPremise();
                    int count = 0;
                    for(int j = 0;j<i;j++){
                        price pn = new price(thatitem.get(j));
                        if(pcode.equals(pn.getPremise())){
                            count++;
                            break;
                        }
                    }
                    if(count==0){
                        retailers.add(pcode);
                    }
                }
                for(int i = 0;i<retailers.size();i++){
                    double sum = 0;
                    double divider = 0;
                    double avg = 0;
                    for(int j = 0;j<thatitem.size();j++){
                        price p = new price(thatitem.get(j));
                        if(p.getPremise().equals(retailers.get(i))){
                            sum+=p.getPrice();
                            divider++;
                        }
                    }
                    avg = sum/divider;
                    retpr.add(avg);
                }
                for(int i = 0;i<retpr.size()-1;i++){
                    for(int j = 0;j<retpr.size()-1-i;j++){
                        if(retpr.get(j)>retpr.get(j+1)){
                            double tempp = retpr.get(j);
                            String tempr = retailers.get(j);
                            retpr.set(j,retpr.get(j+1));
                            retpr.set(j+1, tempp);
                            retailers.set(j,retailers.get(j+1));
                            retailers.set(j+1,tempr);
                        }
                    }
                }
                System.out.println("Top 5 cheapest seller on average price: ");
                for(int i = 0;i<5;i++){
                    if(i<retailers.size()){
                        for(int j = 0;j<premise.size();j++){
                            premise pr = new premise(premise.get(j));
                            if(pr.getCode().equals(retailers.get(i))){
                                System.out.printf("%d. %s\n",i+1,pr.getPremise());
                                System.out.printf("Price: %.2f\n",retpr.get(i));
                                System.out.printf("Address: %s\n",pr.getAddress());
                            }
                        }
                    }
                }
                }
            }
        }else if(choice==4){
            ArrayList<String[]>thatitem = new ArrayList<String[]>();
            for(int i = 1;i<pricecatcher.size();i++){
                price p = new price(pricecatcher.get(i));
                if(p.getItem().equals(go.getCode())){
                    thatitem.add(pricecatcher.get(i));
                }
            }
            ArrayList<String>dates = new ArrayList<String>();
            ArrayList<Double>dpr = new ArrayList<Double>();
            if(thatitem.size()==0){
                System.out.println("no records");
            }else{
                for(int i = 0;i<thatitem.size();i++){
                    price p = new price(thatitem.get(i));
                    String date = p.getDate();
                    int count = 0;
                    for(int j = 0;j<i;j++){
                        price pn = new price(thatitem.get(j));
                        if(date.equals(pn.getDate())){
                            count++;
                            break;
                        }
                    }
                    if(count==0){
                        dates.add(date);
                    }
                }
                for(int i = 0;i<dates.size();i++){
                    double sum = 0;
                    double divider = 0;
                    double avg = 0;
                    for(int j = 0;j<thatitem.size();j++){
                        price p = new price(thatitem.get(j));
                        if(p.getDate().equals(dates.get(i))){
                            sum+=p.getPrice();
                            divider++;
                        }
                    }
                    avg = sum/divider;
                    double round = avg%0.1;
                    if(round<0.05){
                        avg = avg-round;
                    }else{
                        avg = avg-round+0.1;
                    }
                    dpr.add(avg);
                }
                double totavg = 0;
                double totsum = 0;
                for(int i = 0;i<dpr.size();i++){
                    totsum+= dpr.get(i);
                }
                totavg = totsum/dpr.size();
                double round = totavg%0.1;
                if(round<0.05){
                    totavg = totavg-round;
                }else{
                    totavg = totavg-round+0.1;
                }
                System.out.println("Price trend chart for product " + go.getItem());
                System.out.printf("Average price for this product is: %.2f",totavg);
                System.out.println("For the price,1 \"+\" means RM1 above average,1 \"*\" means 10 cent above average");
                System.out.println("While 1 \"-\" means RM1 below average,1 \"_\" means 10 cent below average");
                System.out.printf("%12s%3s%20s\n","Days","|","Price");
                System.out.println("-------------------------------------------------------------------------------------");
                for(int i = 0;i<dates.size();i++){
                    int one = 0;
                    int dot1 = 0;
                    System.out.printf("%12s%3s(%.2f)",dates.get(i),"|",dpr.get(i));
                    double temp = dpr.get(i);
                    if(temp>totavg){
                        double rem = temp-totavg;
                        while(rem>1){
                            rem--;
                            one++;
                        }
                        while(rem>0.1){
                            rem-=0.1;
                            dot1++;
                        }
                        
                        for(int x = 0;x<one;x++){
                            System.out.print("+");
                        }
                        for(int x = 0;x<dot1;x++){
                            System.out.print("*");
                        }
                        
                    }else if(temp<totavg){
                        double rem = totavg - temp;
                        while(rem>1){
                            rem--;
                            one++;
                        }
                        while(rem>0.1){
                            rem-=0.1;
                            dot1++;
                        }
                        
                        for(int x = 0;x<one;x++){
                            System.out.print("-");
                        }
                        for(int x = 0;x<dot1;x++){
                            System.out.print("_");
                        }
                        
                    }
                    System.out.println("");
                }
            }
            
        }else if(choice==5){
            cart.get(userid).add(go.getItem());
            System.out.println("Item successfully added\n");
        }else if(choice==6){
            break;
        }else{
            System.out.println("Invalid choice");
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
    
    public static void missing(ArrayList<String>themissing,double[]toootal,ArrayList<String[]>thatitem,ArrayList<String[]>items,ArrayList<String[]>premise,ArrayList<String>cart){
        ArrayList<String>newmissing = new ArrayList<String>();
        ArrayList<String[]>newitem = new ArrayList<String[]>();
        ArrayList<ArrayList<String>>retailer = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>>retailer2 = new ArrayList<ArrayList<String>>();
        ArrayList<Double>retpr = new ArrayList<Double>();
        int org = themissing.size();
        String itemcd = "";
        for(int i =0;i<themissing.size();i++){
            for(int j = 0;j<items.size();j++){
                item it = new item(items.get(j));
                if(it.getItem().equals(themissing.get(i))){
                    itemcd = it.getCode();
                }
            }
            for(int j = 0;j<thatitem.size();j++){
                price p = new price(thatitem.get(j));
                if(itemcd.equals(p.getItem())){
                    newitem.add(thatitem.get(j));
                }
            }
        }
        for(int i = 0;i<newitem.size();i++){
            price p = new price(newitem.get(i));
            String pcode = p.getPremise();
            int count = 0;
            for(int j = 0;j<i;j++){
                price pn = new price(newitem.get(j));
                if(pcode.equals(pn.getPremise())){
                    count++;
                    break;
                }
            }
            if(count==0){
                ArrayList<String>ppp = new ArrayList<String>();
                ppp.add(pcode);
                retailer.add(ppp);
            }
        }
        for(int y = 0;y<retailer.size();y++){
            String premcd = retailer.get(y).get(0);
            ArrayList<String>own = new ArrayList<String>();
            own.add(premcd);
            int inxx=1;
            for(int z = 0;z<newitem.size();z++){
                price p = new price(newitem.get(z));
                if(p.getPremise().equals(premcd)){
                String itemcode = p.getItem();
                int count = 0;
                String itemname = "";
                for(int a = 1;a<items.size();a++){
                    item it = new item(items.get(a));
                    if(itemcode.equals(it.getCode())){
                        itemname = it.getItem();
                    }
                }
                for(int a = 1;a<inxx;a++){
                    if(own.get(a).equals(itemname)){
                        count++;
                        break;
                    }
                }
                if(count==0){
                    own.add(itemname);
                    inxx++;
                }
                }
            }
            retailer.set(y, own);
        }
        int max = 0;
        for(int y =0;y<retailer.size();y++){
            if(retailer.get(y).size()>max){
                max = retailer.get(y).size();
            }
        }
                    
        for(int y = 0;y<retailer.size();y++){
            if(retailer.get(y).size()==max){
                retailer2.add(retailer.get(y));
            }
        }
        for(int y = 0;y<retailer2.size();y++){
            double tot = 0;
            for(int z = 1;z<retailer2.get(y).size();z++){
                String premcd = retailer2.get(y).get(0);
                itemcd = "";
                double sum = 0;
                double avg = 0;
                double div = 0;
                for(int a = 1;a<items.size();a++){
                    item it = new item(items.get(a));
                    if(it.getItem().equals(retailer2.get(y).get(z))){
                        itemcd = it.getCode();
                    }
                }
                for(int a = 0;a<newitem.size();a++){
                    price p = new price(newitem.get(a));
                    if(p.getItem().equals(itemcd)&&p.getPremise().equals(premcd)){
                        sum+= p.getPrice();
                        div+=1;
                    }
                }
                avg = sum/div;
                tot+=avg;
                }
            retpr.add(tot);
        }
        double min = retpr.get(0);
        int tgt =0 ;
        for(int k = 0;k<retpr.size();k++){
            if(retpr.get(k)<min){
                min = retpr.get(k);
            }
        }
        for(;tgt<retpr.size();tgt++){
            if(retpr.get(tgt)==min){
                break;
            }
        }
        for(int y = 1;y<retailer2.get(tgt).size()-1;y++){
            System.out.print(retailer2.get(tgt).get(y)+", ");
        }
        System.out.print("and " + retailer2.get(tgt).get(retailer2.get(tgt).size()-1) + " in ");
        for(int y = 0;y<premise.size();y++){
            premise p = new premise(premise.get(y));
            if(p.getCode().equals(retailer2.get(tgt).get(0))){
                System.out.println(p.getPremise());
                System.out.println("Adress: " + p.getAddress() + "\n");
            }
        }
        for(int y = 1;y<retailer2.get(tgt).size();y++){
            String premcd = retailer2.get(tgt).get(0);
            String itemname = retailer2.get(tgt).get(y);
            itemcd = "";
            double sum = 0;
            double avg = 0;
            double div = 0;
            double mul = 0;
            for(int a = 1;a<cart.size();a++){
                if(cart.get(a).equals(itemname)){
                    mul++;
                }
            }
            for(int a = 1;a<items.size();a++){
                item it = new item(items.get(a));
                if(it.getItem().equals(itemname)){
                    itemcd = it.getCode();
                }
            }
            for(int a = 0;a<newitem.size();a++){
                price p = new price(newitem.get(a));
                if(p.getItem().equals(itemcd)&&p.getPremise().equals(premcd)){
                    sum+= p.getPrice();
                    div+=1;
                }
            }
            avg = sum/div;
            toootal[0]+=avg*mul;
        }
        
        if(max<themissing.size()&&max!=0){
            for(int y = 1;y<cart.size();y++){
                int det = 0;
                for(int z = 1;z<retailer2.get(tgt).size();z++){
                    if(cart.get(y).equals(retailer2.get(tgt).get(z))){
                        det++;
                    }
                }
                if(det==0){
                    newmissing.add(cart.get(y));
                }
            }
            missing(newmissing,toootal,newitem,items,premise,cart);
        }else if(max==0){
            System.out.printf("with the total of RM %.2f",toootal[0]);
            for(int i = 0;i<themissing.size()-1;i++){
                System.out.println(themissing.get(i) + ", ");
            }
            System.out.println("and " + themissing.get(themissing.size()-1) + " cannot be found in any stores");
        }else{
            System.out.printf("with the total of RM %.2f",toootal[0]);
        }
    }
}
