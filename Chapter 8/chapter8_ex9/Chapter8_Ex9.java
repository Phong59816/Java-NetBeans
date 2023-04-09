
package chapter8_ex9;

/*
Name: Phong Tran
Date: 10/08/21
Project: Chapter 8 Exercise 9
Description: This program is a game of tictactoe
*/
import java.util.Scanner;
public class Chapter8_Ex9 {

    public static void main(String[] args) {
        //create empty board
        char [][]board = {{'|',' ','|',' ','|',' ','|'},
                          {'|',' ','|',' ','|',' ','|'},
                          {'|',' ','|',' ','|',' ','|'}};
        //printing empty board
        emptyBoard(board);
        //turn counter to rotate player
        int turn = 0;
        char player = ' ';
        
        while(turn < 9){
            //rotate player turns
            if(turn % 2 == 0){
                player = 'X';
            }
            else{
                player = 'O';
            }
            //prompt user to enter index
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a row(0, 1, or 2) for player " + player + ": ");
        int rowIndex = input.nextInt();
        System.out.print("Enter a column(0, 1, or 2) for player " + player + ": ");
        int colIndex = input.nextInt();
        
        //replace input col index to correct col index
        switch(colIndex){
            case 0 : colIndex = 1;
            break;
            case 1 : colIndex = 3;
            break;
            case 2 : colIndex = 5;
        }
        //printing gameboard
        board[rowIndex][colIndex] = player;
         for (int row = 0;row < board.length;row++){
            for (int col = 0;col < board[row].length;col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
            System.out.println("-------------");
        }
         //increment turn
        turn++;
        
        //set up win condition and end game when condition is met
             if((board [0][1] == player && board[0][1] == board[0][3] && board[0][3] == board[0][5]) ||
                (board [1][1] == player && board[1][1] == board[1][3] && board[1][1] == board[1][5]) ||
                (board [2][1] == player && board[2][1] == board[2][3] && board[2][3] == board[2][5]) ||
                (board [0][1] == player && board[0][1] == board[1][1] && board[1][1] == board[2][1]) ||
                (board [0][3] == player && board[0][3] == board[1][3] && board[1][3] == board[2][3]) ||
                (board [0][5] == player && board[0][5] == board[1][5] && board[1][5] == board[2][5]) ||
                (board [0][1] == player && board[0][1] == board[1][3] && board[1][3] == board[2][5]) ||
                (board [0][5] == player && board[0][5] == board[1][3] && board[1][3] == board[2][1])){
                 //print which player won
            System.out.print("player " + player + " won");
            break;
        }
                
        //end game when draw
        if (turn == 9){
            System.out.println("Draw");
            break;
        }
        }
        
    }//emptyboard method
        public static void emptyBoard(char[][]board){
        for (int row = 0;row < board.length;row++){
            for (int col = 0;col < board[row].length;col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}