package thomasmorrislab7;
/*
Thomas Morris
Lab 7
This program will recursively print all possible subsets using the first n integers from the set of integers contained in the array int[] A.
This program will also print all possible permutaions of String s.
 */
import java.util.Scanner;
public class ThomasMorrisLab7 {
    static void subsets(int[] A, int n){
        subsets("",A,n);
    }
    static void subsets(String s, int[] A, int n){
        if(n==0)
            System.out.println(s);
        else{
            subsets(s,A,n-1);
            subsets(A[n-1]+s,A,n-1);
        }
    }
    
    static void permutations(String s){
        permutations(s, 0);
    }
    static void permutations(String s, int pos){
        if(s.length() == pos) //base case
            System.out.println(s);
        else{
            char[] ca = s.toCharArray(); //create a character array to make the swap - I could not figure this out except this way
            for (int i = pos; i < ca.length; i++) {
                //s1 = s.substring(0, pos)+s.charAt(i)+s.substring(pos+1, i)+s.charAt(pos)+s.substring(i+1);
                char temp = ca[i];
                ca[i] = ca[pos];
                ca[pos] = temp;
                String s1 = new String(ca); //character constructor to buld the swapped string
                permutations(s1,pos+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int[] A = {1,2,3,4,5,6,7};
        //subsets(A,3);
        //String s = "abc";
        //permutations(s);
        int choice;
        do{
            System.out.println("1. Print Subsets");
            System.out.println("2. Print Permutations");
            System.out.println("3. Exit");
            System.out.print("Enter a choice from the menu above: ");
            choice = in.nextInt();
            while(choice<0 || choice>3){
                System.out.println("Invaild entry!");
                System.out.println("1. Print Subsets");
                System.out.println("2. Print Permutations");
                System.out.print("Enter a choice from the menu above: ");
                choice = in.nextInt();
            }
            switch(choice){
                case 1:
                    System.out.print("Enter the number of elements in the array: ");
                    int aE = in.nextInt();
                    while(aE<1){
                        System.out.println("Invalid entry!");
                        System.out.print("Enter the number of elements in the array: ");
                        aE = in.nextInt();
                    }
                    int[] A = new int[aE];
                    for (int i = 0; i < A.length; i++) {
                        System.out.print("Enter element "+(i+1)+": ");
                        A[i] = in.nextInt();
                    }
                    System.out.print("Enter n for the subset: ");
                    int n = in.nextInt();
                    while(n<0 || n > A.length){
                        System.out.println("Invalid entry!");
                        System.out.print("Enter n for the subset: ");
                        n = in.nextInt(); 
                    }
                    subsets(A,n);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter the string: ");
                    String s = in.next();
                    permutations(s);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Thanks for using my program!");
                    System.out.println("Created By: Thomas Morris");
                    break;
                default:
                    System.out.println("Invalid entry!");
            }
            
        }while(choice != 3);
    } 
}
