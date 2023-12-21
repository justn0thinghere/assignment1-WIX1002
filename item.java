
package javaapplication94;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class item {
    private ArrayList<String[]>items = new ArrayList<String[]>();
    private String itemcode;
    private String item;
    private String unit;
    private String item_group;
    private String item_category;
    private String[]new_item = new String[5];
    public item(){
        String line = ""; //declare object line
        try{
            int [] count = {0};
            counteritem(count);
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\lookup_item.csv"));
            int i = 0; //decalre int i to be the first index number in the array items[(this)][]
            while((line = br.readLine()) != null){ //line is given the value the Line readed from the file
                String[]iteem = new String[5];
                if(i<1){
                    iteem=line.split(",");
                }
                if(i>=1&&i<count[0]){
                String[]item = line.split(","); //split the line readed from the file [i][0]-item_code [i][1]-item [i][2]-unit [i][3]-item_group [i][4]-item_category
                int length = item.length;
                iteem[0]= item[0];
                if(item[1].charAt(0) == '"' && item[1].charAt(item[1].length()-1)!='"'){
                    iteem[1] = item[1] + ",";
                    int x =2;
                    while((item[x].charAt(item[x].length()-1))!='"'){
                        iteem[1] = iteem[1]+item[x]+",";
                        x++;
                    }
                    iteem[1] = iteem[1]+item[x];
                    x++;
                    for(int j = 2;j<iteem.length;j++){
                        iteem[j] = item[x];
                        x++;
                    }
                }
                else{
                    iteem = line.split(",");
                }
                }
                items.add(iteem);
                i++; //update i so the next line will be split and become the elements of the next items[i][]
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public item(String[]x){
        itemcode = x[0];
        item = x[1];
        unit = x[2];
        item_group = x[3];
        item_category = x[4];
    }
    
    public String getCode(){
        return itemcode;
    }
    
    public String getItem(){
        return item;
    }
    
    public String getUnit(){
        return unit;
    }
    
    public String getGroup(){
        return item_group;
    }
    
    public String getCat(){
        return item_category;
    }
    
    public static void counteritem(int [] count){ //this is to change the value of coutn[0] as it is reffered in this class, so any changes made in this class will relfect on count[0], all other count classes works as the same function
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\lookup_item.csv"));
            while((line = br.readLine()) != null){ //if the line readed has a value then count will +1 to know how many lines have value
                count[0]++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<String[]> call(){
        return items;
    }
    public void setCode(String n){
        itemcode = n;
    }
    public void setItem(String n){
        int count = 0;
        for(int i = 0;i<n.length();i++){
            if(n.charAt(i)==','){
                count++;
                break;
            }
        }
        if(count==1){
            item = '"' + n + '"';
        }else{
            item = n;
        }
    }
    public void setUnit(String n){
        unit = n;
    }
    public void setGroup(String n){
        item_group = n;
    }
    public void setCat(String n){
        item_category = n;
    }
    public String[] newitem(){
        new_item[0] = itemcode;
        new_item[1] = item;
        new_item[2] = unit;
        new_item[3] = item_group;
        new_item[4] = item_category;
        return new_item;
    }
}
