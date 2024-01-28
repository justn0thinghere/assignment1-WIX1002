
package wix1002_2016_ii_6;

public class Wix1002_2016_II_6 {

    public static void main(String[] args) {
        FinancialRecord a = new FinancialRecord(1234,10000.00);
        a.setannualInterestRate(7.77);
        a.displayRecordInfo();
        System.out.println("");
        FinancialRecord b = new FinancialRecord(1001,20000);
        b.setannualInterestRate(8.0);
        b.displayRecordInfo();
        System.out.println("Monthly interest rate is: " + b.getMonthlyInterestRate());
        b.deposit(1500);
        b.withdraw(500);
    }
    
}
