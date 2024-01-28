
package wix1002_2019_i_2;

import java.util.Random;
import java.util.Scanner;

public class Wix1002_2019_I_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = input.nextInt();
        double[][][]matrix = generate(N);
        display(matrix);
        double[][]added = add(matrix);
        double[][]multiply = multiply(matrix);
        System.out.println("Matrix A + B");
        for(int i = 0;i<added.length;i++){
            for(int j = 0;j<added[i].length;j++){
                System.out.print(added[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Matrix A X B");
        for(int i = 0;i<multiply.length;i++){
            for(int j = 0;j<multiply[i].length;j++){
                System.out.print(multiply[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static double[][][]generate(int N){
        Random r = new Random();
        double[][][]matrix = new double[2][N][N];
        for(int i = 0;i<2;i++){
            for(int x = 0;x<N;x++){
                for(int y = 0;y<N;y++){
                    matrix[i][x][y]=r.nextInt(10);
                }
            }
        }
        return matrix;
    }
    
    public static void display(double[][][]matrix){
        System.out.println("Matrix A: ");
        for(int x = 0;x<matrix[0].length;x++){
            for(int y = 0;y<matrix[0][x].length;y++){
                System.out.print(matrix[0][x][y] + " ");
            }
            System.out.println("");
        }
        System.out.println("Matrix B: ");
        for(int x = 0;x<matrix[1].length;x++){
            for(int y = 0;y<matrix[1][x].length;y++){
                System.out.print(matrix[1][x][y] + " ");
            }
            System.out.println("");
        }
    }
    
    public static double[][]add(double[][][]matrix){
        double[][]added = new double[matrix[0].length][matrix[0].length];
        for(int x = 0;x<added.length;x++){
            for(int y = 0;y<added[x].length;y++){
                added[x][y] = matrix[0][x][y] + matrix[1][x][y];
            }
        }
        return added;
    }
    
    public static double[][] multiply(double[][][]matrix){
        int size = matrix[0].length;
        double[][]multiply = new double[size][size];
        for(int x = 0;x<multiply.length;x++){
            for(int y = 0;y<multiply[x].length;y++){
                for(int i = 0;i<size;i++){
                    multiply[x][y]+=matrix[0][x][i]*matrix[1][i][y];
                }
            }
        }
        return multiply;
    }
}
