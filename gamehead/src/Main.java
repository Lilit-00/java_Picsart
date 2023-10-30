import java.io.BufferedWriter;
import java.io.File;
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        System.out.println(" Game start !!!");
        System.out.println(" Enter 0 for mode adamin mode.");
        System.out.println(" Enter 1 for mode user mode.  ");
        System.out.println(" Press x to exit");


        Writer path = new FileWriter("words.txt");
        BufferedWriter write = new BufferedWriter(path);


        try (Scanner sc = new Scanner(System.in)) {

           String str = sc.nextLine();
           if (str.equals("1")){

               Person obj = new Person();
               obj.Word();

           }else if(str.equals("0")) {
               System.out.println("Start andim mode!!!");

               while (true){
                   String strCurrent= sc.next();
                   if(strCurrent.equals("1")) {

                       System.out.println("Admin mode has ended !!! , and start user mode .");

                       new Person().Word();
                       break;
                   }


                   if(!strCurrent.equals("x")) {
                       write.write(strCurrent+"\n");
                       write.flush();

                   }else break;


               }
           }
       }finally {
           write.close();
       }
    }
}

class Random {

  static String[] read()  {

      String currentWord;
      List<String> list= new ArrayList<>();

        try(  BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {

            while ((currentWord =  reader.readLine()) != null) {
                list.add(currentWord);
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(list);
        String[] arr = new String[list.size()];
        list.toArray(arr);
        return arr;
    }


}

class Person{
    int liveCount = 5;
    Random obj = new Random();

    String str = obj.read()[getRandomNumber()].toUpperCase();

    char[]   current = new char[10];

    Person(){
      //  current=new char[str.length()];
        for(int i = 0;i<str.length();i++ ){
              current[i]='-';
        }
    }

    void Word() {

        Scanner sc = null;
        System.out.print("To guess the word");
        this.print(current);

        while (liveCount != 0){


            sc = new Scanner(System.in);

            char temp = sc.next().charAt(0);

            if (temp == 'x'){
                System.out.println("Game END");
                break;
            }

            if (!countain(temp,str)){
                liveCount--;

            }

            if(full(current))
            {

                System.out.println("New Word ...");
                this.print(current);

            }else {
                this.countain(temp,str);
                this.print(current);
            }


        }
    }


    String nowWord(){
       return obj.read()[getRandomNumber()].toUpperCase();

    }
    boolean full(char[] current){
        for(int i = 0;i<str.length();i++){
            if(current[i] == '-')
                return false;
        }
        print(this.current);
        str = nowWord().toUpperCase();
        for (int i=0;i<current.length;i++) {
            this.current[i]='-';
        }

        return true;
    }

    void print(char[] arr){
        for (int i = 0;i<str.length();i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
     boolean countain(char c, String str){

        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
               if(str.charAt(i) == c){
                   current[i] = c;
                   flag= true;
               }
        }

        return flag;
    }

    int getRandomNumber(){
        int randomNumber;
        int size =  obj.read().length;
        java.util.Random r=new java.util.Random();
        return randomNumber = r.nextInt(size);
    }
}