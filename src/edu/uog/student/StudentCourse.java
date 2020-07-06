package edu.uog.student;

import edu.uog.course.Course;

public class StudentCourse {
	
	public static String csvFile="D:\\Hamza 4th semester\\StudentCourse.csv";
	
	private int StudentCOURSE_ID;
	
	  private Course COURSE_ID;
	  
	  private Student STUDENT_ID;
	  
	  private String SECTION;
	  
	public int getStudentCOURSE_ID() {
		return StudentCOURSE_ID;
	}
	public void setStudentCOURSE_ID(int studentCOURSE_ID) {
		StudentCOURSE_ID = studentCOURSE_ID;
	}
	public Course getCOURSE_ID() {
		return COURSE_ID;
	}
	public void setCOURSE_ID(Course cOURSE_ID) {
		COURSE_ID = cOURSE_ID;
	}
	public Student getSTUDENT_ID() {
		return STUDENT_ID;
	}
	public void setSTUDENT_ID(Student sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	public String getSECTION() {
		return SECTION;
	}
	public void setSECTION(String sECTION) {
		SECTION = sECTION;
	}
	public String toString()
	{
		 String str=null;
		 str= this.COURSE_ID.getCOURSE_ID()+","+this.STUDENT_ID.getPERSON_ID()+","+this.SECTION;
		     
				 return str;
	}

	}