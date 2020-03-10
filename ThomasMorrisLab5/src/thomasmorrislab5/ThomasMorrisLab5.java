package thomasmorrislab5;
/*
Lab 5
CSC 191 - Feb 27, 2019
This program will display a matrix of size defined by the use of numbers 0-9 and tell the user whether or not the matrix contains four consecutive numbers of the same value.
 */
import java.util.Scanner;
class Pattern{
    //declare needed variables
    final int ROWS, COL;
    private int p[][];
    
    //get size from user
    public Pattern(int r, int c){
        ROWS = r;
        COL = c;
        p = new int[ROWS][COL];
    }
    //generate array
    public void generateP(){
        for(int r = 0; r < p.length; r++){
            for (int c = 0; c < p[r].length; c++) {
                p[r][c] = (int)(Math.random()*10); //gives us values from 0-9
            }
        }
    }
    
    //for testing
    public void setP(){
        Scanner in = new Scanner(System.in);
        for(int r = 0; r < p.length; r++) {
            for (int c = 0; c < p[r].length; c++) {
                System.out.print("Enter row "+(r+1)+" and column "+(c+1)+" number: ");
                p[r][c] = in.nextInt();
            }
        }
    }
    //display matrix
    public void printP(){
        for(int r = 0; r < p.length; r++) {
            for (int c = 0; c < p[r].length; c++) {
                System.out.printf("%6d", p[r][c]);
            }
            System.out.println();
        }
    }
    //determine if same 4 numbers horizontally - return boolean
    public boolean horizontal(){
        for(int r = 0; r < p.length; r++) {
            for (int c = 0; c < p[r].length-3; c++) {
                if(p[r][c] == p[r][c+1] && p[r][c] == p[r][c+2] && p[r][c] == p[r][c+3])
                    return true;
            }
        }
        return false;
    }
    //" " vertically
    public boolean vertical(){
        for (int r = 0; r < p.length-3; r++) {
            for (int c = 0; c < p[r].length; c++) {
                if(p[r][c] == p[r+1][c] && p[r][c] == p[r+2][c] && p[r][c] == p[r+3][c])
                    return true;
            }
        }
        return false;
    }
    //" " diagonally
    public boolean diagonal1(){
        for(int k = 0 ; k < ROWS+COL-1; k++) {
            int[] temp = new int[ROWS];
            for (int i = 0; i < ROWS; i++) {
                temp[i] = (i+1)*-1;
            }
            for(int j = 0 ; j <= k ; j++) {
                int i = k-j;
                if(i < ROWS && j < COL)
                    temp[i] = p[i][j];   
            }
            for(int i = 0; i < temp.length-3; i++) {
                if(temp[i] == temp[i+1] && temp[i] == temp[i+2] && temp[i] == temp[i+3])
                    return true;
            }
        }
        return false;
    }
    
    //" " diagonally
    public boolean diagonal2(){
        for (int k = 0; k < ROWS+COL-1; k++) {
            int[] temp = new int[ROWS];
            for (int i = 0; i < ROWS; i++) {
                temp[i] = (i+1)*-1;
            }
            for (int j = 0; j <= k; j++) {
                int l = 0;
                int m = COL-1-j;
                if(m<ROWS && j<COL){
                    temp[l] = p[j][m];
                    l++;
                }
                m--;
            }
            for(int i = 0; i < temp.length-3; i++) {
                if(temp[i] == temp[i+1] && temp[i] == temp[i+2] && temp[i] == temp[i+3])
                    return true;
            }
        }
        return false;
    }
       
}
public class ThomasMorrisLab5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //collect rows
        System.out.print("Enter the size of the matrix rows: ");
        int rows = in.nextInt();
        while(rows<0){ //input validation
            System.out.println("Invalid entry. Enter an integer greater than zero.");
            System.out.print("Enter the size of the matrix rows: ");
            rows = in.nextInt();
        }
        
        //collect columns
        System.out.print("Enter the size of the matrix columns: ");
        int col = in.nextInt();
        while(col<0){ //input validation
            System.out.println("Invalid entry. Enter an integer greater than zero.");
            System.out.print("Enter the size of the matrix columns: ");
            col = in.nextInt();
        }
        
        //create a new object with data collected
        Pattern p = new Pattern(rows,col);
        p.generateP();
        //p.setP();
        System.out.println();
        p.printP();
        System.out.println();
        if(p.horizontal())
            System.out.println("There are 4 in a row horizontally.");
        if(p.vertical())
            System.out.println("There are 4 in a row vertically.");
        if(p.diagonal1())
            System.out.println("There are 4 in a row diagonally scanning from top left to bottom right.");
        if(p.diagonal2())
            System.out.println("There are 4 in a row diagonally scanning from top right to bottom left.");
    }   
}
