package edu.uog.teacher;

import java.util.List;
import java.util.Scanner;

public interface TeacherInterface {
	
	public static void TeacherMenu() {
  	  @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice=-1;

  		while (choice!=5) {
			System.out.println("=====================================================");
			System.out.println("Teacher");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Search");
			System.out.println("5.   Back");
			System.out.print("Enter Your Choice [1-5]: ");
			choice =input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Teacher");
				System.out.println("---------------------------------");
				Teacher teacher = new Teacher();
				
				System.out.println("Enter Teacher ID: ");
				int id=input.nextInt();
				teacher.setTeacher_ID(id);
			
				System.out.println("Enter Teacher Title: ");
				String title=input.nextLine();
				title+=input.nextLine();
				teacher.setTITLE(title);

				System.out.println("Enter teacher for name: ");
				String forname =input.nextLine();
				forname+=input.nextLine();
				teacher.setFORE_NAME(forname);

				System.out.println("Enter teacher sur name: ");
				String surname =input.nextLine();
				surname+=input.nextLine();
				teacher.setSUR_NAME(surname);

				System.out.println("Enter Age : ");
				int age =input.nextInt();
				teacher.setAGE(age);
			
				System.out.println("Enter Address :");
				String address =input.nextLine();
				address+=input.nextLine();
				teacher.setADDRESS(address);
				
				System.out.println("Enter Gender :");
				String gender =input.nextLine();
				gender+=input.nextLine();
				teacher.setADDRESS(gender);
				
				teacher= teacherData.Save(teacher);
				System.out.println(teacher.toString());
				System.out.println("---------------------------------");
				
				break;
			    case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Teacher's id");
				System.out.println("---------------------------------");
				System.out.println("Enter Teacher ID: ");
				int teacher_ID =input.nextInt();
				
				Teacher teacherdelete = teacherData.deleteOne(teacher_ID);
				System.out.println(teacherdelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Teacher's Data");
				System.out.println("---------------------------------");
				List<Teacher> teachers = teacherData.findAll();
				for (int i=0; i<teachers.size(); i++) {
					System.out.println(teachers.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("Search Teacher");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search =input.nextLine();
				search+=input.nextLine();
				List<Teacher> teachersearch = teacherData.search(search);
				for (int i=0; i<teachersearch.size(); i++) {
					System.out.println(teachersearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println("back to main menu");
				System.out.println("...................................");
				break;
			
				
			}
		}
	}

}
