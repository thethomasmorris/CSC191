package a0305;
/*
Welcome to Recursion!
Our first looks at some recursive methods
March 5, 2019
*/
public class A0305 {
    //factorial n! = n*(n-1)*(n-2)*...2*1;
    
    //iterative way - using loops
    static int fact(int n){
        int result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;
        return result;
    }
    
    //recursion - calls itself
    static int factRecur(int n){
        //stopping condition (aka base case) can not be recursive without a base case
        if(n==0)
            return 1;
        return n*factRecur(n-1);
    }
    
    //find out if something is a 2's power
    
    //iterative way
    static boolean isPower(int n){
        while(n>1){
            if(n%2 != 0)
                return false;
            n= n/2;
        }
        return true;
    }
    
    //recursive way
    static boolean isPowerRecur(int n){
        //base case
        if(n==1)
            return true;
        return (isPowerRecur(n/2) && n%2==0);
    }
    
    //greatest common divisor using Euclid's method
    
    //iterative way
    static int gcd(int n1, int n2){
        if(n1<n2){
            int t = n1;
            n1 = n2;
            n2 = t;
        }
            
        while(n2>0){
            int r = n1%n2;
            n1 = n2;
            n2 = r;
        }
        return n1;
    }
    
    //recursive way
    static int gcdRecur(int n1, int n2){
        if(n1<n2){
            int t = n1;
            n1 = n2;
            n2 = t;
        } 
        if(n2==0)
            return n1;
        return gcdRecur(n2, n1%n2);
    }
    
    //convert from decimal to binary
    
    //iterative way
    static String decToBin(int decimal){
        String binary = "";
        while(decimal > 0){
            binary = decimal%2 + binary;
            decimal /= 2;
        }
        return binary;
    }
    
    //recursive way
    static String decToBinRecur(int decimal){
        //base case
        if(decimal == 0)
            return ""; //return null
        return decToBinRecur(decimal/2)+decimal%2;
    }
    
    //reversing a string recursively
    static String reverseRecur(String s){
        if(s.length()==1)
            return s;
        return s.charAt(s.length()-1) + reverseRecur(s.substring(0, s.length()-1));
    }
    //stack is the memory stack of your program - last in, first out
    //stack overflow means that we filled up our memory beyond 
    public static void main(String[] args) {
    }   
}
