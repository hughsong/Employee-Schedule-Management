package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Filter_Emp {
	
	private ArrayList<Employee> emp;
	
	private ArrayList<WorkDay> work;
	
	private Random randomGenerator;
	
	private int[] num;
	
	
	public Filter_Emp() {
		randomGenerator = new Random();
		emp = new ArrayList<Employee>();
		work = new ArrayList<WorkDay>();
		num = new int[12];
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from employee"); 
			while(rs.next()) {
				Employee temp = new Employee(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
						rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));
				emp.add(temp);
			}
			rs.close();
			stmt.close();
			con.close();  
		}catch(Exception e){ System.out.println(e);}
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:4000/test1","root","721015");  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Work_Num"); 
			int counter = 0;
			while(rs.next()) {
				num[counter] = rs.getInt(3);
				counter++;
				num[counter] = rs.getInt(4);
				counter++;
			}
			rs.close();
			stmt.close();
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}
		
	}
	//find employees who is available in particular day
	public ArrayList findAvailableEmp(ArrayList<Employee> emp, String day){
		ArrayList<Employee> tmp = new ArrayList<Employee>();
		Employee tmp2;
		for (int i = 0; i < emp.size(); i++) {
			tmp2 = emp.get(i);
			if(tmp2.check(day)) {
				tmp.add(tmp2);
			}
		}
		return tmp;
	}
	
	//find one casher from those available employees
	public int findCasher(ArrayList<Employee> emp) {
		ArrayList tmp = new ArrayList();
		Employee tmp2;
		for (int i = 0; i < emp.size(); i++) {
			tmp2 = emp.get(i);
			if(tmp2.getLevel().equalsIgnoreCase("A")||tmp2.getLevel().equalsIgnoreCase("B")) {
				tmp.add(i);
			}
		}
		
		if(tmp.size()==0) {
			for (int i = 0; i < emp.size(); i++) {
				tmp2 = emp.get(i);
				if(tmp2.getLevel().equalsIgnoreCase("S")) {
					tmp.add(i);
				}
			}
		}
		
		if(tmp.size()>1) {
			int index = randomGenerator.nextInt(tmp.size());

			return (int)tmp.get(index);
		}else {
			return (int)tmp.get(0);
		}
	}
	
	//dai wei
	public int findUsher(ArrayList<Employee> emp) {
		ArrayList tmp = new ArrayList();
		Employee tmp2;
		for (int i = 0; i < emp.size(); i++) {
			tmp2 = emp.get(i);
			if(tmp2.getLevel().equalsIgnoreCase("S")||tmp2.getLevel().equalsIgnoreCase("A")||tmp2.getLevel().equalsIgnoreCase("C")) {
				tmp.add(i);
			}
		}
		
		if(tmp.size()>1) {
			int index = randomGenerator.nextInt(tmp.size());
			
			return (int)tmp.get(index);
		}else if(tmp.size()==1){
			return (int)tmp.get(0);
		}else {
			return -1;
		}
		
	}
	//ji dong
	public int findMoti(ArrayList<Employee> emp, int num) {
		ArrayList tmp = new ArrayList();
		Employee tmp2;
		for (int i = 0; i < emp.size(); i++) {
			tmp2 = emp.get(i);
			if(tmp2.getLevel().equalsIgnoreCase("S")) {
				return i;
			}
			if(tmp2.getProficiency()>=num) {
				tmp.add(i);
			}
		}
		
		if(tmp.size()>1) {
			int index = randomGenerator.nextInt(tmp.size());
			return (int)tmp.get(index);
		}else {
			return (int)tmp.get(0);
		}
	}
	
	//dian
	public int findOrder(ArrayList<Employee> emp) {
		ArrayList tmp = new ArrayList();
		Employee tmp2;
		for (int i = 0; i < emp.size(); i++) {
			tmp2 = emp.get(i);
			if(tmp2.getProficiency()>=40) {
				tmp.add(i);
			}
		}
		
		if(tmp.size()>1) {
			int index = randomGenerator.nextInt(tmp.size());
			return (int)tmp.get(index);
		}else {
			return (int)tmp.get(0);
		}
		
	}
	
	//shang
	public int findBus(ArrayList<Employee> emp) {
		ArrayList tmp = new ArrayList();
		Employee tmp2;
		for (int i = 0; i < emp.size(); i++) {
			tmp2 = emp.get(i);
			if(tmp2.getProficiency()>=30) {
				tmp.add(i);
			}
		}
		
		if(tmp.size()>1) {
			int index = randomGenerator.nextInt(tmp.size());
			return (int)tmp.get(index);
		}else {
			return (int)tmp.get(0);
		}
		
	}
	//zhuo
	public int findTB(ArrayList<Employee> emp) {
		
			int index = randomGenerator.nextInt(emp.size());
			
			return index;
		
	}
	
	public void filter(String day,int num) {
		ArrayList<Employee> tmp = new ArrayList<Employee>();
		WorkDay tmp2 = new WorkDay(day,num);
		int index;
		tmp = findAvailableEmp(emp,day);
		index = findCasher(tmp);
		tmp2.addEmp(tmp.get(index).getName(), "$");
		tmp.remove(index);
		index = findUsher(tmp);
		if(index!=-1) {
			tmp2.addEmp(tmp.get(index).getName(), "^");
			tmp.remove(index);
		}else {
			JOptionPane.showMessageDialog(null, day + " do not have Usher, please check employee availble time.");
		}
		
		if(num ==6) {
			index = findMoti(tmp,60);
			tmp2.addEmp(tmp.get(index).getName(), "*");
			tmp.remove(index);
		}else if(num == 7){
			index = findMoti(tmp,60);
			tmp2.addEmp(tmp.get(index).getName(), "*D");
			tmp.remove(index);
			
			index = findMoti(tmp,60);
			tmp2.addEmp(tmp.get(index).getName(), "*T");
			tmp.remove(index);
		}else if(num == 8) {
			index = findMoti(tmp,70);
			tmp2.addEmp(tmp.get(index).getName(), "*");
			tmp.remove(index);
			
			index = findMoti(tmp,60);
			tmp2.addEmp(tmp.get(index).getName(), "*D");
			tmp.remove(index);
			
			index = findMoti(tmp,60);
			tmp2.addEmp(tmp.get(index).getName(), "*T");
			tmp.remove(index);
		}
		
		index = findOrder(tmp);
		tmp2.addEmp(tmp.get(index).getName(), "O");
		tmp.remove(index);
		
		index = findBus(tmp);
		tmp2.addEmp(tmp.get(index).getName(), "D");
		tmp.remove(index);
		
		index = findTB(tmp);
		tmp2.addEmp(tmp.get(index).getName(), "T");
		tmp.remove(index);
		//test
		//System.out.println();
		work.add(tmp2);
	}
	
	public ArrayList<WorkDay> autoArrange(){
		filter("MonM",num[0]);
		filter("MonN",num[1]);
		filter("WesM",num[2]);
		filter("WesN",num[3]);
		filter("ThuM",num[4]);
		filter("ThuN",num[5]);
		filter("FriM",num[6]);
		filter("FriN",num[7]);
		filter("SatM",num[8]);
		filter("SatN",num[9]);
		filter("SunM",num[10]);
		filter("SunN",num[11]);
		System.out.println(work.size());
		
		return work;
	}
	

}
