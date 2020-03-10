package thomasmorrislab1;
/*
January 23, 2019 Lab 1
Thomas Morris
Three methods to print the letter n, an obtuse triangle, and a parallelogram of
a given heights.
*/

import java.util.Scanner;
public class ThomasMorrisLab1 {
    
    public static void printN(int height){
        for (int i = 0; i < height; i++) { //controls when a new line is created - slowest and makes columns
            System.out.println();
            for (int j = 0; j < (height+2); j++) { //controls the row being created
                if(j == 0 || j == (height+1) || j ==(i+1)){ //check for first case, last case, and then steadily increase where the next asterisk goes by 1
                    System.out.print("*");
                }
                else //when above condition is not met it means a space is needed
                    System.out.print(" "); 
            }
        }
       System.out.println();
    }
    
    public static void printTri(int height){
        for (int i = 0; i < height; i++) { //controls when a new line is created - slowest
            System.out.println();
            for (int  j = 0;  j < i;  j++) { //creates the number of spaces before asterisks
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) { //creates the number of asterisks needed on the same line as the spaces
                System.out.print("*");
            }
        }
        System.out.println();
    }  
    
    public static void printPara(int height){
        for (int i = 0; i < height; i++) { //controls when a new line is created - slowest
            System.out.println();
            for (int j = height; j > i; j--) { //creates the spaces need before asterisks
                System.out.print(" ");
            }
            for (int k = 0; k < height; k++) { //creates the same number of asterisks as the height
                System.out.print("*");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        String input = "";
        char choice;
        do{
            System.out.println("p. print figures");
            System.out.println("e. exit");
            System.out.print("Enter a choice from the above menu: ");
            input = in.next();
            choice = input.toLowerCase().charAt(0); //take the first character from the input to allow repeated entries
            switch(choice){
                case 'p':
                    System.out.print("Please enter the height: "); //collect height from the user
                    int height = in.nextInt();
                    while(height<3){ //validate input
                        System.out.print("Invalid Entry! Please enter the height greater than 2: "); //collect height from the user
                        height = in.nextInt();
                    }
                    System.out.println("Letter 'N' of "+height+" height:");
                    printN(height);
                    System.out.println();
                    System.out.println("Obtuse triangle of "+height+" height:");
                    printTri(height);
                    System.out.println();
                    System.out.println("Parallelogram of "+height+" height:");
                    printPara(height);
                    System.out.println();
                    break;
                case 'e':
                    System.out.println("Thanks for using my program!");
                    break;      
                default:
                    System.out.println("Invalid Entry! Please try again.");
                    break;
            }
        }while(choice != 'e');
    }
}

