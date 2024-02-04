import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		new MainMenu();
	}
}

class MainMenu{
	private JFrame frame;
	private JButton signup;
	private JButton login;
	MainMenu(){
		frame = new JFrame();
		
		signup = new JButton("Signup");
		signup.setBounds(100,100,100,25);
		signup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new SIGNUP(frame);
			}
			
		});
		
		login = new JButton("Login");
		login.setBounds(100,130,100,25);
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new LOGIN(frame);
			}
			
		});
		
		
		frame.add(login);
		frame.add(signup);
		frame.setLayout(null);
		frame.setSize(325, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Menu");
	}
}
