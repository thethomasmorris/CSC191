/*
Polynomial Math Recursively
March 26 & 28, 2019
 */
package a0326b;
import java.util.Scanner;
class Polynomial{
    final int MAXSIZE = 20;
    int p[]; //holds poly's coefficients
    int deg; //holds poly's degree
    
    //constructor
    Polynomial(){
        p = new int[MAXSIZE];
        deg = -1;
    }
    
    public void readPoly(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the degree: ");
        deg = in.nextInt();
        
        System.out.println("Next enter the coefficients: ");
        for (int i = 0; i <= deg; i++) {
            System.out.print("Enter the coefficient for term x^"+(deg-i)+": ");
            p[i] = in.nextInt();
        }
    }
    
    public void printPoly(){
        for (int i = 0; i < deg; i++) {
            if(p[i] != 0)
                System.out.print(p[i]+"x^"+(deg-i));
            if(p[i+1] != 0)
                System.out.print(" + ");
        }
        if(p[deg] != 0)
            System.out.println(p[deg]);
        else
            System.out.println();
    }
    
    public Polynomial addPoly(Polynomial P1, Polynomial P2){
        Polynomial P3 = new Polynomial();
        int i1 = P1.deg;
        int i2 = P2.deg;
        int i3 = Math.max(P1.deg, P2.deg);
        P3.deg = i3;
        
        while(i1 >= 0 && i2 >= 0){
            P3.p[i3--] = P1.p[i1--]+P2.p[i2--];
        }
        
        while(i1 >= 0){
            P3.p[i3--] = P1.p[i1--];
        }
        
        while(i2 >= 0){
            P3.p[i3--] = P2.p[i2--];
        }
        return P3;
    }
    
    // Multiply polys - overloading same name but different paramenters
    public Polynomial multiplyPoly(Polynomial P1, Polynomial P2){
        return multiplyPoly(P1,P2,P2.deg);
    }
    
    public Polynomial multiplyPoly(Polynomial P1, Polynomial P2, int d){
        Polynomial Pm1 = new Polynomial();
        Polynomial Pm2;
        
        if(d == -1){
            Pm2 = new Polynomial();
            return Pm2;
        }
        for (int i = P1.deg; i >= 0; i--)
            Pm1.p[i] = P1.p[i]*P2.p[d];
        Pm1.deg = P1.deg;
        Pm2 = multiplyPoly(P1,P2,d-1);
        Pm2.deg++;
        
        return addPoly(Pm1, Pm2);
    }
    
    //evaluate poly recursively for a specific x value
    public double evalPoly(double x){
        return evalPoly(deg, x);
    }
    
    double evalPoly(int d, double x){
        //base case
        if(d == 0)
            return p[0];
        return evalPoly(d-1, x)*x + p[d];
    }
}
public class A0326b {
    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        p.readPoly();
        p.printPoly();
        
        Polynomial p2 = new Polynomial();
        p2.readPoly();
        p2.printPoly();
        
        System.out.println();
        System.out.println("Add");
        Polynomial p3 = new Polynomial();
        p3 = p3.addPoly(p,p2);
        p3.printPoly();
        
        System.out.println();
        System.out.println("Multiply");
        Polynomial p4 = p.multiplyPoly(p, p2);
        p4.printPoly();
        
        System.out.println();
        System.out.println("Evaluate");
        System.out.println(p.evalPoly(4));
        
    }
}
