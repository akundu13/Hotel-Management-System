package hotel.management;

import java.sql.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
/*import java.awt.Color;
import java.awt.Font;*/
import java.awt.event.*;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/
import javax.swing.*;
/*import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;*/

public class EmployeeInfo extends JFrame implements ActionListener 
{
	JTable table;
	JButton load,back;
	public EmployeeInfo()
	{
		setLayout(null);
		setBounds(200,200,1200,650);
		setResizable(false);
		setTitle("Employee Details");
		getContentPane().setBackground(Color.WHITE);
		
		
		//Set Table
		table=new JTable();
		table.setBounds(0,40,1200,500);
		add(table);
		
		//Set Table Label
		JLabel name=new JLabel("Name");
		name.setBounds(45,10,150,30);
		name.setForeground(Color.red);
		name.setFont(new Font("tahoma",Font.BOLD,16));
		add(name);
		
		JLabel age=new JLabel("Age");
		age.setBounds(200,10,150,30);
		age.setForeground(Color.blue);
		age.setFont(new Font("tahoma",Font.BOLD,16));
		add(age);
		
		JLabel gender=new JLabel("Gender");
		gender.setBounds(350,10,150,30);
		gender.setForeground(Color.red);
		gender.setFont(new Font("tahoma",Font.BOLD,16));
		add(gender);
		
		JLabel dpt=new JLabel("Department");
		dpt.setBounds(470,10,150,30);
		dpt.setForeground(Color.blue);
		dpt.setFont(new Font("tahoma",Font.BOLD,16));
		add(dpt);
		
		JLabel salary=new JLabel("Salary");
		salary.setBounds(650,10,150,30);
		salary.setForeground(Color.red);
		salary.setFont(new Font("tahoma",Font.BOLD,16));
		add(salary);
		
		JLabel ph=new JLabel("Phone Number");
		ph.setBounds(760,10,150,30);
		ph.setForeground(Color.blue);
		ph.setFont(new Font("tahoma",Font.BOLD,16));
		add(ph);
		
		JLabel aadhaar=new JLabel("Aadhaar");
		aadhaar.setBounds(940,10,150,30);
		aadhaar.setForeground(Color.red);
		aadhaar.setFont(new Font("tahoma",Font.BOLD,16));
		add(aadhaar);
		
		JLabel mail=new JLabel("Email Id");
		mail.setBounds(1090,10,150,30);
		mail.setForeground(Color.blue);
		mail.setFont(new Font("tahoma",Font.BOLD,16));
		add(mail);
		
		//Set Button
		load=new JButton("Load Data");
		load.setBounds(400,570,120,30);
		load.setBackground(Color.black);
		load.setForeground(Color.WHITE);
		add(load);
		
		load.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(550,570,120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		add(back);
		
		back.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==load)
		{
			try
			{
				DatabaseConnection conn=new DatabaseConnection();
				String str="select * from employee";
				ResultSet rs=conn.state.executeQuery(str);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e) {}
			
		}else if(ae.getSource()==back)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String[] args) 
	{
		new EmployeeInfo();

	}

}
