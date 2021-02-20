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

public class SearchRoom extends JFrame implements ActionListener
{
	JTable table;
	JComboBox type_combo;
	JCheckBox only_check;
	JButton submit,back;
	public SearchRoom ()
	{
		setLayout(null);
		setTitle("Search Room");
		setBounds(280,200,1000,650);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		
		//Set Search For Room Label
		JLabel label=new JLabel("Search For Room");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Bookman Old Style",Font.HANGING_BASELINE,35));
		label.setBounds(350,25,300,30);
		add(label);
		
		//Set Room Bed Type
		JLabel type=new JLabel("Room Bed Type");
		type.setFont(new Font("tahoma",Font.BOLD,18));
		type.setBounds(30,80,150,30);
		add(type);
		
		type_combo=new JComboBox(new String[] {"Single Bed","Double Bed"});
		type_combo.setBounds(200,83,150,25);
		type_combo.setBackground(Color.WHITE);
		add(type_combo);
		
		only_check=new JCheckBox("Only Display Available");
		only_check.setBounds(650,80,150,30);
		only_check.setBackground(Color.white);
		add(only_check);
		
		//Set Table
		table=new JTable();
		table.setBounds(0,200,1000,300);
		add(table);
		
		
		//Set Button
		submit=new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.white);
		submit.setBounds(280,555,150,30);
		submit.addActionListener(this);
		add(submit);
		
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.white);
		back.setBounds(500,555,150,30);
		back.addActionListener(this);
		add(back);
		
		
		//Set Labels Of table
		JLabel number=new JLabel("Room Number");
		number.setForeground(Color.blue);
		number.setFont(new Font("tahoma",Font.BOLD,18));
		number.setBounds(40,150,150,30);
		add(number);
		
		
		JLabel available=new JLabel("Availability");
		available.setForeground(Color.red);
		available.setFont(new Font("tahoma",Font.BOLD,18));
		available.setBounds(250,150,150,30);
		add(available);
		
		
		JLabel status=new JLabel("Cleaning Status");
		status.setForeground(Color.blue);
		status.setFont(new Font("tahoma",Font.BOLD,18));
		status.setBounds(430,150,150,30);
		add(status);
		
		
		JLabel price=new JLabel("Room Price");
		price.setForeground(Color.red);
		price.setFont(new Font("tahoma",Font.BOLD,18));
		price.setBounds(650,150,150,30);
		add(price);
		
		
		JLabel room_type=new JLabel("Bed Type");
		room_type.setForeground(Color.blue);
		room_type.setFont(new Font("tahoma",Font.BOLD,18));
		room_type.setBounds(850,150,150,30);
		add(room_type);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==submit)
		{
			try
			{
				String str="select * from rooms where bed_type='"+type_combo.getSelectedItem()+"'";
				String str2="select * from rooms where room_available='Available' And bed_type='"+type_combo.getSelectedItem()+"'";
				
				DatabaseConnection conn=new DatabaseConnection();
				ResultSet rs=conn.state.executeQuery(str);
				
				//set into table
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				//set check box
				if(only_check.isSelected())
				{
					ResultSet rs2=conn.state.executeQuery(str2);
					//set table
					table.setModel(DbUtils.resultSetToTableModel(rs2));
				}
			}catch(Exception e) {}
			
		}else if(ae.getSource()==back)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args)
	{
		new SearchRoom();

	}

}
