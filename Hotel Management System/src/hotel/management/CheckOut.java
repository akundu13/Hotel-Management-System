package hotel.management;

import java.sql.ResultSet;

import java.awt.*;
/*import java.awt.Color;
import java.awt.Font;*/
import java.awt.event.*;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/
import javax.swing.*;
/*import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;*/

public class CheckOut extends JFrame implements ActionListener
{
	JTextField room_text;
	JComboBox cus_id_combo;
	JButton check,back,tick_button;
	public CheckOut()
	{
		setLayout(null);
		setTitle("Check Out");
		setBounds(340,300,900,300);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		
		//Set Check Out Details Label
		JLabel label=new JLabel("Check Out Details");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Bookman Old Style",Font.HANGING_BASELINE,30));
		label.setBounds(50,20,300,30);
		add(label);
		
		//Set Customer ID
		JLabel id=new JLabel("Customer ID");
		id.setFont(new Font("tahoma",Font.BOLD,16));
		id.setBounds(30,80,150,30);
		add(id);
		
		cus_id_combo=new JComboBox();
		try
		{
			DatabaseConnection conn=new DatabaseConnection();
			String str="select * from customer";
			ResultSet rs=conn.state.executeQuery(str);
			while(rs.next())
			{
				cus_id_combo.addItem(rs.getString("id_number"));
			}
		}catch(Exception e) {}
		
		cus_id_combo.setBounds(200,80,150,25);
		add(cus_id_combo);
		
		//Set Room Number
		JLabel room=new JLabel("Room Number");
		room.setFont(new Font("tahoma",Font.BOLD,16));
		room.setBounds(30,120,150,30);
		add(room);
		
		room_text=new JTextField();
		room_text.setBounds(200,120,150,25);
		add(room_text);
		
		
		//Set Button
		check=new JButton("Check Out");
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.setBounds(45,190,100,30);
		add(check);
		
		check.addActionListener(this);
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(190,190,100,30);
		add(back);
		
		back.addActionListener(this);
		
		//Set Tick Image Button
		ImageIcon img2=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/tick.png"));
		Image img3=img2.getImage().getScaledInstance(35,25,Image.SCALE_DEFAULT);
		ImageIcon tick_img=new ImageIcon(img3);
		tick_button=new JButton(tick_img);
		tick_button.setBounds(350,80,35,25);
		add(tick_button);
		
		tick_button.addActionListener(this);
		
		//Set Check Out Image
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/checkout.jpg"));
		Image img1=img.getImage().getScaledInstance(400,220,Image.SCALE_DEFAULT);
		ImageIcon checkout_img=new ImageIcon(img1);
		JLabel checkout_label=new JLabel(checkout_img);
		checkout_label.setBounds(430,25,400,220);
		add(checkout_label);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==tick_button)
		{
			String id=(String)cus_id_combo.getSelectedItem();
			try
			{
				DatabaseConnection conn=new DatabaseConnection();
				String str="select * from customer where id_number='"+id+"'";
				ResultSet rs=conn.state.executeQuery(str);
				while(rs.next())
				{
					room_text.setText(rs.getString("room_no"));
				}
			}catch(Exception e) {}
		}
		else if(ae.getSource()==check)
		{
			String id=(String)cus_id_combo.getSelectedItem();
			String room=room_text.getText();
			try
			{
				String str="delete from customer where id_number='"+id+"'";
				String str2="update rooms set room_available='Available' where room_number='"+room+"'";
				
				DatabaseConnection conn=new DatabaseConnection ();
				conn.state.executeUpdate(str);
				conn.state.executeUpdate(str2);
				
				JOptionPane.showMessageDialog(null, "Check Out Done");
				new Reception().setVisible(true);
				this.setVisible(false);
			}catch(Exception e) {}
		}else if(ae.getSource()==back)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String[] args)
	{
		new CheckOut();

	}

}
