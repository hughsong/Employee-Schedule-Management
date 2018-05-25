package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class Available_Calendar_M extends AbstractTableModel{

	
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
				items.add(rs.getString(5));
				items.add(rs.getString(7));
				items.add(rs.getString(9));
				items.add(rs.getString(11));
				items.add(rs.getString(13));
				items.add(rs.getString(15));
				rowData.add(items);
			}
			rs.close();
			stmt.close();
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}
	
	public Available_Calendar_M() {
		
		columnNames = new Vector();
		columnNames.add("Name");
		columnNames.add("Monday Morning");
		columnNames.add("Wednesday Morning");
		columnNames.add("Tuseday Morning");
		columnNames.add("Friday Morning");
		columnNames.add("Saturday Morning");
		columnNames.add("Sunday Morning");
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

