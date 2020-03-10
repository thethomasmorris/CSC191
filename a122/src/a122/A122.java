package a122;

/*
January 22, 2019 Lecture
String Review
Thomas Morris
*/

public class A122 {
    public static void main(String[] args) {
        String s = "Java is fun!";
        
        //charAt function - string index starts at zero
        //length()-1 provides the ending index
        
        //print every other character in string s
        for (int i = 1; i < s.length(); i+=2) 
            System.out.print(s.charAt(i));
        System.out.println();
        
        //more String Fun!
        String s2 = "Java";
        String s3 = s;
        String s4 = " Java ";
        String s5 = "Java is fun!";
        String s6 = new String("Java is fun!"); //don't use String pool
        
        /*
        using a constructor to create string
        s, s3, s5 are all the same object because of the String pool
        primate variables is the name of the memory locatin where the variable
        is locate
        reference variable is how is string is 'edited'
        
        String literals use a String pool to conserve memory in Java
        If you use the new keyword, then you are skipping the string pool
        
        
        == with Strings - test whether they are the same object or not
         equals() method test whether they contain the same text
        String pool with sometimes return the correct answer with == but only
        because they're the same object
        also equalsIgnoreCase() method is not case sensitive
        */
        System.out.println();
        System.out.println("testing == "+(s3==s)); //true same object
        System.out.println("testing equals method: "+s3.equals(s)); //true
        System.out.println("testing == "+(s5==s)); //true bc of String pool
        System.out.println("testing equals method: "+s5.equals(s)); //true
        System.out.println("testing == "+(s6==s)); //false different objects
        System.out.println("testing equals method: "+s6.equals(s)); //true
        System.out.println("testing == "+(s2==s4));
        System.out.println("testing equals method: "+s2.equals(s4));
        
        System.out.println();
        //contains()
        System.out.println("contains method returns boolean: "+s.contains(s2));
        System.out.println("contains method returns boolean: "+s.contains("java"));
        
        System.out.println();
        //startsWith() and endsWith()
        System.out.println("startsWith method: "+s.startsWith("j")); //false
        System.out.println("endsWith method: "+s.endsWith("!")); //true
        
        System.out.println(); //QUIZ/TEST Question
        //replace() - can only substitute one character for another
        s.replace('!','.');
        System.out.println("replace method: "+s);
        //remember that strings are immutable!
        System.out.println("replace method: "+s.replace('!','.'));
        System.out.println(s);
        //rember that strings are immutable!
        String s7 = s.replace('!', '.');
        System.out.println("S7 new string with replacement: "+s7);
        
        System.out.println();
        //trim() removes beginning and ending spaces
        System.out.println("s4 before: "+s4);
        System.out.println("trim method: "+s4.trim());
        
        System.out.println();
        //method chaining
        //executed left to right order
        System.out.println(s.toUpperCase().substring(8,11)); 
        //substring method the first number is inclusive and the last number is not
        
        
        
        
    }   
}
