package a129;

//Square is a child class of Shape
public class Square extends Shape {
    
    //we only put new or different class members in the child
    private int side; //side length
    
    public Square(String name, String color, int s){
        //our first line of code in the child constructor is to call the parent
        super(name, color, 4); //super calls the parent
        side = s;
    }
    
    //get and set methods for child data member
    public int getSide(){
        return side;
    }
    
    public void setSide(int s){
        side = s;
    }
    
    //squares can have an area - new method
    public int getArea(){
        return side*side;
    }
    
    @Override
    public String toString(){
        return super.toString()+" This square has a side length of "+side+".";
    }
    
}
