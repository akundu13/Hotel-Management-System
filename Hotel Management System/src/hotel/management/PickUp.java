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

public class PickUp extends JFrame implements ActionListener
{
	JTable table;
	JComboBox model_combo;
	JButton submit,back;
	public PickUp()
	{
		setLayout(null);
		setTitle("Search Room");
		setBounds(270,200,1030,650);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		
		//Set Pick Up Service Label
		JLabel label=new JLabel("Pick Up Service");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Bookman Old Style",Font.HANGING_BASELINE,35));
		label.setBounds(350,25,300,30);
		add(label);
		
		//Set Car Type
		JLabel type=new JLabel("Car Type");
		type.setFont(new Font("tahoma",Font.BOLD,18));
		type.setBounds(50,80,150,30);
		add(type);
		
		model_combo=new JComboBox();
		try
		{
			DatabaseConnection conn=new DatabaseConnection();
			String str="select * from drivers";
			ResultSet rs=conn.state.executeQuery(str);
			
			while(rs.next())
			{
				model_combo.addItem(rs.getString("model"));
			}
		}catch(Exception e) {}
		model_combo.setBounds(200,83,150,25);
		model_combo.setBackground(Color.WHITE);
		add(model_combo);
		
		
		//Set Table
		table=new JTable();
		table.setBounds(0,200,1030,300);
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
		JLabel name=new JLabel("Driver Name");
		name.setForeground(Color.blue);
		name.setFont(new Font("tahoma",Font.BOLD,15));
		name.setBounds(30,150,150,30);
		add(name);
		
		
		JLabel age=new JLabel("Age");
		age.setForeground(Color.red);
		age.setFont(new Font("tahoma",Font.BOLD,15));
		age.setBounds(200,150,150,30);
		add(age);
		
		
		JLabel gender=new JLabel("Gender");
		gender.setForeground(Color.blue);
		gender.setFont(new Font("tahoma",Font.BOLD,15));
		gender.setBounds(330,150,150,30);
		add(gender);
		
		
		JLabel brand=new JLabel("Car Brand");
		brand.setForeground(Color.red);
		brand.setFont(new Font("tahoma",Font.BOLD,15));
		brand.setBounds(460,150,150,30);
		add(brand);
		
		
		JLabel model=new JLabel("Car Model");
		model.setForeground(Color.blue);
		model.setFont(new Font("tahoma",Font.BOLD,15));
		model.setBounds(610,150,150,30);
		add(model);
		
		
		JLabel available=new JLabel("Car Available");
		available.setForeground(Color.red);
		available.setFont(new Font("tahoma",Font.BOLD,15));
		available.setBounds(750,150,150,30);
		add(available);
		
		
		JLabel loc=new JLabel("Car Location");
		loc.setForeground(Color.blue);
		loc.setFont(new Font("tahoma",Font.BOLD,15));
		loc.setBounds(900,150,150,30);
		add(loc);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==submit)
		{
			try
			{
				String str="select * from drivers where model='"+model_combo.getSelectedItem()+"'";
				String str2="select * from rooms where available='Available' And bed_type='"+model_combo.getSelectedItem()+"'";
				
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
		new PickUp();

	}

}
