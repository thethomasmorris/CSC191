package thomasmorrislab4;
/*
Lab 4
Thomas Morris
Determine if all points are on the same line
Determine the most central point to the others
Determine the two points that are farthest apart
Determine the two points that are closest
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
    
    public void findFurthestPair(){
        //we will start by assuming row 0 and row 1 contain the pair with farthest dist
        int p1 = 0, p2 = 1;
        double farthestDist = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                double dist = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if(farthestDist < dist){
                    p1 = i;
                    p2 = j;
                    farthestDist = dist;
                }
            }
        }
        System.out.println();
        System.out.println("The farthest two points are: ("+points[p1][0]+", "+points[p1][1]+") and ("+points[p2][0]+", "+points[p2][1]+")");
    }
    
    public double slope(double x1, double y1, double x2, double y2){
        return (y2-y1)/(x2-x1);
    }
    
    public boolean sameLine(){
        int p1 = 0, p2 = 1;
        double slope = slope(points[p1][0], points[p1][1], points[p2][0], points[p2][1]); //get slope of first two points
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                double slope2 = slope(points[i][0], points[i][1], points[j][0], points[j][1]); //get slope of next points
                if(slope != slope2) //slope of all points must be equal to be a line
                    return false;
            }
        }
        return true;
    }
    
    public void centralPoint(){
        double central = 0; //hold the central points distance which should be the smallest
        int p = 0;
        for (int i = 0; i < points.length; i++) {
            double total = 0;
            for (int j = 0; j < points.length; j++) {
                total += distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if(i == 0){ //for first case need to add the final total in to be compared
                    central = total;
                }
            }
            if(central > total){ //when the central distance is bigger than the total we just got we should replace the point and the new total
                p = i;
                central = total;
            }   
        }
        System.out.println();
        System.out.println("The central point is: ("+points[p][0]+", "+points[p][1]+")");  
    }
}

public class ThomasMorrisLab4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many points do you want to compare? ");
        int size = input.nextInt();
        while(size < 2){
            System.out.println("Invalid entry. Number of points must be an integer greater than two to preform a comparision.");
            System.out.print("How many points do you want to compare? ");
            size = input.nextInt();
        }
        PointList pl = new PointList(size);
        int choice;
        do{
            System.out.println();
            System.out.println("1. Determine if all points are on the same line");
            System.out.println("2. Determine the most central point to the others");
            System.out.println("3. Find the two points that are farthest apart");
            System.out.println("4. Exit");
            System.out.print("Enter a choice from the menu above: ");
            choice = input.nextInt();
            while(choice < 1 || choice > 4){
                System.out.println();
                System.out.println("Invalid entry. Enter a choice 1-4 from the menu below.");
                System.out.println("1. Determine if all points are on the same line");
                System.out.println("2. Determine the most central point to the others");
                System.out.println("3. Find the two points that are farthest apart");
                System.out.println("4. Exit");
                System.out.print("Enter a choice from the menu above: ");
                choice = input.nextInt();
            }
            switch(choice){
                case 1:
                    if(pl.sameLine()){
                        System.out.println();
                        System.out.println("All points are on the same line.");
                    }
                    else{
                        System.out.println();
                        System.out.println("All points are NOT on the same line.");
                    }
                    break;
                case 2:
                    pl.centralPoint();
                    break;
                case 3:
                    pl.findFurthestPair();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Thank you for using my program!");
                    System.out.println("Created By: Thomas Morris");
                    break;
                default:
                    System.out.println("Invalid entry. Please try again.");
            }
        }while(choice != 4);
    }
}