
package wix1002_2020_i_2;

import java.util.Scanner;

public class Wix1002_2020_I_2 {

    public static void main(String[] args) {
        char[]direction = new char[2];
        double[]degree = new double[2];
        double[]minute = new double[2];
        double[]second = new double[2];
        double[][]location = new double[2][2];//location[x][0] is latitude,location[x][1] is longitude, x is 0 and 1 for 2 locations
        System.out.println("Enter Location 1");
        input(direction,degree,minute,second);
        convert(direction,degree,minute,second,location[0]);
        System.out.println("Enter Location 2");
        input(direction,degree,minute,second);
        convert(direction,degree,minute,second,location[1]);
        for(int i = 0;i<2;i++){
            System.out.printf("Location 1: %f Latitude, %f Longitude\n",location[i][0],location[i][1]);
        }
        System.out.printf("Distance: %.2f KM\n",distance(location));
    }
    public static void input(char[]direction,double[]degree,double[]minute,double[]second){
        Scanner input = new Scanner(System.in);
        for(int i = 0;i<2;i++){
            while(true){
                System.out.println("Enter direction: ");
                direction[i]=input.next().charAt(0);
                if(direction[i]=='S'||direction[i]=='N'||direction[i]=='W'||direction[i]=='E'){
                    break;
                }else{
                    System.out.println("Invalid direction");
                }
            }
            System.out.println("Enter degree, minute and second: ");
            degree[i] = input.nextDouble();
            minute[i] = input.nextDouble();
            second[i] = input.nextDouble();
        }
    }
    public static void convert(char[]direction,double[]degree,double[]minute,double[]second,double[]location){
        double la = 0;
        double lon = 0;
        for(int i = 0;i<2;i++){
            if(direction[i]=='N'){
                la+= degree[i] + (minute[i]*60 + second[i])/3600;
            }else if(direction[i]=='S'){
                la-= degree[i] + (minute[i]*60 + second[i])/3600;;
            }else if(direction[i]=='E'){
                lon+=degree[i] + (minute[i]*60 + second[i])/3600;;
            }else if(direction[i]=='W'){
                lon-=degree[i] + (minute[i]*60 + second[i])/3600;;
            }   
        }
        location[0]+=la;
        location[1]+=lon;
    }
    public static double distance(double[][]location){
        double a = Math.pow(Math.sin((location[0][0]-location[1][0])*Math.PI/360),2) + Math.cos(location[0][0]*Math.PI/180)*Math.cos(location[1][0]*Math.PI/180)*Math.pow(Math.sin((location[0][1]-location[1][1])*Math.PI/360),2);
        double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        double d = c * 6371;
        return d;
    }
}
