package pigdicegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class pigdicegame {
    public static void main(String[] args){
        while(true){
            startgame();
        }
    }
    static void startgame(){
        Scanner scan3= new Scanner(System.in);
        System.out.println(("press y to play"));
        String start=scan3.next();
        if (start.equals("y")) {
            round();
        }
    }
    static void round(){
        int i=0;
        int usernumber=0;
        Scanner scan2= new Scanner(System.in);
        System.out.println("type number of users");
        int user_number= scan2.nextInt();
        List<Integer> score = new ArrayList<>();
        while(i< user_number){
            score.add(0);
            i+= 1;
        }
        //System.out.println(score);
        //*System.out.println(Arrays.toString (new List[]{score}));*/
        game(score,usernumber, user_number);
    }
    static void won(int addsurentscore, List score, int usernumber, int userscore){
        System.out.println("==wongame==");
        addsurentscore=(int) score.get(usernumber);
        addsurentscore+=userscore;
        score.set(usernumber, addsurentscore);
        System.out.println(score);
        startgame();


    }
    static void game(List score, int usernumber, int user_number) {
        int userscore = 0;
        int addsurentscore;
        int usernumberdisplay;
        while(true){
            if (usernumber >=user_number){
                usernumber=0;
            }
            Scanner scan1= new Scanner(System.in);
            usernumberdisplay=usernumber+1;
            System.out.println("user"+ usernumberdisplay +",press yes to hold, any key to keep playing");
            String user_choice= scan1.next();
            int random = (int )(Math.random() * 6 + 2);
            if(user_choice.equals("yes")){
                addsurentscore= (int) score.get(usernumber);
                addsurentscore+=userscore;
                if (addsurentscore>=100){
                    won(addsurentscore, score, usernumber, userscore);
                }
                score.set(usernumber, addsurentscore);
                System.out.println("==hold==");
                System.out.println(score);
                usernumber+= 1;
                userscore= 0;
            }
            else{
                userscore += random;
                System.out.println(userscore);
            }
            if(random== 1){
                System.out.println("==gotone==");
                userscore= 0;
                addsurentscore=(int) score.get(usernumber);
                addsurentscore+=userscore;
                score.set(usernumber, addsurentscore);
                usernumber+= 1;
                System.out.println(score);
            }
            if (userscore>= 100){
                addsurentscore=(int) score.get(usernumber);
                addsurentscore+=userscore;
                score.set(usernumber, addsurentscore);
                won(addsurentscore,score, usernumber, userscore);
            }
        }
    }
}