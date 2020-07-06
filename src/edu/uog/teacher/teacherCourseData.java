package edu.uog.teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import edu.uog.course.courseData;

public class teacherCourseData {
	
public static TeacherCourse FindOne(int TeacherCourse_ID){
	
			List<TeacherCourse> teacherscourses = new ArrayList<TeacherCourse>();	
			String line;
			try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
			
			while((line=bufferreader.readLine())!=null) {
				TeacherCourse teachercourse = new TeacherCourse();
				String[] rowteacher = line.split(",");
				
				if(Integer.parseInt(rowteacher[0]) == TeacherCourse_ID ) 
				
				{
				teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(rowteacher[0]));
				teachercourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(rowteacher[1])));
				//teachercourse.setTEACHER_ID(teacherData.findOne(Integer.parseInt(rowteacher[2])));
				
				teachercourse.setSECTION(rowteacher[3]);
				
				
				
				
				teacherscourses.add(teachercourse);
				
				return teachercourse;
				}
				
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
		
	}

		
		public static List<TeacherCourse> FindAll(){
			List<TeacherCourse> teachers= new ArrayList<TeacherCourse>();
			String line ;
			try {
				
				@SuppressWarnings("resource")
				BufferedReader bufferedReader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
				
				while((line=bufferedReader.readLine()) != null) {
					TeacherCourse teachercourse = new TeacherCourse();
					String[] rowteacher = line.split(",");
					teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(rowteacher[0]));
					//teachercourse.setTEACHER_ID(teacherData.findOne(Integer.parseInt(rowteacher[1])));
					teachercourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(rowteacher[2])));
					teachercourse.setSECTION(rowteacher[3]);
					
					teachers.add(teachercourse);
				}
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return teachers;
		}

		public static List<TeacherCourse> Search(String search){
			List<TeacherCourse> teachers= new ArrayList<TeacherCourse>();
			String line ;
			try {
				@SuppressWarnings("resource")
				BufferedReader bufferedReader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
				
				while((line=bufferedReader.readLine())!=null) {
					TeacherCourse teachercourse = new TeacherCourse();
					String[] rowteacher = line.split(",");
					teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(rowteacher[0]));
					//teachercourse.setTEACHER_ID(TeacherData.FindOne(Integer.parseInt(rowteacher[1])));
					teachercourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(rowteacher[2])));
					teachercourse.setSECTION(rowteacher[3]);
						
					
					
					
					teachers.add(teachercourse);
					}
					//return rooms;
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return teachers;
		}

		public static TeacherCourse Save(TeacherCourse teacher) {
			
			FileWriter filewriter;
			List<TeacherCourse> teachers = FindAll();
			
			try {
				filewriter = new FileWriter(TeacherCourse.csvFile);
				
				for(int i=0;i<teachers.size();i++) {
					filewriter.append(teachers.get(i).toString());
					filewriter.append("\n");
				}
				
				
				if(teachers.size()>0) {
					teacher.setTEACHERCOURSE_ID(teachers.get(teachers.size()-1).getTEACHERCOURSE_ID()+1);
				
				}
				else {
					teacher.setTEACHERCOURSE_ID(1);;
				}
				teachers.add(teacher);
					filewriter.append(teacher.toString());
					filewriter.append("\n");
					filewriter.flush();
					filewriter.close();
				
				
				
		} catch (IOException e) {
				
				e.printStackTrace();
			}
			return teacher;
		}
public static TeacherCourse deleteOne(int TeacherCourse_ID) {
			
			FileWriter filewriter;
			List<TeacherCourse> teachercourses = FindAll();
			TeacherCourse teacher = teacherCourseData.FindOne(TeacherCourse_ID);
			
			try {
				filewriter = new FileWriter(TeacherCourse.csvFile);
				
				for(int i=0;i<teachercourses.size();i++) {
					if(teachercourses.get(i).getTEACHERCOURSE_ID()!=TeacherCourse_ID) {
					filewriter.append(teachercourses.get(i).toString());
					filewriter.append("\n");
					}
				}
				
				teachercourses.add(teacher);
					
					filewriter.flush();
					filewriter.close();
				
		} catch (IOException e) {
				
				e.printStackTrace();
			}
			return teacher;
		}



}
