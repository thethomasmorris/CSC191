package a0207;

/*
First look at 2D arrays
CSC 191 - Feb 7, 2019
This program will use a 2D array to hold 2 exam scores (columns)
for 4 students (rows) It will ask the user to input the scores.
 */

import java.util.Scanner;

public class A0207 {
    
    //average method that accepts the array as an argument and which student (row)
    static double average(int[][] a, int student){
        double total = 0;
        for (int score = 0; score < a[student].length; score++) {
            total += a[student][score];
        }
        return total/a[student].length; //total divided  by row length
    }
    
    public static void main(String[] args) {
        
        //declare and initialize our array without user input
//        int [][] scores = {
//            {85,65,70},
//            {95,69,78},
//            {80,95,87},
//            {82,85, 80}
//        };
        
        //declare and initialize for user input
        int [][] scores = new int[4][3]; //rows then columns for size
        
        //ask the user for the input of scores
        //scores.length gives us the number of rows
        //scores[r].length gives us the number of columns
        //r must be given a index value - which starts at zero
        //clean edges - every row is the same length
        //jagged arrays - rows are of varying length
        Scanner in = new Scanner(System.in);
        for (int r = 0; r < scores.length; r++) {
            for (int c = 0; c < scores[r].length; c++) {
                System.out.print("Enter exam score "+(c+1)+" for student "+(r+1)+": ");
                scores[r][c] = in.nextInt();
            }
        }
        
        //print our 2D array 
        for (int r = 0; r < scores.length; r++) {
            System.out.print("Student "+(r+1)+" scores: ");
            for (int c = 0; c < scores[r].length; c++) {
                System.out.printf("%4d", scores[r][c]);
            }
            System.out.print("  Exam Average: ");
            System.out.printf("%6.2f", average(scores, r));
            System.out.println();
        }
    }  
}
