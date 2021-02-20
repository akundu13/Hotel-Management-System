package hotel.management;

import java.awt.*;
/*import java.awt.Color;
import java.awt.Font;
import java.awt.Image;*/
import java.awt.event.*;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/
import javax.swing.*;
/*import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;*/
public class Dashboard extends JFrame implements ActionListener
{
	JMenuBar mb;
	JMenu menu1,menu2;
	JMenuItem reception,room,driver,employee;
	
	public Dashboard()
	{ 
		setLayout(null);
		setBounds(-5,0,1950,999);
		setTitle("Main Page");
		//Set the image
		ImageIcon img3=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/dashimg.jpg"));
		Image dashimg=img3.getImage().getScaledInstance(1950,950,Image.SCALE_DEFAULT);
		ImageIcon dash=new ImageIcon(dashimg);
		JLabel img3_label=new JLabel(dash);
		img3_label.setBounds(-4, 0, 1950,957);
		add(img3_label);
		
		
		//set menubar
		mb=new JMenuBar();
		//mb.setBackground(Color.yellow);
		mb.setBounds(0, 0, 1950,25);
		img3_label.add(mb);
		//Set menu
		menu1=new JMenu("Hotel Management");
		menu1.setForeground(Color.red);
		mb.add(menu1);
		
		menu2=new JMenu("Admin");
		menu2.setForeground(Color.BLUE);
		mb.add(menu2);
		
		//Set Menu item
		reception=new JMenuItem("Reception");
		reception.setForeground(Color.magenta);
		menu1.add(reception);
		
		reception.addActionListener(this);
		
		employee=new JMenuItem("Add Employee");
		employee.setForeground(Color.magenta);
		menu2.add(employee);
		
		employee.addActionListener(this);
		

		room=new JMenuItem("Add Room");
		room.setForeground(Color.magenta);
		menu2.add(room);
		
		room.addActionListener(this);
		

		driver=new JMenuItem("Add Driver");
		driver.setForeground(Color.magenta);
		menu2.add(driver);
		
		
		driver.addActionListener(this);
		
		JLabel label=new JLabel("THE INDANA GROUP WELCOME YOU");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Bookman Old Style",Font.BOLD,50));
		label.setBounds(300,80,1000,70);
		img3_label.add(label);
		

		
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Reception"))
		{
			new Reception().setVisible(true);
			//this.setVisible(false);
		}else if(ae.getActionCommand().equals("Add Employee"))
		{
			new AddEmployee().setVisible(true);
		}else if(ae.getActionCommand().equals("Add Room"))
		{
			new AddRooms().setVisible(true);
		}else if(ae.getActionCommand().equals("Add Driver"))
		{
			new AddDriver().setVisible(true);
		}
	}
	
	
	

	public static void main(String[] args)
	{
		Dashboard dash=new Dashboard();

	}

}
