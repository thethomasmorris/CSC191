package thomasmorrislab11;
/*
Lab 11
Thomas Morris
August 17, 2019
Create a simple calculator GUI 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.text.*;
public class ThomasMorrisLab11 extends JFrame{
    private JButton one, two, three, four, five, six, seven, eight, nine, zero, zerozero, plus, minus, multiply, divide, decimal, equal, clear, clearAll, off;
    private JPanel inputDisplay, numDisplay, opDisplay, clearDisplay;
    private JTextField inputText;

    public ThomasMorrisLab11(){
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
        
        two = new JButton();
        two.setBounds(58,22,42,42);
        two.setText("2");
        two.setBackground(Color.WHITE);
        numDisplay.add(two);
        
        three = new JButton();
        three.setBounds(100,22,42,42);
        three.setText("3");
        three.setBackground(Color.WHITE);
        numDisplay.add(three);
        
        four = new JButton();
        four.setBounds(16,64,42,42);
        four.setText("4");
        four.setBackground(Color.WHITE);
        numDisplay.add(four);
        
        five = new JButton();
        five.setBounds(58,64,42,42);
        five.setText("5");
        five.setBackground(Color.WHITE);
        numDisplay.add(five);
        
        six = new JButton();
        six.setBounds(100,64,42,42);
        six.setText("6");
        six.setBackground(Color.WHITE);
        numDisplay.add(six);
        
        seven = new JButton();
        seven.setBounds(16,106,42,42);
        seven.setText("7");
        seven.setBackground(Color.WHITE);
        numDisplay.add(seven);
        
        eight = new JButton();
        eight.setBounds(58,106,42,42);
        eight.setText("8");
        eight.setBackground(Color.WHITE);
        numDisplay.add(eight);
        
        nine = new JButton();
        nine.setBounds(100,106,42,42);
        nine.setText("9");
        nine.setBackground(Color.WHITE);
        numDisplay.add(nine);
        
        zero = new JButton();
        zero.setBounds(16,148,42,42);
        zero.setText("0");
        zero.setBackground(Color.WHITE);
        numDisplay.add(zero);
        
        zerozero = new JButton();
        zerozero.setBounds(58,148,84,42);
        zerozero.setText("00");
        zerozero.setBackground(Color.WHITE);
        numDisplay.add(zerozero);
        
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
        
        decimal = new JButton();
        decimal.setBounds(16,148,50,42);
        decimal.setFont(new Font("SansSerif", Font.PLAIN, 18));
        decimal.setText(".");
        decimal.setBackground(Color.WHITE);
        opDisplay.add(decimal);
        
        minus = new JButton();
        minus.setBounds(100,22,42,42);
        minus.setFont(new Font("SansSerif", Font.PLAIN, 18));
        minus.setText("-");
        minus.setBackground(Color.WHITE);
        opDisplay.add(minus);
        
        multiply = new JButton();
        multiply.setBounds(100,64,42,42);
        multiply.setFont(new Font("SansSerif", Font.PLAIN, 18));
        multiply.setText("*");
        multiply.setBackground(Color.WHITE);
        opDisplay.add(multiply);
        
        divide = new JButton();
        divide.setBounds(100,106,42,42);
        divide.setFont(new Font("SansSerif", Font.PLAIN, 18));
        divide.setText("/");
        divide.setBackground(Color.WHITE);
        opDisplay.add(divide);
        
        equal = new JButton();
        equal.setBounds(100,148,42,42);
        equal.setFont(new Font("SansSerif", Font.PLAIN, 14));
        equal.setText("=");
        equal.setBackground(Color.WHITE);
        opDisplay.add(equal);
        
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
        
        //clearAll button
        clearAll = new JButton();
        clearAll.setBounds(10,85,116,60);
        clearAll.setText("C/A");
        clearAll.setBackground(Color.WHITE);
        clearDisplay.add(clearAll);
        
        //off button
        off = new JButton();
        off.setBounds(380,210,116,45);
        off.setText("OFF");
        off.setBackground(Color.WHITE);
        contentPane.add(off);
        
        setTitle("Calculator"); //set title bar text of window
        setSize(535,300); //set window size (width, height)
        setVisible(true);
    }
    
    private void plusButton(ActionEvent event){
        
    }
    public static void main(String[] args) {
        ThomasMorrisLab11 calc = new ThomasMorrisLab11();
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 
}
