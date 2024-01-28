
package wix1002_2016_i_5;

public class Point extends CreditCard{
    public Point(String n,String c){
        super(n,c);
        type = "Point Reward";
    }
    public void getReward(String[][]expense){
        double total = 0;
        for(int i = 0;i<expense.length;i++){
            double x = Double.parseDouble(expense[i][2])%1;
            if(expense[i][1].equalsIgnoreCase("Friday")){    
                total+= (Double.parseDouble(expense[i][2])-x)*2;
            }else if(expense[i][1].equalsIgnoreCase("Saturday")){    
                total+= (Double.parseDouble(expense[i][2])-x)*3;
            }else if(expense[i][1].equalsIgnoreCase("Sunday")){    
                total+= (Double.parseDouble(expense[i][2])-x)*4;
            }else{
                total+= (Double.parseDouble(expense[i][2])-x);
            }
        }
        total = total * 0.01;
        reward = total;
    }
}
