
package wix1002_2016_i_5;

public class CreditCard {
    protected String name;
    protected String cardnum;
    protected String type;
    protected double reward;
    public CreditCard(String n,String c){
        name = n;
        cardnum = c;
        type = "";
    }
    public double getreward(){
        return reward;
    }
    public void setReward(double d){
        reward = d;
    }
    public String toString(){
        return "Name of cardholder: " + name + "\nCard number: " + cardnum + "\nCard type: " + type + "\nTotal cash reward: " + reward;
    }
}
