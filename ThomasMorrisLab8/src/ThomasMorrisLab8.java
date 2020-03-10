/*
Thomas Morris
Lab 8 
Construct a timetable to determine a tournament schedule
 */
import java.util.Scanner;
class Schedule{
    int size;
    Schedule(int size){
        this.size = size;
    }
    int[][] T = new int[size][size];
    void buildSchedule(int n){
        if (n == 1)
            T[0][0] = 1;
        else{
            buildSchedule(n/2);
            for (int i = 0; i < (n/2); i++ ) {
                for (int j = 0; j < (n/2); j++) {
                    T[i][j+(n/2)] = T[i][j]+(n/2);
                    T[i+(n/2)][j] = T[i][j]+(n/2);
                    T[i+(n/2)][j+(n/2)] = T[i][j];
                }
            }
        }
    }
    void printSchedule(){
        System.out.println("Player");
        System.out.print("Day");
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                System.out.print(T[i][j]+" ");
            }
            System.out.println();
        }
    }
}
public class ThomasMorrisLab8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Print Tournament Schedule");
            System.out.println("2. Exit");
            System.out.print("Enter a choice from the menu above: ");
            choice = in.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter the tournament size: (2's power only) ");
                    int n = in.nextInt();
                    Schedule t = new Schedule(n);
                    t.buildSchedule(n);
                    t.printSchedule();
                    break;
                case 2:
                    System.out.println("Thank you for using my program!");
                    System.out.println("Created By: Thomas Morris");
                    break;
            }
        }while(choice != 2);
    } 
}
