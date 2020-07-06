package edu.uog.course;

import java.util.List;
import java.util.Scanner;

public interface CourseInterface {
	
	public static void CourseMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice=-1;
		{
		while (choice!=5) {
			System.out.println("=====================================================");
			System.out.println("Course Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert course");
			System.out.println("2.   Delete course");
			System.out.println("3.   Show course");
			System.out.println("4.   Search course ");
			System.out.println("5.    Back");
			System.out.print("Enter Your Choice [1-5]: ");
			choice =input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Course");
				System.out.println("---------------------------------");
				Course course = new Course();
				
				System.out.println("Enter Course Code: ");
				String code =input.nextLine();
				code+=input.nextLine();
				course.setCOURSE_CODE(code);

				System.out.println("Enter Course title: ");
				String course_title =input.nextLine();
				course_title+=input.nextLine();
				course.setCOURSE_TITLE(course_title);

				System.out.println("Enter Course Description: ");
				String description =input.nextLine();
				description+=input.nextLine();
				course.setCOURSE_DESC(description);

				System.out.println("Enter Course credit hours: ");
				String credithours =input.nextLine();
				course.setCOURSE_CREDITHOUR(credithours);
				

				course = courseData.Save(course);
				System.out.println(course.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Course");
				System.out.println("---------------------------------");
				System.out.println("Enter Course ID: ");
				int course_ID =input.nextInt();
				
				Course coursedelete = courseData.deleteOne(course_ID);
				System.out.println(coursedelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				List<Course> courses = courseData.findAll();
				for(int j=0;j<courses.size();j++) {
				System.out.println(courses.get(j).toString());
				}
			case 4:
				System.out.println("---------------------------------");
				System.out.println("Search Course by Course Code");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search =input.nextLine();
				search+=input.nextLine();
				List<Course> coursesearch = courseData.search(search);
				for (int i=0; i<coursesearch.size(); i++) {
					System.out.println(coursesearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println("                      back to main menu");
				System.out.println("...................................");
				break;
			default:
				System.out.println("Invalid Choice!");
				
			}
		}
	}


	}}


