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

public class CustomerInfo extends JFrame implements ActionListener 
{
	JTable table;
	JButton load,back;
	public CustomerInfo()
	{
		setLayout(null);
		setBounds(200,200,1200,650);
		setResizable(false);
		setTitle("Customer Details");
		getContentPane().setBackground(Color.WHITE);
		
		
		//Set Table
		table=new JTable();
		table.setBounds(0,40,1200,500);
		add(table);
		
		//Set Table Label
		JLabel name=new JLabel("ID Type");
		name.setBounds(45,10,150,30);
		name.setForeground(Color.red);
		name.setFont(new Font("tahoma",Font.BOLD,16));
		add(name);
		
		JLabel age=new JLabel("ID Number");
		age.setBounds(200,10,150,30);
		age.setForeground(Color.blue);
		age.setFont(new Font("tahoma",Font.BOLD,16));
		add(age);
		
		JLabel gender=new JLabel("Name");
		gender.setBounds(350,10,150,30);
		gender.setForeground(Color.red);
		gender.setFont(new Font("tahoma",Font.BOLD,16));
		add(gender);
		
		JLabel dpt=new JLabel("Gender");
		dpt.setBounds(470,10,150,30);
		dpt.setForeground(Color.blue);
		dpt.setFont(new Font("tahoma",Font.BOLD,16));
		add(dpt);
		
		JLabel salary=new JLabel("Country");
		salary.setBounds(650,10,150,30);
		salary.setForeground(Color.red);
		salary.setFont(new Font("tahoma",Font.BOLD,16));
		add(salary);
		
		JLabel ph=new JLabel("Room Number");
		ph.setBounds(760,10,150,30);
		ph.setForeground(Color.blue);
		ph.setFont(new Font("tahoma",Font.BOLD,16));
		add(ph);
		
		JLabel aadhaar=new JLabel("Check In");
		aadhaar.setBounds(940,10,150,30);
		aadhaar.setForeground(Color.red);
		aadhaar.setFont(new Font("tahoma",Font.BOLD,16));
		add(aadhaar);
		
		JLabel mail=new JLabel("Deposit");
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
				String str="select * from customer";
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
		new CustomerInfo();

	}

}
