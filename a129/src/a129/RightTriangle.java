package a129;

public class RightTriangle extends Shape {
    private int height;
    private int base;
    
    public RightTriangle(String name, String color, int b, int h){
        super(name, color, 3);
        base = b;
        height = h;
    }
    
    //we can override methods from parent if needed in the child
    //perimeter is calculated differently for triangle
    public double getPerimeter(){
        return base + height + Math.sqrt(((base*base)+(height*height)));
    }
    
    @Override
    public String toString(){
        return super.toString()+" This right triangle has a base of "+base+" and a height of "+height+".";
    }
}
