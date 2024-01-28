
package wix1002_2020_i_4;

public class CloudPackage extends Cloud {
    protected int core;
    protected int memory;
    protected double pph; //pph stands for price per hour
    public CloudPackage(String p,int c,int m,double pp){
        super(p);
        core = c;
        memory =m;
        pph = pp;
    }
    public boolean check(Job j){
        if(this.memory>=j.memory){
            return true;
        }else{
            return false;
        }
    }
    public void totalCost(Job j){
        cost = (j.task/core) * pph;
    }
}
