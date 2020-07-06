package edu.uog.student;

import java.util.List;
import java.util.Scanner;

public interface StudnetCourseInterface {
	
	public static void StudentCourseMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=5) {
			System.out.println("=====================================================");
			System.out.println("StudentCourse Menu");
			System.out.println("=====================================================");
			
			System.out.println("1.   Insert StudentCourse");
			System.out.println("2.   Delete StudentCourse");
			System.out.println("3.   Show StudentCourse");
			System.out.println("4.   Search StudentCourse");
			System.out.println("5.   Back to main menu");
			System.out.print("Enter Your Choice [1-5]: ");
			choice =input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New StudentCourse");
				System.out.println("---------------------------------");
				StudentCourse studentcourse = new StudentCourse();
				
				System.out.println("Enter StudentCourse ID: ");
				int id =input.nextInt();
				studentcourse.setStudentCOURSE_ID(id);


				System.out.println("Enter Course ID: ");
				int course_id =input.nextInt();
				studentCourseData Studentcourse =new studentCourseData();
				Studentcourse.FindOne(course_id);
				
				System.out.println("Enter Student ID: ");
				int student_id =input.nextInt();
				studentData studentdata=new studentData();
				studentdata.findOne( student_id);
				

				System.out.println("Enter Section: ");
				String section =input.nextLine();
				section+=input.nextLine();
				studentcourse.setSECTION(section);

				studentcourse = studentCourseData.Save(studentcourse);
				System.out.println(studentcourse.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete StudentCourse");
				System.out.println("---------------------------------");
				System.out.println("Enter studentcourse ID: ");
				int studentcourse_ID =input.nextInt();
				
				StudentCourse studentcoursedelete = studentCourseData.DelOne(studentcourse_ID);
				System.out.println(studentcoursedelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All studentcourse Data");
				System.out.println("---------------------------------");
				List<StudentCourse> studentcourses = studentCourseData.FindAll();
				for (int i=0; i<studentcourses.size(); i++) {
					System.out.println(studentcourses.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("Search studentcourse ");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search =input.nextLine();
				search+=input.nextLine();
				List<StudentCourse> studentcoursesearch = studentCourseData.Search(search);
				for (int i=0; i<studentcoursesearch.size(); i++) {
					System.out.println(studentcoursesearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid Choice!");
			
				
			}
		}
	}

}
