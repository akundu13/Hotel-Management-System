package hotel.management;

import java.awt.Color;
import java.awt.Image;

import java.awt.event.*;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

import javax.swing.*;
/*import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;*/

public class Reception extends JFrame implements ActionListener{

	JButton new_customer,room,department,employee_info,customer_info,manager_info,check_out,update_check,update_room,pick_up,search_room,log_out;
	public Reception()
	{
		setLayout(null);
		setBounds(340,200,900,600);
		setTitle("Reception");
		getContentPane().setBackground(Color.white);
	
		
		//Set New Customer Form Button
		new_customer=new JButton("New Customer Form");
		new_customer.setBackground(Color.black);
		new_customer.setForeground(Color.white);
		new_customer.setBounds(40,40,150,30);
		add(new_customer);
		
		new_customer.addActionListener(this);
		
		//Set Room Button
		room=new JButton("Room");
		room.setBackground(Color.black);
		room.setForeground(Color.white);
		room.setBounds(40,80,150,30);
		add(room);
		
		room.addActionListener(this);
		
		//Set Department Button
		department=new JButton("Department");
		department.setBackground(Color.black);
		department.setForeground(Color.white);
		department.setBounds(40,120,150,30);
		add(department);
		
		department.addActionListener(this);
		
		//Set All Employee Info Button
		employee_info=new JButton("All Employee Info");
		employee_info.setBackground(Color.black);
		employee_info.setForeground(Color.white);
		employee_info.setBounds(40,160,150,30);
		add(employee_info);
		
		employee_info.addActionListener(this);
		
		//Set Customer Info Button
		customer_info=new JButton("Customer Info");
		customer_info.setBackground(Color.black);
		customer_info.setForeground(Color.white);
		customer_info.setBounds(40,200,150,30);
		add(customer_info);
		
		customer_info.addActionListener(this);
		
		//Set Customer Info Button
		manager_info=new JButton("Manager Info");
		manager_info.setBackground(Color.black);
		manager_info.setForeground(Color.white);
		manager_info.setBounds(40,240,150,30);
		add(manager_info);
		
		manager_info.addActionListener(this);
		
		//Set Check Out Button
		check_out=new JButton("Check Out");
		check_out.setBackground(Color.black);
		check_out.setForeground(Color.white);
		check_out.setBounds(40,280,150,30);
		add(check_out);
		
		check_out.addActionListener(this);
		
		//Set Update Check Status Button
		update_check=new JButton("Update Check In");
		update_check.setBackground(Color.black);
		update_check.setForeground(Color.white);
		update_check.setBounds(40,320,150,30);
		add(update_check);
		
		update_check.addActionListener(this);
		
		//Set Update Room Status Button
		update_room=new JButton("Update Room Status");
		update_room.setBackground(Color.black);
		update_room.setForeground(Color.white);
		update_room.setBounds(40,360,150,30);
		add(update_room);
		
		update_room.addActionListener(this);
		
		//Set Pick Up Service Button
		pick_up=new JButton("Pick Up Service ");
		pick_up.setBackground(Color.black);
		pick_up.setForeground(Color.white);
		pick_up.setBounds(40,400,150,30);
		add(pick_up);
		
		pick_up.addActionListener(this);
				
		//Set Search Room Button
		search_room=new JButton("Search Room ");
		search_room.setBackground(Color.black);
		search_room.setForeground(Color.white);
		search_room.setBounds(40,440,150,30);
		add(search_room);	
		
		search_room.addActionListener(this);
		
		//Set Log Out Button
		log_out=new JButton("Log Out ");
		log_out.setBackground(Color.black);
		log_out.setForeground(Color.white);
		log_out.setBounds(40,480,150,30);
		add(log_out);
		
		log_out.addActionListener(this);
		
		//Set Image
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/reception.jpg"));
		Image img1=img.getImage().getScaledInstance(600, 510, Image.SCALE_DEFAULT);
		ImageIcon recp_img=new ImageIcon(img1);
		JLabel repimg_label=new JLabel(recp_img);
		repimg_label.setBounds(240,20,600,510);
		add(repimg_label);
		
		
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==new_customer)
		{
			new AddCustomer().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==room)
		{
			new Room().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==department)
		{
			new Department().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==employee_info)
		{
			new EmployeeInfo().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==customer_info)
		{
			new CustomerInfo().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==manager_info)
		{
			new ManagerInfo().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==check_out)
		{
			new CheckOut().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==update_check)
		{
			new UpdateCheck().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==update_room)
		{
			new UpdateRoom().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==pick_up)
		{
			new PickUp().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==search_room)
		{
			new SearchRoom().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==log_out)
		{
			setVisible(false);
		}
		
		
	}

	public static void main(String[] args) {
		
		new Reception();
	}

}
