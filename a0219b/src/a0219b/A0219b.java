package a0219b;
import java.util.Scanner;
import java.text.DecimalFormat;
/*
This project will represent a course and help a teacher average grades
We will have parent class called course
Our child class will be CSC191
This project will use 2D arrays to store grades 
Feb 19 & 21, 2019
 */
//parent class
class Course{
    //data members
    private double[][] grades;
    
    //constructor
    public Course(double[][] g){
        grades = new double[g.length][g[0].length];
        
        for (int i = 0; i < g.length; i++) 
            for (int j = 0; j <g[i].length; j++) 
                grades[i][j] = g[i][j];
    }
    
    //default no-arg constructor
    public Course(){
        
    }
    
    //singleton get and set methods for data members
    public double[][] getGrades(){
        return grades;
    }
    
    public void setGrades(double[][] g){
        grades = new double[g.length][g[0].length];
        
        for (int i = 0; i < g.length; i++) 
            for (int j = 0; j <g[i].length; j++) 
                grades[i][j] = g[i][j];
    }
    
    //print the grades
    public void printGrades(){
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Student "+(i+1)+" scores: ");
            for (int j = 0; j < grades[i].length; j++) {
                System.out.printf("%7.2f", grades[i][j]);
            }
            System.out.println();
        }
    }
    
    // method to calculate each row's (aka student's) avg
    // return a single dimensional array with avg
    // department poloicy for course avgerages
    // average is a weighted avg: hw 60%, midterm 20%, final 20%
    // midterm is stored at grades[r][grades[r].length-2]
    // final exam is stored at grades[r][grades[r].length-1]
    public double[] getAvg(){
        double[] avg = new double[grades.length]; // # of rows
        double sum;
        for (int i = 0; i < grades.length; i++) {
            //calculate hw average
            sum = 0;
            double hmwavg = 0;
            for (int j = 0; j < grades[i].length-2; j++) { //don't include mid or final
                sum += grades[i][j];
            }
            hmwavg = sum/(grades[i].length-1);
            
            //midterm and final exam grades
            double midterm = grades[i][grades[i].length-2];
            double fexam = grades[i][grades[i].length-1];
            
            //calculate weighted average for this student
            avg[i] = (hmwavg*0.6)+(midterm*0.2)+(fexam*0.2);
        }
        return avg;
    }
    
    //override our toString() method
    @Override
    public String toString(){
        return "Your class had "+grades.length+" students and "+(grades[0].length-2)+" homework grades.";
    }
}

//CSC191 is a child class of parent class course - denoted by keyword extends
//we will define unique things to the child in this class
class CSC191 extends Course{
    private double labGrades[][]; //must be the same number of rows as grades
   
    //constructor
    public CSC191(double[][] g, double[][] lg){
        super(g); //call super constructor to set grade values
        labGrades = new double[lg.length][lg[0].length];
        for (int i = 0; i < lg.length; i++) {
            for (int j = 0; j < lg[0].length; j++) {
                labGrades[i][j] = lg[i][j];
            }
        }
        
    }
    
    //need get and set methods for labGrades - do later on your own
    
    //put in new and/or overridden methods
    //hw 40%, lab 20%, midterm 20%, fexam 20%
    @Override //replacing the definition of getAverage() in course
    public double[] getAvg(){
        double[][] csc191Grades = getGrades();
        double[] avg = new double[csc191Grades.length];
        double sum;
        
        for (int i = 0; i < csc191Grades.length; i++) {
            //calculate hw average
            sum = 0;
            double hmwavg = 0;
            for (int j = 0; j < csc191Grades[i].length-2; j++) {
                sum += csc191Grades[i][j];
            }
            hmwavg = sum/(csc191Grades[i].length-2);
            
            //average lab grades
            sum = 0;
            double labavg = 0;
            for (int j = 0; j < labGrades[i].length; j++) {
                sum += labGrades[i][j];
            }
            labavg = sum/labGrades[i].length;
            
            //pull out midterm and final exam grades
            double midterm = csc191Grades[i][csc191Grades[i].length-2];
            double fexam = csc191Grades[i][csc191Grades[i].length-1];
            
            //calculate weighted average
            avg[i] = hmwavg*0.4 + midterm*0.2 + fexam*0.2 + labavg*0.2;
        }
        return avg;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Your class also has "+labGrades[0].length+" lab grades.";
    }
}

