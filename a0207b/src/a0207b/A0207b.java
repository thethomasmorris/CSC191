package a0207b;
/*
My 2D Array Project
Feb 7 and Feb 12, 2019
different methods working with a 2D array
 */
import java.util.Scanner;
class My2DArray{
    //constant declarations - values that can't change
    final int MAXR = 10; //name constants in all caps
    final int MAXC = 10;
    
    //data members
    private int a[][];
    private int nR, nC; //actual number of rows and columns
    //one negative is that arrays are a fixed size
    
    public My2DArray(){
        a = new int[MAXR][MAXC];
        nR = 0;
        nC = 0;
    }
    
    //methods
    public void readA(){
        Scanner in = new Scanner(System.in);
        //collect rows
        System.out.print("Enter the number of rows: ");
        nR = in.nextInt();
        //input validation
        while(nR>MAXR || nR < 1){
            System.out.println("The rows must be between 1 and "+MAXR);
            System.out.print("Enter the number of rows: ");
            nR = in.nextInt();
        }
        //collect columns
        System.out.print("Enter the number of columns: ");
        nC = in.nextInt();
        //input validation
        while(nC>MAXR || nC < 1){
            System.out.println("The columns must be between 1 and "+MAXC);
            System.out.print("Enter the number of columns: ");
            nC = in.nextInt();
        }
        
        for (int r = 0; r < nR; r++) {
            for (int c = 0; c < nC; c++) {
                System.out.print("Enter an integer: ");
                a[r][c] = in.nextInt();
            }
        }
    }
    
    //randomly generate the array contents
    public void generateA(){
        //set nR & nC
        nR = (int) ((Math.random()*MAXR)+1); //plus 1 to shift over since it can be anything 0-1 to make it anything 1-10
        nC = (int) ((Math.random()*MAXC)+1);
        
        //generate values 0-99 to pupulate each spot in an array
        for (int r = 0; r < nR; r++) {
            for (int c = 0; c < nC; c++) {
                a[r][c] = (int) (Math.random()*100); //0-100
            }
        }
    }
    
    public void printA(){
        for (int r = 0; r < nR; r++) {
            for (int c = 0; c < nC; c++) {
                System.out.printf("%6d", a[r][c]);
            }
            System.out.println();
        }
    }
    
    //method to sum by rows
    public void sumRows(){
        System.out.println("Row totals: ");
        for (int r = 0; r < nR; r++) {
            int total = 0;
            for (int c = 0; c < nC; c++) {
                total += a[r][c];
            }
            System.out.println("Row "+(r+1)+": "+total);
        }
    }
    
    //method to sum by columns
    public void sumColumns(){
        System.out.println("Column totals: ");
        for (int c = 0; c < nC; c++) {
            int total = 0;
            for (int r = 0; r < nR; r++) {
                total += a[r][c];
            }
            System.out.println("Column "+(c+1)+": "+total);
        }
    }
    
    //method to shuffle the entire array
    public void shuffleA(){
        for (int r = 0; r < nR; r++) {
            for (int c = 0; c < nC; c++) {
                //generate random row and col for swap
                int row = (int)(Math.random()*nR);
                int col = (int)(Math.random()*nC);
                
                //make sure we aren't swaping a num with itself
                while(r==row && c==col){
                    row = (int)(Math.random()*nR);
                    col = (int)(Math.random()*nC);
                }
                
                //make the swap
                int temp = a[r][c];
                a[r][c] = a[row][col];
                a[row][col] = temp;
            }
        }
    }
    
    //find row with largest sum
    //prints the largest total plus index of which row it is
    public int[] largestR(){
        //need to use Integer.MIN_VALUE since read() could enter neg nums
        int maxRowSum = Integer.MIN_VALUE;
        int indexMaxRow = 0;
        for (int r = 0; r < nR; r++) {
            int rowTotal = 0;
            for (int c = 0; c < nC; c++) {
                rowTotal += a[r][c];
            }
            //rowTotal has the total once inner loop finishes
            if(rowTotal > maxRowSum){
                maxRowSum = rowTotal;
                indexMaxRow = r;
            }
        }
        
        //create the array to return the result
        int[] max = new int[2];
        max[0] = maxRowSum;
        max[1] = indexMaxRow;
        return max;
    }
    
    //sort the rows - use bubble sort long way
    public void sortRows(){
        for (int r = 0; r < nR; r++) {
            for (int c = 0; c < nC-1; c++) {
                for (int i = 0; i < nC-1; i++) {
                    if(a[r][i]>a[r][i+1]){
                        //if true swap them
                        int temp = a[r][i];
                        a[r][i] = a[r][i+1];
                        a[r][i+1] = temp;
                    }
                }
            }
        }
    }
    
    //bubble sort with stages
    
    //sort the entire array with smallest in a[0][0] & largest in a[nR-1][nC-1]
    public void sortA(){
        for (int r = 0; r < nR; r++) {
            for (int c = 0; c < nC-1; c++) {
                for (int i = 0; i < nR; i++) {
                    for (int j = 0; j < nC; j++) {
                        if(a[i][j]>a[r][c]){
                            int temp = a[r][c];
                            a[r][c] = a[i][j];
                            a[i][j] = temp;
                        }
                    }
                }
            }
        }
    }
    
    /*some thing to try during study time
    1. max element of the entire array
    2. min element of the entire array
    3. min row of array
    4. min and max columns of array
    5. sort by columns
    6. printing different patterns from the array
    */
}
public class A0207b {
    public static void main(String[] args) {
        //create an object to test with
        My2DArray myA = new My2DArray();
        myA.generateA();
        myA.printA();
        System.out.println();
        //myA.readA();
        //myA.printA();
        myA.sumRows();
        System.out.println();
        myA.sumColumns();
        System.out.println();
        myA.shuffleA();
        myA.printA();
        System.out.println();
        int max[] = myA.largestR();
        System.out.println("Row "+(max[1]+1)+" is the largest row.");
        System.out.println("Row "+(max[1]+1)+"'s sum is "+max[0]+".");
        System.out.println();
        System.out.println("Sort rows");
        myA.sortRows();
        myA.printA();
        System.out.println("Sort array");
        myA.sortA();
        myA.printA();
    }  
}
