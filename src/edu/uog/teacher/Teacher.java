package edu.uog.teacher;

import edu.uog.person.Person;

public class Teacher extends Person{
	
	public static String csvFile="D:\\Hamza 4th semester\\Teacher.csv";
	
	
	private int Teacher_ID;

	public int getTeacher_ID() {
		return Teacher_ID;
	}

	public void setTeacher_ID(int teacher_ID) {
		Teacher_ID = teacher_ID;
	} 
	
public String toString() {
		
		String str=null;
		
		str="" + this.Teacher_ID;
				
		return str;
	}
	

}
