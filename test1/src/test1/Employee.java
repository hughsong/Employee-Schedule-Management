package test1;

import java.util.HashMap;

public class Employee {
	private String name;
	private int times;
	private String level;
	private int proficiency;
	private HashMap<String, String> info = new HashMap<String, String>();
	
	public Employee(String name, int times,String level,int proficiency,String monM,String monN,
			String wesM, String wesN,String thuM,String thuN,String friM,String friN,
			String satM,String satN,String sunM,String sunN){
		
		
		this.name = name;
		this.times = times;
		this.level = level;
		this.proficiency = proficiency;
		
		info.put("MonM", monM);
		info.put("MonN", monN);
		info.put("WesM", wesM);
		info.put("WesN", wesN);
		info.put("ThuM", thuM);
		info.put("ThuN", thuN);
		info.put("FriM", friM);
		info.put("FriN", friN);
		info.put("SatM", satM);
		info.put("SatN", satN);
		info.put("SunM", sunM);
		info.put("SunN", sunN);
		
	}
	 public String getName() {
		 return name;
	 }
	 
	 public int getTimes() {
		 return times;
	 }
	 
	 public String getLevel() {
		 return level;
	 }
	 
	 public int getProficiency() {
		 return proficiency;
	 }
	 
	 public boolean check(String day) {
		 if(info.get(day).equalsIgnoreCase("Y"))
			 return true;
		 else
			 return false;
	 }
	 
	
}
