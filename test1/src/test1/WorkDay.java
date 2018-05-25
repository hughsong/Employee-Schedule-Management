package test1;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkDay {
	private String day;
	private int num;
	private String shift;
	private ArrayList emp;
	
	
	public WorkDay(String day, int num) {
		this.day = day;
		this.num = num;
		this.shift = shift;
		emp = new ArrayList();
	}
	
	public void addEmp(String name, String position) {
		emp.add(name+"  "+position);
		//test
		//System.out.print(name+"  "+position+", ");
	}
	
	public String getDay() {
		return day;
	}
	
	
	public ArrayList getemp() {
		/*
		for(int i = 0; i< emp.size();i++) {
			System.out.print(emp.get(i));
		}
		*/
		return emp;
	}

}
