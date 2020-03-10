package a0423a;
/*
Introduction to Linked Lists
April 23rd, 2019
 */
import java.util.*;

class Book{
    int id;
    String name, author, publisher;
    int quantity;
    
    public Book(int id, String name, String author, String publisher, int quantity){
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}
public class A0423a {
    
    public static void print(LinkedList list){
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i)+" ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        //Let's create our first linked list
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        
        //add some ints to the linked list 
        numbers.addLast(222);
        numbers.addLast(333);
        numbers.addLast(444);
        numbers.addLast(555);
        numbers.addFirst(111);
        print(numbers);
        
        numbers.removeFirst();
        numbers.removeLast();
        numbers.remove(2);
        print(numbers);
        
        //create a String LinkedList
        LinkedList<String> name = new LinkedList<String>();
        name.add("bbb"); //adds to the end by default
        name.add("aaa");
        print(name);
        
        //Let's compare linked lists and array lists
        
        //linked lists - implemented as a double linked list
        //better for add and remove
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.add(4);
        ll.add(6);
        
        System.out.println("Here is our linked list: ");
        Iterator iter2 = ll.iterator(); 
        //job of an iterator is to keep up with where you are in the list 
        //and go to the next one
        while(iter2.hasNext())
            System.out.print(iter2.next()+" ");
        System.out.println();
        
        //array lists - implemented as a resizable array in Java
        //better for get and set compared to a linked list
        ArrayList al = new ArrayList();
        al.add(3);
        al.add(2);
        al.add(1);
        al.add(4);
        al.add(6);
        
        System.out.println("Here is our array list: ");
        Iterator iter1 = al.iterator(); 
        //job of an iterator is to keep up with where you are in the list 
        //and go to the next one
        while(iter1.hasNext())
            System.out.print(iter1.next()+" ");
        System.out.println();
        
        System.out.println();
        //biggest and smallest ints in Java
        System.out.println("Max Integer Value: "+Integer.MAX_VALUE);
        System.out.println("Min Integer Value: "+Integer.MIN_VALUE);
        System.out.println();
        
        //test the performance of add for both types of lists
        long startTime = System.nanoTime();
        //add a bunch of times to ArrayList
        for (int i = 0; i < 1000000; i++)
            al.add(i);
        long endTime = System.nanoTime();
        long duration = endTime-startTime;
        System.out.printf("Aray list add: %12d", duration);
        System.out.println();
        
        //lets repeat that for the linked list
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++)
            ll.add(i);
        endTime = System.nanoTime();
        duration = endTime-startTime;
        System.out.printf("Link list add: %12d", duration);
        System.out.println();
        
        System.out.println();
        //test get now
        startTime = System.nanoTime();
        //add a bunch of times to ArrayList
        for (int i = 0; i < 10000; i++)
            al.get(i);
        endTime = System.nanoTime();
        duration = endTime-startTime;
        System.out.printf("Aray list get: %12d", duration);
        System.out.println();
        
        //lets repeat that for the linked list
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            ll.get(i);
        endTime = System.nanoTime();
        duration = endTime-startTime;
        System.out.printf("Link list get: %12d", duration);
        System.out.println();
        
        System.out.println();
        //Let's create a linked list with Book objects in it
        LinkedList<Book> list = new LinkedList<Book>();
        
        //create our books
        Book b1 = new Book(101,"Let Us C","Kanetkar","BPB",8);
        Book b2 = new Book(102,"Data Communications","Forouzan","McGraw Hill",4);
        Book b3 = new Book(103,"Operating Systems","Galvin","Wiley",6);
        
        //add books to the list
        list.add(b1);
        list.add(b2);
        list.add(b3);
        
        //traversing the list - for loop with index, iterator object, for each
        //for each only work with collections
        for(Book b:list) {
            System.out.println(b.id+", "+b.name+", "+b.author+", "+b.publisher+", "+b.quantity);
            //these are not private so we get direct access
        }
        
    }
}
