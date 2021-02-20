package hotel.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCheck extends JFrame implements ActionListener
{
	JTextField room_text,name_text,check_text,amount_text,pending_text;
	JComboBox cus_id;
	JButton check,update,back;
	public UpdateCheck()
	{
		setLayout(null);
		setTitle("Update Check In");
		setBounds(300,250,950,460);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);	
		
		//Set Check In Label
		JLabel label=new JLabel("Check In Details");
		label.setBounds(70,25,300,30);
		label.setForeground(Color.blue);
		label.setFont(new Font("Bookman Old Style",Font.HANGING_BASELINE,35));
		add(label);
		
		//Set Customer ID
		JLabel customer_id=new JLabel("Customer ID");
		customer_id.setFont(new Font("tahoma",Font.BOLD,18));
		customer_id.setBounds(30,80,150,30);
		add(customer_id);
		
		cus_id=new JComboBox();
		
		try {
			DatabaseConnection conn =new DatabaseConnection();
			String str="select * from customer";
			ResultSet rs=conn.state.executeQuery(str);
			while(rs.next())
			{
				cus_id.addItem(rs.getString("id_number"));
			}
			
		}catch(Exception e) {}
		cus_id.setBounds(250,80,150,30);
		add(cus_id);
		
		//Set Room Number
		JLabel room_no=new JLabel("Room Number");
		room_no.setFont(new Font("tahoma",Font.BOLD,18));
		room_no.setBounds(30,120,150,30);
		add(room_no);
		
		room_text=new JTextField();
		room_text.setBounds(250,120,150,25);
		add(room_text);
		
		//Set Name
		JLabel name=new JLabel("Name");
		name.setFont(new Font("tahoma",Font.BOLD,18));
		name.setBounds(30,160,150,30);
		add(name);
		
		name_text=new JTextField();
		name_text.setBounds(250,160,150,25);
		add(name_text);
		
		//Set Check In
		JLabel check_in=new JLabel("Check In");
		check_in.setFont(new Font("tahoma",Font.BOLD,18));
		check_in.setBounds(30,200,150,30);
		add(check_in);
		
		check_text=new JTextField();
		check_text.setBounds(250,200,150,25);
		add(check_text);
		
		//Set Amount Paid
		JLabel amount_paid=new JLabel("Amount Paid");
		amount_paid.setFont(new Font("tahoma",Font.BOLD,18));
		amount_paid.setBounds(30,240,150,30);
		add(amount_paid);
		
		amount_text=new JTextField();
		amount_text.setBounds(250,240,150,25);
		add(amount_text);
		
		//Set Pending Amount 
		JLabel pending_amount=new JLabel("Pending Amount ");
		pending_amount.setFont(new Font("tahoma",Font.BOLD,18));
		pending_amount.setBounds(30,280,160,30);
		add(pending_amount);
		
		pending_text=new JTextField();
		pending_text.setBounds(250,280,150,25);
		add(pending_text);
		
		//Set Buttons
		check=new JButton("Check");
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.setBounds(35,350,100,30);
		add(check);
		
		check.addActionListener(this);
		
		update=new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setBounds(170,350,100,30);
		add(update);
		
		update.addActionListener(this);
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(300,350,100,30);
		add(back);
		
		back.addActionListener(this);
		
		//Set Check In & Out Image
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/Checkinout.jpg"));
		Image img1=img.getImage().getScaledInstance(450,350,Image.SCALE_DEFAULT);
		ImageIcon inout_img=new ImageIcon(img1);
		JLabel inout_label=new JLabel(inout_img);
		inout_label.setBounds(450,50,450,350);
		add(inout_label);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==check)
		{
			//fetching details
			
			String id=(String)cus_id.getSelectedItem();
			String room_no=null;
			String deposit=null;
			String price=null;
			int pending;
			try
			{
				DatabaseConnection conn=new DatabaseConnection();
				String str="select * from customer where id_number='"+id+"'";
				ResultSet rs=conn.state.executeQuery(str);
				while(rs.next())
				{
					room_text.setText(rs.getString("room_no"));
					room_no=rs.getString("room_no");
					name_text.setText(rs.getString("name"));
					check_text.setText(rs.getString("status"));
					amount_text.setText(rs.getString("deposit"));
					deposit=rs.getString("deposit");
					
				}
				String str2="select * from rooms where room_number='"+room_no+"'";
				ResultSet rs2=conn.state.executeQuery(str2);
				while(rs2.next())
				{
					price=rs2.getString("room_price");
					pending=Integer.parseInt(price)-Integer.parseInt(deposit);
					pending_text.setText(Integer.toString(pending));
				}
			}catch(Exception e) {}
		}else if(ae.getSource()==update)
		{
			try {
				DatabaseConnection conn=new DatabaseConnection();
			
				String id =(String) cus_id.getSelectedItem(); //id
				String room = room_text.getText(); //room_number;    
				String name = name_text.getText(); //name    
				String check = check_text.getText(); //status;    
				String amount= amount_text.getText(); //deposit    
			
				conn.state.executeUpdate("update customer set room_no ='"+room+"',name ='"+name+"',status ='"+check+"',deposit ='"+amount+"' where id_number ='"+id+"'");
                            
				JOptionPane.showMessageDialog(null, "Data Updated Successfully");
               
			}catch(Exception ee){}
			
			
		}else if(ae.getSource()==back)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main(String[] args)
	{
		new UpdateCheck();

	}

}
