package edu.uog;

import java.util.List;
import java.util.Scanner;

import edu.uog.campus.Room;
import edu.uog.campus.SemesterInterface;
import edu.uog.campus.roomData;
import edu.uog.campus.roomInterface;
import edu.uog.course.CourseInterface;
import edu.uog.student.StudentInterface;
import edu.uog.student.StudnetCourseInterface;
import edu.uog.teacher.TeacherCourseInterface;
import edu.uog.teacher.TeacherInterface;
import edu.uog.timetable.TimeSlotInterface;
import edu.uog.timetable.TimeTableInterface;
import edu.uog.timetable.WeekDayInterface;

public class TimeTableManagment {
	
	 public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			
			System.out.println("*******************************************************");
			System.out.println("            OBJECT ORIENTED PROGRAMMING              ");
			System.out.println("*******************************************************");
            System.out.println("            SUBMITTED TO : DR NOUMAN RIAZ              ");
			System.out.println("*******************************************************");
		    System.out.println("            WELCOME TO MY TIME TABLE PROJECT       ");
			System.out.println("*******************************************************");
			System.out.println("            WELCOME TO MAIN MENU                   ");
			System.out.println("*******************************************************");
			System.out.println("            Main Menu                              ");
			System.out.println("*******************************************************");
			System.out.println("1.     Rooms        ");
			System.out.println("2.     Courses      ");
			System.out.println("3.     Semester     ");
			System.out.println("4.     Student     ");
			System.out.println("5.     Studnet Course      ");
			System.out.println("6.     Teacher       ");
			System.out.println("7.     TeacherCourse        ");
			System.out.println("8.     TimeSlot      ");
			System.out.println("9.     TimeTable      ");
			System.out.println("10.    WeekDay       ");
	        System.out.println("11.    Quit");
			System.out.println("Enter Your Choice [1-11]: ");
			choice = input.nextInt();
	
			switch (choice) {
			case 1:
				roomInterface.RoomMenu();
				choice=-1;
				break;
			case 2:
				 CourseInterface.CourseMenu();
				 choice=-1;
				 break;
			case 3:
				SemesterInterface.SemesterMenu();
				 choice=-1;
				 break;
           case 4:
        	   StudentInterface.studentMenu();
			    choice=-1;
			    break;
		    case 5:
				StudnetCourseInterface.StudentCourseMenu();
				choice=-1;
				break;
			case 6:
				  TeacherInterface.TeacherMenu();
			         choice=-1;
			         break;
			case 7:
				TeacherCourseInterface.TeacherCourseMenu();;
				choice=-1;
				break;
			case 8:
				TimeSlotInterface.TimeSlotMenu();
				choice=-1;
				break;
			case 9:
				TimeTableInterface.TimeTableMenu();
				choice=-1;
				break;
			case 10:
				WeekDayInterface.WeekDayMenu();
			choice=-1;
			break;
				
			default:
				System.out.println("Invalid Choice! TRY AGAIN");
			}
		}}}

	
		
	
		
	
		



