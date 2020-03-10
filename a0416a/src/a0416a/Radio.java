package a0416a;
/*
Introduction to GUI
We will use the Swing class
Create a GUI representing a radio
April 16, 2019
Thomas Morris
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Radio extends JFrame {
    
    private JButton oneJButton, twoJButton, threeJButton, fourJButton, fiveJButton, sixJButton, powerJButton;
    private JPanel tuningJPanel, presetJPanel, volumeControlJPanel;
    private JRadioButton amJRadioButton, fmJRadioButton;
    private JTextField stationJTextField;
    private JCheckBox muteJCheckBox;
    private JSlider volumeJSlider;
    
    //no-argument constructor
    public Radio(){
        createUserInterface();
    }
    
    //create and position GUI components
    private void createUserInterface(){
        //create contentPane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.CYAN);
        contentPane.setLayout(null); //pass through null so we can create our own layout
        
        //setup the presetJPanel
        presetJPanel = new JPanel();
        presetJPanel.setLayout(null);
        presetJPanel.setBorder(new TitledBorder("Pre-set Stations")); //anonymous 
        presetJPanel.setBounds(10,10,355,75); //(x, y, width, height)
        presetJPanel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(presetJPanel);
        
        //setup oneJButton
        oneJButton = new JButton();
        oneJButton.setBounds(16,22,42,42);
        oneJButton.setText("1");
        oneJButton.setBackground(Color.CYAN);
        presetJPanel.add(oneJButton);
        
        //setup twoJButton
        twoJButton = new JButton();
        twoJButton.setBounds(72,22,42,42);
        twoJButton.setText("2");
        twoJButton.setBackground(Color.CYAN);
        presetJPanel.add(twoJButton);
        
        //setup threeJButton
        threeJButton = new JButton();
        threeJButton.setBounds(128,22,42,42);
        threeJButton.setText("3");
        threeJButton.setBackground(Color.CYAN);
        presetJPanel.add(threeJButton);
        
        //setup the volumeControlJPanel
        volumeControlJPanel = new JPanel();
        volumeControlJPanel.setLayout(null);
        volumeControlJPanel.setBorder(new TitledBorder("Volume Control")); //anonymous 
        volumeControlJPanel.setBounds(10,95,250,90); //(x, y, width, height)
        volumeControlJPanel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(volumeControlJPanel);
        
        //setup mutJCheckBox
        muteJCheckBox = new JCheckBox();
        muteJCheckBox.setBounds(16,24,60,42);
        muteJCheckBox.setText("Mute");
        muteJCheckBox.setBackground(Color.LIGHT_GRAY);
        volumeControlJPanel.add(muteJCheckBox);
        
        //setup volumeJSlider
        volumeJSlider = new JSlider();
        volumeJSlider.setBounds(86,24,150,50);
        volumeJSlider.setPaintTicks(true); //turns on tick marks
        volumeJSlider.setMajorTickSpacing(10); //how spaced out are the tick marks (15 total ticks)
        volumeJSlider.setBackground(Color.LIGHT_GRAY);
        volumeControlJPanel.add(volumeJSlider);
        
        //setup the volumeControlJPanel
        tuningJPanel = new JPanel();
        tuningJPanel.setLayout(null);
        tuningJPanel.setBorder(new TitledBorder("Tuning")); //anonymous 
        tuningJPanel.setBounds(270,95,166,90); //(x, y, width, height)
        tuningJPanel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(tuningJPanel);
        
        //setup stationJTextField
        stationJTextField = new JTextField();
        stationJTextField.setBounds(16,20,50,55);
        stationJTextField.setText("88.9");
        stationJTextField.setEditable(false); //determines if they can edit it or not - default is true
        stationJTextField.setHorizontalAlignment(JLabel.CENTER); //all caps mean constant
        stationJTextField.setBackground(Color.CYAN);
        tuningJPanel.add(stationJTextField);
        
        //set properties of application's window
        setTitle("Radio"); //set title bar text of window
        setSize(575,240); //set window size (width, height)
        setVisible(true); //dispaly window
        
    } //close of createUserInterface method
    
    public static void main(String[] args) {
        Radio app = new Radio();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 
}
