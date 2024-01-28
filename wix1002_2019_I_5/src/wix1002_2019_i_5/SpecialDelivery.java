
package wix1002_2019_i_5;

public class SpecialDelivery extends Delivery{
    protected boolean weekend;
    protected boolean nighttime;
    public SpecialDelivery(String s,String r,double w,boolean we,boolean nt){
        super(s,r,w);
        weekend = we;
        nighttime = nt;
    }
    public double totalCost(){
        double cost = super.totalCost();
        if(weekend){
            cost = cost+50;
        }
        if(nighttime){
            cost = cost*1.2;
        }
        return cost;
    }
    public String toString(){
        if(weekend&&nighttime){
            return super.toString() + "\nWeekend Delivery\nNIghttime Delivery";
        }else if(weekend){
            return super.toString() + "\nWeekend Delivery";
        }else if(nighttime){
            return super.toString() + "\nNIghttime Delivery";
        }else{
            return super.toString();
        }
    }
}
