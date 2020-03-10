/*
January 17, 2019 Lecture
another while loop review
Thomas Morris
smallest factor of an integer
120 - 2 2 2 3 5
*/
import java.util.Scanner;

public class a117 {
    public static void main(String[] args) {
        //ask the user fo ran integer to factor
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer to factor: ");
        int number = input.nextInt();
        //input validation
        while(number<1){
            System.out.print("You entered an invalid number.");
            System.out.print("Enter a positive integer to factor: ");
            number = input.nextInt();
        }   
        //find and print all of the smallest factors
        int factor = 2;
        System.out.print("The factors of "+number+" are: ");
        while(number>=factor){
            if(number%factor == 0){
                number /= factor;
                System.out.print(factor+" ");
            }
            else
                factor++;
        }
        System.out.println();
        
    }
}
