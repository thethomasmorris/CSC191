package a0219a;
/*
February 19, 2019 Lecture
Thomas Morris
 */
import java.util.Scanner;

class PointList{
    private double [][] points;
    
    //constructor
    public PointList(int len){
        points = new double [len][2];
        
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            System.out.println("Enter x and y coordinates of point "+(i+1)+": ");
            System.out.print("X: ");
            points[i][0] = input.nextDouble();
            System.out.print("Y: ");
            points[i][1] = input.nextDouble();
        }
    }
    
    public double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    
    public void findClosestPair(){
        //we will start by assuming row 0 and row 1 contain the pair with shortest dist
        int p1 = 0, p2 = 1;
        double shortestDist = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                double dist = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if(shortestDist > dist){
                    p1 = i;
                    p2 = j;
                    shortestDist = dist;
                }
            }
        }
        System.out.println("The closest two points are: ("+points[p1][0]+", "+points[p1][1]+") and ("+points[p2][0]+", "+points[p2][1]+")");
    }
}

public class A0219a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many points wdo you want to compare? ");
        int size = input.nextInt();
        
        PointList pl = new PointList(size);
        pl.findClosestPair();
    }
}
