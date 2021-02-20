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
/*import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;*/

public class AddRooms extends JFrame implements ActionListener
{
	JTextField room_text,price_text;
	JComboBox available_combo,status_combo,type_combo;
	JButton add,cancel;
	public AddRooms()
	{
		setLayout(null);
		setBounds(390,250,800,400);
		setTitle("Add Rooms");
		setResizable(false);
		getContentPane().setBackground(Color.gray);
		
		//Set rooms label
		JLabel label=new JLabel("ROOMS");
		label.setForeground(Color.white);
		label.setFont(new Font("Bookman Old Style",Font.BOLD,40));
		label.setBounds(150, 5, 180, 75);
		add(label);
		
		//Set Room Number
		JLabel room=new JLabel("Room Number");
		room.setForeground(Color.white);
		room.setFont(new Font("tahoma",Font.BOLD,18));
		room.setBounds(40, 60, 180, 75);
		add(room);
		
		room_text=new JTextField();
		room_text.setBounds(215,85,150,25);
		add(room_text);
		
		//Set Available
		JLabel available=new JLabel("Available");
		available.setForeground(Color.white);
		available.setFont(new Font("tahoma",Font.BOLD,18));
		available.setBounds(40, 100, 180, 75);
		add(available);
		
		available_combo=new JComboBox(new String[]  {"Available","Occupied"});
		available_combo.setBounds(215, 125, 150, 25);
		available_combo.setBackground(Color.WHITE);
		add(available_combo);
		
		
		//Set cleaning status
		JLabel status=new JLabel("Cleaning Status");
		status.setForeground(Color.white);
		status.setFont(new Font("tahoma",Font.BOLD,18));
		status.setBounds(40, 140, 180, 75);
		add(status);
		
		status_combo=new JComboBox(new String[]  {"Cleaned","Not Cleaned"});
		status_combo.setBounds(215, 165, 150, 25);
		status_combo.setBackground(Color.WHITE);
		add(status_combo);
		
		//Set Price
		JLabel price=new JLabel("Price");
		price.setForeground(Color.white);
		price.setFont(new Font("tahoma",Font.BOLD,18));
		price.setBounds(40, 185, 180, 75);
		add(price);
		
		price_text=new JTextField();
		price_text.setBounds(215,210,150,25);
		add(price_text);
		
		//Set Bed Type
		JLabel type=new JLabel("Bed Type");
		type.setForeground(Color.white);
		type.setFont(new Font("tahoma",Font.BOLD,18));
		type.setBounds(40, 225, 180, 75);
		add(type);
		
		type_combo=new JComboBox(new String[]  {"Single Bed","Double Bed"});
		type_combo.setBounds(215, 249, 150, 25);
		type_combo.setBackground(Color.WHITE);
		add(type_combo);
		
		//Set Buttons
		add=new JButton("Add Room");
		add.setBackground(Color.white);
		add.setForeground(Color.black);
		add.setBounds(70,300,100,28);
		add(add);
		
		add.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.WHITE);
		cancel.setForeground(Color.black);
		cancel.setBounds(235,300,100,29);
		add(cancel);
		
		cancel.addActionListener(this);
		
		
		//Set Image
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/room.JPEG"));
		Image img1=img.getImage().getScaledInstance(360, 330, Image.SCALE_DEFAULT);
		ImageIcon roomimg=new ImageIcon(img1);
		JLabel room_label=new JLabel(roomimg);
		room_label.setBounds(400, 20, 360, 330);
		add(room_label);
		
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			//fetching text from textField
			String room=room_text.getText();
			String price=price_text.getText();
			
			//fetching text from comboBox
			String available=(String)available_combo.getSelectedItem();
			String status=(String)status_combo.getSelectedItem();
			String type=(String)type_combo.getSelectedItem();
			
			try {
				DatabaseConnection conn=new DatabaseConnection();
				String query="insert into rooms values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
				conn.state.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"New Rooms Added");
				this.setVisible(false);
			}catch(Exception e) {}
			
		}else if(ae.getSource()==cancel)
		{
			this.setVisible(false);
		}
	}
	public static void main(String[] args) 
	{
		new AddRooms();

	}

}
