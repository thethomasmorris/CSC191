package thomasmorrislab2;

public class Employee {
    private String name;
    private int id;
    private double pay;
    private double timesheet[] = new double[7];
    private String email;
    
    //contstructor to set up our values
    public Employee(String n, int i, double p, double t[], String e){
        name = n;
        id = i;
        pay = p;
        timesheet = t;
        email = e;
    }
    
    //default constructor
    public Employee(){
        
    }
    
    //singleton pattern for each variable
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int i){
        id = i;
    }
    
    public double getPay(){
        return pay;
    }
    
    public void setPay(double p){
        pay = p;
    }
    
    public double[] getTimesheet(){
        return timesheet;
    }
    
    public void setTimesheet(double[] t){
        timesheet = t;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String e){
        email = e;
    }
    
    public double calculatePay(){
        double totalHours = 0;
        double totalPay = 0;
        for (int i = 0; i < timesheet.length; i++) //add all the hours into totalHours
            totalHours += timesheet[i];
        if(totalHours <= 40) //determine if they get overtime pay
            totalPay = totalHours*pay;
        else{
            totalPay = 40*pay; //calculate non overtime pay
            totalHours -= 40; //remove already calculated hours
            totalPay += totalHours*(pay*1.5); //give them their overtime rate for hours worked over 40
        }
        return totalPay;
    }
    
    //override default toString 
    @Override
    public String toString(){
        return "name: "+name+" id: "+id+" pay: "+pay+" email: "+email;
    }
}
