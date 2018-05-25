package test1;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Confirm_Num extends JDialog implements ActionListener{
	JLabel jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16;
	JButton jb1, jb2;
	JTextField jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11,jtf12,jtf13,jtf14,jtf15,jtf16;
	JPanel jp1,jp2,jp3;
	String title;
	Vector<Vector> day;
	Vector shift;
	ArrayList workers = null;
	int[] newList = new int[12];	
	
	public Confirm_Num(Frame arg0, String arg1, boolean arg2) {
		super(arg0, arg1, arg2);
		day = new Vector<Vector>();
		workers = new ArrayList();
		title = arg1;
		jl5= new JLabel("Monday Morning");
		jl6 = new JLabel("Monday Night");
		jl7 = new JLabel("Wednesday Morning");
		jl8 = new JLabel("Wednesday Night");
		jl9 = new JLabel("Tuseday Morning");
		jl10 = new JLabel("Tuseday Night");
		jl11 = new JLabel("Friday Morning");
		jl12 = new JLabel("Friday Night");
		jl13 = new JLabel("Saturday Morning");
		jl14 = new JLabel("Saturday Night");
		jl15 = new JLabel("Sunday Morning");
		jl16 = new JLabel("Sunday Night");
		
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
		
		getInfo();
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jb1 = new JButton("Commit");
		jb2 = new JButton("Cancel");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jp1.setLayout(new GridLayout(12,1));
		jp2.setLayout(new GridLayout(12,1));

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

	public void getInfo() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Work_Num"); 
			while(rs.next()) {
				shift = new Vector();
				shift.add(rs.getInt(3));
				shift.add(rs.getInt(4));
				shift.add(rs.getString(2));
				day.add(shift);
			}
			rs.close();
			stmt.close();
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}
		jtf5.setText(Integer.toString((int)day.get(0).get(0)));	
		jtf6.setText(Integer.toString((int)day.get(0).get(1)));
		jtf7.setText(Integer.toString((int)day.get(1).get(0)));
		jtf8.setText(Integer.toString((int)day.get(1).get(1)));
		jtf9.setText(Integer.toString((int)day.get(2).get(0)));
		jtf10.setText(Integer.toString((int)day.get(2).get(1)));
		jtf11.setText(Integer.toString((int)day.get(3).get(0)));
		jtf12.setText(Integer.toString((int)day.get(3).get(1)));
		jtf13.setText(Integer.toString((int)day.get(4).get(0)));
		jtf14.setText(Integer.toString((int)day.get(4).get(1)));
		jtf15.setText(Integer.toString((int)day.get(5).get(0)));
		jtf16.setText(Integer.toString((int)day.get(5).get(1)));
	}
	
	public void getAllWorker() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Employee"); 
			
			//get all of employee info from db and save in object
			while(rs.next()) {
				Employee temp = new Employee(rs.getString(1),(int)rs.getInt(2),rs.getString(3),
						(int)rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
						rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),
						rs.getString(16));
				workers.add(temp);
			}
			rs.close();
			stmt.close();
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	
	public void deleteTable() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();  
			String tmp ="DROP TABLE Work_Num;";
			System.out.println(tmp);
			PreparedStatement pstmt = con.prepareStatement(tmp);
			pstmt.executeUpdate();
			this.dispose();
			 
		}catch(Exception e){ System.out.println(e);}  
		
	}

	public void createTable() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();  
			String tmp ="CREATE TABLE IF NOT EXISTS Work_Num( \r\n"
					+"Id INTEGER(8) NOT NULL PRIMARY KEY,\r\n"
					+"Day VARCHAR(60) NOT NULL, \r\n"
					+"Morning INTEGER(8) NOT NULL,\r\n" 
					+"Night INTEGER(8) NOT NULL\r\n" 
					+");\n";
			System.out.println(tmp);
			PreparedStatement pstmt = con.prepareStatement(tmp);
			pstmt.executeUpdate();
			this.dispose();
			 
		}catch(Exception e){ System.out.println(e);}  
	}

	public void conndb(String command) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();  
			String tmp =command;
			System.out.println(tmp);
			PreparedStatement pstmt = con.prepareStatement(tmp);
			pstmt.executeUpdate();
			this.dispose();
			 
		}catch(Exception e){ System.out.println(e);}  
	}
	public void modify() {	
		conndb("INSERT INTO Work_Num VALUES( 1,'Mon',"+jtf5.getText()+","+jtf6.getText()+");");
		conndb("INSERT INTO Work_Num VALUES( 2,'Wed',"+jtf7.getText()+","+jtf8.getText()+");");
		conndb("INSERT INTO Work_Num VALUES( 3,'Thu',"+jtf9.getText()+","+jtf10.getText()+");");
		conndb("INSERT INTO Work_Num VALUES( 4,'Fri',"+jtf11.getText()+","+jtf12.getText()+");");
		conndb("INSERT INTO Work_Num VALUES( 5,'Sat',"+jtf13.getText()+","+jtf14.getText()+");");
		conndb("INSERT INTO Work_Num VALUES( 6,'Sun',"+jtf15.getText()+","+jtf16.getText()+");");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1) {
			deleteTable();
			createTable();
			modify();
		}
	}
	
	

}
