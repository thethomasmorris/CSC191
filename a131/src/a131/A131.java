package a131;
/*
January 31st Lecture
Review of single-dimensional arrays
 */
import java.util.Scanner;
import java.util.Random;
public class A131 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //array definition with literal values 
        //size of array was automatically set to seven
        String days[] = {"Sunday", "Monday", "Tuesdy", "Wednesday", "Thursday", "Friday", "Saturday"};
        //either way will be read by the java compiler
        String[] days2 = {"Sunday", "Monday", "Tuesdy", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        //change mispelled word
        days[2] = "Tuesday";
        
        //define an array and populate with user input
        
        //find out how big is the array
        System.out.print("How many numbers do you want to store: ");
        int numOfNums = in.nextInt();
        
        while(numOfNums < 1){ //0 may be legal in Java, but logically it is excluded
            System.out.println("You must enter an integer greater than zero.");
            System.out.print("How many numbers do you want to store: ");
            numOfNums = in.nextInt();
        }
        
        //create the array of size numOfNums
        int nums[] = new int[numOfNums];
        
        for (int i = 0; i < numOfNums; i++) {
            System.out.print("Enter the "+(i+1)+" integer number in the data set to store: ");
            nums[i] = in.nextInt();
        }
        
        printA(nums);
        System.out.println("sum = "+sumA(nums));
        int reverse[] = reverseA(nums);
        System.out.print("The content of reverse: ");
        printA(reverse);
        System.out.print("The content of nums: ");
        printA(nums);
        //when an operation is done to an array it is permanent
        //it doesn't have to be returned to the caller
        //the changes were made to the object in memory
        System.out.print("The content of rotate left: ");
        printA(rotateL(nums));
        System.out.print("The content of shuffle: ");
        printA(shuffleA(nums));
        
    } //close main
    
    // method to print an array
    //when not creating objects we need the static return time
    static void printA(int a[]){
        for (int i = 0; i < a.length; i++) { //string is a class - classes have methods - uses length() and arrays have properties
            System.out.print(a[i]+" "); 
        }
        System.out.println();
    }
    
    //method to sum the contents of the array
    static int sumA(int a[]){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
    
    static int[] reverseA(int[] a){
        for (int i = 0; i < a.length/2; i++) {
            //swap a[i] and a[a.length-1-i]
            int temp = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = temp;
        }
        return a;
    }
    
    //rotate array conents left one spot
    static int[] rotateL(int[] a){
        int temp = a[0];
        for (int i = 1; i < a.length; i++) {
            a[i-1] = a[i]; 
        }
        a[a.length-1] = temp;
        return a;
    }
    
    //rotate array contents right one spot - do yourself!
    
    //method to shuffle the array contents
    static int[] shuffleA(int[] a){
        int x = 0; //random index to swap with y
        int y = 0; //random index to swap with x
        Random r = new Random(); //a random object to generate random nums
        // i controls how many random swaps to make
        for (int i = 0; i < a.length; i++) {
            x = r.nextInt(a.length); //gives us random int between 0 and a.length-1 inclusive
            y = r.nextInt(a.length);
            
            //make swaps
            while(x == y)
                x = r.nextInt(a.length);
            int temp = a[x];
            a[x] = a[y];
            a[y] = temp;
        }
        return a;
    }
    // search and sort methods!
    
    // first sorts
    
    // method to bubble sort - fast way
    static int[] bubbleSort(int[] a){
        for (int stage = a.length-2; stage > 0; stage--) {
            boolean isSorted = true;
            for (int i = 0; i <= stage; i++) {
                if(a[i]>a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    isSorted = false;
                }//close if
            }//close inner loop
            if(isSorted)
                return a;
        }
        return a;
    }
    
    //insertion sort
    //we keep sorted sublist on left and insert new number where it goes in sublist
    static void insertionSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for(j=i-1; j>=0; j--){
                if(a[j]>temp)
                    a[j+1] = a[j]; //scoot it over
                else
                    break;  //end loop immediately
            }//close of inner loop
            a[j+1] = temp;
        }
    }
    
    //selection sort
    //we repeatedly find the largest num and put at the end moving left each time
    static void selectionSort(int[] a){
        for (int stage = a.length-1; stage >=1; stage--) {
            //make the index of max number 0
            int maxI = 0;
            for (int i = 1 ; i <= stage; i++) {
                if(a[i]>a[maxI])
                    maxI = i;
            }
            //sawp a[maxI] with a[stage]
            int temp = a[maxI];
            a[maxI] = a[stage];
            a[stage] = temp;
        }
    }
    
    //search methods - sequential search and binary search
    
    //sequential search method for an item in the array
    //returns index of the first occurance of k in array a
    //return -1 if k is not found in a
    static int sequentialSearch(int k, int[] a){
        for (int i = 0; i < a.length; i++) {
            if(a[i]==k)
                return i;
        }
        return -1; //not found
    }
    
    //sequential search that returns all locations of k in a
    
    static int[] sequentialSearchAll(int k, int[] a){
        int t[] = new int[a.length];
        int tIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]==k)
                t[tIndex++] = i;
        }
        //copy into new smaller array that doesn't have nulls
        int result[] = new int[tIndex];
        for (int i = 0; i < tIndex; i++) {
            result[i] = t[i];
        }
        return result;        
    }
    
    //binary search - array has to be pre-sorted
    static boolean isSorted(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            if(a[i]>a[i+1])
                return false;
        }
        return true;
    }
    
    static int binarySearch(int key, int[] a){
        int left = 0;
        int r = a.length-1;
        
        while(left<=r){
            int m = (left+r)/2;
            if(a[m]==key)
                return m;
            if(a[m]>key)
                r = m-1;
            else
                left = m+1;
        }
        return -1; //not found
        
    }
    //binary search all
    
} //close class
