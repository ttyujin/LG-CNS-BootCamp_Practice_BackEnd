import java.util.Scanner;

import features.game.GuessGame;

public class GuessGameApp {
    
    public static void main(String[] args) {
        GuessGame game=new GuessGame();
        
        // String result1=game.gameFor();
        // System.out.println(result1);
        
        // String result2=game.gameWhile();
        // System.out.println(result2);
       
        String result3=game.gameDoWhile();
        System.out.println(result3);

        
        
        
        
        // Scanner scan= new Scanner(System.in);
        // System.out.print(">>>>생각하는 숫자를 입력하세요: ");
        // int guess=scan.nextInt();
        // System.out.println("guess>>>"+guess);
    }
}
