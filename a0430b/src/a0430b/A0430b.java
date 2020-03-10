package a0430b;
/*
A first look at the concept of generics
We will generalize the data type of arrays so one class will work with any array 
 */

//write a generic class with generic datatype T
class Box<T>{
    //we can create a private instance variable of type T
    private T t;
    
    public void set(T t){
        this.t = t;
    }
    
    public T get(){
        return t;
    }
}

public class A0430b {
    //generic method for printing our array
    public static <E> void printArray(E[] inputArray){ //e stands for element but it can be anything
        //print out the array elements
        for(E element: inputArray)
            System.out.print(element+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        //create some arrays
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,2.2,3.3,4.4,5.5};
        Character[] charArray = {'H','E','L','L','O'};
        String[] stringArray = {"WORLD","!!!"};
        
        //print them using our generic method
        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
        printArray(stringArray);
        
        //create objects for our generic box class
        Box<Integer> integerbox = new Box<Integer>();
        Box<String> stringbox = new Box<String>();
        
        //add values to t for each object
        integerbox.set(10); //autoboxing - converts this from primitive data type to object data type
        integerbox.set(new Integer(10)); //explicit data type conversion
        
        stringbox.set("Hello World");
        
        //print t from each object
        System.out.printf("Integer value: %d \n", integerbox.get());
        System.out.printf("String value: %s \n", stringbox.get());      
    }
}
