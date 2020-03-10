package thomasmorrislab10;
/*
Lab 10
Create a program that allows the user to:
1)count the number of words in a file
2)count the number of characters in the file
3)remove all occurences of a word from the file
4)Replace all occurences of a word in the file with another word
April 10, 2019
Thomas Morris
 */
import java.util.Scanner;
import java.io.*;
public class ThomasMorrisLab10 {
    public static int countWords(String filepath){
        int count = 0;
        try{
            File file = new File(filepath);
            Scanner input = new Scanner(file);
            
            while(input.hasNextLine()){
                String sentence = input.nextLine();
                for (int i = 0; i < sentence.length(); i++) {
                    if((sentence.charAt(i) == ' ') || (i == sentence.length()-1))
                        count++;  
                }
            }
        }catch(IOException ex){
            System.out.println("There is an IOException problem! ");
            return -1;
        }
        return count;
    }
    
    public static int countChar(String filepath){
        int count = 0;
        try{
            File file = new File(filepath);
            Scanner input = new Scanner(file);
            
            while(input.hasNextLine()){
                String sentence = input.nextLine();
                for (int i = 0; i < sentence.length(); i++)
                    count++;  
            }
        }catch(IOException ex){
            System.out.println("There is an IOException problem! ");
            return -1;
        }
        return count;
    }
    
    public static void removeWord(String filepath, String filename, String remove){
        try{
            File file = new File(filepath+filename);
            Scanner input = new Scanner(file);
            File newfile = new File(filepath+"newfile.txt");
            FileWriter fWriter = new FileWriter(newfile);
            PrintWriter output = new PrintWriter(fWriter);
            String word = "";
            while(input.hasNextLine()){
                String sentence = input.nextLine().toLowerCase();
                String newSentence = "";
                for (int i = 0; i < sentence.length(); i++) {
                    if((sentence.charAt(i) != ' ') || (i == sentence.length()-1))
                        word = word+sentence.charAt(i);
                    else if((sentence.charAt(i) == ' ') && (!word.equals(remove))){
                        newSentence = newSentence+word+" ";
                        word = "";
                    }
                    if(word.toLowerCase().equals(remove) && ((sentence.charAt(i) == ' ') || (i == sentence.length()-1))){
                        word = "";
                    }
                }
                if(!word.equals("")){
                    newSentence = newSentence+word;
                    word = "";
                }
                output.println(newSentence);
            }
            output.close();
        }catch(IOException ex){
            System.out.println("There is an IOException problem! ");
        }
    }
        
    public static void replaceWord(String filepath, String filename, String remove, String replace){
        try{
            File file = new File(filepath+filename);
            Scanner input = new Scanner(file);
            File newfile = new File(filepath+"newfile.txt");
            FileWriter fWriter = new FileWriter(newfile);
            PrintWriter output = new PrintWriter(fWriter);
            String word = "";
            while(input.hasNextLine()){
                String sentence = input.nextLine().toLowerCase();
                String newSentence = "";
                for (int i = 0; i < sentence.length(); i++) {
                    if((sentence.charAt(i) != ' ') || (i == sentence.length()-1))
                        word = word+sentence.charAt(i);
                    else if((sentence.charAt(i) == ' ') && (!word.equals(remove))){
                        newSentence = newSentence+word+" ";
                        word = "";
                    }
                    if(word.toLowerCase().equals(remove) && ((sentence.charAt(i) == ' ') || (i == sentence.length()-1))){
                        word = replace+" ";
                    }
                }
                if(!word.equals("")){
                    newSentence = newSentence+word;
                    word = "";
                }
                output.println(newSentence);
            }
            output.close();
        }catch(IOException ex){
            System.out.println("There is an IOException problem! ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Count the number of words in the file.");
            System.out.println("2. Count the number of characters in the file..");
            System.out.println("3. Remove all occurrences of a word from the file.");
            System.out.println("4. Replace all occurrences of a word in the file with another word.");
            System.out.println("5. Exit");
            System.out.print("Enter an item from the menu: ");
            choice = in.nextInt();
            in.nextLine();
            while(choice < 1 || choice > 5){
                System.out.println("Invalid entry!");
                System.out.println("1. Count the number of words in the file.");
                System.out.println("2. Count the number of characters in the file.");
                System.out.println("3. Remove all occurrences of a word from the file.");
                System.out.println("4. Replace all occurrences of a word in the file with another word.");
                System.out.println("5. Exit");
                System.out.print("Enter an item from the menu: ");
                choice = in.nextInt();
                in.nextLine();
            }
            switch(choice){
                case 1:
                    System.out.print("Enter the file path: ");
                    String filepath = in.nextLine();
                    System.out.print("Enter the file name: ");
                    String filename = in.nextLine();
                    System.out.println("The number of words in "+filepath+filename+" is "+countWords(filepath+filename));
                    break;
                case 2:
                    System.out.print("Enter the file path: ");
                    filepath = in.nextLine();
                    System.out.print("Enter the file name: ");
                    filename = in.nextLine();
                    System.out.println("The number of characters in "+filepath+filename+" is "+countChar(filepath+filename));
                    break;
                case 3:
                    System.out.print("Enter the file path: ");
                    filepath = in.nextLine();
                    System.out.print("Enter the file name: ");
                    filename = in.nextLine();
                    System.out.print("Enter the word to remove: ");
                    String word = in.nextLine();
                    removeWord(filepath,filename,word);
                    System.out.println("The word "+word+" has been removed from "+filepath+filename+"");
                    break;
                case 4:
                    System.out.print("Enter the file path: ");
                    filepath = in.nextLine();
                    System.out.print("Enter the file name: ");
                    filename = in.nextLine();
                    System.out.print("Enter the word to remove: ");
                    word = in.nextLine();
                    System.out.print("Enter the word to replace: ");
                    String replace = in.nextLine();
                    replaceWord(filepath,filename,word,replace);
                    System.out.println("The word "+word+" has been removed from "+filepath+filename+" and replaced with "+replace+".");
                    break; 
                case 5:
                    System.out.println("Thank you for using my program!");
                    System.out.println("Created By: Thomas Morris");
                    break;
                default:
                    System.out.println("Invalid entry! Please try again.");
            }
        }while(choice != 5);
    }  
}
