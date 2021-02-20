package hotel.management;

import java.sql.*;

import java.awt.*;
/*import java.awt.Color;
import java.awt.Font;
import java.awt.Image;*/
import java.awt.event.*;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

import javax.swing.*;
/*import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;*/

public class AddEmployee extends JFrame implements ActionListener
{
	JTextField name_text,age_text,salary_text,phone_text,aadhaar_text,email_text;
	JRadioButton female_radio, male_radio;
	JComboBox job_combo;
	JButton submit;
	

	public AddEmployee()
	{
		setLayout(null);
		setTitle("Add Employee");
		setBounds(400,250,800,500);
		getContentPane().setBackground(Color.gray);
		setResizable(false);
		
		//Set Name
		JLabel name=new JLabel("NAME ");
		name.setFont(new Font("tahoma",Font.BOLD,18));
		name.setForeground(Color.white);
		name.setBounds(50, 85, 120, 30);
		add(name);
		
		name_text=new JTextField();
		name_text.setBounds(145,88,150,25);
		add(name_text);
		
		//Set Age
		JLabel age=new JLabel("AGE ");
		age.setFont(new Font("tahoma",Font.BOLD,18));
		age.setForeground(Color.white);
		age.setBounds(50, 125, 120, 30);
		add(age);
		
		age_text=new JTextField();
		age_text.setBounds(145,125,150,25);
		add(age_text);
		
		//Set Gender
		JLabel gender=new JLabel("GENDER ");
		gender.setFont(new Font("tahoma",Font.BOLD,18));
		gender.setForeground(Color.WHITE);
		gender.setBounds(50, 165, 120, 30);
		add(gender);
		
		male_radio=new JRadioButton("MALE");
		male_radio.setForeground(Color.white);
		male_radio.setBounds(140, 165, 70, 30);
		male_radio.setFont(new Font("tahoma",Font.BOLD,16));
		male_radio.setBackground(Color.gray);
		add(male_radio);
		
		female_radio=new JRadioButton("FEMALE");
		female_radio.setForeground(Color.white);
		female_radio.setBounds(210, 165, 100, 30);
		female_radio.setFont(new Font("tahoma",Font.BOLD,16));
		female_radio.setBackground(Color.gray);
		add(female_radio);
		
		//Set Job
		JLabel job=new JLabel("JOB ");
		job.setFont(new Font("tahoma",Font.BOLD,18));
		job.setForeground(Color.white);
		job.setBounds(50, 205, 120, 30);
		add(job);
		
		String jobs[]= {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
		job_combo=new JComboBox(jobs);
		job_combo.setBounds(145, 205, 150, 25);
		job_combo.setBackground(Color.WHITE);
		add(job_combo);
		
		//Set Salary
		JLabel salary=new JLabel("SALARY ");
		salary.setFont(new Font("tahoma",Font.BOLD,18));
		salary.setForeground(Color.white);
		salary.setBounds(50, 245, 120, 30);
		add(salary);
		
		salary_text=new JTextField();
		salary_text.setBounds(145,245,150,25);
		add(salary_text);
		
		//Set Phone
		JLabel phone=new JLabel("PHONE ");
		phone.setFont(new Font("tahoma",Font.BOLD,18));
		phone.setForeground(Color.white);
		phone.setBounds(50, 285, 120, 30);
		add(phone);
		
		phone_text=new JTextField();
		phone_text.setBounds(145,285,150,25);
		add(phone_text);
	
		//Set Aadhaar
		JLabel aadhaar=new JLabel("AADHAAR ");
		aadhaar.setFont(new Font("tahoma",Font.BOLD,18));
		aadhaar.setForeground(Color.white);
		aadhaar.setBounds(50, 325, 120, 30);
		add(aadhaar);
		
		aadhaar_text=new JTextField();
		aadhaar_text.setBounds(145,325,150,25);
		add(aadhaar_text);
		
		//Set Email
		JLabel email=new JLabel("EMAIL ");
		email.setFont(new Font("tahoma",Font.BOLD,18));
		email.setForeground(Color.white);
		email.setBounds(50, 365, 120, 30);
		add(email);
		
		email_text=new JTextField();
		email_text.setBounds(145,365,150,25);
		add(email_text);
		
		//Add Submit Button
		submit=new JButton("SUBMIT");
		submit.setBackground(Color.white);
		submit.setForeground(Color.black);
		submit.setBounds(120, 410, 90,30);
		add(submit);
		
		submit.addActionListener(this);
		
		//Add Image of employee
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/emp.jpg"));
		Image img2=img.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
		ImageIcon emp=new ImageIcon(img2);
		JLabel emp_label=new JLabel(emp);
		emp_label.setBounds(350,85,400,300);
		add(emp_label);
		
		//Set Label
		JLabel label=new JLabel("EMPLOYEE DETAILS");
		label.setFont(new Font("Bookman Old Style",Font.BOLD,40));
		label.setForeground(Color.white);
		label.setBounds(185, 25, 500, 30);
		add(label);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		//Fetching values from textfields
		String name=name_text.getText();
		String age=age_text.getText();
		String salary=salary_text.getText();
		String phone=phone_text.getText();
		String aadhaar=aadhaar_text.getText();
		String email=email_text.getText();
		
		//Fetching values from radiobutton
		String gender=null;
		if(male_radio.isSelected())
		{
			gender="Male";
		}else if(female_radio.isSelected())
		{
			gender="Female";
		}
		
		//Fetching values from combobox
		String  job=(String)job_combo.getSelectedItem();
		
		String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhaar+"','"+email+"')";
	
		try {
			DatabaseConnection conn=new DatabaseConnection();
			conn.state.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"New Employee Added");
			this.setVisible(false);
		}catch(Exception e){}
		
	}
	
	public static void main(String[] args) 
	{

		AddEmployee emp=new AddEmployee();

	}

}
