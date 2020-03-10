package thomasmorrishw2;
/*
Thomas Morris
Homework 2
February 19th, 2019
Memory Matching Game using a 2D array
 */
import java.util.Scanner;

class matchingGame{
    
    //declare global variables that will be needed throughout each method
    String[][] aBoard; //answer board
    String[][] hBoard; //hidden board
    final int SIZE; //board size
    private boolean win = false;
    
    public matchingGame(int s){
        SIZE = s;
        hBoard = new String [s][s];
        aBoard = new String [s][s];
    }
    //create hidden board of SIZE
    public void hiddenBoard(){
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                hBoard[r][c] = "*";
            }
        }
    }
    
    //create answer board using random generated values up to SIZE*SIZE
    public void answerBoard(){
        //create a single dimensional array with all possible numbers in duplicate
        String[] possibleNums =  new String[(SIZE*SIZE)];
        int num = 1;
        for (int i = 0; i < (SIZE*SIZE); i+=2) {
            possibleNums[i] = ""+(num);
            possibleNums[i+1] = ""+(num);
            num++;
        }
        
        //place 1 of each of all the possible numbers into the answerboard afterwards replace that with null string to prevent duplicates
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                //generate a random index
                int randomIndex = (int) (Math.random()*possibleNums.length);
                while(possibleNums[randomIndex].equals(""))
                    randomIndex = (int) (Math.random()*possibleNums.length);
                //place the random number on the board
                aBoard[r][c] = ""+possibleNums[randomIndex];
                //replace the used number with zero so it does not get used again
                possibleNums[randomIndex] = "";
            }
        }
    }
    
    //print board
    public void printBoard(){
        System.out.println();
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.printf("%6d", i);
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("_______");
        }
        System.out.println();
        for (int r = 0; r < SIZE; r++) {
                System.out.print((r+1)+"|");
            for (int c = 0; c < SIZE; c++) {
                if((r>=9) && (c==0))
                    System.out.printf("%5s", hBoard[r][c]);
                else
                    System.out.printf("%6s", hBoard[r][c]);
            }
            System.out.println();
        }
    }
    
    /*for testing
    public void printABoard(){
        System.out.println();
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.printf("%6d", i);
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("_______");
        }
        System.out.println();
        for (int r = 0; r < SIZE; r++) {
                System.out.print((r+1)+"|");
            for (int c = 0; c < SIZE; c++) {
                if((r>=9) && (c==0))
                    System.out.printf("%5s", aBoard[r][c]);
                else
                    System.out.printf("%6s", aBoard[r][c]);
            }
            System.out.println();
        }
    }
    */
    
    //return if the user has won or not
    public boolean getWin(){
        for (int i = 0; i < hBoard.length; i++) {
            for (int j = 0; j < hBoard[i].length; j++) {
                if(!hBoard[i][j].equals(aBoard[i][j]))
                    return win;
            }
        }
        win = true;
        return win;
    }
    
    //user guesses a row and column - need to collect data
    public void turn(int r1, int c1, int r2, int c2){
        if(r1 == r2 && c1 == c2){
            System.out.println();
            System.out.println("You entered the same information for both cards.");
            System.out.println("Please try again.");
        }
        else if(aBoard[r1][c1].equals(aBoard[r2][c2])){
            System.out.println("*************");
            System.out.println("It's a match!");
            System.out.println("*************");
            hBoard[r1][c1] = aBoard[r1][c1];
            hBoard[r2][c2] = aBoard[r2][c2];
        }
        else{
            System.out.println();
            System.out.println("Those cards do not match.");
            System.out.println("Card 1 at row "+(r1+1)+" and column "+(c1+1)+" is "+aBoard[r1][c1]);  
            System.out.println("Card 2 at row "+(r2+1)+" and column "+(c2+1)+" is "+aBoard[r2][c2]);  
            System.out.println("Try again!");
        }

    }
    //tell user if correct, permanately change hidden board
    //if incorrect tell the user the values in order received
    //create printed board which shows correctly guessed values and hidden values for others (created by permately changing hidden board)
    
}
public class ThomasMorrisHW2 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int choice;
       do{
           //main menu
           System.out.println();
           System.out.printf("%15s", "Main Menu");
           System.out.println();
           System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
           System.out.println("1. Play Matching Game");
           System.out.println("2. Exit");
           System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
           System.out.print("Enter a choice from the menu above: ");
           choice = in.nextInt();
           //input validation
           while(choice < 1 || choice > 2){
               System.out.println();
               System.out.println("Invalid entry. Please try again.");
               System.out.println();
               System.out.printf("%15s", "Main Menu");
               System.out.println();
               System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
               System.out.println("1. Play Matching Game");
               System.out.println("2. Exit");
               System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
               System.out.print("Enter a choice from the menu above: ");
               choice = in.nextInt();
           }
           switch(choice){
               case 1:
                   //collect board size
                   System.out.println();
                   System.out.printf("%15s", "Directions");
                   System.out.println();
                   System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                   System.out.println("Simple memory matchmaking game.");
                   System.out.println("Find two cards that match in a grid.");
                   System.out.println("The grid board size must be an even integer between 2 and 14.");
                   System.out.println();
                   System.out.print("Enter the grid board size: ");
                   int boardSize = in.nextInt();
                   while((boardSize%2 > 0) || (boardSize < 2) || (boardSize > 14)){
                       System.out.println();
                       System.out.println("Invalid entry. Board size must be an even integer between 2 and 14 inclusive. Please try again."); 
                       System.out.print("Enter the grid board size: ");
                       boardSize = in.nextInt();
                   }
                   matchingGame m = new matchingGame(boardSize);
                   m.hiddenBoard(); //generate hidden board of user defined size
                   m.answerBoard(); //generate answer board of with numbers 1 though (boardSize*boardSize) in duplicate
//                   m.printABoard(); //for testing
                   m.printBoard();
                   //loop to control turns
                   while(false == m.getWin()){
                       System.out.println();
                       System.out.print("Enter the row for card 1: ");
                       int r1 = in.nextInt();
                       while(r1 < 1 || r1 > boardSize){
                            System.out.print("Invalid entry. Must be an integer between 1 and "+boardSize+". Enter the row for card 1: ");
                            r1 = in.nextInt();
                       }  
                       System.out.print("Enter the column for card 1: ");
                       int c1 = in.nextInt();
                       while(c1 < 1 || c1 > boardSize){
                            System.out.print("Invalid entry. Must be an integer between 1 and "+boardSize+". Enter the column for card 1: ");
                            c1 = in.nextInt();
                       }  
                       System.out.println();
                       System.out.print("Enter the row for card 2: ");
                       int r2 = in.nextInt();
                       while(r2 < 1 || r2 > boardSize){
                            System.out.print("Invalid entry. Must be an integer between 1 and "+boardSize+". Enter the row for card 2: ");
                            r2 = in.nextInt();
                       }  
                       System.out.print("Enter the column for card 2: ");
                       int c2 = in.nextInt();
                       while(c2 < 1 || c2 > boardSize){
                            System.out.print("Invalid entry. Must be an integer between 1 and "+boardSize+". Enter the column for card 2: ");
                            c2 = in.nextInt();
                       } 
                       m.turn(r1-1,c1-1,r2-1,c2-1);
                       m.printBoard(); 
//                       m.printABoard(); //for testing
                       m.getWin();
                   }
                   //print winning message
                   if(m.getWin()){
                       System.out.println();
                       System.out.println("**********");
                       System.out.println("**********");
                       System.out.println("**********");
                       System.out.println("YOU WIN!!!");
                       System.out.println("**********");
                       System.out.println("**********");
                       System.out.println("**********");
                       System.out.println();
                   }
                   break;
               case 2:
                   System.out.println();
                   System.out.println("Created By: Thomas Morris");
                   System.out.println("Thank you for using my program!");
                   break;
               default:
                   System.out.println("Invalid entry. Please try again.");
                   break;
           }
       }while(choice != 2);
    }
}
