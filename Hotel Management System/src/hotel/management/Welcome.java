package hotel.management;

/*import java.awt.Color;
import java.awt.Font;*/
import java.awt.*;
import java.awt.event.*;


/*import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;*/
import javax.swing.*;

public class Welcome extends JFrame implements ActionListener{
	
	JButton next;
	public Welcome()
	{
		/*setSize(1224,430);
		setLocation(350,250);*/
		
		setBounds(65,95,1429,700);//Set frame location and size
		setLayout(null);//Set the layout of this frame
		setResizable(false);//Prevent to change frame size
		setTitle("HOTEL MANAGEMENT SYSTEM");//Set frame title
		
	
		//loading the first image
		ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/img1.jpg"));
		JLabel img_label=new JLabel(img1);//putting ImageIcon object in JLabel
		
		img_label.setBounds(0, 0, 1429,700);//Set Image location and size
		add(img_label);//Adding image label in the frame
		
		
		
		//Add Hotel Logo
		ImageIcon logo=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/logo.png"));
		JLabel logo_label=new JLabel(logo);//putting ImageIcon object in JLabel
		
		logo_label.setBounds(100, 20, 240,65);//Set Logo image location and size
		img_label.add(logo_label);//Adding logo label in the frame
		
		
		
		//welcome text
		JLabel welcome_label=new JLabel("Welcome To Indana Hotels");
		welcome_label.setBounds(45,575,1500,90);//Set label size and location
		welcome_label.setForeground(Color.ORANGE);//Set label text color
		welcome_label.setFont(new  Font("serif",Font.ITALIC,85));//Set label text size and style
		img_label.add(welcome_label);
		
		
		
		//Next button
		next=new JButton("NEXT");
		next.setBackground(Color.ORANGE);//set button background color
		next.setForeground(Color.RED);//Set button text color
		next.setBounds(1300,615,80,40);//Set button size and location
		
		next.addActionListener(this);
		img_label.add(next);//Adding next button in the frame
		
	
		//visible the JFrame
		setVisible(true); 
		
		while(true)
		{
			welcome_label.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
			welcome_label.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		new Login().setVisible(true);
		this.setVisible(false);
	}

	public static void main(String[] args) {

		Welcome wel=new Welcome();
		//wel.setVisible(true);

	}

}
