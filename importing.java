
package javaapplication94;

import java.util.ArrayList;
import java.util.Scanner;

public class importing {
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
                        for(int i=0;i<newpremise.size();i++){
                            premise p = new premise(newpremise.get(i));
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
                        for(int i = 0;i<newitem.size();i++){
                            item iteem = new item(newitem.get(i));
                            if(line3.equals(iteem.getCode())){
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
                    default:
                        System.out.println("Invalid choice");
                        break;
            }
        }
     }
    }
}
