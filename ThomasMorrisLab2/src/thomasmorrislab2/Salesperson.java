package thomasmorrislab2;

public class Salesperson extends Employee{
    private double commission;
    
    public Salesperson(String n, int i, double p, double t[], String e, double c){
        super(n, i, p, t, e); //set the info in the class that superceeds this one
        commission = c; //assign a value to commission since this instance is unique to this class
    }
    
    //default constructor
    public Salesperson(){
        
    }
    
    //singleton pattern for new variable
    public double getCommission(){
        return commission;
    }
    
    public void setCommission(double c){
        commission = c;
    }
    
    public double calculatePay(double wSales){
        return super.calculatePay() + (wSales*(commission/100)); //call calculate pay and add commission bonus to it
    }
    
    //override default toString and include commission
    @Override
    public String toString(){
        return "name: "+getName()+" id: "+getId()+" pay: "+getPay()+" email: "+getEmail()+" commission: "+commission;
    }
}
