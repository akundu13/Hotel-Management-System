package hotel.management;

import net.proteanit.sql.*;

import java.sql.*;
//import java.sql.ResultSet;
import java.awt.event.*;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/
import java.awt.*;
/*import java.awt.Color;
import java.awt.Font;
import java.awt.Image;*/
import javax.swing.*;
/*import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;*/

public class Room extends JFrame implements ActionListener
{
	JButton load,back;
	JTable table;
	public Room()
	{
		//Set Frame
		setLayout(null);
		setBounds(280,200,1000,600);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Room Details");
		
		//Set Table
		table=new JTable();
		table.setBounds(0,40,500,400);
		add(table);
		
		//Set Table Label
		JLabel room=new JLabel("Room No");
		room.setBounds(15,5,120,30);
		room.setForeground(Color.RED);
		room.setFont(new Font("tahoma",Font.BOLD,15));
		add(room);
		
		JLabel available=new JLabel("Availability");
		available.setBounds(104,5,120,30);
		available.setForeground(Color.BLUE);
		available.setFont(new Font("tahoma",Font.BOLD,15));
		add(available);
		

		JLabel clean=new JLabel("Clean Status");
		clean.setBounds(200,5,120,30);
		clean.setForeground(Color.RED);
		clean.setFont(new Font("tahoma",Font.BOLD,15));
		add(clean);
		
		JLabel price=new JLabel("Price");
		price.setBounds(320,5,120,30);
		price.setForeground(Color.BLUE);
		price.setFont(new Font("tahoma",Font.BOLD,15));
		add(price);
		
		
		JLabel type=new JLabel("Bed Type");
		type.setBounds(410,5,120,30);
		type.setForeground(Color.BLUE);
		type.setFont(new Font("tahoma",Font.BOLD,15));
		add(type);
		
		//Set Buttons
		load=new JButton("Load Data");
		load.setForeground(Color.WHITE);
		load.setBackground(Color.BLACK);
		load.setBounds(50,500,150,30);
		add(load);
		
		load.addActionListener(this);
		
		back=new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(250,500,150,30);
		add(back);
		
		back.addActionListener(this);
		
		//Set Image
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/roomimg.jpg"));
		Image img1=img.getImage().getScaledInstance(460, 500, Image.SCALE_DEFAULT);
		ImageIcon roomimg=new ImageIcon(img1);
		JLabel room_label=new JLabel(roomimg);
		room_label.setBounds(505,25,460,500);
		add(room_label);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==load)
		{
			try
			{
				DatabaseConnection conn=new DatabaseConnection ();
				String str="select * from rooms";
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
		new Room();

	}

}
