
package javaapplication94;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class price {
    private String date;
    private String premisecode;
    private String itemcode;
    private double prices;
    private String[]newprices = new String[4];
    private ArrayList<String[]>pricecatcher = new ArrayList<String[]>();
    public price(){ //a class built for reading the values in pricecatcher file into pricecatcher array
        String line = ""; //declare object line
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\pricecatcher_2023-08.csv"));
            int i = 0;
            while((line = br.readLine()) != null){ //line will hold the value read from the csv file
                String[]pricecatche = new String[4];
                pricecatche = line.split(","); //line will be splitted into elements and stored in pricecatcher[][],[0]-date[1]-premise_code[2]-item_code[3]-price
                pricecatcher.add(pricecatche);
                i++; //update i so next line will be stored in next pricecatcher[i]
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void countprice(int[]count){
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\pricecatcher_2023-08.csv"));
            while((line = br.readLine()) != null){
                count[0]++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public price(String[]x){
        date = x[0];
        premisecode = x[1];
        itemcode = x[2];
        prices = Double.parseDouble(x[3]);
    }
    
    public ArrayList<String[]> call(){
        return pricecatcher;
    }
    
    public String getDate(){
        return date;
    }
    public String getPremise(){
        return premisecode;
    }
    public String getItem(){
        return itemcode;
    }
    public double getPrice(){
        return prices;
    }
    
    public void setDate(String n){
        date = n;
    }
    public void setPremise(String n){
        premisecode = n;
    }
    public void setItem(String n){
        itemcode = n;
    }
    public void setPrice(double n){
        prices = n;
    }
    public String[] newPrices(){
        newprices[0]=date;
        newprices[1]=premisecode;
        newprices[2]=itemcode;
        newprices[3]=String.valueOf(prices);
        return newprices;
    }
}
