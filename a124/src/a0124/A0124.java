package a0124;
/*
January 24th Lecture
Review of Class Construction


**NOTES**
- a source code file can only have 1 public class
- no access modifier means you get defaul access
- default access means this class is only available to other classes
  in the same package as this class.
*/
class RegularPolygon{
    /*
    - no matter what we put inside it is called a class member - whether it is a variable or method (constructors are methods)
    - private data members (aka private instance variables)
    - they are private for data hiding
    */
    private int n = 3; //number of sides
    private double side = 1; //side length
    private double x, y; //coordinates of center point of polygon
    //string default value is empty - every data type has a default value
    
    //1 private data members, 2 constructors, 3 get and set
    //custom constructor allows us to set private data members
    //customs
    public RegularPolygon(int number, double newSide, double newX, double newY){ //can not be private //multiple methods or constructors with the same name but different parameters are considered overloaded
        n = number;
        side = newSide; 
        x = newX;
        y = newY;
    }
    //after defining our own custome constructor, Java gets ride of the default
    //we can define a default one ourself if we want
    public RegularPolygon(){
        //this is default - doesn't do anything other than create object
    }
    
    //get and set method for each private data member
    //getters and setters (accessor and mutators)
    public int getN(){
        return n;
    }
    
    public void setN(int number){
        n = number;
    }
    
    public double getSide(){
        return side;
    }
    
    public void setSide(double s){
        side = s;
    }
    
    public double getX(){
        return x;
    }
    
    public void setX(double number){
        x = number;
    }
    
   public double getY(){
        return y;
    }
    
    public void setY(double number){
        y = number;
    }
    
    //other methods needed for the class
    public double getPerimeter(){
        return n*side;
    }
    public double getArea(){
        return n*side*side/(Math.tan(Math.PI/n)*4);
    }
    
    //override our toString() method
    //when you try to print an object you get a memory address and is the default action of toString()
    //overriding is replacing
    
    @Override //compiler message
    //design your string to show the values of all the data members
    public String toString(){
        return "a polygon with "+n+" sides of length "+side+" that is centered at ("+x+", "+y+")";
    }
    
}
public class A0124 {

    public static void main(String[] args) {
        RegularPolygon polygon1 = new RegularPolygon(); //default constructor - gives default values to undefined of zero //creates the object based off class and will use default values based off that class
        RegularPolygon polygon2 = new RegularPolygon(10,4,5.6,7.8);
        
        //invoke to toString method by printing the object
        System.out.println(polygon1);
        
        System.out.println("Polygon 1 area: "+polygon1.getArea());
        System.out.println("Polygon 1 perimeter: "+polygon1.getPerimeter());
        
        polygon1.setSide(5.4);
        System.out.println("Polygon 1 side length: "+polygon1.getSide());
        
        System.out.println();
        System.out.println(polygon2);
        
        System.out.println("Polygon 2 area: "+polygon2.getArea());
        System.out.println("Polygon 2 perimeter: "+polygon2.getPerimeter());
        
        polygon2.setSide(5.4);
        System.out.println("Polygon 2 side length: "+polygon2.getSide());
    }  
}
