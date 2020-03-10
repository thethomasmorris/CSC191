package thomasmorrislab2;
/*
February 6, 2019 Lab 2
Thomas Morris
Class Inheritance & Single Dimensional Arrays to calculate a standard employee's pay as well as a salesperson's pay
*/

import java.util.Scanner;
public class ThomasMorrisLab2 {
    public static void main(String[] args) {
        double timesheetJohn[] = {7.5, 7.5, 7.5, 0, 5, 7.5, 10};
        double timesheetJane[] = {12, 12, 0, 0, 0, 12, 0};
        Employee e = new Employee("John Doe", 901654510, 7.5, timesheetJohn, "jdoe@eku.edu");
        Salesperson s = new Salesperson("Jane Doe", 7544210, 15.14, timesheetJane, "janedoe@gmail.com", 2.25);
        
        //invoke the two string method for each object
        System.out.println(e);
        System.out.println(s);
        
        System.out.println();
        //print John's timesheet
        System.out.println("John's Timesheet");
        for (int i = 0; i < e.getTimesheet().length; i++)
            System.out.println("Day "+(i+1)+": "+e.getTimesheet()[i]+" "); 
        
        System.out.println();
        //print Jane's timesheet
        System.out.println("Jane's Timesheet");
        for (int i = 0; i < s.getTimesheet().length; i++)
            System.out.println("Day "+(i+1)+": "+s.getTimesheet()[i]+" "); 
        
        System.out.println();
        s.setEmail("janed@microsoft.com"); //change email of salesperson
        System.out.println("Name: "+s.getName()+" Email: "+s.getEmail()); //print name and changed email
        s.setCommission(s.getCommission()+5.0); //increase the commission rate by 5%
        System.out.println(s); //show changed commission rate using toString
        
        //calculate each employee's pay
        System.out.println("John's Pay:");
        System.out.println(e.calculatePay()); //40*7.5 = 300, //45*7.5 =  40*7.5 + 5*11.25 = 300+56.25 = 356.25
        System.out.println("Jane's Pay:");
        System.out.println(s.calculatePay(10000.00)); // commission is $725 + (hourly pay 36*15.14 = 545.04) = 1270.04         
        
        
    }
}
