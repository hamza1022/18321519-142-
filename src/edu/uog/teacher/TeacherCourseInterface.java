package edu.uog.teacher;

import java.util.List;
import java.util.Scanner;

import edu.uog.course.courseData;

@SuppressWarnings("static-access")
public interface TeacherCourseInterface {
	public static void TeacherCourseMenu() {
	
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	int choice=-1;
	
	while (choice!=5) {
		System.out.println("=====================================================");
		System.out.println("TeacherCourse Menu");
		System.out.println("=====================================================");
		
		System.out.println("1.   Insert TeacherCourse");
		System.out.println("2.   Delete TeacherCourse");
		System.out.println("3.   Show TeacherCourse");
		System.out.println("4.   Search TeacherCourse");
		System.out.println("5.   Back to main menu");
		System.out.print("Enter Your Choice [1-5]: ");
		choice =input.nextInt();
		
	

		switch (choice) {
		case 1:
			System.out.println("---------------------------------");
			System.out.println("Add New TeacherCourse");
			System.out.println("---------------------------------");
			TeacherCourse teachercourse = new TeacherCourse();
			
			System.out.println("Enter TeacherCourse ID: ");
			int id =input.nextInt();
			teachercourse.setTEACHERCOURSE_ID(id);


			System.out.println("Enter Course Id: ");
			int course_id =input.nextInt();
			courseData course = new courseData();
			course.findOne(course_id);
			
			 
			  
			System.out.println("Enter Teacher Id: ");
			int teacher_id =input.nextInt();
			teacherData teacher = new teacherData();
			teacher.findOne(teacher_id);

			System.out.println("Enter Section: ");
			String section =input.nextLine();
			section+=input.nextLine();
			teachercourse.setSECTION(section);

			teachercourse = teacherCourseData.Save(teachercourse);
			System.out.println(teachercourse.toString());
			System.out.println("---------------------------------");
			break;
		case 2:
			System.out.println("---------------------------------");
			System.out.println("Delete TeacherCourse");
			System.out.println("---------------------------------");
			System.out.println("Enter teachercourse ID: ");
			int teachercourse_ID =input.nextInt();
			
			TeacherCourse teachercoursedelete = teacherCourseData.deleteOne(teachercourse_ID);
			System.out.println(teachercoursedelete.toString());
			System.out.println("---------------------------------");
			break;
		case 3:
			System.out.println("---------------------------------");
			System.out.println("Show All teachercourse Data");
			System.out.println("---------------------------------");
			List<TeacherCourse> teachercourses = teacherCourseData.FindAll();
			for (int i=0; i<teachercourses.size(); i++) {
				System.out.println(teachercourses.get(i).toString());
			}
			System.out.println("---------------------------------");
			break;
		case 4:
			System.out.println("---------------------------------");
			System.out.println("Search teachercourse ");
			System.out.println("---------------------------------");
			System.out.println("Enter search: ");
			String search =input.nextLine();
			search+=input.nextLine();
			List<TeacherCourse> teachercoursesearch = teacherCourseData.Search(search);
			for (int i=0; i<teachercoursesearch.size(); i++) {
				System.out.println(teachercoursesearch.get(i).toString());
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




