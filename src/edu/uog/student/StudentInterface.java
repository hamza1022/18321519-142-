package edu.uog.student;

import java.util.List;
import java.util.Scanner;

public interface StudentInterface {
	
	public static void studentMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice=-1;

	
		while (choice!=5) {
			System.out.println("=====================================================");
			System.out.println("Student");
			System.out.println("=====================================================");
			System.out.println("1.   ADD Student ");
			System.out.println("2.   Delete Student");
			System.out.println("3.   Show Students");
			System.out.println("4.   Search Student");
			System.out.println("5.   Back To Main Menu");
			System.out.print("Enter Your Choice [1-5]: ");
			choice =input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Student");
				System.out.println("---------------------------------");
				Student student = new Student();
				
				System.out.println("Enter Student ID: ");
				int id=input.nextInt();
				student.setSTUDENT_ID(id);

				System.out.println("Enter Student Roll no: ");
				String rollno =input.nextLine();
				rollno+=input.nextLine();
				student.setSTUDENT_ROLLNO(rollno);

  				//System.out.println("Enter Student Title: ");
				//String title=input.nextLine();
				//title+=input.nextLine();
				//student.setTITLE(title);

				System.out.println("Enter Student forname: ");
				String forname =input.nextLine();
				forname+=input.nextLine();
				student.setFORE_NAME(forname);

//				System.out.println("Enter STUDENT surname: ");
	//			String surname =input.nextLine();
		//		surname+=input.nextLine();
			//	student.setSUR_NAME(surname);

				//System.out.println("Enter Age : ");
				//int age =input.nextInt();
			     //student.setAGE(age);
			
				//System.out.println("Enter Address :");
				//String address =input.nextLine();
				//address+=input.nextLine();
				//student.setADDRESS(address);
				
				//System.out.println("Enter Gender :");
				//String gender =input.nextLine();
				//gender+=input.nextLine();
				//student.setADDRESS(gender);

				System.out.println("Enter Study Program: ");
				String program=input.nextLine();
				program+=input.nextLine();
				student.setSTUDY_PROGRAM(program);

				System.out.println("Enter Study year ");
				String year =input.nextLine();
				year+=input.nextLine();
				student.setSTUDY_YEAR(year);

				student = studentData.Save(student);
				System.out.println(student.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Student's info ");
				System.out.println("---------------------------------");
				System.out.println("Enter Student ID: ");
				int student_ID =input.nextInt();
				
				Student studentdelete = studentData.deleteOne(student_ID);
				System.out.println(studentdelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Student Data");
				System.out.println("---------------------------------");
				List<Student> students = studentData.findAll();
				for (int i=0; i<students.size(); i++) {
					System.out.println(students.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("Search Student");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search =input.nextLine();
				search+=input.nextLine();
				List<Student> studentsearch = studentData.search(search);
				for (int i=0; i<studentsearch.size(); i++) {
					System.out.println(studentsearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println("                     back to main menu");
				System.out.println("...................................");
				break;
			default:
				System.out.println("Invalid Choice!");
			
				
			}
		}
	}
	}


