
package wixq002_2019_i_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Wixq002_2019_I_4 {

    public static void main(String[] args) {
        System.out.println("The essay is:");
        int wordcount = 0;
        int sentence = 0;
        int[]charcount = new int[26];
        try{
            BufferedReader br = new BufferedReader(new FileReader("myAmbition.txt"));
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
                String[]words=line.split(" ");
                wordcount+=words.length;
                for(int i = 0;i<words.length;i++){
                    if(words[i].charAt(words[i].length()-1)=='.'){
                        sentence++;
                    }
                    for(int x = 0;x<words[i].length();x++){
                        char character = words[i].toLowerCase().charAt(x); 
                        if(character>='a'&&character<='z'){
                            charcount[(int)(character -'a')]++;
                        }
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Number of sentences: " + sentence);
        System.out.println("Number of words: " + wordcount);
        for(int i = 0;i<charcount.length;i++){
            System.out.println((char)(i+'A') + ": " + charcount[i]);
        }
    }
    
}
