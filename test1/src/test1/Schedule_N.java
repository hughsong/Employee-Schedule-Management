package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class Schedule_N extends AbstractTableModel{
Vector rowData, columnNames,items;
	
	public void show() {

		
	}
	
	public Schedule_N() {
		
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

