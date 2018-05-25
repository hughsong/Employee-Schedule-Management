package test1;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ADD_Modi extends JDialog implements ActionListener {
	
	JLabel jl1, jl2, jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16;;
	JButton jb1, jb2;
	JTextField jtf1, jtf2, jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11,jtf12,jtf13,jtf14,jtf15,jtf16;
	JPanel jp1,jp2,jp3;
	String title;
	String name;

	public ADD_Modi(Frame arg0, String arg1, boolean arg2, String name) {
		super(arg0, arg1, arg2);
		this.name = name;
		title = arg1;
		jl1 = new JLabel("Name");
		jl2 = new JLabel("Times");
		jl3 = new JLabel("Level");
		jl4 = new JLabel("Proficiency");
		jl5= new JLabel("Monday Morning");
		jl6 = new JLabel("Monday Night");
		jl7 = new JLabel("Wednesday Morning");
		jl8 = new JLabel("Wednesday Night");
		jl9 = new JLabel("Thusday Morning");
		jl10 = new JLabel("Thusday Night");
		jl11 = new JLabel("Friday Morning");
		jl12 = new JLabel("Friday Night");
		jl13 = new JLabel("Saturday Morning");
		jl14 = new JLabel("Saturday Night");
		jl15 = new JLabel("Sunday Morning");
		jl16 = new JLabel("Sunday Night");
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		jtf6 = new JTextField();
		jtf7 = new JTextField();
		jtf8 = new JTextField();
		jtf9 = new JTextField();
		jtf10 = new JTextField();
		jtf11 = new JTextField();
		jtf12 = new JTextField();
		jtf13 = new JTextField();
		jtf14 = new JTextField();
		jtf15 = new JTextField();
		jtf16 = new JTextField();
		
		if(name!=null) {

			find(name);
		}
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jb1 = new JButton("Commit");
		jb2 = new JButton("Cancel");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jp1.setLayout(new GridLayout(16,1));
		jp2.setLayout(new GridLayout(16,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp1.add(jl8);
		jp1.add(jl9);
		jp1.add(jl10);
		jp1.add(jl11);
		jp1.add(jl12);
		jp1.add(jl13);
		jp1.add(jl14);
		jp1.add(jl15);
		jp1.add(jl16);
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		jp2.add(jtf8);
		jp2.add(jtf9);
		jp2.add(jtf10);
		jp2.add(jtf11);
		jp2.add(jtf12);
		jp2.add(jtf13);
		jp2.add(jtf14);
		jp2.add(jtf15);
		jp2.add(jtf16);
		jp3.add(jb1);
		this.add(jp1,"West");
		this.add(jp2,"Center");
		this.add(jp3,"South");
		this.setSize(300,600);
		this.setVisible(true);
	}
	
	public void find(String name) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee where Name = '"+name+"'"); 
			while(rs.next()) {
				jtf1.setText(rs.getString(1));
				jtf2.setText(Integer.toString(rs.getInt(2)));
				jtf3.setText(rs.getString(3));
				jtf4.setText(Integer.toString(rs.getInt(4)));
				jtf5.setText(rs.getString(5));
				jtf6.setText(rs.getString(6));
				jtf7.setText(rs.getString(7));
				jtf8.setText(rs.getString(8));
				jtf9.setText(rs.getString(9));
				jtf10.setText(rs.getString(10));
				jtf11.setText(rs.getString(11));
				jtf12.setText(rs.getString(12));
				jtf13.setText(rs.getString(13));
				jtf14.setText(rs.getString(14));
				jtf15.setText(rs.getString(15));
				jtf16.setText(rs.getString(16));
				
			}
			rs.close();
			stmt.close();
			con.close();  
		}catch(Exception e){ System.out.println(e);}
	}
	public void add() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:4000/test1","root","721015");  
				Statement stmt=con.createStatement();  
				String tmp = "INSERT INTO Employee VALUES('"
				+jtf1.getText()
				+"',"+ jtf2.getText()
				+",'"+ jtf3.getText()
				+"',"+ jtf4.getText()
				+",'"+ jtf5.getText()
				+"','"+ jtf6.getText()
				+"','"+ jtf7.getText()
				+"','"+ jtf8.getText()
				+"','"+ jtf9.getText()
				+"','"+ jtf10.getText()
				+"','"+ jtf11.getText()
				+"','"+ jtf12.getText()
				+"','"+ jtf13.getText()
				+"','"+ jtf14.getText()
				+"','"+ jtf15.getText()
				+"','"+ jtf16.getText()
				+"')";
				System.out.println(tmp);
				PreparedStatement pstmt = con.prepareStatement(tmp);
				pstmt.executeUpdate();
				this.dispose();
				 
			}catch(Exception e){ System.out.println(e);}  
		}
	
	public void modify() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();  
			String tmp ="UPDATE employee \n SET "
					+"Times = "+ jtf2.getText()
					+", Level= '"+ jtf3.getText()
					+"', Proficiency= "+ jtf4.getText()
					+", MonM='"+ jtf5.getText()
					+"', MonN='"+ jtf6.getText()
					+"', WesM='"+ jtf7.getText()
					+"',WesN='"+ jtf8.getText()
					+"',TusM='"+ jtf9.getText()
					+"',TusN='"+ jtf10.getText()
					+"',FriM='"+ jtf11.getText()
					+"',FriN='"+ jtf12.getText()
					+"',SatM='"+ jtf13.getText()
					+"',SatN='"+ jtf14.getText()
					+"',SunM='"+ jtf15.getText()
					+"',SunN='"+ jtf16.getText()
					+"' \nWHERE Name ='"+name+"';";
			
			System.out.println(tmp);
			PreparedStatement pstmt = con.prepareStatement(tmp);
			pstmt.executeUpdate();
			this.dispose();
			 
		}catch(Exception e){ System.out.println(e);}  
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1) {
			if(title.equals("Add new Employee")) {
				add();
			}else {
				 modify();
			}
			
		}else if(arg0.getSource()==jb2) {
			this.dispose();
		}
		
		
	}

}
