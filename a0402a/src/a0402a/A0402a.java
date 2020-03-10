package a0402a;
/*
Thomas Morris
Lecture April 2, 2019
Our first look at reading form and writing to text files on c:\
 */
import java.util.Scanner;
import java.io.*;

public class A0402a {
    public static void main(String[] args) throws IOException {
        try{
            //any work that might encounter the IOException goes here
            
            //create a file in the c:\java folder scores.txt
            File file = new File("c:\\java\\scores.txt");
            if(file.exists()){
                System.out.println("File already exists. Goodbye!");
                System.exit(0); //clean way to end program - log an error message using 1 or something other than 0
            }
            
            //create a filewriter object and wrap it with a printwriter object 
            FileWriter fWriter = new FileWriter(file);
            PrintWriter output = new PrintWriter(fWriter); //uses sout message to print to file - easier to use than FileWriter
            
            //Write formatted output to the file
            output.println("John T Smith");
            //sout is a prebuilt output screen to the console in java
            //so this will be an output stream connected to our file that we created using the constructors above
            output.println(90);
            output.println("Eric K Jones");
            output.println(85);
            
            //closing the file causes the write to happen
            output.close();
            
            //create a Scanner attached to the file
            Scanner input = new Scanner(file); //use the scanner constructor
            
            //read data from the file
            while(input.hasNextLine()){
                String name = input.nextLine();
                int score = input.nextInt();
                input.nextLine(); //throw away the end of line char after the int
                System.out.println(name+": "+score);
            }
            //close scanner
            input.close();
            
        } catch(IOException ex){
            //put any code here we want executed if there is an Exception
            System.out.println("There is an IOException problem! ");
        }
    } 
}
