
package wix1002_2020_i_4;

public class Wix1002_2020_I_4 {

    public static void main(String[] args) {
        Job J1 = new Job("J1",252,20);
        Job J2 = new Job("J2",108,10);
        Job J3 = new Job("J3",72,25);
        
        CloudPackage clouds0 = new CloudPackage("P2-15",4,15,1.24);
        CloudPackage clouds1 = new CloudPackage("P2-30",6,30,2.11);
        CloudPackage clouds2 = new CloudPackage("P5-20",4,20,1.38);
        CloudPackage clouds3 = new CloudPackage("P6-30",6,20,1.88);
        CloudPackage[]clouds = {clouds0,clouds1,clouds2,clouds3};
        double[]costJ1 = new double[4];
        double[]costJ2 = new double[4];
        double[]costJ3 = new double[4];
        for(int i = 0;i<costJ1.length;i++){
            if(clouds[i].check(J1)){
                clouds[i].totalCost(J1);
                costJ1[i] = clouds[i].getcost();
            }
        }
        for(int i = 0;i<costJ2.length;i++){
            if(clouds[i].check(J2)){
                clouds[i].totalCost(J2);
                costJ2[i] = clouds[i].getcost();
            }
        }
        for(int i = 0;i<costJ3.length;i++){
            if(clouds[i].check(J3)){
                clouds[i].totalCost(J3);
                costJ3[i] = clouds[i].getcost();
            }
        }
        double total = 0;
        System.out.println(J1.toString());
        double min1 = 999999999;
        for(int i = 0;i<costJ1.length;i++){
            if(costJ1[i]!=0&&costJ1[i]<min1){
                min1 = costJ1[i];
            }
        }
        total+=min1;
        for(int i = 0;i<costJ1.length;i++){
            if(costJ1[i]==min1){
                clouds[i].totalCost(J1);
                System.out.println(clouds[i].toString());
            }
        }
        System.out.println(J2.toString());
        double min2 = 999999999;
        for(int i = 0;i<costJ2.length;i++){
            if(costJ2[i]!=0&&costJ2[i]<min2){
                min2 = costJ2[i];
            }
        }
        total+=min2;
        for(int i = 0;i<costJ2.length;i++){
            if(costJ2[i]==min2){
                clouds[i].totalCost(J2);
                System.out.println(clouds[i].toString());
            }
        }
        System.out.println(J3.toString());
        double min3 = 999999999;
        for(int i = 0;i<costJ3.length;i++){
            if(costJ3[i]!=0&&costJ3[i]<min1){
                min3 = costJ3[i];
            }
        }
        total+=min3;
        for(int i = 0;i<costJ3.length;i++){
            if(costJ3[i]==min3){
                clouds[i].totalCost(J3);
                System.out.println(clouds[i].toString());
            }
        }
        System.out.println("Total cost: " + total);
    }
    
}
