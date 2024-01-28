
package wix1002_2016_ii_6;

public class FinancialRecord {
    private int id;
    private double balance;
    private double annualInterestRate;
    public FinancialRecord(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
    }
    public FinancialRecord(int i,double b){
        id = i;
        balance = b;
    }
    public int getid(){
        return id;
    }
    public double getbalance(){
        return balance;
    }
    public double getannualInterestRate(){
        return annualInterestRate;
    }
    public void setid(int i){
        id = i;
    }
    public void setbalance(double b){
        balance = b;
    }
    public void setannualInterestRate(double r){
        annualInterestRate = r;
    }
    public double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }
    public void withdraw(double w){
        System.out.printf("Previous balance: RM %.2f\n",balance);
        balance = balance - w;
        System.out.printf("Current balance after withdrawal of RM %.2f is: RM %.2f\n",w,balance);
    }
    public void deposit(double d){
        System.out.printf("Previous balance: RM %.2f\n",balance);
        balance = balance + d;
        System.out.printf("Current balance after deposit of RM %.2f is: RM %.2f\n",d,balance);
    }
    public void displayRecordInfo(){
        System.out.println("The information about financial record of id " + id + " is ");
        System.out.println("Financial record id is: " + id);
        System.out.printf("Financial record balance is: RM %.2f\n",balance);
        System.out.println("Annual interest rate is: " + annualInterestRate);
    }
}
