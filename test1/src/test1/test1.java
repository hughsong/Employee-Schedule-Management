package test1;

import java.sql.*;  
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class test1 extends JFrame implements ActionListener{

	
	JPanel jp1 = null,jp = null;
	JButton jb1 = null ,jb2 = null,jb3 = null, jb4 = null,jb5 = null,jb6 = null;
	JTable jt = null,jt2 = null;
	JScrollPane jsp =null, jsp2 = null;
	EmpModel em = null;
	Available_Calendar_M ac_m = null;
	Available_Calendar_N ac_n = null;
	Schedule_M s_m = null;
	Schedule_N s_n = null;
	ADD_Modi am = null;
	boolean flag1 = true;
	boolean flag2 = true;
	int page = 1;
	Confirm_Num c_n = null;
	ArrayList<WorkDay> work = null; 
	
	public test1() {
	
		em = new EmpModel();
		
		jt = new JTable(em);
		jt2 = new JTable();
		
		jsp = new JScrollPane(jt);
		jsp2 = new JScrollPane(jt2);
		
		jp = new JPanel();
		jp1 = new JPanel();
	
		
		jb1 = new JButton("New");
		jb2 = new JButton("Modify");
		jb3 = new JButton("Delete");
		
		jb4 = new JButton("1");
		jb5 = new JButton("2");
		jb6 = new JButton("3");
		
		//add listeners to the buttons
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		//ADD Buttons to the panel
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp1.add(jb4);
		jp1.add(jb5);
		jp1.add(jb6);
		//add components on frame
		this.add(jp1);
		this.add(jsp);
		this.add(jsp2);
		this.setTitle("Employee Imformation");
		this.add(jp);
		
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);  
	}

	public static void main(String[] args) {
		
		test1 my_test = new test1();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb4 && page ==1){
			
		}else {
			if(arg0.getSource()==jb1)
			{
				am = new ADD_Modi(this, "Add new Employee", true,null);
				em = new EmpModel();
				jt.setModel(em);
			}else if(arg0.getSource()==jb3)
			{
				int rowNum = jt.getSelectedRow();
				String name = (String)em.getValueAt(rowNum, 0);
				em.delete(name);
				em = new EmpModel();
				jt.setModel(em);
			}else if(arg0.getSource()==jb2)
			{
				if(jb2.getText()=="Modify") {
					int rowNum = jt.getSelectedRow();
					String Name = (String)em.getValueAt(rowNum, 0);	
					am = new ADD_Modi(this, "Modify "+Name+"'s info", true,Name);
					em = new EmpModel();
					jt.setModel(em);
				}else {
					c_n = new Confirm_Num(this, "Comfirm How many people work each day", true);
					Filter_Emp fe = new Filter_Emp();
					work = fe.autoArrange();
					s_m = new Schedule_M(work);
					jt.setModel(s_m);
				}
				//Click 1
			}else if(arg0.getSource()==jb4) {
				try {
					
					jsp2.setVisible(false);
					jb1.setVisible(true);
					jb2.setVisible(true);
					jb3.setVisible(true);
				}finally {
					em = new EmpModel();
					jt.setModel(em);
					jt2 = new JTable();
					jb2.setText("Modify");
					page = 1;
				}
				//Click 2
			}else if(arg0.getSource()==jb5) {
				try {
					
					jsp2.setVisible(true);
					jb1.setVisible(false);
					jb2.setVisible(false);
					jb3.setVisible(false);
				}finally {
					ac_n = new Available_Calendar_N();
					ac_m = new Available_Calendar_M();
					jt.setModel(ac_m);
					jt2.setModel(ac_n);
					flag1 = false;
					page = 2;
				}
				
				//Click 3
			}else if(arg0.getSource()==jb6) {
				try {
					
					jsp2.setVisible(false);
					jb1.setVisible(false);
					jb2.setVisible(true);
					jb3.setVisible(false);
				}finally {
					jb2.setText("Confirm_Num");
					page = 3;
				}
			}
		}
	}

}
