package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class EmpModel extends AbstractTableModel{

	
	Vector rowData, columnNames,items;
	
	public void show() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from employee"); 
			while(rs.next()) {
				items = new Vector();
				items.add(rs.getString(1));
				items.add(rs.getInt(2));
				items.add(rs.getString(3));
				items.add(rs.getInt(4));
				rowData.add(items);
			}
			rs.close();
			stmt.close();
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}
	
	public void delete(String Name) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();  
			String tmp = "DELETE FROM employee " + 
					"WHERE Name='"+Name+"';";
			System.out.println(tmp);
			PreparedStatement pstmt = con.prepareStatement(tmp);
			pstmt.executeUpdate();
			 
		}catch(Exception e){ System.out.println(e);} 
		
	}
	public EmpModel() {
		
		columnNames = new Vector();
		columnNames.add("Name");
		columnNames.add("Times");
		columnNames.add("Level");
		columnNames.add("Proficiency");
		
		rowData = new Vector();
		show();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(arg0)).get(arg1);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}

	
}
