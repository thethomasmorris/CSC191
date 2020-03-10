package a0115;
/*
January 15, 2019 Lecture
Review while loops and pre-increment and post-increment
largest number whose square less than or equal to a number m
Thomas Morris
Assignment info if applicable
*/
import java.util.Scanner;
public class A0115 {
    public static void main(String[] args) {
        //variable declarations & initializations
        int m;
        int n = 1;
        
        //collect a value for m from the user
        Scanner input = new Scanner(System.in); //constructor - the method used to create an object ex. Scanner(System.in)
        System.out.print("Enter a large integer: "); //sout and tab is a System.out.println
        m = input.nextInt();
        
        //use a while loop for input validation
        // m must be > 0
        while(m<1){ //while they give you bad data - ask for new input
            System.out.println("You must enter a value greater than 0.");
            System.out.print("Enter a large integer: ");
            m = input.nextInt();
        }
        
        //find the largest number squared less than or equal to m
        while(n*n<m){
            n++;
        }
        //output to the user
        System.out.println("This number is "+(n-1)*(n-1));
        
        n = 15;
        //pre-increment vs. post-increment
        System.out.println(n++); //print 15
        System.out.println(n); //print 16
        System.out.println(++n); //prints 17
        System.out.println(n); //prints 17
        
    }    
}
