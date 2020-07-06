package edu.uog.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import edu.uog.course.courseData;

public class studentCourseData {
	
	public static StudentCourse FindOne(int StudentCourse_ID){
		
		List<StudentCourse> studentscourses = new ArrayList<StudentCourse>();	
		String line;
		try {
		@SuppressWarnings("resource")
		BufferedReader bufferreader = new BufferedReader(new FileReader(StudentCourse.csvFile));
		
		while((line=bufferreader.readLine())!=null) {
			StudentCourse studentcourses = new StudentCourse();
			String[] rowstudent = line.split(",");
			
			if(Integer.parseInt(rowstudent[0]) == StudentCourse_ID ) 
			
			{
				studentcourses.setStudentCOURSE_ID(Integer.parseInt(rowstudent[0]));
				studentcourses.setSTUDENT_ID(studentData.findOne(Integer.parseInt(rowstudent[3])));
				studentcourses.setCOURSE_ID(courseData.findOne(Integer.parseInt(rowstudent[2])));
				studentcourses.setSECTION(rowstudent[4]);
				
			
			
			studentscourses.add(studentcourses);
			
			return studentcourses;
			}
			
			
		}
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return null;
	
	
}
	
	public static List<StudentCourse> FindAll(){
		List<StudentCourse> studentscourses= new ArrayList<StudentCourse>();
		String line ;
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while((line=bufferedReader.readLine()) != null) {
				StudentCourse studentcourse = new StudentCourse();
				String[] rowstudent = line.split(",");
				studentcourse.setStudentCOURSE_ID(Integer.parseInt(rowstudent[0]));
				studentcourse.setSTUDENT_ID(studentData.findOne(Integer.parseInt(rowstudent[1])));
				studentcourse.setSECTION(rowstudent[2]);
				studentcourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(rowstudent[3])));
				//setCOURSE_REQUISITIES(CourseData.FindOne(Integer.parseInt(rowstudent[4])));
				
				studentscourses.add(studentcourse);
			}
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return studentscourses;
	}

	public static List<StudentCourse> Search(String search){
		List<StudentCourse> studentscourses= new ArrayList<StudentCourse>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while((line=bufferedReader.readLine())!=null) {
				StudentCourse studentcourse = new StudentCourse();
				String[] rowstudent = line.split(",");
				
				studentcourse.setStudentCOURSE_ID(Integer.parseInt(rowstudent[0]));
				studentcourse.setSTUDENT_ID(studentData.findOne(Integer.parseInt(rowstudent[1])));
				studentcourse.setSECTION(rowstudent[2]);
				studentcourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(rowstudent[3])));
				//studentcourse.setCOURSE_REQUISITIES(CourseData.FindOne(Integer.parseInt(rowstudent[4])));
				
				
				
				studentscourses.add(studentcourse);
				}
				//return rooms;
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return studentscourses;
	}

	public static StudentCourse Save(StudentCourse student) {
		
		FileWriter filewriter;
		List<StudentCourse> studentscourses = FindAll();
		
		try {
			filewriter = new FileWriter(StudentCourse.csvFile);
			
			for(int i=0;i<studentscourses.size();i++) {
				filewriter.append(studentscourses.get(i).toString());
				filewriter.append("\n");
			}
			
			
			if(studentscourses.size()>0) {
				student.setStudentCOURSE_ID(studentscourses.get(studentscourses.size()-1).getStudentCOURSE_ID()+1);
			}
			else {
				student.setStudentCOURSE_ID(1);
			}
			studentscourses.add(student);
				filewriter.append(student.toString());
				filewriter.append("\n");
				filewriter.flush();
				filewriter.close();
			
			
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return student;
	}

public static StudentCourse DelOne(int StudentCOurse_ID) {
		
		FileWriter filewriter;
		List<StudentCourse> persons = FindAll();
		StudentCourse studentcourse = studentCourseData.FindOne(StudentCOurse_ID);
		
		try {
			filewriter = new FileWriter(StudentCourse.csvFile);
			
			for(int i=0;i<persons.size();i++) {
				if(persons.get(i).getStudentCOURSE_ID()!=StudentCOurse_ID) {
				filewriter.append(persons.get(i).toString());
				filewriter.append("\n");
				}
			}
			
			persons.add(studentcourse);
				
				filewriter.flush();
				filewriter.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return studentcourse;
	}

}
