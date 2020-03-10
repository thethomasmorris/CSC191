package thomasmorrislab2;
import java.util.Scanner;
/*
January 30, 2019 Lab 2
Thomas Morris
Display, add, and subtract time in terms of hours, minutes and seconds
*/
class Time {
    private int hours, minutes, seconds; //private int data members
    
    public Time(){ //provide a default constructor since we created a custom one
        
    }
    
    public Time(int h, int m, int s){ //custom constructor
        hours = h;
        minutes = m;
        seconds = s;
    }
    
    //create getters and setters for each private int data member
    public int getHours(){
        return hours;
    }
    
    public void setHours(int h){
        hours = h;
    }
    
    public int getMinutes(){
        return minutes;
    }
    
    public void setMinutes(int m){
        minutes = m;
    }
    
    public int getSeconds(){
        return seconds;
    }
    
    public void setSeconds(int s){
        seconds = s;
    }
    
    public void addTime(Time t2){
        int hours3 = t2.hours+hours;
        int minutes3 = t2.minutes+minutes;
        int seconds3 = t2.seconds+seconds;
        
        //make sure that you increment minutes or hours up by one if 60 or more second or minutes have passed
        if(seconds3 >= 60){
            minutes3 += seconds3/60;
            seconds3 %= 60;
        }
        if(minutes3 >= 60){
            hours3 += minutes3/60;
            minutes3 %= 60;
        }
        
        //print output to user
        System.out.println("t1 = ("+hours+","+minutes+","+seconds+") plus "+"t2 = ("+t2.hours+","+t2.minutes+","+t2.seconds+") equals "+"t3 = ("+hours3+","+minutes3+","+seconds3+").");
    }
    
    public void subTime(Time t2){
        int hours3 = hours-t2.hours;
        
        int minutes3 = minutes-t2.minutes;
        if(minutes3 < 0){ //borrow from hours if negative
            hours3 -= 1;
            minutes3 += 60; 
        }
        
        int seconds3 = seconds-t2.seconds;
        if(seconds3 < 0){ //borrow from minutes if negative
            minutes3 -= 1;
            seconds3 += 60;
        }

        //print output to user
        System.out.println("t1 = ("+hours+","+minutes+","+seconds+") subtract "+"t2 = ("+t2.hours+","+t2.minutes+","+t2.seconds+") equals "+"t3 = ("+hours3+","+minutes3+","+seconds3+").");
    }
    
    @Override
    public String toString(){
        return hours+" hours, "+minutes+" minutes, "+seconds+" seconds";
    }
    
}

