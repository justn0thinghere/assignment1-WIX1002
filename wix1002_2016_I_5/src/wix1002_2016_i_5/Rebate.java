
package wix1002_2016_i_5;

public class Rebate extends CreditCard{
    public Rebate(String n,String c){
        super(n,c);
        type = "Cash Rebate";
    }
    public void getReward(String[][]expense){
        double total = 0;
        for(int i = 0;i<expense.length;i++){
            if(expense[i][0].equalsIgnoreCase("fuel")){
                total+= Double.parseDouble(expense[i][2])*0.08;
            }else if(expense[i][0].equalsIgnoreCase("Utility")){
                total+= Double.parseDouble(expense[i][2])*0.05;
            }else if(expense[i][0].equalsIgnoreCase("grocery")){
                total+= Double.parseDouble(expense[i][2])*0.02;
            }else if(expense[i][0].equalsIgnoreCase("other")){
                total+= Double.parseDouble(expense[i][2])*0.002;
            }
        }
        reward = total;
    }
}
