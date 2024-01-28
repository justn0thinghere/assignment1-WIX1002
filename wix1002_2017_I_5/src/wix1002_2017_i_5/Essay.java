
package wix1002_2017_i_5;

public class Essay extends GradedActivity{
    private int grammar;
    private int spelling;
    private int length;
    private int content;
    public Essay(int g,int s,int l,int c){
        grammar = g;
        spelling = s;
        length = l;
        content = c;
        score = g+s+l+c;
    }
    public String toString(){
        return "Essay Score:\nGrammar: " + grammar + "\nSpelling: " + spelling + "\nLength: " + length + "\nContent: " + content + "\n\n" + super.toString();
    }
}
