/*
January 17, 2019 Lecture
Thomas Morris
printf and for loops for multiplication table
*/

public class b117 {
    public static void main(String[] args) {
       //notes
       //printf is most commonly used to line up data and for proper spacing
       //does not line break and is preferred for making information tables
       //square brackets in documentation denote optional information
       //flags control justification - the default is right justifcation
       
       //display table heading
       System.out.println("         Multiplication Table");
       //display number title row
        System.out.print("  ");
        for (int i = 1; i < 10; i++)
            System.out.printf("%4d",i);
        //printf doesn't give us a line break
        System.out.println("\n---------------------------------------");
       //display table body
        for (int i = 1; i < 10; i++){ //columns
            System.out.print(i+"|");
            for (int j = 1; j < 10; j++) { //rows
                System.out.printf("%4d",i*j);
            }
            System.out.println();
        }
    } 
}
