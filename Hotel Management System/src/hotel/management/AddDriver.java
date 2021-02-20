package hotel.management;

import java.awt.*;
/*import java.awt.Color;
import java.awt.Font;
import java.awt.Image;*/

import java.sql.*;
import java.awt.event.*;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

import javax.swing.*;
/*import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;*/

public class AddDriver extends JFrame implements ActionListener
{
	 JTextField name_text,age_text,car_text,model_text,location_text;	
	 JButton add,cancel;
	 JComboBox gender_combo,available_combo;
	 
	public AddDriver()
	{
		setLayout(null);
		setBounds(390,250,800,450);
		setResizable(false);
		setTitle("Add Driver");
		getContentPane().setBackground(Color.gray);
		
		//Set Driver label
		JLabel label=new JLabel("DRIVERS");
		label.setForeground(Color.white);
		label.setFont(new Font("Bookman Old Style",Font.BOLD,35));
		label.setBounds(150, 5, 250, 75);
		add(label);

		
		//Set Driver Name
		JLabel name=new JLabel("Name");
		name.setBounds(60,70,100,30);
		name.setFont(new Font("tahoma",Font.BOLD,20));
		name.setForeground(Color.WHITE);
		add(name);
		
		name_text=new JTextField();
		name_text.setBounds(240,73,150,25);
		add(name_text);
		
		//Set Driver Age
		JLabel age=new JLabel("Age");
		age.setBounds(60,110,100,30);
		age.setFont(new Font("tahoma",Font.BOLD,20));
		age.setForeground(Color.WHITE);
		add(age);
		
		age_text=new JTextField();
		age_text.setBounds(240,113,150,25);
		add(age_text);
		
		//Set Driver Gender
		JLabel gender=new JLabel("Gender");
		gender.setBounds(60,150,100,30);
		gender.setFont(new Font("tahoma",Font.BOLD,20));
		gender.setForeground(Color.WHITE);
		add(gender);
		
		gender_combo=new JComboBox(new String[]  {"Female","Male"});
		gender_combo.setBounds(240, 153, 150, 25);
		gender_combo.setBackground(Color.WHITE);
		add(gender_combo);
		
		//Set Driver Car Company
		JLabel car=new JLabel("Car Company");
		car.setBounds(60,190,150,30);
		car.setFont(new Font("tahoma",Font.BOLD,20));
		car.setForeground(Color.WHITE);
		add(car);
		
		car_text=new JTextField();
		car_text.setBounds(240,193,150,25);
		add(car_text);
		
		//Set Driver Car Model
		JLabel model=new JLabel("Car Model");
		model.setBounds(60,230,150,30);
		model.setFont(new Font("tahoma",Font.BOLD,20));
		model.setForeground(Color.WHITE);
		add(model);
		
		model_text=new JTextField();
		model_text.setBounds(240,233,150,25);
		add(model_text);
		
		//Set Driver Available
		JLabel available=new JLabel("Available");
		available.setForeground(Color.white);
		available.setFont(new Font("tahoma",Font.BOLD,20));
		available.setBounds(60, 270, 150, 30);
		add(available);
		

		available_combo=new JComboBox(new String[]  {"Available","Occupied"});
		available_combo.setBounds(240, 273, 150, 25);
		available_combo.setBackground(Color.WHITE);
		add(available_combo);
		
		
		//Set Driver Location
		JLabel location=new JLabel("Location");
		location.setForeground(Color.white);
		location.setFont(new Font("tahoma",Font.BOLD,20));
		location.setBounds(60, 310, 150, 30);
		add(location);
		
		
		location_text=new JTextField();
		location_text.setBounds(240,313,150,25);
		add(location_text);
		
		//Set Buttons
		add=new JButton("Add Driver");
		add.setBackground(Color.white);
		add.setForeground(Color.black);
		add.setBounds(70,360,120,28);
		add(add);
		
		add.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.WHITE);
		cancel.setForeground(Color.black);
		cancel.setBounds(239,358,120,29);
		add(cancel);
		
		cancel.addActionListener(this);
		
		
		//Set Image
		ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/driver.jpg"));
		Image img2=img1.getImage().getScaledInstance(340,310,Image.SCALE_SMOOTH);
		ImageIcon driver=new ImageIcon(img2);
		JLabel dri_label=new JLabel(driver);
		dri_label.setBounds(430,65,340,310);
		add(dri_label);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			//fetching all data
			String name=name_text.getText();
			String age=age_text.getText();
			String car=car_text.getText();
			String model=model_text.getText();
			String location=location_text.getText();
			
			String gender=(String)gender_combo.getSelectedItem();
			String available=(String)available_combo.getSelectedItem();
			
			//connect with database
			try {
			DatabaseConnection conn=new DatabaseConnection();
			String query="insert into drivers values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+available+"','"+location+"')";
			conn.state.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"New Driver Added");
			this.setVisible(false);
			}catch(Exception e) {System.out.println(e);}
		}else if(ae.getSource()==cancel)
		{
			this.setVisible(false);
		}
	}
	public static void main(String[] args)
	{
		new AddDriver();

	}

}
