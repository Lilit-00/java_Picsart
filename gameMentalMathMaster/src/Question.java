import java.util.Random;

public class Question{
    Player player = new Player();
    ArithmeticUtils arith =new ArithmeticUtils();
    String questions = arith.questions;


    boolean method(int i){
        return arith.answer == i;
    }
    String getQuestions(){
        return questions;
    }
    void setQuestions(String questions){
        this.questions = questions;
    }
}
class ArithmeticUtils{
    String questions;
    int answer;
    String generatorExpression(){


        Random myRandom = new Random();
        int randomNumber1 = myRandom.nextInt(10);
        int randomNumber2 = myRandom.nextInt(10);
        String currentOperator = pickRandom();

      /*answer = switch (currentOperator){
          case "+"->randomNumber1 + randomNumber2;
          case "-"->randomNumber1 - randomNumber2;
          case "/"->randomNumber1 / randomNumber2;
          case "*"->randomNumber1 * randomNumber2;

          default ->0;
      };*/

        if (currentOperator == "+") {
            answer = randomNumber1 + randomNumber2;
        }else if(currentOperator == "-") {
            answer = randomNumber1 - randomNumber2;

        }else if(currentOperator == "/"){
            if(randomNumber2 == 0)
                randomNumber2++;
            answer = randomNumber1/randomNumber2;
        }else {
            answer = randomNumber1 * randomNumber2;

        }
        questions = Integer.toString(randomNumber1)+currentOperator+Integer.toString(randomNumber2);

        // System.out.println("nor answer"+answer);
        return questions;
    }



    static String getRandom(String[] arr) {
        Random myRandom = new Random();
        int rdm = myRandom.nextInt(arr.length);

        return arr[rdm];
    }
    static String pickRandom() {

        String[] operator = {"+", "-", "/", "*"};
        String r = getRandom(operator);
        return r;
    }

}