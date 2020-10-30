import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main implements Runnable, ActionListener{


  //generate the initial random number
  Random rand = new Random();
  int randomNumber = rand.nextInt(100) + 1;

  // Class Variables  
  JPanel mainPanel;

  JLabel descriptionLabel;
  JLabel outputLabel;

  JTextField guessField;

  JButton submitButton;
  JButton newNumberButton;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Guessing Game");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    

    //initialize the class Variables
    mainPanel = new JPanel();
    mainPanel.setLayout(null);

    descriptionLabel = new JLabel("Guess the Number between 0 and 100:");
    outputLabel = new JLabel();

    guessField = new JTextField();

    submitButton = new JButton("Submit");
    newNumberButton = new JButton("New Number");

    //set size & location
    descriptionLabel.setBounds(10,10,300,20);
    outputLabel.setBounds(10,100,300,20);

    guessField.setBounds(10,40,300,20);

    submitButton.setBounds(10,70,120,20);
    newNumberButton.setBounds(140,70,170,20);

    //add action listeners
    submitButton.addActionListener(this);
    newNumberButton.addActionListener(this);

    //add action commands
    submitButton.setActionCommand("submit");
    newNumberButton.setActionCommand("newNumber");

    //add to main mainPanel
    mainPanel.add(descriptionLabel);
    mainPanel.add(outputLabel);
    mainPanel.add(guessField);
    mainPanel.add(submitButton);
    mainPanel.add(newNumberButton);

    //add mainPanel to frame
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("submit")){ //if the submit button was pressed
      //store the entered guess in a Variable
      int guess = Integer.parseInt(guessField.getText());

      if(guess == randomNumber){ //check if number is correct
        outputLabel.setText("You are correct! Good job!");
      }else if(guess < randomNumber){ //if the guess is less than the random number
        outputLabel.setText("Your guess of " + guess + " is too low!"); //tell the user it's too low
      }else{ //if the guess is more than the random number
        outputLabel.setText("Your guess of " + guess + " is too high!"); //tell the user it's too high
      }
    }else{
      //choose a new random number
      randomNumber = rand.nextInt(100) + 1;
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();

    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