public class A0219b {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //ask the user how many students and homework grades
        System.out.print("How many students in your class? ");
        int student = input.nextInt();
        System.out.print("How many homework grades? ");
        int hw = input.nextInt();
        
        //input validation
        while(student < 1){
            System.out.println("Invalid entry. Enter an interger of 1 or higher.");
            System.out.print("How many students in your class? ");
            student = input.nextInt();
        }
        while(hw < 1){
            System.out.println("Invalid entry. Enter an interger of 1 or higher.");
            System.out.print("How many homework grades? ");
            hw = input.nextInt();
        }
        //get input of scores from the user
        double[][] scores = new double[student][hw+2]; //includes mid & fe
        for (int r = 0; r < scores.length; r++) {
            //collect hw grades
            for (int c = 0; c < scores[r].length-2; c++) {
                System.out.print("Enter homework "+(c+1)+" for student "+(r+1)+": ");
                scores[r][c] = input.nextDouble();
                while(scores[r][c] < 0 || scores[r][c] > 110){
                    System.out.println("Invalid entry. Must be between 0 and 110.");
                    System.out.print("Enter homework "+(c+1)+" for student "+(r+1)+": ");
                    scores[r][c] = input.nextDouble();
                }
            }
            //collect midterm and fexam grades
            //midterm grade
            System.out.print("Enter student "+(r+1)+" midterm grade: ");
            scores[r][scores[r].length-2] = input.nextDouble();
            while(scores[r][scores[r].length-2] < 0 || scores[r][scores[r].length-2] > 110){
                System.out.println("Invalid entry. Must be between 0 and 110.");
                System.out.print("Enter student "+(r+1)+" midterm grade: ");
                scores[r][scores[r].length-2] = input.nextDouble();
            }
            //final exam grade
            System.out.print("Enter student "+(r+1)+" final exam grade: ");
            scores[r][scores[r].length-1] = input.nextDouble();
            while(scores[r][scores[r].length-1] < 0 || scores[r][scores[r].length-1] > 110){
                System.out.println("Invalid entry. Must be between 0 and 110.");
                System.out.print("Enter student "+(r+1)+" final exam grade: ");
                scores[r][scores[r].length-1] = input.nextDouble();
            }
        }
        //use the scores to demonstrate the Course class
        Course csc160 = new Course(scores);
        csc160.printGrades();
        
        //print averages
        double[] avgs = csc160.getAvg();
        DecimalFormat df = new DecimalFormat("###.##");
        for (int i = 0; i < avgs.length; i++) {
            System.out.println("The average for student "+(i+1)+" is "+df.format(avgs[i])+".");
        }
        
        //invoke toString from course
        System.out.println(csc160);
        
        //get input of lab scores
        System.out.print("How many lab grades? ");
        int lab = input.nextInt();
        while(lab<1){
            System.out.println("You must have at least 1 lab grade.");
            System.out.print("How many lab grades? ");
            lab = input.nextInt();
        }
        
        //collect lab grades
        double[][] labs = new double[student][lab];
        for (int r = 0; r < labs.length; r++) {
            //collect hw grades
            for (int c = 0; c < labs[r].length; c++) {
                System.out.print("Enter lab "+(c+1)+" for student "+(r+1)+": ");
                labs[r][c] = input.nextDouble();
                while(labs[r][c] < 0 || labs[r][c] > 110){
                    System.out.println("Invalid entry. Must be between 0 and 110.");
                    System.out.print("Enter homework "+(c+1)+" for student "+(r+1)+": ");
                    labs[r][c] = input.nextDouble();
                }
            }
        }
        //get averages for a CSC191 object
        CSC191 spring19 = new CSC191(scores, labs);
        System.out.println("CSC 191 Scores");
        spring19.printGrades();
        //print averages
        double[] avgs191 = spring19.getAvg();
        for (int i = 0; i < avgs191.length; i++) {
            System.out.println("The average for student in CSC 191 "+(i+1)+" is "+df.format(avgs191[i])+".");
        }
        
        //invoke csc191 toString
        System.out.println(spring19);
    } 
}
