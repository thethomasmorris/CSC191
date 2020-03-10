package a0425a;
/*
a look at common exceptions and how to handle them
April 25, 2019
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class A0425a {
    public static double quotient(int num1, int num2){
        if(num2 == 0){
            System.out.println("Divisor cannot be zero. (method)");
            System.exit(1); //prevents division and exits program
        }
        return num1/num2;
    }
    public static double quotientExcept(int n1, int n2){
        if(n2 == 0)
            throw new ArithmeticException("Divisor cannot be zero.");
        return (double)(n1)/n2;
    }
    
    public static void main(String[] args) {
        
        //divide by zero errors when denominator is 0
        Scanner in = new Scanner(System.in);
        //prompt user for 2 integers
        System.out.print("Enter an integer: ");
        int number1 = in.nextInt();
        System.out.print("Enter another integer: ");
        int number2 = in.nextInt();
        System.out.println();
//        
//        //handle divide by zero with a while loop
//        while(number2==0){
//            System.out.println("You can't enter 0 for this number.");
//            System.out.println("Enter another integer: ");
//            number2 = in.nextInt();
//        }
//        
//        //but what if the division is being handled by a method?
//        int result = quotient(9,0);
//        System.out.println(result);

        //we actually would want to handle with an exception
        try{
            double result = quotientExcept(number1,number2);
            System.out.println(number1+"/"+number2+" is "+result);
        }catch(ArithmeticException ex){
            System.out.println("Exception: you can't divide by zero");
        }
        System.out.println("Execution of main continues...");
        
        //an example of input data type mismatches
        boolean continueInput = true;
        do{
            try{
                System.out.print("Enter an integer: ");
                int number = in.nextInt();
                System.out.println("The number is "+number);
                continueInput = false;
            }catch(InputMismatchException ex){
                System.out.println("Try again. Incorrect input: an integer is required.");
                in.nextLine(); //discard bad input with end of line character
            }
        }while(continueInput);
        
        //array negative size input by user
        try{
            System.out.print("Enter a positive integer: ");
            int n = in.nextInt();
            int result[] = new int[n];
            for (int i = 0; i <result.length; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
        }catch(NegativeArraySizeException ex){
            System.out.println("Exception: you must enter a postiive number. ");
            System.out.print("Enter a positive integer: ");
            int n = in.nextInt();
            int result[] = new int[n];
            for (int i = 0; i <result.length; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
        }
    }  
}
