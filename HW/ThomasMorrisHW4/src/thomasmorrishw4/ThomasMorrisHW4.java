package thomasmorrishw4;
/*
Thomas Morris
Hw 4
April 5, 2019
This program shows the different possible paths to go in a 2D grid starting
from the bottom left corner and moving to the top right corner.
The only possible moves are either up (U) or right (r).
 */
import java.util.Scanner;
public class ThomasMorrisHW4 {
    static int routes(int rows, int cols){
        return routes(rows,cols,"");
    }
    static int routes(int rows, int cols, String s){
        if(rows == 1 && cols == 1){
            System.out.println(s);
            return 1;
        }
        int total = 0;
        if(rows>1){
            total += routes(rows-1,cols,s+"U");
        }
        if(cols>1){
            total += routes(rows,cols-1,s+"R");
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Find routes in a grid");
            System.out.println("2. Exit");
            System.out.print("Enter a choice from the menu above: ");
            choice = in.nextInt();
            while(choice < 1 || choice > 2){
                System.out.println("Invalid entry!");
                System.out.println("Menu");
                System.out.println("1. Find routes in a grid");
                System.out.println("2. Exit");
                System.out.print("Enter a choice from the menu above: ");
            }
            switch(choice){
                case 1:
                    System.out.print("Enter the number of rows in the grid: ");
                    int rows = in.nextInt();
                    while(rows < 1){
                        System.out.println("Invalid entry! Must be greater than zero.");
                        System.out.print("Enter the number of rows in the grid: ");
                        rows = in.nextInt();
                    }
                    System.out.print("Enter the number of columns in the grid: ");
                    int cols = in.nextInt();
                    while(cols < 1){
                        System.out.println("Invalid entry! Must be greater than zero.");
                        System.out.print("Enter the number of columns in the grid: ");
                        cols = in.nextInt();
                    }
                    System.out.println("There are "+routes(rows,cols)+" different routes in the grid to go from S to F.");
                    break;
                case 2:
                    System.out.println("Thank you for using my program!");
                    System.out.println("Created By: Thomas Morris");
            }
        } while(choice != 2);
    }
}
