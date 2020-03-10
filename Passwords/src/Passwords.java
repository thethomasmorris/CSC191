/* This program has two functions: password validation and password generator
 The options are presented in a menu to the user
 Password Validation:
 Verify Password Requirements
 8 or more characters in length, can only contain letters and numbers, 
 and must contain 2 or more numbers
 Generate Random Passwords:
 generate random passwords per user instructions 
 following this general pattern: 
 uppercaseletters+number+lowercaseletters+number+symbol */

//default (nothing) - same package only
//protected - same package has access but so do children 
//public -
//private -

//static - use the method without creating an object 
//return type

//parameters

//a well written method has only one function - the purpose is code reuse

import java.util.Scanner;
public class Passwords { //has to match .java file
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String choice = "";
      
      do{
          System.out.println("g. Generate Password");
          System.out.println("v. Validate Password");
          System.out.println("e. Exit");
          System.out.print("Pike an option from the menu above: ");
          choice = input.next();
          System.out.println();
          switch (choice.toLowerCase().charAt(0)){
              case 'g':
                  // pattern: uppercaseletters+number+lowercaseletters+number+symbol
                  
                  //ask the user for how many uppercase letters
                  System.out.print("How many uppercase letters in your password? ");
                  int upper = input.nextInt();
                  while(upper < 0){
                      System.out.print("How many uppercase letters in your password? Enter a number greater than 0.");
                      upper = input.nextInt();
                  }
                  //add random uppercase letters to the password
                  String password = "";
                  for (int i = 0; i < upper; i++) {
                      password += getRandomUpperCaseLetter();
                  }
                  //add random number to the password
                  password += getRandomDigitCharacter();
                  //ask how many lowercase
                  System.out.print("How many lowercase letters in your password? ");
                  int lower = input.nextInt();
                  while(lower < 0){
                      System.out.print("How many lowercase letters in your password? Enter a number greater than 0.");
                      lower = input.nextInt();
                  }
                  //add random lowercase letters
                  for (int i = 0; i < lower; i++) {
                      password += getRandomLowerCaseLetter();
                  }
                  //add the final number and symbol
                  password += getRandomDigitCharacter();
                  password += getRandomSymbolCharacter();
                  
                  //output new password to the user
                  System.out.println("Here is your password: "+password);
                  break;
              case 'v':
                  //ask the user for their password
                  System.out.print("Enter a password to validate: ");
                  String s = input.next();
                  
                  //validate and output result
                  if(isValidPassword(s)){
                      System.out.println("Valid password.");
                  } else{
                      System.out.println("Invalid password.");
                  }
                  
                  break;
              case 'e':
                  System.out.println("Goodbye! Thanks for using our program.");
                  break;
              default:
                  System.out.println("You entered an invalid menu choice. Please try again!");
                  break;    
          } 
      } while('e' != choice.toLowerCase().charAt(0)); //&& if using 'e' as well as 'E'
          
  }
  
  /* Generate a random character between ch1 and ch2 */
  public static char getRandomCharacter(char ch1, char ch2) {
      return (char)(ch1+Math.random()*(ch2-ch1+1));
  }

  /* Generate a random lowercase letter */
  public static char getRandomLowerCaseLetter() {
    return getRandomCharacter('a', 'z');
  }

  /* Generate a random uppercase letter */
  public static char getRandomUpperCaseLetter() {
    return getRandomCharacter('A', 'Z');
  }

  /* Generate a random digit character */
  public static char getRandomDigitCharacter() {
    return getRandomCharacter('0', '9');
  }

  /* Generate a random character */
  public static char getRandomSymbolCharacter() {
    return getRandomCharacter('#', '&');
  }
  
  /* Check if a string is a valid password */
  public static boolean isValidPassword(String s) {
      //only letters and digits? If not return false. 
      //If yes, check other conditions
      for (int i = 0; i < s.length(); i++) {
          if(!isLetter(s.charAt(i)) && !isDigit(s.charAt(i)))
              return false;
      }
      
      //check length. return false if length < 8
      if(s.length() < 8)
          return false;
      
      //count the number of digits, return false if 1 or 0
      //return true if 2 or more
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
          if(isDigit(s.charAt(i)))
              count++;   
      }
      
      if(count>1)
          return true;
      
      return false;
  }
  
  /* Check if a char is a letter */
  public static boolean isLetter(char letter){
      return (letter > 64 && letter < 91 || letter > 96 && letter < 123);
  }
  
  /* Check if a char is a digit */
  public static boolean isDigit(char letter){
     return (letter > 47 && letter <58);
  }
}