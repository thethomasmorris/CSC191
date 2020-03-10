package a129;
/* This is the parent class (aka superclass).  Define class members (attributes and methods)
here that apply to all children classes (aka subclasses). You must use public or protected
access modifiers for the class members if you want the child to have direct access to them.
*/
public class Shape {
    private String name;
    private String color;
    private int num_sides;
    
    public Shape(String name, String color, int n){
        this.name = name;
        this.color = color;
        num_sides = n;
    }
    
    public String getName(){
        return name;
    }
    
    //protected access means only child classes and classes in same package
    //have access to this set method.  Public is used more often!
    protected void setName(String name){
        this.name = name;
    }
    
    public String getColor(){
        return color;
    }
    
    protected void setColor(String color){
        this.color = color;
    }
    
    public int getNumSides(){
        return num_sides;
    }
    
    public void setNumSides(int s){
        num_sides = s;
    }
    
    public int getPerimeter(int side){
        return num_sides*side;
    }
    
    @Override
    public String toString(){
        return "The shape named "+name+" is the color "+color+".";
    }
}