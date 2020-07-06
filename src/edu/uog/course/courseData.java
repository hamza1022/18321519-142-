package edu.uog.course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.course.Course;

public class courseData {
	@SuppressWarnings("resource")
	public  static List<Course> findAll() 
	{
	
		List<Course> courses = new ArrayList<Course>();
		String line;
		
		try {
		BufferedReader bufferreader = new BufferedReader(new FileReader(Course.csvFile ));
		
		while((line=bufferreader.readLine())!=null) {
			
			Course course = new Course();
			String[] courseRow = line.split(",");
			
			course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
			course.setCOURSE_CODE(courseRow[1]);
			course.setCOURSE_TITLE((courseRow[2]));
			course.setCOURSE_DESC((courseRow[3]));
			course.setCOURSE_CREDITHOUR(courseRow[4]);
			
		    //course.setCOUSRE_PREREQUIST(findOne(Integer.parseInt(courseRow[5])));
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
		
		return courses;
		
	}
	
	@SuppressWarnings("resource")
	public  static Course findOne(int course_ID) 
	{
	
		
		String line;
		
		try {

		BufferedReader bufferreader = new BufferedReader(new FileReader(Course.csvFile ));
		
		while((line=bufferreader.readLine())!=null) {
			
			Course course = new Course();
			String[] courseRow = line.split(",");
			
			if (Integer.parseInt(courseRow[0]) == course_ID) {
			
				course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
				course.setCOURSE_CODE(courseRow[1]);
				course.setCOURSE_TITLE((courseRow[2]));
				course.setCOURSE_DESC((courseRow[2]));
				course.setCOURSE_CREDITHOUR(courseRow[4]);
				//course.setCOURSEPRERQUIST_ID();
				

			
			return course;
			}
			
			
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
		
		return null;
		
	}
	@SuppressWarnings("resource")
	public static List<Course> search(String search) 
	{
		List<Course> courses = new ArrayList<Course>();
	
		
		String line;
		
		try {

		BufferedReader bufferreader = new BufferedReader(new FileReader(Course.csvFile));
		
		while((line=bufferreader.readLine())!=null) {
			
			Course course = new Course();
			String[] courseRow = line.split(",");
			
			if (courseRow[1].contains(search) == true) {
				course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
				course.setCOURSE_CODE(courseRow[1]);
				course.setCOURSE_TITLE((courseRow[2]));
				course.setCOURSE_DESC((courseRow[2]));
				course.setCOURSE_CREDITHOUR(courseRow[4]);
				//course.setCOURSEPRERQUIST_ID();
				
			courses.add(course);
			}
			
			
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
		
		return courses;
		

	

	}
	@SuppressWarnings("resource")
	public static Course Save(Course course) {
		
	    FileWriter filewriter;
		
		List <Course> courses =findAll();
		 

		try {
			filewriter=new FileWriter(Course.csvFile);
	
			
			for(int i=0;i<courses.size();i++) {
				filewriter.append(courses.get(i).toString());
				filewriter.append("\n");
				}
			if(courses.size()>0)
			course.setCOURSE_ID(courses.get(courses.size()-1).getCOURSE_ID()+1);
			else
				course.setCOURSE_ID(1);
			filewriter.append(course.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return course;
		
		
		
		
		
	}
	
	public static Course deleteOne(int course_ID) {
		FileWriter filewriter;

		List<Course> courses = findAll();
		Course course = findOne(course_ID);

		try {
			filewriter = new FileWriter(Course.csvFile);

			for (int i=0; i<courses.size(); i++) {
				if (courses.get(i).getCOURSE_ID() != course_ID) {
					filewriter.append(courses.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return course;
		
	}
}
	


