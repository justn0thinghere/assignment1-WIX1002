/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication94;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class chooseitem {
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
    
    public static void selection(ArrayList<String[]>items,ArrayList<String[]>premise,ArrayList<String[]>pricecatcher,ArrayList<ArrayList<String>>cart,String[]selection,int userid){
        while(true){
        System.out.println("Selected: " + selection[1]);
        Scanner input = new Scanner(System.in);
        item go = new item(selection);
        String[]org = selection;
        System.out.println("Select actions: ");
        System.out.println("1.View item details");
        System.out.println("2.Modify item details");
        System.out.println("3.View top 5 cheapest seller");
        System.out.println("4.View price trend");
        System.out.println("5.Add to shopping cart");
        System.out.println("6.Remove item");
        System.out.println("Back - Any other number");
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
                    for(int i = 0;i<cart.size();i++){
                        cart.get(i).remove(org[1]);
                    }
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
                selection[2] = unit;
            }
            System.out.print("Do you want to change item group/main category?YES-1,NO-any other number: ");
            c = input.nextInt();
            input.nextLine();
            if(c==1){
                System.out.println("Enter new group/main category: ");
                String group = input.nextLine();
                go.setGroup(group);
                selection[3] = group;
            }
            System.out.print("Do you want to change item sub category?YES-1,NO-any other number: ");
            c = input.nextInt();
            input.nextLine();
            if(c==1){
                System.out.println("Enter new group/main category: ");
                String sub = input.nextLine();
                go.setCat(sub);
                selection[4] = sub;
            }
            String[]newitems = go.newitem();
            item goes = new item(org);
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
                    double temp = dpr.get(i);
                    round = temp%0.1;
                    if(round<0.05){
                        temp = temp-round;
                    }else{
                        temp = temp-round+0.1;
                    }
                    System.out.printf("%12s%3s(%.2f)",dates.get(i),"|",temp);
                    if(temp>totavg){
                        double rem = temp-totavg;
                        while(rem>=1){
                            one++;
                            rem--;
                        }
                        dot1 = (int)Math.round(rem/0.1);
                        for(int x = 0;x<one;x++){
                            System.out.print("+");
                        }
                        for(int x = 0;x<dot1;x++){
                            System.out.print("*");
                        }
                        
                    }else if(temp<totavg){
                        double rem = totavg - temp;
                        while(rem>=1){
                            one++;
                            rem--;
                        }
                        dot1 = (int)Math.round(rem/0.1);
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
            for(int i = 1;i<items.size();i++){
                item it = new item(items.get(i));
                if(it.getItem().equals(selection[1])){
                    items.remove(i);
                    String cod = it.getCode();
                    for(int j = 1;j<pricecatcher.size();j++){
                        price p = new price(pricecatcher.get(j));
                        if(cod.equals(p.getItem())){
                            pricecatcher.remove(j);
                            break;
                        }
                    }
                    break;
                }
            }
            for(int i = 0;i<cart.size();i++){
                cart.get(i).remove(selection[1]);
            }
            break;
        }else{
            break;
        }
        }
    }
}