public class ThomasMorrisLab2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //collect input
        
        //hours
        System.out.print("Enter the number of hours (0-24): ");
        int hours = in.nextInt();
        while(hours < 0 || hours > 24){ //input validation
            System.out.println("Invalid entry. Hours must be a positive integer number between 0 and 24 inclusive.");
            System.out.print("Enter the number of hours (0-24): ");
            hours = in.nextInt();
        }

        //minutes
        System.out.print("Enter the number of minutes (0-59): ");
        int minutes = in.nextInt();
        while(minutes < 0 || minutes > 59){ //input validation
            System.out.println("Invalid entry. Minutes must be a positive integer between 0 and 59 inclusive.");
            System.out.print("Enter the number of minutes: ");
            minutes = in.nextInt();
        }
        
        //seconds
        System.out.print("Enter the number of seconds (0-59): ");
        int seconds = in.nextInt();
        while(seconds < 0 || seconds > 59){ //input validation
            System.out.println("Invalid entry. Seconds must be a positive integer between 0 and 59 inclusive.");
            System.out.print("Enter the number of seconds: ");
            seconds = in.nextInt();
        }
        
        Time t1 = new Time(hours, minutes, seconds);
        Time t2 = new Time();
        String input = "";
        char choice;
        do{
            System.out.println("Main Menu");
            System.out.println("1. Add Time");
            System.out.println("2. Subtract Time");
            System.out.println("3. Display Time");
            System.out.println("4. Change Time");
            System.out.println("5. Exit");
            System.out.print("Enter a choice from the above menu: ");
            input = in.next();
            choice = input.toLowerCase().charAt(0); //take the first character from the input to allow repeated entries
            switch(choice){
                    case '1':
                        //add time
                        
                        //collect input for option 1 and place in t2
                        //hours
                        System.out.print("Enter the number of hours to add (0-24): ");
                        int hours1 = in.nextInt();
                        while(hours1 < 0 || hours1 > 24){ //input validation
                            System.out.println("Invalid entry. Hours must be a positive integer number between 0 and 24 inclusive.");
                            System.out.print("Enter the number of hours (0-24): ");
                            hours1 = in.nextInt();
                        }

                        //minutes
                        System.out.print("Enter the number of minutes to add (0-59): ");
                        int minutes1 = in.nextInt();
                        while(minutes1 < 0 || minutes1 > 59){ //input validation
                            System.out.println("Invalid entry. Minutes must be a positive integer between 0 and 59 inclusive.");
                            System.out.print("Enter the number of minutes: ");
                            minutes1 = in.nextInt();
                        }

                        //seconds
                        System.out.print("Enter the number of seconds to add (0-59): ");
                        int seconds1 = in.nextInt();
                        while(seconds1 < 0 || seconds1 > 59){ //input validation
                            System.out.println("Invalid entry. Seconds must be a positive integer between 0 and 59 inclusive.");
                            System.out.print("Enter the number of seconds: ");
                            seconds1 = in.nextInt();
                        }

                        t2 = new Time(hours1, minutes1, seconds1);
                        t1.addTime(t2);
                        break;
                    case '2':
                        //subtract time
                        
                        //collect input for option 2 and place in t2
                        //hours
                        System.out.print("Enter the number of hours to subtract (0-24): ");
                        int hours2 = in.nextInt();
                        while(hours2 < 0 || hours2 > 24){ //input validation
                            System.out.println("Invalid entry. Hours must be a positive integer number between 0 and 24 inclusive.");
                            System.out.print("Enter the number of hours (0-24): ");
                            hours2 = in.nextInt();
                        }

                        //minutes
                        System.out.print("Enter the number of minutes to subtract (0-59): ");
                        int minutes2 = in.nextInt();
                        while(minutes2 < 0 || minutes2 > 59){ //input validation
                            System.out.println("Invalid entry. Minutes must be a positive integer between 0 and 59 inclusive.");
                            System.out.print("Enter the number of minutes: ");
                            minutes2 = in.nextInt();
                        }

                        //seconds
                        System.out.print("Enter the number of seconds to subtract (0-59): ");
                        int seconds2 = in.nextInt();
                        while(seconds2 < 0 || seconds2 > 59){ //input validation
                            System.out.println("Invalid entry. Seconds must be a positive integer between 0 and 59 inclusive.");
                            System.out.print("Enter the number of seconds: ");
                            seconds2 = in.nextInt();
                        }

                        t2 = new Time(hours2, minutes2, seconds2);
                        t1.subTime(t2);                       
                        break;
                    case '3':
                        //display time
                        System.out.println("t1 = "+"("+t1.getHours()+", "+t1.getMinutes()+", "+t1.getSeconds()+")");
                        break;
                    case '4':
                        //change time
                        //hours
                        System.out.print("Enter the number of hours (0-24): ");
                        hours = in.nextInt();
                        while(hours < 0 || hours > 24){ //input validation
                            System.out.println("Invalid entry. Hours must be a positive integer number between 0 and 24 inclusive.");
                            System.out.print("Enter the number of hours (0-24): ");
                            hours = in.nextInt();
                        }

                        //minutes
                        System.out.print("Enter the number of minutes (0-59): ");
                        minutes = in.nextInt();
                        while(minutes < 0 || minutes > 59){ //input validation
                            System.out.println("Invalid entry. Minutes must be a positive integer between 0 and 59 inclusive.");
                            System.out.print("Enter the number of minutes: ");
                            minutes = in.nextInt();
                        }

                        //seconds
                        System.out.print("Enter the number of seconds (0-59): ");
                        seconds = in.nextInt();
                        while(seconds < 0 || seconds > 59){ //input validation
                            System.out.println("Invalid entry. Seconds must be a positive integer between 0 and 59 inclusive.");
                            System.out.print("Enter the number of seconds: ");
                            seconds = in.nextInt();
                        }
                        
                        t1 = new Time(hours, minutes, seconds); //replace values store in t1 with new values
                        break;
                    case '5':
                        System.out.println("Thanks for using my program!");
                        break;      
                    default:
                        System.out.println("Invalid Entry! Please try again.");
                        break;
                }
            }while(choice != '5');
    }
}
