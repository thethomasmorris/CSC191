package thomasmorrislab3;
/*
Thomas Morris
February 13th, 2019
Lab 3
Tic, Tac, Toe using a 2D array
 */
import java.util.Scanner;
class TTT{
    //initialize the board as blank
    private char[][] board = {
        {' ',' ',' '},
        {' ',' ',' '},
        {' ',' ',' '}
    };
    //set up guess variables for X and O
    private int pxr, pxc, por, poc;
    
    //determine winner
    private boolean win = false;
    
    //default constructor
    public TTT(){
        
    }
    
    //singleton for each private data member
    public int getPXR(){
        return pxr;
    }
    
    public int getPXC(){
        return pxc;
    }
    
    public int getPOR(){
        return por;
    }
    
    public int getPOC(){
        return poc;
    }
    
    public void setPXR(int p1r){
        pxr = p1r;
    }
    
    public void setPXC(int p1c){
        pxc = p1c;
    }
    
    public void setPOR(int p2r){
        por = p2r;
    }
    
    public void setPOC(int p2c){
        poc = p2c;
    }
    
    public boolean getWin(){
        return win;
    }
    
    public void setWin(boolean w){
        win = w;
    }
    
    //reset the board after the game
    public void resetBoard(){
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = ' ';
            }
        }
    }
    //print board
    public void printBoard(){
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                if(j==0)
                    System.out.print("|");
                System.out.print(" "+board[i][j]+" |");
            }
            if(i==2){
                System.out.println();
                System.out.print("-------------");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    //place X's move on the board if spot not taken
    public void xTurn(){
        if(board[pxr][pxc] == ' ')
            board[pxr][pxc] = 'X';
        else
            System.out.println("Position taken. X loses their turn.");
    }
    
    //place O's move on the board if spot not taken
    public void oTurn(){
        if(board[por][poc] == ' ')
            board[por][poc] = 'O';
        else
            System.out.println("Position taken. O loses their turn.");
    }
    
    //determine if x won
    public void xWinner(){
        //check rows for win
        
        for (int r = 0; r < board.length; r++) {
            int count = 0;
            for (int c = 0; c < board[r].length; c++) {
                if(board[r][c] == 'X')
                    count++;
            }
            if(count == 3)
                win = true;
        }
        
        //check columns for win
        for (int c = 0; c < board.length; c++) {
            int count = 0;
            for (int r = 0; r < board.length; r++) {
                if(board[r][c] == 'X')
                    count++;
            }
            if(count == 3)
                win = true;
        }
        
        //check first diagonal case
        int count = 0;
        for(int i = 0; i < board.length; i++){
            if(board[i][i] == 'X')
                count++;
            if(count == 3)
                win = true;
        }
        
        //check second diagonal case
        if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
            win = true;
    }
    
    //determine if O won
    public void oWinner(){
        //check rows for win
        
        for (int r = 0; r < board.length; r++) {
            int count = 0;
            for (int c = 0; c < board[r].length; c++) {
                if(board[r][c] == 'O')
                    count++;
            }
            if(count == 3)
                win = true;
        }
        
        //check columns for win
        for (int c = 0; c < board.length; c++) {
            int count = 0;
            for (int r = 0; r < board.length; r++) {
                if(board[r][c] == 'O')
                    count++;
            }
            if(count == 3)
                win = true;
        }
        
        //check first diagonal case
        int count = 0;
        for(int i = 0; i < board.length; i++){
            if(board[i][i] == 'O')
                count++;
            if(count == 3)
                win = true;
        }
        
        //check second diagonal case
        if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
            win = true;
    }
    
    //check if the whole board is full and if so declare tie
    public void isTie(){
        int count = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if(board[r][c] != ' ')
                    count++;
            }
            if(count == 9)
                win = true;
        }
    }
}
public class ThomasMorrisLab3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int xWins = 0;
        int oWins = 0;
        int ties = 0;
        TTT t = new TTT();
        char choice;
        do{
            t.setWin(false);
            t.resetBoard();
            System.out.print("Would you like to play Tic, Tac, Toe? (Y/N) ");
            String input = in.next();
            choice = input.toLowerCase().charAt(0);
            //input validation
            while(choice != 'y' && choice != 'n'){
                System.out.println("Invalid entry. Enter y for yes or n for no.");
                System.out.print("Would you like to play Tic, Tac, Toe? (Y/N) ");
                input = in.next();
                choice = input.toLowerCase().charAt(0);
            }
            switch(choice){
                case 'y':
                    while(!t.getWin()){
                        //generate gameboard
                        t.printBoard();
                        //get choice for X
                        System.out.print("Enter a row (1, 2, or 3) for Player X: ");
                        int pxr = in.nextInt();
                        while(pxr < 1 || pxr > 3){
                            System.out.println("Invalid entry. ");
                            System.out.print("Enter a row (1, 2, or 3) for Player X: ");
                            pxr = in.nextInt();
                        }
                        t.setPXR(pxr-1);
                        System.out.print("Enter a column (1, 2, or 3) for Player X: ");
                        int pxc = in.nextInt();
                        while(pxc < 1 || pxc > 3){
                            System.out.println("Invalid entry. ");
                            System.out.print("Enter a column (1, 2, or 3) for Player X: ");
                            pxc = in.nextInt();
                        }
                        t.setPXC(pxc-1);
                        t.xTurn(); //record x's turn
                        t.xWinner(); //check if x won
                        if(t.getWin()){ //if x won display that
                            t.printBoard();
                            xWins++;
                            System.out.println();
                            System.out.println("X wins!");
                            System.out.println();
                        }  
                        if(!t.getWin()){ //check to make sure previous choice didn't stop game
                            t.isTie();
                            if(t.getWin()){
                                t.printBoard();
                                ties++;
                                System.out.println();
                                System.out.println("Tie!");
                                System.out.println();
                            }
                        }
                        if(!t.getWin()){
                            //generate gameboard
                            t.printBoard();
                            //get choice for O
                            System.out.print("Enter a row (1, 2, or 3) for Player O: ");
                            int por = in.nextInt();
                            while(por < 1 || por > 3){
                                System.out.println("Invalid entry. ");
                                System.out.print("Enter a row (1, 2, or 3) for Player O: ");
                                por = in.nextInt();
                            }
                            t.setPOR(por-1);
                            System.out.print("Enter a column (1, 2, or 3) for Player O: ");
                            int poc = in.nextInt();
                            while(poc < 1 || poc > 3){
                                System.out.println("Invalid entry. ");
                                System.out.print("Enter a column (1, 2, or 3) for Player O: ");
                                poc = in.nextInt();
                            }
                            t.setPOC(poc-1);
                            t.oTurn(); //record O's turn
                            t.oWinner(); 
                            if(t.getWin()){ 
                                t.printBoard();
                                oWins++;
                                System.out.println();
                                System.out.println("O wins!");
                                System.out.println();
                            }
                            if(!t.getWin()){ //check to make sure nobody has already won
                                t.isTie(); //check for tie
                                if(t.getWin()){ //if tie display that, increase count, and print board
                                    t.printBoard();
                                    ties++;
                                    System.out.println();
                                    System.out.println("Tie!");
                                    System.out.println();
                                }
                            }
                        }
                    }
                    break;
                case 'n':
                    System.out.println();
                    System.out.println("Scores: ");
                    System.out.println("Player X: "+xWins);
                    System.out.println("Player O: "+oWins);
                    System.out.println("Ties: "+ties);
                    System.out.println();
                    System.out.println("Created By: Thomas Morris");
                    System.out.println("Thank you for using my program!");
                    break;
                default:
                    System.out.println("Invalid entry. Please try again.");   
            }
        }while (choice != 'n');
    }
}
