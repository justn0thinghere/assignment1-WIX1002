
package javaapplication94;

import java.util.ArrayList;
import java.util.Scanner;

public class shopcarts {
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
                    ArrayList<String>filter = new ArrayList<String>();
                    ArrayList<String>chosenfilter = new ArrayList<String>();
                    for(int x = 1;x<premise.size();x++){
                        premise p = new premise(premise.get(x));
                        int sim = 0;
                        for(int y = 1;y<x;y++){
                            premise pn = new premise(premise.get(y));
                            if(p.getDistrict().equals(pn.getDistrict())){
                                sim++;
                                break;
                            }
                        }
                        if(sim == 0){
                            filter.add(p.getDistrict());
                        }
                    }
                    while(true){
                        System.out.println("Choose any district you want to add into filter");
                        for(int x = 0;x<filter.size();x++){
                            System.out.printf("%d. %s\n",x+1,filter.get(x));
                        }
                        System.out.println("%End - any other number");
                        System.out.print("Enter your choice: ");
                        int filterchoice = input.nextInt();
                        input.nextLine();
                        if(filterchoice<=filter.size()){
                            int sim = 0;
                            for(int y = 0;y<chosenfilter.size();y++){
                                if(filter.get(filterchoice-1).equals(chosenfilter.get(y))){
                                    sim++;
                                }
                            }
                            if(sim==0){
                                chosenfilter.add(filter.get(filterchoice-1));
                            }
                        }else{
                            break;
                        }
                    }
                    if(chosenfilter.size()==0){
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
                        finding(thatitem,themissing,retailer,retailer2,retpr,items,premise,pricecatcher,cart,userid);
                    }else{
                        System.out.println("Your chosen filters are: ");
                        for(int x = 0;x<chosenfilter.size()-1;x++){
                            System.out.print(chosenfilter.get(x) + ",");
                        }
                        System.out.println(chosenfilter.get(chosenfilter.size()-1));
                        for(int x = 1;x<cart.get(userid).size();x++){
                            String code = "";
                            for(int y = 1;y<items.size();y++){
                                item go = new item(items.get(y));
                                if(cart.get(userid).get(x).equals(go.getItem())){
                                    code = go.getCode();
                                    break;
                                }
                            }
                            for(int k = 0;k<chosenfilter.size();k++){
                                String filtered = chosenfilter.get(k);
                                for(int kj = 0;kj<premise.size();kj++){
                                    premise pn = new premise(premise.get(kj));
                                    String district = pn.getDistrict();
                                    String premcd = pn.getCode();
                                    if(district.equals(filtered)){
                                        for(int y = 1;y<pricecatcher.size();y++){
                                            price p = new price(pricecatcher.get(y));
                                            String premcode = p.getPremise();
                                            if(p.getItem().equals(code)&&premcode.equals(premcd)){
                                                thatitem.add(pricecatcher.get(y));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    finding(thatitem,themissing,retailer,retailer2,retpr,items,premise,pricecatcher,cart,userid);
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
                    finding(thatitem,themissing,retailer,retailer2,retpr,items,premise,pricecatcher,cart,userid);
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
    
    public static void finding(ArrayList<String[]>thatitem,ArrayList<String>themissing,ArrayList<ArrayList<String>>retailer,ArrayList<ArrayList<String>>retailer2,ArrayList<Double>retpr,ArrayList<String[]>items,ArrayList<String[]>premise,ArrayList<String[]>pricecatcher,ArrayList<ArrayList<String>>cart,int userid){
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
                        if(retailer.get(y).size()-1>max){
                            max = retailer.get(y).size()-1;
                        }
                    }
                    
                    for(int y = 0;y<retailer.size();y++){
                        if(retailer.get(y).size()==max+1){
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
                    System.out.print(retailer2.get(tgt).get(retailer2.get(tgt).size()-1) + " in ");
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
                        System.out.printf("1 unit of %s is %.2f, %.0f unit of it is %.2f\n\n",itemname,avg,mul,avg*mul);
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
    
    public static void missing(ArrayList<String>themissing,double[]toootal,ArrayList<String[]>thatitem,ArrayList<String[]>items,ArrayList<String[]>premise,ArrayList<String>cart){
        ArrayList<String>newmissing = new ArrayList<String>();
        ArrayList<String[]>newitem = new ArrayList<String[]>();
        ArrayList<ArrayList<String>>retailer = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>>retailer2 = new ArrayList<ArrayList<String>>();
        ArrayList<Double>retpr = new ArrayList<Double>();
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
            if(retailer.get(y).size()-1>max){
                max = retailer.get(y).size()-1;
            }
        }
                    
        for(int y = 0;y<retailer.size();y++){
            if(retailer.get(y).size()==max+1){
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
        double min = 0;
        int tgt = 0;
        if(retpr.size()>0){
            min = retpr.get(0);
        }
        if(retailer2.size()>0){
        for(int k = 0;k<retpr.size();k++){
            if(retpr.get(k)<min){
                min = retpr.get(k);
            }
        }
        tgt =0 ;
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
            System.out.printf("1 unit of %s is %.2f, %.0f unit of it is %.2f\n\n",itemname,avg,mul,avg*mul);
            toootal[0]+=avg*mul;
        }
        }
        if(max<themissing.size()&&max>0){
            for(int y = 0;y<themissing.size();y++){
                int det = 0;
                for(int z = 1;z<retailer2.get(tgt).size();z++){
                    if(themissing.get(y).equals(retailer2.get(tgt).get(z))){
                        det++;
                    }
                }
                if(det==0){
                    newmissing.add(themissing.get(y));
                }
            }
            missing(newmissing,toootal,newitem,items,premise,cart);
        }else if(max<themissing.size()&&max==0){
            System.out.printf("with the total of RM %.2f\n",toootal[0]);
            for(int y = 0;y<themissing.size()-1;y++){
                System.out.print(themissing.get(y) + ", ");
            }
            System.out.println(themissing.get(themissing.size()-1) + " cannot be found in any stores");
        }else if(max==themissing.size()){
            System.out.printf("with the total of RM %.2f",toootal[0]);
        }
    }
}
