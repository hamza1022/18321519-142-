package edu.uog.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class studentData {
	
	public static List<Student> findAll()  {
		List<Student> students = new ArrayList<Student>();
		String line;

		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(Student.csvFile));

			while ((line = bufferreader.readLine()) != null) {
				Student student = new Student();

				String[] studentRow = line.split(",");

				student.setSTUDENT_ID(Integer.parseInt(studentRow[0]));
				student.setSTUDENT_ROLLNO(studentRow[1]);
				student.setTITLE(studentRow[2]);
				student.setFORE_NAME(studentRow[3]);
				student.setSUR_NAME(studentRow[4]);
				student.setAGE(Integer.parseInt(studentRow[5]));
				student.setGENDER(studentRow[6]);
				student.setADDRESS(studentRow[7]);
				
				student.setSTUDY_PROGRAM(studentRow[8]);
				student.setSTUDY_YEAR(studentRow[9]);
				
               
				students.add(student);
			}
		} catch (IOException e) {
			System.out.println("Error Ocurred");
			e.printStackTrace();
		}

		return students;
	}

	@SuppressWarnings("resource")
	public static Student findOne(int student_ID)  {
		String line;

		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Student.csvFile));

			while ((line = bufferreader.readLine()) != null) {
				Student student = new Student();

				String[] studentRow = line.split(",");

				if (Integer.parseInt(studentRow[0]) == student_ID) {
					student.setSTUDENT_ID(Integer.parseInt(studentRow[0]));
					student.setSTUDENT_ROLLNO(studentRow[1]);
					student.setTITLE(studentRow[2]);
					student.setFORE_NAME(studentRow[3]);
					student.setSUR_NAME(studentRow[4]);
					student.setAGE(Integer.parseInt(studentRow[5]));
					student.setGENDER(studentRow[6]);
					student.setADDRESS(studentRow[7]);
					student.setSTUDY_PROGRAM(studentRow[8]);
					student.setSTUDY_YEAR(studentRow[9]);
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("resource")
	public static List<Student> search(String search)  {
		List<Student> students = new ArrayList<Student>();
		String line;

		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Student.csvFile));

			while ((line = bufferreader.readLine()) != null) {
				Student student = new Student();

				String[] studentRow = line.split(",");

				if (studentRow[1].contains(search) == true) {
					student.setSTUDENT_ID(Integer.parseInt(studentRow[0]));
					student.setSTUDENT_ROLLNO(studentRow[1]);
					student.setTITLE(studentRow[2]);
					student.setFORE_NAME(studentRow[3]);
					student.setSUR_NAME(studentRow[4]);
					student.setAGE(Integer.parseInt(studentRow[5]));
					student.setGENDER(studentRow[6]);
					student.setADDRESS(studentRow[7]);
					student.setSTUDY_PROGRAM(studentRow[8]);
					student.setSTUDY_YEAR(studentRow[9]);
					
					students.add(student);
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return students;
	}

	public static Student Save(Student student) {
		FileWriter filewriter;

		List<Student> students = findAll();

		try {
			filewriter = new FileWriter(Student.csvFile);

			for (int i=0; i<students.size(); i++) {
				filewriter.append(students.get(i).toString());
				filewriter.append("\n");
			}
			if (students.size()>0)
				student.setSTUDENT_ID(students.get(students.size()-1).getSTUDENT_ID()+1);
			else
				student.setSTUDENT_ID(1);
			filewriter.append(student.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			System.out.println("Error Occured");
			e.printStackTrace();
		}


		return student;
	}

	public static Student deleteOne(int student_ID) {
		
		FileWriter filewriter;

		List<Student> students = findAll();
		Student student = findOne(student_ID);

		try {
			filewriter = new FileWriter(Student.csvFile);

			for (int i=0; i<students.size(); i++) {
				if (students.get(i).getSTUDENT_ID() != student_ID) {
					filewriter.append(students.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return student;
	
	}
      
	}
	
	
	
	


