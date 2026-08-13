package features.game;

import java.util.Scanner;

/*
Q) 숫자를 맞추는 게임
-난수 필요 (1~100) -> answer임
-answer를 맞추는 게임
-주어진 기회는 10번
-up,down으로 난수를 맞추는 게임이다
-콘솔로부터 데이터를 입력받기 위한 Scanner

반환값 출력
-성공했을때) "x번째 정답을 맞췄습니다."
-실패했을때) "10번의 기회를 모두 사용했습니다."
-> if 문 사용
*/
public class GuessGame{
    
    Scanner scan = new Scanner(System.in);
    int answer;
    public GuessGame(){
        
    }

    //case 1
    public String gameFor(){
        System.out.println("debug >>>> answer log : " + answer);

            String result = null;
            int cnt = 0;
            boolean isFlag = false;

            Scanner scan = new Scanner(System.in);

            for(int idx = 1; idx <= 10; idx++) {
                cnt = idx;

                System.out.print(">>>> 생각하는 숫자를 입력하세요 : ");
                int guess = scan.nextInt();

                if(answer > guess) {
                    System.out.println(">>> Up");
                } else if(answer < guess) {
                    System.out.println(">>> Down");
                } else {
                    isFlag=true;
                    break;
                }
            }

            result=(isFlag)?cnt+"번째 정답을 맞췄습니다.":"10번의 기회를 모두 사용했습니다.";
            return result;
        
                //나의 방법
                // int answer = (int)(Math.random() * 100) + 1;

                // for(int time = 1; time <= 10; time++) {

                //     System.out.print(">>>> 생각하는 숫자를 입력하세요 : ");
                    
                //     int guess = scan.nextInt();

                //     if(guess == answer) {
                //         return time + "번째 정답을 맞췄습니다!";
                //         // System.out.println(time + "번째 정답을 맞췄습니다!");
                //         // break;

                //     } 
                //     else if(guess < answer) {
                //         System.out.println("UP");
                //     } 
                //     else {
                //         System.out.println("DOWN");
                //     }
                // }

                // return "10번의 기회를 모두 사용했습니다.";
    }

    //case 2
      public String gameWhile(){
        
        int answer = (int)(Math.random() * 100) + 1;
        int time = 1;

        while(time <= 10) {

            System.out.print(">>>> 생각하는 숫자를 입력하세요 : ");
            
            int guess = scan.nextInt();

            if(guess == answer) {
               return time + "번째 정답을 맞췄습니다!";
            } 
            else if(guess < answer) {
                System.out.println("UP");
            } 
            else {
                System.out.println("DOWN");
            }

            time++;
        }

        return "10번의 기회를 모두 사용했습니다.";
    }

    //case 3
      public String gameDoWhile(){
        int answer = (int)(Math.random() * 100) + 1;
        int time = 1;

        do {

            System.out.print(">>>> 생각하는 숫자를 입력하세요 : ");
            int guess = scan.nextInt();

            if(guess == answer) {
               return time + "번째 정답을 맞췄습니다!";
            } 
            else if(guess < answer) {
                System.out.println("UP");
            } 
            else {
                System.out.println("DOWN");
            }

            time++;

        } while(time <= 10);

        return "10번의 기회를 모두 사용했습니다.";
        
    }
}