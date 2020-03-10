package thomasmorrislab12;
/*
Thomas Morris
Lab 12
April 24th, 2019
This program will create a GUI application that will keep a movie inventory for the user
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.TitledBorder;

class Movie{
    String name;
    String media;
    int year;
    
    public Movie(String n, String m, int y){
        name = n;
        media = m;
        year = y;
    }
}
public class ThomasMorrisLab12 extends JFrame{
    
    private JPanel inputMovieJPanel;
    private JLabel yearJLabel;
    private JTextField yearJTextField;
    private JLabel mediaJLabel;
    private JTextField mediaJTextField;
    private JLabel titleJLabel;
    private JTextField titleJTextField;
    private JButton addMoviesJButton;
    private JButton showMoviesJButton;
    private JLabel displayJLabel;
    private JTextArea displayJTextArea;
    LinkedList<Movie> list = new LinkedList<Movie>();
    
    public ThomasMorrisLab12(){
        createUserInterface();
    }
    
    private void createUserInterface(){
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        inputMovieJPanel = new JPanel();
        inputMovieJPanel.setBounds(16, 16, 208, 218);
        inputMovieJPanel.setBorder(new TitledBorder("Input Movie"));
        inputMovieJPanel.setLayout(null);
        contentPane.add(inputMovieJPanel);
        
        titleJLabel = new JLabel();
        titleJLabel.setBounds(8, 32, 90, 23);
        titleJLabel.setText("Movie Name: ");
        inputMovieJPanel.add(titleJLabel);
        
        titleJTextField = new JTextField();
        titleJTextField.setBounds(120, 32, 80, 21);
        titleJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputMovieJPanel.add(titleJTextField);
        
        mediaJLabel = new JLabel();
        mediaJLabel.setBounds(8, 64, 90, 23);
        mediaJLabel.setText("Media : ");
        inputMovieJPanel.add(mediaJLabel);
        
        mediaJTextField = new JTextField();
        mediaJTextField.setBounds(120, 64, 80, 21);
        mediaJTextField.setHorizontalAlignment(JTextField.RIGHT );
        inputMovieJPanel.add(mediaJTextField);
        
        yearJLabel = new JLabel();
        yearJLabel.setBounds(8, 98, 90, 23);
        yearJLabel.setText("Release Year: ");
        inputMovieJPanel.add(yearJLabel);

        yearJTextField = new JTextField();
        yearJTextField.setBounds(120, 98, 80, 21);
        yearJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputMovieJPanel.add(yearJTextField);
        
        addMoviesJButton = new JButton();
        addMoviesJButton.setBounds(72, 182, 120, 24);
        addMoviesJButton.setText("Add Movie");
        inputMovieJPanel.add(addMoviesJButton);
        
        addMoviesJButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    addMovieJButtonActionPerformed(event);
                }
            }
        );
        
        displayJLabel = new JLabel();
        displayJLabel.setBounds(240, 16, 150, 23);
        displayJLabel.setText( "Movies: " );
        contentPane.add(displayJLabel);

        displayJTextArea = new JTextArea();
        displayJTextArea.setBounds(240, 48, 402, 184);
        displayJTextArea.setEditable(false);
        contentPane.add(displayJTextArea);

        showMoviesJButton = new JButton();
        showMoviesJButton.setBounds(486, 244, 156, 23);
        showMoviesJButton.setText("Show Movies");
        contentPane.add(showMoviesJButton);
        
        showMoviesJButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    showMoviesJButtonActionPerformed(event);
                }
            }
        );
        
        setTitle("Movie Database");
        setSize(670, 308);          
        setVisible(true); 
    }
    
    private void addMovieJButtonActionPerformed(ActionEvent event){
        String name = titleJTextField.getText();
        String media = mediaJTextField.getText();
        int year = Integer.parseInt(yearJTextField.getText());
        
        Movie m = new Movie(name,media,year);
        list.add(m); 
        titleJTextField.setText("");
        mediaJTextField.setText("");
        yearJTextField.setText("");
    }
    
    private void showMoviesJButtonActionPerformed(ActionEvent event){
        displayJTextArea.setText("Year\tMedia\tTitle\n");
        for(Movie m:list)
            displayJTextArea.append(m.year+"\t"+m.media+"\t"+m.name+"\n");
    }
    
    public static void main(String[] args) {
        ThomasMorrisLab12 application = new ThomasMorrisLab12();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}
