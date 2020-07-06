package edu.uog.timetable;

import java.util.List;
import java.util.Scanner;

public interface TimeSlotInterface {
	
	@SuppressWarnings("static-access")
	public static void TimeSlotMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice=-1;
		{
		while (choice!=5) {
			System.out.println("=====================================================");
			System.out.println("Timeslot ");
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
				System.out.println("Add TimeSlot ");
				System.out.println("---------------------------------");
				TimeSlot timeslot = new TimeSlot();
				
				System.out.println("Enter Timeslot ID: ");
				int id=input.nextInt();
				timeslot.setTIMESLOT_ID(id);

				//System.out.println("Enter WeekDay id: ");
				//int weekday_id =input.nextInt();
				//weekDayData Weekdaydata=new weekDayData();
				//weekDaydata.findOne(weekday_id);

				System.out.println("Enter timeslot start: ");
				String timeslot_start =input.nextLine();
				timeslot_start+=input.nextLine();
				timeslot.setTIMESLOT_START(timeslot_start);

				System.out.println("Enter timeslot end: ");
				String timeslot_end =input.nextLine();
				timeslot_start+=input.nextLine();
				timeslot.setTIMESLOT_END(timeslot_end);

				timeslot = timeSlotData.Save(timeslot);
				System.out.println(timeslot.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete ");
				System.out.println("---------------------------------");
				System.out.println("Enter Timeslot ID: ");
				int TIMESLOT_ID =input.nextInt();
				
				TimeSlot timeslotdelete = timeSlotData.deleteOne(TIMESLOT_ID);
				System.out.println(timeslotdelete.toString());
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Show All TimeSlot Data");
				System.out.println("---------------------------------");
				List<TimeSlot> timeslots = timeSlotData.findAll();
				for (int i=0; i<timeslots.size(); i++) {
					System.out.println(timeslots.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("Search Timeslot");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search =input.nextLine();
				search+=input.nextLine();
				List<TimeSlot>timeslotsearch = timeSlotData.search(search);
				for (int i=0; i<timeslotsearch.size(); i++) {
					System.out.println(timeslotsearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println("               back to main menu");
				System.out.println("......................................................");
				break;
			
				
			}
		}
	}
	




	}
	

}
