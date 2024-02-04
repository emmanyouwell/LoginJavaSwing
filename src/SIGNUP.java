import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SIGNUP {
	private JFrame frame;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JTextField email;
	private JPasswordField pass;
	private JTextArea description;
	private JRadioButton male;
	private JRadioButton female;
	private JCheckBox chk1;
	private JButton btn1;
	SIGNUP(JFrame f){
		frame = new JFrame();
		
		lbl1 = new JLabel("Email:");
		lbl1.setBounds(10,10,100,25);
		
		email = new JTextField();
		email.setBounds(50,10,175,25);
		
		lbl2 = new JLabel("Password:");
		lbl2.setBounds(10, 40, 100, 25);
		
		pass = new JPasswordField();
		pass.setBounds(75,40,150,25);
		
		lbl3 = new JLabel("Gender:");
		lbl3.setBounds(10, 70, 100, 25);
		
		male = new JRadioButton("Male");
		male.setBounds(60,70,100,25);
		
		female = new JRadioButton("Female");
		female.setBounds(140, 70,100, 25);
		
		lbl4 = new JLabel("Description:");
		lbl4.setBounds(10,100,100,25);
		
		description = new JTextArea();
		description.setBounds(10,130,210,100);
		
		chk1 = new JCheckBox("Receive the latest newsletter");
		chk1.setBounds(10, 240, 200,25);
		
		btn1 = new JButton("Sign up");
		btn1.setBounds(10,270,100,25);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				String eml = email.getText();
				String pw = new String(pass.getPassword());
				String gender = (male.isSelected() ? "Male" : female.isSelected() ? "Female" : "None selected");
				String desc = description.getText();
				boolean news = chk1.isSelected();
				
				String msg = "Email: " + eml + "\nPassword: " + pw + "\nGender: " + gender + "\nDescription: " + desc + "\nReceive newsletter: " + (news ? "Yes" : "No");
				String record = eml + "\n" + pw + "\n" + gender + "\n" + desc + "\n" + (news ? "Yes" : "No");
				 try {
					  //Creates File Writer Object
				      FileWriter writer = new FileWriter("C:\\Users\\Emmanuel\\LTC Java Swing\\Login\\src\\database.txt");
				      
				      //Writes inside the file
				      writer.write(record);
				      
				      
				      //Close the file writer
				      writer.close();
				    } catch (IOException err) { //Input Output Exception
				      System.out.println("An error occurred.");
				      err.printStackTrace();
				    }
				
				JOptionPane.showMessageDialog(null, msg, "Information", JOptionPane.INFORMATION_MESSAGE);
				f.setVisible(true);
				frame.dispose();
			}
			
		});
		
		frame.add(lbl4);
		frame.add(description);
		frame.add(btn1);
		frame.add(chk1);
		frame.add(female);
		frame.add(male);
		frame.add(lbl3);
		frame.add(pass);
		frame.add(lbl2);
		frame.add(email);
		frame.add(lbl1);
		frame.setLayout(null);
		frame.setSize(325, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SIGNUP");
	}
}
