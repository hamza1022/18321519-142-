package edu.uog.timetable;

import java.util.List;
import java.util.Scanner;

public interface TimeTableInterface {
	
	public static void TimeTableMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=5) {
			System.out.println("------------------------------------------------------");
			System.out.println("Welcome to TimeTable Menu");
			System.out.println("1.   Insert ");
			System.out.println("2.   Delete ");
            System.out.println("3.   Show");
			System.out.println("4.   Search ");
			System.out.println("5.   Back");
			System.out.print("Enter Your Choice [1-5]: ");
			choice =input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add Weeday");
				System.out.println("---------------------------------");
				WeekDay weekday = new WeekDay();
				
				System.out.println("Enter WeekDay ID: ");
				int id =input.nextInt();
			   weekday.setWEEKDAY_ID(id);
			   
			   
			   System.out.println("Enter WeekDay Name: ");
				String name =input.nextLine();
				name+=input.next();
			     weekday.setWEEKDAY_NAME(name);
			   
			  
			   weekday = weekDayData.Save(weekday);
				System.out.println(weekday.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete WeekDay");
				System.out.println("---------------------------------");
				System.out.println("Enter WeekDay ID: ");
				int weekday_ID =input.nextInt();
				
				WeekDay weekdaydelete = weekDayData.deleteOne(weekday_ID);
				System.out.println(weekdaydelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All WeekDays Data");
				System.out.println("---------------------------------");
				List<WeekDay> weekdays = weekDayData.findAll();
				for(int j=0;j<weekdays.size();j++) {
				System.out.println(weekdays.get(j).toString());
				
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("Search Weekday by Weekday Name");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search =input.nextLine();
				search+=input.nextLine();
				List<WeekDay> weekdaysearch = weekDayData.search(search);
				for (int i=0; i<weekdaysearch.size(); i++) {
					System.out.println(weekdaysearch.get(i).toString());
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
