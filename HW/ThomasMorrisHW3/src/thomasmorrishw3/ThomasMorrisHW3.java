package thomasmorrishw3;
/*
Thomas Morris
HW 3 - CSC 191
March 1st, 2019
This program:
Allows the user to populate a seating chart with seat pricing for an event
Allows the user to find seats by the seat number and check if they are available for purchase
Allows the user to find available seats by price
Allows the user to mark sold seats by changing the price to 0
Prints a seating chart showing available seats as O and sold seats with an X
 */
import java.util.Scanner;
class Theater{
    double[][] seats;
    String eventName;
    
    public Theater(int n, int m, String e){
        seats = new double[n][m];
        eventName = e;
    }
    
    public void populate(){
        Scanner in = new Scanner(System.in);
        //collects the price for each row of seats
        for (int r = 0; r < seats.length; r++) {
            System.out.print("Enter row "+(r+1)+" price: ");
            double price = in.nextDouble();
            while(price < 0){
                System.out.println("Price must be greater than zero.");
                System.out.print("Enter row "+(r+1)+" price: ");
                price = in.nextDouble();
            }
            for (int c = 0; c < seats[r].length; c++) {
                seats[r][c] = price;
            }
        }
    }
    
    public boolean searchRC(int n, int m){
        //returns either true or false if the seat is sold
        return seats[n-1][m-1] != 0;
    }
    
    public void searchPrice(double price){
        //prints all the available seats at the current prices
        boolean isSeats = false;
        for (int r = 0; r < seats.length; r++) {
            for (int c = 0; c < seats[r].length; c++) {
                if(seats[r][c] == price){
                    System.out.println("Seat at row "+(r+1)+" and column "+(c+1)+" is available for purchase at $"+price+".");
                    isSeats = true;
                }
            }
        }
        if(!isSeats)
            System.out.println("There are no seats available for $"+price+".");
    }
    
    public void markSold(int r, int c){
        if(!searchRC(r,c))
            System.out.println("This seat is already marked sold.");
        else{
            seats[r-1][c-1] = 0;
            System.out.println("Seat at row "+r+" and column "+c+" has been marked sold.");
        }
    }
    
    public void printSeats(){
        System.out.println(eventName);
        System.out.println("Front of Stage");
        for (int r = 0; r < seats.length; r++) {
            for (int c = 0; c < seats[r].length; c++) {
                if(seats[r][c] == 0)
                    System.out.printf("%6c", 'X');
                else
                    System.out.printf("%6c", 'O');
            }
            System.out.println();
        }
    }
}
public class ThomasMorrisHW3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        //collect theater input from user and validate input
        System.out.print("How many rows are in the theater? ");
        int n = in.nextInt();
        while(n<=0){
            System.out.println("Invalid entry. Must be an integer greater than 0.");
            System.out.print("How many rows are in the theatre? ");
            n = in.nextInt();
        }
        System.out.print("How many columns are in the theater? ");
        int m = in.nextInt();
        while(m<=0){
            System.out.println("Invalid entry. Must be an integer greater than 0.");
            System.out.print("How many rows are in the theatre? ");
            m = in.nextInt();
        }
        System.out.print("What is the name of the theater? ");
        String e;
        e = in.next();
        in.nextLine();
        //create object
        Theater t = new Theater(n,m,e);
        
        do{
            //build menu and validate input
            System.out.println();
            System.out.println("    Menu    ");
            System.out.println("1. Populate seating chart");
            System.out.println("2. Find seats by seat number");
            System.out.println("3. Find seats by price");
            System.out.println("4. Mark sold seats");
            System.out.println("5. Print seating chart");
            System.out.println("6. Exit");
            System.out.print("Enter a choice from the menu above: ");
            choice = in.nextInt();
            while(choice<1 || choice>6){
                System.out.println();
                System.out.println("Invalid entry. Please enter a number from 1-6 that corresponds with your menu choice.");
                System.out.println();
                System.out.println("    Menu    ");
                System.out.println("1. Populate seating chart");
                System.out.println("2. Find seats by seat number");
                System.out.println("3. Find seats by price");
                System.out.println("4. Mark sold seats");
                System.out.println("5. Print seating chart");
                System.out.println("6. Exit");
                System.out.print("Enter a choice from the menu above: ");
                choice = in.nextInt();
            }
            switch(choice){
                case 1:
                    //call on populate method to get row prices
                    t.populate();
                    break;
                case 2:
                    //allow user to find seats by seat number
                    System.out.print("Enter seat row number: ");
                    int r = in.nextInt();
                    while(r > n || r <= 0){
                        System.out.println("Invalid entry. Must be an integer greater than 0 and less than "+n+".");
                        System.out.print("Enter seat row: ");
                        r = in.nextInt();
                    }   
                    System.out.print("Enter seat column number: ");
                    int c = in.nextInt();
                    while(c > m || c <= 0){
                        System.out.println("Invalid entry. Must be an integer greater than 0 and less than "+m+".");
                        System.out.print("Enter seat column: ");
                        c = in.nextInt();
                    }
                    if(t.searchRC(r, c))
                        System.out.println("Seat at row "+r+" and column "+c+" is availble for purchase.");
                    else
                        System.out.println("Seat at row "+r+" and column "+c+" is not availble for purchase.");  
                    break;
                case 3:
                    //allow user to find all available seats at their specified price
                    System.out.print("What price ticket are you looking for? $");
                    double price = in.nextDouble();
                    if(price <= 0){
                        System.out.println("Invalid entry. Price must be greater than 0.");
                        System.out.print("What price ticket are you looking for? $");
                        price = in.nextDouble();
                    }
                    t.searchPrice(price);
                    break;
                case 4:
                    //allow user to mark seats as sold by changing price to zero
                    System.out.print("What is the row of the seat you would like to mark sold: ");
                    int sr = in.nextInt();
                    while(sr > n || sr <= 0){
                        System.out.println("Invalid entry. Must be an integer greater than 0 and less than "+n+".");
                        System.out.print("What is the row of the seat you would like to mark sold: ");
                        sr = in.nextInt();
                    }
                    System.out.print("What is the column of the seat you would like to mark sold: ");
                    int sc = in.nextInt();
                    while(sc > m || sc <= 0){
                        System.out.println("Invalid entry. Must be an integer greater than 0 and less than "+m+".");
                        System.out.print("What is the column of the seat you would like to mark sold: ");
                        sc = in.nextInt();
                    }
                    t.markSold(sr, sc);
                    break;
                case 5: 
                    //print the seating chart with O as available and X as sold
                    t.printSeats();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Thank you for using my program!");
                    System.out.println("Created By: Thomas Morris");
                    break;
                default:
                    System.out.println("Invalid entry. Please try again.");
            }
        }while(choice != 6);
    }  
}
