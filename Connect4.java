import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Connect4 {
    char[] line = {'*','*','*','*','*','*','*'};
    char[] line1 = {'*','*','*','*','*','*','*'};
    char[] line2 = {'*','*','*','*','*','*','*'};
    char[] line3 = {'*','*','*','*','*','*','*'};
    char[] line4 = {'*','*','*','*','*','*','*'};
    char[] line5 = {'*','*','*','*','*','*','*'};
    char[] line6 = {'*','*','*','*','*','*','*'};
    char[] guide = {'1','2','3','4','5','6','7'};
    boolean player1Win = false;
    boolean player2Win = false;

    void board(){
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(guide);
    }

    void checkHorizontal(char[] line){
        int player1Count = 0;
        int player2Count = 0;
        for(int i = 0; i < line.length; i+=2){
            for(int x = 1; x < line.length; x+=2){
                if(line[i] == 'a' && line[x] == line[i]){
                    player1Count++;
                } else if(line[i] == 'a' && line[x] == 'b'){
                    System.out.println("Player1 reset");
                    player1Count = 0;
                }
                if(line[i] == 'b' && line[x] == line[i]){
                    player1Count++;
                } else if(line[i] == 'b' && line[x] == 'a'){
                    System.out.println("Player2 reset");
                    player2Count = 0;
                }
            }
        }
        if(player1Count >= 3){
            player1Win = true;
        }
        else if(player2Count >= 3){
            player2Win = true;
        }
    }

    void checkVertical(){
        for(int i = 0; i < line1.length; i++){
            
        }
    }

    void checkResult(){
        checkHorizontal(line1);
        checkHorizontal(line2);
        checkHorizontal(line3);
        checkHorizontal(line4);
        checkHorizontal(line5);
        checkHorizontal(line6);

    }

    void start(){
        while(player1Win == false && player2Win == false){
            this.board();
            System.out.println("player 1 please select a row");
            Scanner player1 = new Scanner(System.in);
            int answer1 = Math.abs(player1.nextInt()-1);
            this.add(answer1, 'a');
            this.board();
            System.out.println("player 2 please select a row");
            Scanner player2 = new Scanner(System.in);
            int answer2 = Math.abs(player2.nextInt()-1);
            this.add(answer2, 'b');
            this.board();
        }
        if(player1Win){
            System.out.println("Player 1 Wins!");
        } else{
            System.out.println("Player 2 Wins!");
        }
    }

    void add(int line, char player){
        if(line6[line] == '*'){
            line6[line] = player;
            checkResult();

        } 
        else if(line5[line] == '*'){
            line5[line] = player;
            checkResult();

        }
        else if(line4[line] == '*'){
            line4[line] = player;
            checkResult();

        }
        else if(line3[line] == '*'){
            line3[line] = player;
            checkResult();
            
        }
        else if(line2[line] == '*'){
            line2[line] = player;
            checkResult();

        }
        else if(line1[line] == '*'){
            line1[line] = player;
            checkResult();

        }
    }

    public static void main(String[] args) {
        Connect4 keff = new Connect4();
        keff.start();
    }
}
