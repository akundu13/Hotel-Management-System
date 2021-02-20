package hotel.management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener
{
	JTextField id_no_text,name_text,nation_text,chek_text,depo_text;
	JButton add,back;
	JComboBox id_combo;
	JRadioButton male_radio,female_radio;
	Choice room_no_cho;
	

	
	public AddCustomer()
	{
		//Set Frame Size 
		setLayout(null);
		setTitle("Add Customer");
		setResizable(false);
		setBounds(340,200,900,500);
		getContentPane().setBackground(Color.WHITE);
		
		
		//Set Add Customer Label
		JLabel label=new JLabel("New Customer Form");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,30));
		label.setBounds(100,10,350,30);
		add(label);
		
		//Set Customer ID
		JLabel id=new JLabel("Customer ID");
		id.setForeground(Color.BLACK);
		id.setFont(new Font("tahoma",Font.BOLD,16));
		id.setBounds(30,60,150,30);
		add(id);
		
		id_combo=new JComboBox(new String[]{"Aadhaar Card","Voter-Id Card","Passport","Driving License"});
		id_combo.setBounds(270,60,150,25);
		id_combo.setBackground(Color.WHITE);
		add(id_combo);
		
		//Set ID Number
		JLabel num=new JLabel("ID Number");
		num.setForeground(Color.BLACK);
		num.setFont(new Font("tahoma",Font.BOLD,16));
		num.setBounds(30,100,150,30);
		add(num);
		
		id_no_text=new JTextField();
		id_no_text.setBounds(270,100,150,25);
		add(id_no_text);
		
		//Set Customer Name
		JLabel name=new JLabel("Customer Name");
		name.setForeground(Color.BLACK);
		name.setFont(new Font("tahoma",Font.BOLD,16));
		name.setBounds(30,140,150,30);
		add(name);
		
		name_text=new JTextField();
		name_text.setBounds(270,140,150,25);
		add(name_text);
		
		//Set Gender
		JLabel gender=new JLabel("Gender");
		gender.setForeground(Color.BLACK);
		gender.setFont(new Font("tahoma",Font.BOLD,16));
		gender.setBounds(30,180,150,30);
		add(gender);
		
		//Set ButtonGroup
		ButtonGroup bg=new ButtonGroup();
		bg.add(male_radio);
		bg.add(female_radio);
		
		male_radio=new JRadioButton("Male");
		male_radio.setBounds(270,180,70,25);
		male_radio.setBackground(Color.WHITE);
		add(male_radio);
		
		
		female_radio=new JRadioButton("Female");
		female_radio.setBounds(350,180,70,25);
		female_radio.setBackground(Color.WHITE);
		add(female_radio);
		
		//Set Nationality
		JLabel nationality=new JLabel("Nationality");
		nationality.setForeground(Color.BLACK);
		nationality.setFont(new Font("tahoma",Font.BOLD,16));
		nationality.setBounds(30,220,150,30);
		add(nationality);
		
		nation_text=new JTextField();
		nation_text.setBounds(270,220,150,25);
		add(nation_text);
		
		//Set Allocated Room Number
		JLabel room_no=new JLabel("Allocated Room Number");
		room_no.setForeground(Color.BLACK);
		room_no.setFont(new Font("tahoma",Font.BOLD,16));
		room_no.setBounds(30,260,200,30);
		add(room_no);
		
		
		room_no_cho=new Choice();
		try {
			DatabaseConnection conn=new DatabaseConnection ();
			String str="select * from rooms where room_available='Available'";
			ResultSet rs=conn.state.executeQuery(str);
			while(rs.next())
			{
				room_no_cho.add(rs.getString("room_number"));
			}
		}catch(Exception e) {}
		room_no_cho.setBounds(270,260,185,55);
		add(room_no_cho);
		
		//Set Check In
		JLabel check_in=new JLabel("Check In");
		check_in.setForeground(Color.BLACK);
		check_in.setFont(new Font("tahoma",Font.BOLD,16));
		check_in.setBounds(30,300,200,30);
		add(check_in);
		
		chek_text=new JTextField();
		chek_text.setBounds(270,300,150,25);
		add(chek_text);
		
		//Set Deposit
		JLabel deposit=new JLabel("Deposit");
		deposit.setForeground(Color.BLACK);
		deposit.setFont(new Font("tahoma",Font.BOLD,16));
		deposit.setBounds(30,340,200,30);
		add(deposit);
		
		
		depo_text=new JTextField();
		depo_text.setBounds(270,340,150,25);
		add(depo_text);
		
		
		//Set Buttons
		add=new JButton("Add");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setBounds(80,400,100,30);
		add(add);
		
		add.addActionListener(this);
		
		back=new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(250,400,100,30);
		add(back);
		
		back.addActionListener(this);
		
		//Set Customer Image
		ImageIcon img =new ImageIcon(ClassLoader.getSystemResource("hotel/management/pictures/customer.png"));
		Image img2=img.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
		ImageIcon customer=new ImageIcon(img2);
		JLabel customer_label=new JLabel(customer);
		customer_label.setBounds(450,30,400,400);
		add(customer_label);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			String id=(String)id_combo.getSelectedItem();
			String idnum=id_no_text.getText();					
		 	String name=name_text.getText();
		 	String gender=null;
		 	if(male_radio.isSelected())
		 	{
		 		gender="Male";
		 		female_radio.setSelected(false);
		 	}else if(female_radio.isSelected())
		 	{
		 		gender="Female";
		 		male_radio.setSelected(false);
		 	}
		 	String nation=nation_text.getText();
		 	String room=room_no_cho.getSelectedItem();
		 	String status=chek_text.getText();
		 	String deposit=depo_text.getText();
		 	
		 	try {
				DatabaseConnection conn=new DatabaseConnection ();
				String str="insert into customer values('"+id+"','"+idnum+"','"+name+"','"+gender+"','"+nation+"','"+room+"','"+status+"','"+deposit+"')";
				String str1="update rooms set room_available='Occupied' where room_number='"+room+"'";
				conn.state.executeUpdate(str);
				conn.state.executeUpdate(str1);
				
				JOptionPane.showMessageDialog(null,"New Customer Added");
				new Reception().setVisible(true);
				this.setVisible(false);
				
			}catch(Exception e) {System.out.println(e);}
			
		}else if(ae.getSource()==back)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) 
	{
		
		new AddCustomer();
	}

}
