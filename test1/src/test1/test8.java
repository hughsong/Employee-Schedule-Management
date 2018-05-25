package test1;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class test8 {
	

	public static void main(String[] args) {
		/*
		Vector<Vector> v1;
		Vector<Integer> v2;
		v1 = new Vector<Vector>();
		v2 = new Vector<Integer>();
		
		v2.add(4);
		v2.add(6);
		v1.add(v2);
		
		int temp = (int)v1.get(0).get(0);
		
		System.out.println(temp);
		
		System.out.println(temp+5);
		
		HashMap<String, String> info = new HashMap<String, String>();
		info.put("monM", "y");
		info.put("monN", "y");
		System.out.println(info.get("monM"));
		*/
		Random randomGenerator = new Random();
		
		for(int i =8; i>0;i--) {
			int index = randomGenerator.nextInt(5);
			System.out.println(index);
		}
		
		
		
		 

	}
	
	

}
