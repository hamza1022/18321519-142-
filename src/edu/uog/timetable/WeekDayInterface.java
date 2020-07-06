package edu.uog.timetable;

import java.util.List;
import java.util.Scanner;

public interface WeekDayInterface {
	
	public static void WeekDayMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice=-1;
		{
		
		while (choice!=5) {
			System.out.println("=====================================================");
			System.out.println("                WeekDay menu                ");
			System.out.println("=====================================================");
			System.out.println("1.   Insert WeekDay");
			System.out.println("2.   Delete WeekDay");
			System.out.println("3.   Show WeekDay");
			System.out.println("4.   Search WeekDay");
			System.out.println("5.   Back");
			System.out.print("Enter Your Choice [1-5]: ");
			choice =input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add WeekDay");
				System.out.println("---------------------------------");
				WeekDay weekday = new WeekDay();
				
				System.out.println("Enter WeekDay ID: ");
				int Weekday=input.nextInt();
				weekday.setWEEKDAY_ID(Weekday);

				System.out.println("Enter WEEKDay Name: ");
				String name =input.nextLine();
				name+=input.nextLine();
				weekday.setWEEKDAY_NAME(name);
	            break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete WEEKDAY ");
				System.out.println("---------------------------------");
				System.out.println("Enter WeekDay ID: ");
				int Weekday_ID =input.nextInt();
				
				WeekDay weekdaydelete = weekDayData.deleteOne(Weekday_ID);
				System.out.println(weekdaydelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All WeekDay's data");
				System.out.println("---------------------------------");
				List<WeekDay> weekdays = weekDayData.findAll();
				for (int i=0; i<weekdays.size(); i++) {
					System.out.println(weekdays.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("Search WeekDay");
				System.out.println("---------------------------------");
				System.out.println("Enter Search: ");
				String search =input.nextLine();
				search+=input.nextLine();
				List<WeekDay> weekdaysearch = weekDayData.search(search);
				for (int i=0; i<weekdaysearch.size(); i++) {
					System.out.println(weekdaysearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
			      System.out.println("                   Back to main menu");
			      System.out.println("...................................");
				break;
			default:
				System.out.println("Invalid Choice!");
			
				
			}
		}
	}

	}

}
