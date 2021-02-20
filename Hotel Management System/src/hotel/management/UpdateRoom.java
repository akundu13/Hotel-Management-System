package hotel.management;
import java.awt.*;
/*import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;*/
import java.awt.event.*;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/
import java.sql.ResultSet;
import javax.swing.*;
/*import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;*/

public class UpdateRoom extends JFrame implements ActionListener
{
	Choice guest_id_cho;
	JTextField room_text,available_text,clean_text;
	JButton check,update,back;
	public UpdateRoom()
	{
		setLayout(null);
		setTitle("Update Room Status");
		setResizable(false);
		setBounds(280,290,1000,400);
		getContentPane().setBackground(Color.WHITE);
		
		//Set Update Room Status Label
		JLabel label=new JLabel("Update Room Status");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,30));
		label.setBounds(30,20,400,30);
		add(label);
		
		//Set Guest ID
		JLabel guest_id=new JLabel("Guest ID");
		guest_id.setFont(new Font("tahoma",Font.BOLD,18));
		guest_id.setBounds(30,80,130,30);
		add(guest_id);
		
		guest_id_cho=new Choice();
		try 
		{
			DatabaseConnection conn=new DatabaseConnection ();
			ResultSet rs=conn.state.executeQuery("select * from customer");
			while(rs.next())
			{
				guest_id_cho.add(rs.getString("id_number"));
			}
		}catch(Exception e) {}
		
		guest_id_cho.setBounds(200,80,185,35);
		add(guest_id_cho);
		
		//Set Room Number
		JLabel room_no=new JLabel("Room Number");
		room_no.setFont(new Font("tahoma",Font.BOLD,18));
		room_no.setBounds(30,130,400,30);
		add(room_no);
		
		room_text=new JTextField();
		room_text.setBounds(200,130,150,25);
		add(room_text);
		
		//Set Availability
		JLabel availability=new JLabel("Availability");
		availability.setFont(new Font("tahoma",Font.BOLD,18));
		availability.setBounds(30,180,400,30);
		add(availability);
		
		available_text=new JTextField();
		available_text.setBounds(200,180,150,25);
		add(available_text);
		
		//Set Clean Status
		JLabel clean=new JLabel("Clean Status");
		clean.setFont(new Font("tahoma",Font.BOLD,18));
		clean.setBounds(30,230,400,30);
		add(clean);
		
		clean_text=new JTextField();
		clean_text.setBounds(200,230,150,25);
		add(clean_text);
		
		//Set Button
		check=new JButton("Check");
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.setBounds(20,300,90,25);
		add(check);
		check.addActionListener(this);
		
		
		update=new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setBounds(140,300,90,25);
		add(update);
		update.addActionListener(this);
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(260,300,90,25);
		add(back);
		back.addActionListener(this);
		
		//Set Room Img
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/roomimg2.jpg"));
		Image img1=img.getImage().getScaledInstance(550, 340, Image.SCALE_DEFAULT);
		ImageIcon roomimg2=new ImageIcon(img1);
		JLabel roomimg2_label=new JLabel(roomimg2);
		roomimg2_label.setBounds(400,10,550,320);
		add(roomimg2_label);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==check)
		{
			String id=guest_id_cho.getSelectedItem();
			String room=null;
			try {
			DatabaseConnection conn=new DatabaseConnection();
			String str="select * from customer where id_number='"+id+"'";
			ResultSet rs=conn.state.executeQuery(str);
		
			while(rs.next())
			{
				room_text.setText(rs.getString("room_no"));
				room=rs.getString("room_no");
				
			}
			
			String str2="select * from rooms where room_number='"+room+"'";
			ResultSet rs2=conn.state.executeQuery(str2);
			while(rs2.next())
			{
				available_text.setText(rs2.getString("room_available"));
				clean_text.setText(rs2.getString("room_status"));
			}
			
			}catch(Exception e) {}
			
		}else if(ae.getSource()==update)
		{
			try {
					DatabaseConnection conn=new DatabaseConnection();
					String room=room_text.getText();
					String available=available_text.getText();
					String clean=clean_text.getText();
					String str="update rooms set room_available='"+available+"' ,room_status='"+clean+"' where room_number='"+room+"'";
					conn.state.executeUpdate(str);
					JOptionPane.showMessageDialog(null,"Room Updated Successfully");
					
					new Reception().setVisible(true);
					this.setVisible(false);
				
				}catch(Exception e) {System.out.println(e);}
		}else if(ae.getSource()==back)
		{
			new Reception().setVisible(true);
			this.setVisible(false);new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args)
	{
		new UpdateRoom();
		

	}

}
