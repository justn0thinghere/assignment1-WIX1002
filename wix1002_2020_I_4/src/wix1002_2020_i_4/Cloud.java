
package wix1002_2020_i_4;

public class Cloud {
    protected String Package;
    protected double cost;
    public double getcost(){
        return cost;
    }
    public Cloud(String p){
        Package = p;
    }
    public String toString(){
        return "CLoud Package: " + Package + " Total cost: " + getcost();
    }
}
