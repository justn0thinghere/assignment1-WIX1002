
package wix1002_2019_i_5;

public class Delivery {
    protected String sender;
    protected String recipent;
    protected double weight;
    public Delivery(String s,String r,double w){
        sender = s;
        recipent = r;
        weight = w;
    }
    
    public double totalCost(){
        double cost = 0;
        if(weight <= 5){
            cost = weight*2.80;
        }else if(weight<=20){
            cost = weight*5.20;
        }else if(weight<=50){
            cost = weight*7.00;
        }else{
            cost = weight*8.60;
        }
        return cost;
    }
    
    public String toString(){
        return "From: " + sender + "\nTo: " + recipent + "\nWeight of Package: " + weight + " kg\nShipping Cost: " + totalCost();
    }
}
