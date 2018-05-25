package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Available_Calendar_N extends AbstractTableModel{

	
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
				items.add(rs.getString(6));
				items.add(rs.getString(8));
				items.add(rs.getString(10));
				items.add(rs.getString(12));
				items.add(rs.getString(14));
				items.add(rs.getString(16));
				rowData.add(items);
			}
			rs.close();
			stmt.close();
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}
	
	public Available_Calendar_N() {
		
		columnNames = new Vector();
		columnNames.add("Name");
		columnNames.add("Monday Night");
		columnNames.add("Wednesday Night");
		columnNames.add("Tuseday Night");
		columnNames.add("Friday Night");
		columnNames.add("Saturday Night");
		columnNames.add("Sunday Night");
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
		if(arg0 == 1) {
			return ((Vector)this.rowData.get(arg0)).get(arg1);
		}else {
			return ((Vector)this.rowData.get(arg0)).get(arg1);
		}
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}

	
}

