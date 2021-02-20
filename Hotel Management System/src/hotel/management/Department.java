package hotel.management;

import java.awt.*;
/*import java.awt.Color;
import java.awt.Font;*/
import java.awt.event.*;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/
import java.sql.ResultSet;
import javax.swing.*;
/*import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;*/
import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener
{
	JTable table;
	JButton submit,back;
	public Department()
	{
		setLayout(null);
		setTitle("Deparment");
		setBounds(410,230,700,540);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		
	
		//Set Table
		table=new JTable();
		table.setBounds(0,50,700,300);
		add(table);
		
		
		//Set Button
		submit=new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.white);
		submit.setBounds(150,450,150,30);
		submit.addActionListener(this);
		add(submit);
		
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.white);
		back.setBounds(350,450,150,30);
		back.addActionListener(this);
		add(back);
		
		
		//Set Labels Of table
		JLabel dpt=new JLabel("Department");
		dpt.setForeground(Color.blue);
		dpt.setFont(new Font("tahoma",Font.BOLD,20));
		dpt.setBounds(150,10,150,30);
		add(dpt);
		
		
		JLabel budget=new JLabel("Budget");
		budget.setForeground(Color.red);
		budget.setFont(new Font("tahoma",Font.BOLD,20));
		budget.setBounds(450,10,150,30);
		add(budget);
		
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==submit)
		{
			try
			{
				String str="select * from department";
				
				DatabaseConnection conn=new DatabaseConnection();
				ResultSet rs=conn.state.executeQuery(str);
				
				//set into table
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
		new Department();

	}

}
