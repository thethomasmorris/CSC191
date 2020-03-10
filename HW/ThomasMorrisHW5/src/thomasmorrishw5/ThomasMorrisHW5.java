package thomasmorrishw5;
/*
HW 5
Thomas Morris
April 25, 2019
Create a simple calculator with GUI 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;

public class ThomasMorrisHW5 extends JFrame{
    private JButton one, two, three, four, five, six, seven, eight, nine, zero, zerozero, plus, minus, multiply, divide, decimal, equal, clear, clearAll, off;
    private JPanel inputDisplay, numDisplay, opDisplay, clearDisplay;
    private JTextField inputText;
    private String number1 = "0", number2 = "0";
    private String op = "";
    
    public ThomasMorrisHW5(){
        createUserInterface();
    }
    
    private void createUserInterface(){
        //create the contentPane
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(null);
        
        //set up input panel
        inputDisplay = new JPanel();
        inputDisplay.setLayout(null);
        inputDisplay.setBorder(new BevelBorder(BevelBorder.LOWERED)); //anonymous 
        inputDisplay.setBounds(10,10,500,30); //(x, y, width, height)
        inputDisplay.setBackground(Color.WHITE);
        contentPane.add(inputDisplay);
        
        //set up input text field
        inputText = new JTextField();
        inputText.setBounds(0,0,500,30);
        inputText.setText("0");
        inputText.setEditable(false); //determines if they can edit it or not - default is true
        inputText.setHorizontalAlignment(JLabel.RIGHT); //all caps mean constant
        inputText.setBackground(Color.WHITE);
        inputDisplay.add(inputText);
        
        //set up num panel
        numDisplay = new JPanel();
        numDisplay.setLayout(null);
        numDisplay.setBorder(new BevelBorder(BevelBorder.LOWERED)); //anonymous 
        numDisplay.setBounds(10,50,156,200); //(x, y, width, height)
        numDisplay.setBackground(Color.LIGHT_GRAY);
        contentPane.add(numDisplay);
        
        //set up buttons for num panel
        one = new JButton();
        one.setBounds(16,22,42,42);
        one.setText("1");
        one.setBackground(Color.WHITE);
        numDisplay.add(one);
        
        one.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      oneButton(event);
                  }
              }
        );
        
        two = new JButton();
        two.setBounds(58,22,42,42);
        two.setText("2");
        two.setBackground(Color.WHITE);
        numDisplay.add(two);
        
        two.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      twoButton(event);
                  }
              }
        );
        
        three = new JButton();
        three.setBounds(100,22,42,42);
        three.setText("3");
        three.setBackground(Color.WHITE);
        numDisplay.add(three);
        
        three.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      threeButton(event);
                  }
              }
        );
        
        four = new JButton();
        four.setBounds(16,64,42,42);
        four.setText("4");
        four.setBackground(Color.WHITE);
        numDisplay.add(four);
        
        four.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      fourButton(event);
                  }
              }
        );
        
        five = new JButton();
        five.setBounds(58,64,42,42);
        five.setText("5");
        five.setBackground(Color.WHITE);
        numDisplay.add(five);
        
        five.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      fiveButton(event);
                  }
              }
        );
        
        six = new JButton();
        six.setBounds(100,64,42,42);
        six.setText("6");
        six.setBackground(Color.WHITE);
        numDisplay.add(six);
        
        six.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      sixButton(event);
                  }
              }
        );
        
        seven = new JButton();
        seven.setBounds(16,106,42,42);
        seven.setText("7");
        seven.setBackground(Color.WHITE);
        numDisplay.add(seven);
        
        seven.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      sevenButton(event);
                  }
              }
        );
        
        eight = new JButton();
        eight.setBounds(58,106,42,42);
        eight.setText("8");
        eight.setBackground(Color.WHITE);
        numDisplay.add(eight);
        
        eight.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      eightButton(event);
                  }
              }
        );
        
        nine = new JButton();
        nine.setBounds(100,106,42,42);
        nine.setText("9");
        nine.setBackground(Color.WHITE);
        numDisplay.add(nine);
        
        nine.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      nineButton(event);
                  }
              }
        );
        
        zero = new JButton();
        zero.setBounds(16,148,42,42);
        zero.setText("0");
        zero.setBackground(Color.WHITE);
        numDisplay.add(zero);
        
        zero.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      zeroButton(event);
                  }
              }
        );
        
        zerozero = new JButton();
        zerozero.setBounds(58,148,84,42);
        zerozero.setText("00");
        zerozero.setBackground(Color.WHITE);
        numDisplay.add(zerozero);
        
        zerozero.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      zerozeroButton(event);
                  }
              }
        );
        
        //set up operation panel
        opDisplay = new JPanel();
        opDisplay.setLayout(null);
        opDisplay.setBorder(new BevelBorder(BevelBorder.LOWERED)); //anonymous 
        opDisplay.setBounds(186,50,156,200); //(x, y, width, height)
        opDisplay.setBackground(Color.LIGHT_GRAY);
        contentPane.add(opDisplay);
        
        //set up operation buttons
        plus = new JButton();
        plus.setBounds(16,22,50,110);
        plus.setFont(new Font("SansSerif", Font.PLAIN, 18));
        plus.setText("+");
        plus.setBackground(Color.WHITE);
        opDisplay.add(plus);
        
        plus.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      plusButton(event);
                  }
              }
        );
        
        decimal = new JButton();
        decimal.setBounds(16,148,50,42);
        decimal.setFont(new Font("SansSerif", Font.PLAIN, 18));
        decimal.setText(".");
        decimal.setBackground(Color.WHITE);
        opDisplay.add(decimal);
        
        decimal.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      decimalButton(event);
                  }
              }
        );
        
        minus = new JButton();
        minus.setBounds(100,22,42,42);
        minus.setFont(new Font("SansSerif", Font.PLAIN, 18));
        minus.setText("-");
        minus.setBackground(Color.WHITE);
        opDisplay.add(minus);
        
        minus.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      minusButton(event);
                  }
              }
        );
        
        multiply = new JButton();
        multiply.setBounds(100,64,42,42);
        multiply.setFont(new Font("SansSerif", Font.PLAIN, 18));
        multiply.setText("*");
        multiply.setBackground(Color.WHITE);
        opDisplay.add(multiply);
        
        multiply.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      multiplyButton(event);
                  }
              }
        );
        
        divide = new JButton();
        divide.setBounds(100,106,42,42);
        divide.setFont(new Font("SansSerif", Font.PLAIN, 18));
        divide.setText("/");
        divide.setBackground(Color.WHITE);
        opDisplay.add(divide);
        
        divide.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      divideButton(event);
                  }
              }
        );
        
        equal = new JButton();
        equal.setBounds(100,148,42,42);
        equal.setFont(new Font("SansSerif", Font.PLAIN, 14));
        equal.setText("=");
        equal.setBackground(Color.WHITE);
        opDisplay.add(equal);
        
        equal.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      equalButton(event);
                  }
              }
        );
        
        //set up clear display
        clearDisplay = new JPanel();
        clearDisplay.setLayout(null);
        clearDisplay.setBorder(new BevelBorder(BevelBorder.LOWERED)); //anonymous 
        clearDisplay.setBounds(370,50,136,150); //(x, y, width, height)
        clearDisplay.setBackground(Color.LIGHT_GRAY);
        contentPane.add(clearDisplay);
        
        //clear button
        clear = new JButton();
        clear.setBounds(10,10,116,60);
        clear.setText("C");
        clear.setBackground(Color.WHITE);
        clearDisplay.add(clear);
        
        clear.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      clearButton(event);
                  }
              }
        );
        
        //clearAll button
        clearAll = new JButton();
        clearAll.setBounds(10,85,116,60);
        clearAll.setText("C/A");
        clearAll.setBackground(Color.WHITE);
        clearDisplay.add(clearAll);
        
        clearAll.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      clearAllButton(event);
                  }
              }
        );
        
        //off button
        off = new JButton();
        off.setBounds(380,210,116,45);
        off.setText("OFF");
        off.setBackground(Color.WHITE);
        contentPane.add(off);
        
        off.addActionListener( //object is passed to this
              new ActionListener(){ //anonymous inner class 
                  //event handler called when submit grades button is clicked
                  public void actionPerformed(ActionEvent event){
                      offButton(event);
                  }
              }
        );
        
        setTitle("Calculator"); //set title bar text of window
        setSize(535,300); //set window size (width, height)
        setVisible(true);
    }
    
    private void oneButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "1";
            else
                number1 += "1";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "1";
            else
                number2 += "1";
            inputText.setText(number2);
        }       
    }
    
    private void twoButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "2";
            else
                number1 += "2";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "2";
            else
                number2 += "2";
            inputText.setText(number2);
        }    
    }
    private void threeButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "3";
            else
                number1 += "3";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "3";
            else
                number2 += "3";
            inputText.setText(number2);
        }    
    }
    
    private void fourButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "4";
            else
                number1 += "4";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "4";
            else
                number2 += "4";
            inputText.setText(number2);
        }    
    }

        private void fiveButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "5";
            else
                number1 += "5";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "5";
            else
                number2 += "5";
            inputText.setText(number2);
        }    
    }
        
    private void sixButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "6";
            else
                number1 += "6";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "6";
            else
                number2 += "6";
            inputText.setText(number2);
        }    
    }  
    
    private void sevenButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "7";
            else
                number1 += "7";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "7";
            else
                number2 += "7";
            inputText.setText(number2);
        }    
    }
    
    private void eightButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "8";
            else
                number1 += "8";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "8";
            else
                number2 += "8";
            inputText.setText(number2);
        }    
    }
        
    private void nineButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "9";
            else
                number1 += "9";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "9";
            else
                number2 += "9";
            inputText.setText(number2);
        }    
    }
            
    private void zeroButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "0";
            else
                number1 += "0";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "0";
            else
                number2 += "0";
            inputText.setText(number2);
        }    
    }
    
    private void zerozeroButton(ActionEvent event){
        if("".equals(op)){
            if(number1.equals("0"))
                number1 = "0";
            else
                number1 += "00";
            inputText.setText(number1);
        }
        else{
            if(number2.equals("0"))
                number2 = "0";
            else
                number2 += "00";
            inputText.setText(number2);
        }    
    }
    
    private void decimalButton(ActionEvent event){
        boolean num1HasDecimal = false;
        boolean num2HasDecimal = false;
        
        for (int i = 0; i < number1.length(); i++) {
            if(number1.charAt(i) == '.')
                num1HasDecimal = true;
        }
        
        for (int i = 0; i < number2.length(); i++) {
            if(number2.charAt(i) == '.')
                num2HasDecimal = true;
        }
        if("".equals(op) && !num1HasDecimal){
            if(number1.equals("0"))
                number1 = "0.";
            else
                number1 += ".";
            inputText.setText(number1);
        }
        else if(!num2HasDecimal){
            if(number2.equals("0"))
                number2 = "0.";
            else
                number2 += ".";
            inputText.setText(number2);
        }    
    }
 
    private void plusButton(ActionEvent event){
        equalButton(event);
        op = "+";
        inputText.setText(number1);
    }
    
    private void minusButton(ActionEvent event){
        equalButton(event);
        op = "-";
        inputText.setText(number1);
    }
    
    private void multiplyButton(ActionEvent event){
        equalButton(event);
        op = "*";
        inputText.setText(number1);
    }
    
    private void divideButton(ActionEvent event){
        equalButton(event);
        op = "/";
        inputText.setText(number1);
    }
    
    private void equalButton(ActionEvent event){
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        switch(op){
            case "+":
                number1 = Double.toString(num1+num2);
                inputText.setText(number1);
                number2 = "0";
                op = "";
                break;
            case "-":
                number1 = Double.toString(num1-num2);
                inputText.setText(number1);
                number2 = "0";
                op = "";
                break;
            case "*":
                number1 = Double.toString(num1*num2);
                inputText.setText(number1);
                number2 = "0";
                op = "";
                break;
            case "/":
                number1 = Double.toString(num1/num2);
                inputText.setText(number1);
                number2 = "0";
                op = "";
                break;
            case "":
                break;
            default:
                System.out.println("OP ERROR");      
        } 
    }
    
    private void clearButton(ActionEvent event){
        if("".equals(op)){
            number1 = "0";
            inputText.setText(number1);
        }
        else{
            number2 = "0";
            inputText.setText(number2);
        } 
    }
    
    private void clearAllButton(ActionEvent event){
        number1 = "0";
        number2 = "0";
        inputText.setText(number1);

    }
    
    private void offButton(ActionEvent event){
        System.exit(0);
    }
    
    public static void main(String[] args) {
        ThomasMorrisHW5 calc = new ThomasMorrisHW5();
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 
}