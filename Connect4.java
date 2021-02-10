import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Connect4 {
    Player player1 = new Player();
    Player player2 = new Player();
    Board game = new Board();
    char[] guide = { '1', '2', '3', '4', '5', '6', '7' };

    void createGame() {
        for (int i = 0; i < game.board.length; i++) {
            for (int x = 0; x < game.board[i].length; x++) {
                // if(x == 0){
                // game.board[i][x] = '*';
                // } else if(game.board[i][x-=1] == '*'){
                // game.board[i][x] = ' ';

                // } else{
                game.board[i][x] = '*';
                // }
            }
        }
    }

    void printGame() {
        for (int i = 0; i < game.board.length; i++) {
            System.out.println(game.board[i]);
        }
    }
    void checkHorizontal() {
        int player1Count = 0;
        int player2Count = 0;

        for (int i = 0; i < game.board.length; i++) {
            for (int x = 0; x < game.board[i].length; x++) {
                if(i<game.board.length-1){
                if(game.board[i][x] == 'a' && game.board[Math.abs(i+1)][x] =='a'){
                    player1Count++;
                } else if(game.board[i][x] == 'a' && game.board[Math.abs(i+1)][x] =='b'){
                    player1Count = 0;
                }
                if(game.board[i][x] == 'b' && game.board[Math.abs(i+1)][x] =='b'){
                    player2Count++;
                } else if(game.board[i][x] == 'b' && game.board[Math.abs(i+1)][x] =='a'){
                    player2Count = 0;
                }
            }
        }
    }

    if (Math.abs(player1Count) >= 3) {
        player1.playerWins = true;
    } else if (Math.abs(player2Count) >= 3) {
        player2.playerWins = true;
    }

    }

    void checkDiagonal(){
        int player1Count = 0;
        int player2Count = 0;
        for (int i = 0; i < game.board.length; i++) {
            for (int x = 0; x < game.board[i].length; x++) {
                if(i<game.board.length-1 && x<game.board[i].length){
                if(game.board[i][x] == 'a' && game.board[Math.abs(i+1)][Math.abs(x+1)] =='a'){
                    player1Count++;
                } else if(game.board[i][x] == 'a' && game.board[Math.abs(i+1)][Math.abs(x+1)] =='b'){
                    player1Count = 0;
                }
                if(game.board[i][x] == 'b' && game.board[Math.abs(i+1)][Math.abs(x+1)] =='b'){
                    player2Count++;
                } else if(game.board[i][x] == 'b' && game.board[Math.abs(i+1)][Math.abs(x+1)] =='a'){
                    player2Count = 0;
                }
            }
        }
    }
    if (Math.abs(player1Count) >= 3) {
        player1.playerWins = true;
    } else if (Math.abs(player2Count) >= 3) {
        player2.playerWins = true;
    }
    }

    void checkVertical() {
        int player1Count = 0;
        int player2Count = 0;
        for (int i = 0; i < game.board.length; i++) {
            for (int x = 0; x < game.board[i].length; x++) {
                for (int y = 1; y < game.board[i].length; y++) {
                    if (game.board[i][x] == 'a' && game.board[i][x] == game.board[i][y]) {
                        player1Count++;
                    } else if (game.board[i][x] == 'a' && game.board[i][y] == 'b') {
                        player1Count = 0;
                    }
                    if (game.board[i][x] == 'b' && game.board[i][x] == game.board[i][y]) {
                        player2Count++;
                    } else if (game.board[i][x] == 'b' && game.board[i][y] == 'a') {
                        player2Count = 0;
                    }
                }
            }
        }

        if (Math.abs(player1Count/2) >= 4) {
            player1.playerWins = true;
        } else if (Math.abs(player2Count/2) >= 4) {
            player2.playerWins = true;
        }
    }

    void checkResult() {
        checkVertical();
        checkHorizontal();
        checkDiagonal();
    }

    void start() {
        createGame();
        while (player1.playerWins == false && player2.playerWins == false) {
            printGame();
            System.out.println("player 1 please select a row");
            Scanner player1Choice = new Scanner(System.in);
            int answer1 = Math.abs(player1Choice.nextInt() - 1);
            add(answer1, 'a');
            printGame();
            System.out.println("player 2 please select a row");
            Scanner player2Choice = new Scanner(System.in);
            int answer2 = Math.abs(player2Choice.nextInt() - 1);
            add(answer2, 'b');
            printGame();
        }
        if (player1.playerWins) {
            System.out.println("Player 1 Wins!");
        } else {
            System.out.println("Player 2 Wins!");
        }
    }

    void add(int line, char player) {
        if (game.board[6][line] == '*' && game.board[6][line] != 'a' && game.board[6][line] != 'b') {
            game.board[6][line] = player;
            checkResult();
        } else if (game.board[5][line] == '*' && game.board[5][line] != 'a' && game.board[5][line] != 'b') {
            game.board[5][line] = player;
            checkResult();
        } else if (game.board[4][line] == '*' && game.board[4][line] != 'a' && game.board[4][line] != 'b') {
            game.board[4][line] = player;
            checkResult();
        } else if (game.board[3][line] == '*' && game.board[3][line] != 'a' && game.board[3][line] != 'b') {
            game.board[3][line] = player;
            checkResult();
        } else if (game.board[2][line] == '*' && game.board[2][line] != 'a' && game.board[2][line] != 'b') {
            game.board[2][line] = player;
            checkResult();
        } else if (game.board[1][line] == '*' && game.board[1][line] != 'a' && game.board[1][line] != 'b') {
            game.board[1][line] = player;
            checkResult();
        } else if (game.board[0][line] == '*' && game.board[0][line] != 'a' && game.board[0][line] != 'b') {
            game.board[0][line] = player;
            checkResult();
        }
    }

    public static void main(String[] args) {
        Connect4 keff = new Connect4();
        keff.start();
    }
}

class Player {
    public boolean playerWins = false;
}

class Board {
    public char[][] board;

    Board() {
        board = new char[7][6];
    }
}