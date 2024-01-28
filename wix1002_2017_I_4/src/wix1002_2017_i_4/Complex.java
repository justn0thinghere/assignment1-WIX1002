
package wix1002_2017_i_4;

public class Complex {
    private double real;
    private double im;
    public Complex(){
        real = 0;
        im = 0;
    }
    public Complex(double a,double b){
        real = a;
        im = b;
    }
    public void addComplexNum(Complex b){
        double c = this.real + b.real;
        double d = this.im + b.im;
        System.out.printf("Addition of the two complex numbers: (%.0f + %.0fi)\n",c,d);
    }
    public void subtractComplexNum(Complex b){
        double c = this.real - b.real;
        double d = this.im - b.im;
        System.out.printf("Subtraction of the two complex numbers: (%.0f + %.0fi)\n",c,d);
    }
    public String toString(){
        return "(" + real + " + " + im + "i)";
    }
}
