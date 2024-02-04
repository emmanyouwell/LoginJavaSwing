import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LOGIN {
	private JFrame frame;
	private JLabel lbl1;
	private JLabel lbl2;
	private JTextField email;
	private JPasswordField pass;
	private JButton btn1;
	LOGIN(JFrame f){
		frame = new JFrame();

		lbl1 = new JLabel("Email:");
		lbl1.setBounds(10,10,100,25);
		
		email = new JTextField();
		email.setBounds(50,10,175,25);
		
		lbl2 = new JLabel("Password:");
		lbl2.setBounds(10, 40, 100, 25);
		
		pass = new JPasswordField();
		pass.setBounds(75,40,150,25);
		
		btn1 = new JButton("Login");
		btn1.setBounds(10,75,100,25);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				String eml = email.getText();
				String pw = new String(pass.getPassword());
				String record = "";
				try {
					  //Create Arraylist to hold the credentials
					  List<String> credentials = new ArrayList<>();
					  
					  //Opens the file
					  File myFile = new File("C:\\Users\\Emmanuel\\LTC Java Swing\\Login\\src\\database.txt");
				      
				      //Creates a scanner object to scan the file
					  Scanner myReader = new Scanner(myFile);

				      //Loops through the file and reads the words per line
					  while(myReader.hasNextLine()) {
						  String data = myReader.nextLine();
						  credentials.add(data);
					  }
				      
				      //Checks if the entered credentials matches the one in the database
					  if (credentials.contains(eml) && credentials.contains(pw)) {
						  for (String s : credentials) {
							  record += s + "\n";
						  }
						  JOptionPane.showMessageDialog(frame, "Logged in!\n" + record, "Login Successful", JOptionPane.INFORMATION_MESSAGE);
					  }
					  else {
						  //Error message
						  JOptionPane.showMessageDialog(frame, "Wrong credentials!", "Login Failed", JOptionPane.ERROR_MESSAGE);
					  }
					 
				    	  
				      
				      
				      //Close the file reader
				      myReader.close();
				    } 
					catch (FileNotFoundException err) { //File exception
				      System.out.println("An error occurred.");
				      err.printStackTrace();
				    }
				
				f.setVisible(true);
				frame.dispose();
			}
			
		});
		
		
		frame.add(btn1);
		frame.add(pass);
		frame.add(lbl2);
		frame.add(email);
		frame.add(lbl1);
		frame.setLayout(null);
		frame.setSize(325, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SIGNUP");
	}
}
