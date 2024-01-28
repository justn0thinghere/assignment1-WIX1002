
package wix1002_2016_i_5;

public class Wix1002_2016_I_5 {

    public static void main(String[] args) {
        Rebate r = new Rebate("John Lim","1111222233334444");
        Point p = new Point("John Lim","5555666677778888");
        String[][]expense = {{"Grocery","Saturday","124.80"},
                            {"Other","Friday","64.60"},
                            {"Fuel","Sunday","95.40"},
                            {"Utility","Friday","100.00"},
                            {"Other","Tuesday","220.00"}};
        r.getReward(expense);
        p.getReward(expense);
        System.out.println(r.toString());
        System.out.println(p.toString());
        if(r.getreward()>p.getreward()){
            System.out.println("The best card is Cash Rebate Card");
        }else if(r.getreward()<p.getreward()){
            System.out.println("The best card is Point Reward Card");
        }else{
            System.out.println("Both cards are equally good");
        }
    }
    
}
