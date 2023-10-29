import com.sun.jdi.connect.Connector;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("The game has started !!!");
        System.out.println("If you want to end the game ,enter 0 ");
        Gamer obj = new Gamer();
        obj.logic();



    }
}

class Gamer implements toDo{
    String[] random = new String[3];
    int currentCount;
    int round;
    Gamer(){
        random[0]="paper";
        random[1]="stone";
        random[2]="scissors";
    }
  public   void logic(){
        Scanner sc = null;
        String word;
        String str;



        while (true){

            str= randomWord();
          //  System.out.println(str);
            round++;
            sc= new Scanner(System.in);
            word = sc.nextLine();
            if(word.trim().equals("0")) {
                //durs e galis
                System.out.println("Game end !!!");
                break;
            }
            System.out.println(word);
          /*  if (word.length()==str.length())
                continue;*/

            if(isTrue(word,str))
            { currentCount++;
                System.out.println(word);
                System.out.println(str);


            }

            this.print();
        }
    }
  public   void print(){
        System.out.println("Round of the game - "+ round+"the player`s score = " + currentCount+"" +
                "" + " the competitor`s score = "+( round - currentCount));
    }

    //stugum e random bary mer barn e ,te voch
    public boolean isTrue(String word,String random){

int u = 10%3;
        if (word.trim().equals( "paper") && random.trim().equals("stone"))
            return true;
        if (word.trim() .equals( "stone" ) && random.trim().equals("scissors"))
            return true;

        if (word.trim().equals( "scissors") && random.trim().equals("paper"))
            return true;


        return false;
    }

   public String randomWord(){
        Random r = new Random();
        int i = r.nextInt(3);
        //ranrom 0 1 3 yntrel
        return   random[i];
    }



}
interface toDo{
    void logic();
    void print();
    String randomWord();
    boolean isTrue(String s,String r);
}