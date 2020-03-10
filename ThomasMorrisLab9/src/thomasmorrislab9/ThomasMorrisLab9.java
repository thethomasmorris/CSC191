package thomasmorrislab9;
/*
Lab 9
Making a cipher using a text file
April 3rd, 2019
Thomas Morris
 */
import java.util.Scanner;
import java.io.*;
public class ThomasMorrisLab9 {
    
    public static String encode(String s, int key){
        return encode(s, key%27, s.length()-1);
    }
    
    public static String encode(String s, int key, int n){
        if(n == -1)
            return "";
        int value = s.charAt(n);
        if(value == ' ')
            value = 96;
        value = value + key;
        if(value > 'z')
            value -= 27;
        char letter = (char)(value);
        return encode(s.substring(0,n), key, n-1)+letter;
    }
    
    public static void main(String[] args) throws IOException {
        try{
            Scanner in = new Scanner(System.in);
            File attack = new File("c:\\java\\attack.txt");
            Scanner input = new Scanner(attack); 
            
            System.out.print("Enter your key: ");
            int key = in.nextInt();
            while(key < 1){
                System.out.println("Invalid entry. Please enter key greater than or equal to 1.");
                System.out.print("Enter your key: ");
                key = in.nextInt();
            }
                
            File encode = new File("c:\\java\\encode.txt");
            if(encode.exists()){
                System.out.println("File already exists. Goodbye!");
                System.exit(0);
            }
            
            FileWriter fWriter = new FileWriter(encode);
            PrintWriter output = new PrintWriter(fWriter);
            while(input.hasNextLine()){
                String sentence = input.nextLine();
                sentence = encode(sentence, key);
                output.println(sentence);
            }
            output.close();
            
            
        } catch(IOException ex){
            System.out.println("There is an IOException problem! ");
        }
    }   
}
