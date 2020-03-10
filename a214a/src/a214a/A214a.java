// Matrix Math - adding and multiplying matrixes
// using 2D arrays to store the matrices
// assuming the 2 matrices have the same dimensions
// Feb 14, 2019

package a214a;
import java.util.Scanner;
public class A214a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        final int N = 3;
        final int M = 3;
        
        // Enter matrix 1
        System.out.println("Enter matrix 1: ");
        double[][] matrix1 = new double[N][M];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = input.nextDouble();
            }
        }
        
        // Enter matrix 2
        System.out.println("Enter matrix 2: ");
        double[][] matrix2 = new double[N][M];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = input.nextDouble();
            }
        }
        
        // add two matrices and print the result
        double[][] result = addMatrix(matrix1, matrix2);
        System.out.println("The addition of the matrices is ");
        printResult(matrix1, matrix2, result, '+');
        
        // multiply two matrices and print the result
        double[][] result2 = multiplyMatrix(matrix1, matrix2);
        System.out.println("The dot product of the matrices is ");
        printResult(matrix1, matrix2, result2, '*');
        
    }//close main
    
    // the method for adding two matrices
    public static double[][] addMatrix(double[][] m1, double[][] m2){
        double[][] result = new double[m1.length][m1[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return result;
    }
    
    // the method to print the result
    public static void printResult(double[][] m1, double[][] m2, double[][] m3, char op){
        for (int i = 0; i < m1.length; i++) { //controls each row output
            //print contents of row i from m1
            for (int j = 0; j < m1[i].length; j++) {
                System.out.printf("%6.1f", m1[i][j]);
            }
            //output the space or operator
            if(i == m1.length/2)
                System.out.print(" "+op+" ");
            else
                System.out.print("   ");
            //print contents of row i from m2
            for (int j = 0; j < m2[i].length; j++) {
                System.out.printf("%6.1f", m2[i][j]);
            }
            //output the space or equal
            if(i == m1.length/2)
                System.out.print(" = ");
            else
                System.out.print("   ");
            //print contents of row i from m3 - must be bigger width
            for (int j = 0; j < m3[i].length; j++) {
                System.out.printf("%8.1f", m3[i][j]);
            }
            System.out.println();
        }
    } //close printResult
    
    //method to multiply 2 matrices
    public static double[][] multiplyMatrix(double[][] m1, double[][] m2){
        double[][] result = new double[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m1[0].length; k++) {
                    result[i][j] += m1[i][k]*m2[k][j];
                }
            }       
        }
        return result;
    }
}
