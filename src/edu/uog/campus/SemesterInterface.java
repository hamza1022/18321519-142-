package edu.uog.campus;

import java.util.List;
import java.util.Scanner;

public interface SemesterInterface {
	
	public static void SemesterMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=5) {
			System.out.println("------------------------------------------------------");
			System.out.println("Welcome to Semester Menu");
			System.out.println("-------------------------------------------------------");
			
			System.out.println("1.   ADD Semester");
			System.out.println("2.   Delete Semester");
			System.out.println("3.   Show Semester");
			System.out.println("4.   Search Semester ");
			System.out.println("5.   Back to main menu");
			System.out.print("Enter Your Choice [1-5]: ");
			choice =input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Semester");
				System.out.println("---------------------------------");
				Semester semester = new Semester();
				
				System.out.println("Enter Semester ID: ");
				int id =input.nextInt();
			
				semester.setSEMESTER_ID(id);

				System.out.println("Enter Semester Name: ");
				String name =input.nextLine();
				name+=input.nextLine();
				semester.setSEMESTER_NAME(name);

				System.out.println("Enter Semester Type: ");
				String type =input.nextLine();
				type+=input.nextLine();
				semester.setSEMESTER_TYPE(type);

				semester = semesterData.Save(semester);
				System.out.println(semester.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Semester");
				System.out.println("---------------------------------");
				System.out.println("Enter Semester ID: ");
				int semester_ID =input.nextInt();
				
				Semester semesterdelete = semesterData.deleteOne(semester_ID);
				System.out.println(semesterdelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All Semesters Data");
				System.out.println("---------------------------------");
				List<Semester> semesters = semesterData.findAll();
				for(int j=0;j<semesters.size();j++) {
				System.out.println(semesters.get(j).toString());
				
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("Search Semester");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search =input.nextLine();
				search+=input.nextLine();
				List<Semester> semestersearch = semesterData.search(search);
				for (int i=0; i<semestersearch.size(); i++) {
					System.out.println(semestersearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println("Back to main menu");
				break;
			default:
				System.out.println("Invalid Choice!");
			
				
			}
		}
	}
	

}



