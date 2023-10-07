import java.util.ArrayList;
import java.util.Scanner;



public class Game{
    ArrayList<Player> playerList = new ArrayList<>();
    long starting;
    long ending;

    void startGame(){

        System.out.println(System.currentTimeMillis() - starting );


        for (int i = 0; i < 3; i++) {

            System.out.println("-------------------------------------");
            Scanner sc = new Scanner(System.in);

            Question questions = new Question();
            playerList.add(questions.player);


            String name = sc.nextLine();
            System.out.println("Enter name: "+name);

            starting = questions.player.statringPlayer(name);
            System.out.println("           Game started for  "+playerList.get(i).getNmae());

            long temp;

            while (true){

                questions.setQuestions(questions.arith.generatorExpression());//stex poxel
                System.out.println(questions.questions);
                // Scanner sc = new Scanner(System.in);

                temp = System.currentTimeMillis();
                int a = sc.nextInt();
                long res =System.currentTimeMillis()- temp;
                //  System.out.println("long res="+res);

                if(questions.method(a)  ){
                    questions.player.corerct++;
                    // System.out.println(a +"== "+ questions.arith.answer);
                }


                if(res>5000 ){
                    System.out.println("jam anaky lacel e ev chenq karox dzer harci patasxany vercnel" );
                    if (questions.method(a));
                    questions.player.corerct--;
                    break;//50mills avel chik kara mtci
                }




                questions.player.count++;

                if ( System.currentTimeMillis()-starting >=10000) {
                    System.out.println(System.currentTimeMillis()+" break jamanak");
                    break;
                }
            }

            System.out.println("player"+i+" "+questions.player.corerct);


        }
    }


    void win(){
        int indexWin = 0;
        int correctMax = playerList.get(0).corerct;
        for (int i = 1;i<playerList.size();i++) {

            if(correctMax< playerList.get(i).corerct)
            {
                indexWin = i;
                correctMax = playerList.get(i).corerct;
            }

        }

        System.out.println(playerList.get(indexWin).getNmae()+"wins today, maxRoghtAnswer = "+correctMax);
    }
}