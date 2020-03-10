package thomasmorrishw1;
/*
Thomas Morris
Homework 1
January 7th, 2019
Determine if a rectangle and a circle given by the user has the circle completely contained within the rectangle, completely outside the rectangle, or if they intersect
*/
import java.util.Scanner;
class Rectangle{
    private double width, height, x, y; //x,y represent top-left most point
        
    //default constructor      
    public Rectangle(){
            
    }
        
    //constructor
    public Rectangle(double w, double h, double x, double y){
        width = w;
        height = h;
        this.x = x;
        this.y = y;
    }
        
    //accessor methods
    public double getWidth(){
        return width;
    }
        
    public double getHeight(){
        return height;
    }
        
    public double getX(){
        return x;
    }
        
    public double getY(){
        return y;
    }
        
    //mutator methods
    public void setWidth(double w){
        width = w;
    }
        
    public void setHeight(double h){
        height = h;
    }
        
    public void setX(double x){
        this.x = x;
    }
        
    public void setY(double y){
        this.y = y;
    }
        
    //calculate rectangle area
    public double getArea(){
        return width*height;
    }
}
    
class Circle{
    private double x, y, radius; //x,y represent center point 
        
    //default constructor
    public Circle(){
            
    }
        
    //constructor
    public Circle(double x, double y, double r){
        this.x = x;
        this.y = y;
        radius = r;
    }
        
    //accessor methods
    public double getX(){
        return x;
    }
        
    public double getY(){
        return y;
    }
        
    public double getRadius(){
        return radius;
    }
        
    //mutator methods
    public void setX(double x){
        this.x = x;
    }
        
    public void setY(double y){
        this.y = y;
    }
        
    public void setRadius(double r){
        radius = r;
    }
        
    //calculate area of triangle
    public double getArea(){
        return Math.PI*(radius*radius);
    }
}
public class ThomasMorrisHW1 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        boolean isCircleSet = false, isRectangleSet = false;
        
        int choice;
        do{
            System.out.println();
            System.out.println("Main Menu"); 
            System.out.println("1. Set Circle Radius and Center Point");
            System.out.println("2. Set Rectangle Width, Height, and Point");
            System.out.println("3. Display Proximity of Rectangle and Circle");
            System.out.println("4. Display Circle Area");
            System.out.println("5. Display Rectangle Area");
            System.out.println("6. Exit");
            System.out.print("Enter a choice: ");
            choice = in.nextInt();
            while(choice < 1 || choice > 6){
                System.out.println();
                System.out.println("Invalid entry! Please enter a number 1-6 from the menu below.");
                System.out.println("Main Menu"); 
                System.out.println("1. Set Circle Radius and Center Point");
                System.out.println("2. Set Rectangle Width, Height, and Point");
                System.out.println("3. Display Proximity of Rectangle and Circle");
                System.out.println("4. Display Circle Area");
                System.out.println("5. Display Rectangle Area");
                System.out.println("6. Exit");
                System.out.print("Enter a choice: ");
                choice = in.nextInt();
            }

            switch(choice){
                case 1: //set circle
                    System.out.println();
                    System.out.println("Set Circle");
                    System.out.print("Enter the x coordinate of center point: ");
                    double cx = in.nextDouble();
                    c.setX(cx);
                    System.out.print("Enter the y coordinate: ");
                    double cy = in.nextDouble();
                    c.setY(cy);
                    System.out.print("Enter the radius: ");
                    double radius = in.nextDouble();
                    c.setRadius(radius);
                    isCircleSet = true;
                    break;
                case 2: //set rectangle
                    //width, height x, y
                    System.out.println();
                    System.out.println("Set Rectanlge");
                    System.out.print("Enter the width: ");
                    double w = in.nextDouble();
                    r.setWidth(w);
                    System.out.print("Enter the height: ");
                    double h = in.nextDouble();
                    r.setHeight(h);
                    System.out.print("Enter the x coordinate of top-left corner: ");
                    double rx = in.nextDouble();
                    r.setX(rx);
                    System.out.print("Enter the y coordinate of top-left corner: ");
                    double ry = in.nextDouble();
                    r.setY(ry);
                    isRectangleSet = true;
                    break;
                case 3: //position relationship
                    if(isCircleSet && isRectangleSet){
                        if((c.getX()-c.getRadius()) > r.getX() && (c.getX()+c.getRadius()) < (r.getX()+r.getWidth()) && (c.getY()+c.getRadius()) < r.getY() && (c.getY()-c.getRadius()) > (r.getY()-r.getHeight()))
                            //compare the leftmost, rightmost, upper and lower boundaries of the rectangle to make sure the circle fits inside of all of them
                            System.out.println("Circle is completely inside the rectangle.");
                        else if(((c.getX()+c.getRadius()) < r.getX() || (c.getX()-c.getRadius()) > r.getX()+r.getWidth()) && ((c.getY()+c.getRadius()) < r.getY()-r.getHeight() || (c.getY()-c.getRadius()) > r.getY())) 
                            //compare the leftmost, rightmost, upper and lower boundaries of the rectangle to make sure the circle does not meet any of them
                            System.out.println("Circle is completely outside the rectangle.");
                        else
                            System.out.println("The circle and rectangle intersect.");
                    }
                    else
                        System.out.println("Please set the circle and rectangle to continue.");
                    break;
                case 4: //display circle area
                    if(isCircleSet){
                        System.out.println("Circle area: "+c.getArea());
                    }
                    else
                        System.out.println("Please set the circle to continue.");
                    break;
                case 5: //display rectangle area
                    if(isRectangleSet){
                        System.out.println("Rectangle area: "+r.getArea());
                    }
                    else
                        System.out.println("Please set the rectangle to continue.");
                    break;
                case 6:
                    System.out.println("Thanks for using my program!");
                    break;
                default:
                    System.out.println("Invalid entry! Please try again.");
                    break;   
            } 
        }while(choice < 6);
    }   
}
