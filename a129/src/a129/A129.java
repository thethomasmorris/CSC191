package a129;
        //java t point
        //api
        //java tutorials point     
public class A129 { //driver program - not technical term
    public static void main(String[] args) { //starts execution
        Square sq = new Square("square","blue", 2);
        RightTriangle tri = new RightTriangle("right triangle","red",4,3);
        
        //invoke toString
        System.out.println(sq);
        System.out.println(tri);
        
        System.out.println("Square Perimeter: "+sq.getPerimeter(sq.getSide())); //uses parent method
        System.out.println("Triangle Perimeter: "+tri.getPerimeter()); //comes from the child
        
    } 
}
