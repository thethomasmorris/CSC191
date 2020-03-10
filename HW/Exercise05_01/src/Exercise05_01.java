//course: CSC191
//project: Exercise05_01
//date: 1/16/2019
//author: Thomas Morris
//purpose: Write a program that reads an unspecified number of integers, determines how many positive and negative values have been read, and computes the total and average of the input values (not counting zeros). Your program ends with the input 0. Display the average as a floating-point number. 

import java.util.Scanner;

public class Exercise05_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int pcount = 0;
        int ncount = 0;
        int tcount = 0;
        float total = 0;
        float average = 0;
        if(input == 0){
            System.out.println("No numbers are entered except 0");
        }
        while(input != 0){
            if(input>0){
                pcount++;
            }
            else{
                ncount++;
            }
            total += input;
            tcount++;
            input = in.nextInt();
        }
        if(tcount > 0){
            average = total/tcount;
            System.out.println("The number of positives is "+pcount);
            System.out.println("The number of negatives is "+ncount);
            System.out.println("The total is "+total);
            System.out.println("The average is "+average);
        }
    } 
}
