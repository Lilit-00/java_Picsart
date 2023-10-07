import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long starting =System.currentTimeMillis();

        System.out.println("START");
        Game game = new Game();
        game.startGame();
        while (System.currentTimeMillis() - starting <60000){

         }
      //  Thread.sleep(15000);
        game.win();
        System.out.println("END!!!");

    }
}





/*
 enum MathOperator {
    Addition("+"),
    Subtraction("-"),
    Multiplication("*"),
    Division("/");
    String operator ;
        MathOperator(String s){
            this.operator = s;
        }

     public String getOperator() {
         return operator;
     }
 }*/


