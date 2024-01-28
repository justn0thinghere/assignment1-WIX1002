
package wix1002_2017_i_5;

public class GradedActivity {
    protected int score;
    public void setScore(int s){
        score = s;
    }
    public int getScore(){
        return score;
    }
    public char getGrade(){
        if(score>=90){
            return 'A';
        }else if(score>=80){
            return 'B';
        }else if(score>=70){
            return 'C';
        }else if(score>=60){
            return 'D';
        }else{
            return 'F';
        }
    }
    public String toString(){
        return "Total score: " + getScore() + "\nGrade: " + getGrade();
    }
}
