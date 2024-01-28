
package wix1002_2016_ii_5;

import java.util.Random;

public class Wix1002_2016_II_5 {

    public static void main(String[] args) {
        Random r = new Random();
        int[][]ttt = new int[3][3];
        for(int i = 0;i<ttt.length;i++){
            for(int j = 0;j<ttt[i].length;j++){
                ttt[i][j] = r.nextInt(2);
            }
        }
        for(int i = 0;i<ttt.length;i++){
            for(int j = 0;j<ttt[i].length;j++){
                System.out.print(ttt[i][j]);
            }
            System.out.println("");
        }
        for(int i = 0;i<3;i++){
            int cnt1 = 0;
            int cnt0 = 0;
            for(int j = 0;j<3;j++){
                if(ttt[i][j]==1){
                    cnt1++;
                }else{
                    cnt0++;
                }
            }
            if(cnt1==3){
                System.out.println("All 1s on row " + i);
            }else if(cnt0==3){
                System.out.println("All 0s on row " + i);
            }
        }
        for(int j = 0;j<3;j++){
            int cnt1 = 0;
            int cnt0 = 0;
            for(int i = 0;i<3;i++){
                if(ttt[i][j]==1){
                    cnt1++;
                }else{
                    cnt0++;
                }
            }
            if(cnt1==3){
                System.out.println("All 1s on column " + j);
            }else if(cnt0==3){
                System.out.println("All 0s on column " + j);
            }
        }
        int cnt1 = 0;
        int cnt0 = 0;
        for(int i = 0;i<3;i++){
            if(ttt[i][i]==1){
                cnt1++;
            }else{
                cnt0++;
            }
        }
        if(cnt1==3){
            System.out.println("All 1s on diagonal [0][0] , [1][1] , [2][2]");
        }else if(cnt0==3){
            System.out.println("All 0s on diagonal [0][0] , [1][1] , [2][2]");
        }
        cnt1 = 0;
        cnt0 = 0;
        for(int i = 0;i<3;i++){
            if(ttt[i][2-i]==1){
                cnt1++;
            }else{
                cnt0++;
            }
        }
        if(cnt1==3){
            System.out.println("All 1s on diagonal [0][2] , [1][1] , [2][0]");
        }else if(cnt0==3){
            System.out.println("All 0s on diagonal [0][2] , [1][1] , [2][0]");
        }
    }
    
}
