package a0430a;
/*
an introduction to interfaces - specifically the Runnable interface
we will use the runnable interface and threads to show mult-threading
multi-threading allows multiple proccesses (aka methods/actions) to run at the same time
 */

class PrintChar implements Runnable{
    private char charToPrint;
    private int times; //number of times to print char
    
    //constructor
    public PrintChar(char c, int t){
        charToPrint = c;
        times = t;
    }
    
    //override the run() method to tell Java what to do when thread starts
    @Override
    public void run(){
        for (int i=0; i<times; i++)
            System.out.print(charToPrint); 
    }
}

class PrintNum implements Runnable{
    private int lastNum;
    
    //constructor
    public PrintNum(int n){
        lastNum = n;
    }
    
    //override the run(0 method to tell Java what to do when thread starts
    public void run(){
        for (int i=1; i<=lastNum; i++)
            System.out.print(" "+i);
    }
}
public class A0430a {
    public static void main(String[] args) {
        //create taks to be run at the same time
        Runnable printA = new PrintChar('a',100);
        Runnable printB = new PrintChar('b',100);
        Runnable print100 = new PrintNum(100);
        
        //create a thread for each task
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        
        //start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    } 
}
