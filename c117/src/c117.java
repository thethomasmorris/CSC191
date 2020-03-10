/*
January 17, 2019 Lecture
Thomas Morris
review break, continue, variable scope with loops, and operator precedence
*/

public class c117 {
    public static void main(String[] args) {
        //break and continue
        for (int i = 0; i < 10; i++) {
            if(i==3)
                continue; //moves to the next iteration
            System.out.print(i+" "); //prints 8 since it was before the break
            if(i==8)
                break; //completely exits loop
        }
        //System.out.println(i); doesn't compile
        System.out.println();
        
        //we can make i available outside the loop if we want
        int i;
        for (i = 0; i < 10; i++)
            System.out.print(i+" ");
        System.out.println();
        System.out.println(i);
        
        //unary operators - !(not), - (negative)
        int x = 5;
        x = -x;
        System.out.println(x);
        x = -x;
        System.out.println(x);
        
        System.out.println();
        //more complicated pre- and post-increment example
        x = 5;
        int y = 10;
        int z = ++x + y--;
        System.out.println("x: "+x);
        System.out.println("y: "+y);
        System.out.println("z: "+z);
        
        System.out.println();
        
        z = -++x + y--; //does not permanately change x with the minus sign
        System.out.println("x: "+x);
        System.out.println("y: "+y);
        System.out.println("z: "+z);
    } 
}

