package hotel.management;

/*import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;*/
import javax.swing.*;

/*import java.awt.Color;
import java.awt.Font;
import java.awt.Image;*/
import java.awt.*;

import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener
{
	JTextField text;
	JLabel user,password;
	JPasswordField pass;
	JButton signin,cancel;
	public Login() 
	{
		//Frame Setting
		/*setLocation(400,230);
		setSize(600,400);*/
		setBounds(450,230,600,300);
		setTitle("LOG IN");
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);//Set background color
		
		//Textfield Lebel Set
		user=new JLabel("User Name :");
		user.setBounds(10, 18, 190, 90);
		user.setForeground(Color.BLACK);
		user.setFont(new Font("calibri",Font.BOLD,25));
		
		//TextField size & location set
		text=new JTextField("");
		text.setBounds(150, 50, 150, 30);
		text.setForeground(Color.GRAY);
		//text.setBorder();
		
		//Password Field Lebel Set
		password=new JLabel("Password :");
		password.setBounds(14, 80, 190, 90);
		password.setForeground(Color.BLACK);
		password.setFont(new Font("calibri",Font.BOLD,25));

		//PasswordField size & location set
		pass=new JPasswordField("");
		pass.setBounds(150, 107, 150, 30);
		pass.setForeground(Color.GRAY);
		
		//Set Login Button
		signin=new JButton("LOGIN");
		signin.setBackground(Color.BLACK);
		signin.setForeground(Color.WHITE);
		signin.setBounds(35, 162, 80, 25);
		signin.addActionListener(this);
		
		
		//Set Cancel Button
		cancel=new JButton("CANCEL");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(175, 160, 90, 26);
		cancel.addActionListener(this);
		
		//Set Image
		ImageIcon img2=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/img2.png"));
		Image img=img2.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);//For Custom the image size
		ImageIcon icon=new ImageIcon(img);//convert the Image to ImageIcon
		JLabel img_label=new JLabel(icon);
	
		img_label.setBounds(250,18,390,200);
		
		//Adding all components 
		add(user);
		add(password);
		add(pass);
		add(text);
		add(signin);
		add(cancel);
		add(img_label);
		
		
		//visible the frame
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==signin)
		{
			String username=text.getText();
			String pass_word=pass.getText();
			
			
			String str="select * from login where username='"+username+"' and password='"+pass_word+"'";
			try {
				DatabaseConnection conn=new DatabaseConnection();
				ResultSet rs=conn.state.executeQuery(str);
				if(rs.next()) {
					new Dashboard().setVisible(true);
					this.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Username and Password");
					//this.setVisible(false);
				}
				
			}catch(Exception e) {}
			
		}else if(ae.getSource()==cancel)
		{
			System.exit(0);
		}
	}

	public static void main(String[] args) 
	{
		Login login=new Login();

	}

}
