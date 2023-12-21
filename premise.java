
package javaapplication94;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class premise {
    ArrayList<String[]>premise = new ArrayList<String[]>();
    String premisecode;
    String premisename;
    String address;
    String premisetype;
    String state;
    String district;
    String[] new_premise = new String[6];
    public premise(){ //to read and update the values in String[][]premise, how to use?same as items
        String line = ""; //declare and initialize object line
        try{
            int [] count = {0}; //for this class it is a little bit special so we will need this
            counterpremise(count); //update the count value for later use
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\lookup_premise.csv"));
            
            int i = 0; //initialize i to be used in premise[i][]
            while((line = br.readLine()) != null){ //line will become the line readed from the file
                String[]preem = new String[6];
                if(i<1){
                    preem = line.split(","); //only works for line 1 and 2 to split all elements, [0]-premise_code [1]-premise [2]-address [3]-premise_type [4]-state [5]-district
                }
                if(i>=1&&i<count[0]){//***
                String[]prem = line.split(",");//String[]prem is declared to help split all elements, now all element are split by , and all , dissapeared, however in some premise,address and district, they have coma also and will be splitted while they should be together as one element
                int length = prem.length; //hence we declare a length var to determine how much elements are splitted and will be used later
                preem[0] = prem[0]; //index 0 is always a number string and dont have "" so premise[0]=prem[0]
                int x=0;
                if(prem[1].charAt(0)=='"'&&prem[1].charAt(prem[1].length()-1)!='"'){ //some premise name have  , in it,and all of them have " in the start and the end, so add up the one start with " until the one end with " will make the premise name which should be in premise[1] when this condition is met
                    
                    preem[1] = prem[1] +  ",";
                    x = 2;
                    while((prem[x].charAt(prem[x].length()-1))!='"'){
                        preem[1] = preem[1]+prem[x]+",";
                        x++;
                    }
                    preem[1]=preem[1]+prem[x];
                    x++;
                }else{
                    preem[1]=prem[1];
                    x=2;
                }
                if(prem[x].charAt(0)=='"'&&prem[x].charAt(prem[x].length()-1)!='"'){
                    preem[2] = ""; //initialize premise[i][2] which should be the address
                    while((prem[x].charAt(prem[x].length()-1))!='"'){ //so address always ends with a " behind the last element that should be in the address element
                        preem[2] = preem[2]+prem[x]+","; //so we add up all the elements that before that last element that have " in the end of it,making up the address with comas between every word
                        x++; //update x
                    }
                    preem[2]=preem[2]+prem[x]; //when the "last address element" that have " is reached, the loop will stop and that element will not be added, so we add it here
                    x++;
                }else{
                    preem[2]=prem[x];
                    x++;
                }
                    int j = 3; //for [i][3] and [i][4], there is no problem bcause they are always one element without ,
                    while(j<5){
                        preem[j] = prem[x]; //so we just have to give them the values which held in the 2 current prem[x]
                        j++;
                        x++;
                    }
                    preem[5]="";
                    if(prem[x].charAt(0)=='"'&&prem[x].charAt(prem[x].length()-1)!='"'){ //for the last element,district some of them have , between them, so will they be splitted
                        while(x<length-1){ //while x is smaller than value of length, the loop will go on, until the last element in prem[] is reached
                            preem[5] += prem[x]+",";//hence we combine them into one element
                            x++;
                        }
                        preem[5] += prem[x];
                    }else{ // for those district that have no , between just initialize them as normal, assign the value of the last x into it.
                        preem[5] = prem[x];
                    }
                
                }
                premise.add(preem);
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void counterpremise(int [] count){ 
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication94\\src\\javaapplication94\\lookup_premise.csv"));
            while((line = br.readLine()) != null){
                count[0]++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<String[]>calling(){
        return premise;
    }
    
    public premise(String[]x){
        premisecode = x[0];
        premisename = x[1];
        address = x[2];
        premisetype = x[3];
        state = x[4];
        district = x[5];
    }
    
    public String getCode(){
        return premisecode;
    }
    public String getPremise(){
        return premisename;
    }
    public String getAddress(){
        return address;
    }
    public String getType(){
        return premisetype;
    }
    public String getState(){
        return state;
    }
    public String getDistrict(){
        return district;
    }
    
    public void setCode(String n){
        premisecode = n;
    }
    public void setPremise(String n){
        int count = 0;
        for(int i = 0;i<n.length();i++){
            if(n.charAt(i)==','){
                count++;
                break;
            }
        }
        if(count==1){
            premisename = '"' + n + '"';
        }else{
            premisename = n;
        }
    }
    public void setAddress(String n){
        int count = 0;
        for(int i = 0;i<n.length();i++){
            if(n.charAt(i)==','){
                count++;
                break;
            }
        }
        if(count==1){
            address = '"' + n + '"';
        }else{
            address = n;
        }
    }
    public void setState(String n){
        state = n;
    }
    public void setDistrict(String n){
        int count = 0;
        for(int i = 0;i<n.length();i++){
            if(n.charAt(i)==','){
                count++;
                break;
            }
        }
        if(count==1){
            district = '"' + n + '"';
        }else{
            district = n;
        }
    }
    public String[] newpremise(){
        new_premise[0]=premisecode;
        new_premise[1]=premisename;
        new_premise[2]=address;
        new_premise[3]=premisetype;
        new_premise[4]=state;
        new_premise[5]=district;
        return new_premise;
    }
}
