package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class Schedule_M extends AbstractTableModel{
	Vector rowData, columnNames,items;
	ArrayList<WorkDay> work = null;

	
	public void show() {
		for (int i = 0; i < work.size(); i++) {
			int counter = 0;
			WorkDay tmp;
			ArrayList tmp2;
			items = new Vector();
			tmp = work.get(i);
			tmp2 = tmp.getemp();
			
			items.add(tmp.getDay());
			for (int j = 0; j < tmp2.size(); j++) {
				items.add((String)tmp2.get(j));
				System.out.print(tmp2.get(j)+" ");
				counter++;
				
			}
			
			if(counter == 6) {
				items.add(" ");
				items.add(" ");
			}else if(counter == 7) {
				items.add(" ");
			}else if(counter == 5) {
				items.add(" ");
				items.add(" ");
				items.add(" ");
			}
			System.out.println();
			rowData.add(items);
		}
		/*
		for(int i = 0; i<rowData.size();i++) {
			Vector tmp =(Vector)rowData.get(i);
			for(int j = 0; j<tmp.size();j++) {
				System.out.print(tmp.get(i)+" ");
				
				
			}
			System.out.println();
			
		}
		*/

		
	}
	
	public Schedule_M(ArrayList<WorkDay> work) {
		this.work = work;
		/*
		columnNames = new Vector();
		columnNames.add("Name");
		columnNames.add("Monday Morning");
		columnNames.add("Wednesday Morning");
		columnNames.add("Tuseday Morning");
		columnNames.add("Friday Morning");
		columnNames.add("Saturday Morning");
		columnNames.add("Sunday Morning");
		*/
		rowData = new Vector();
		show();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
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

	

	
}

