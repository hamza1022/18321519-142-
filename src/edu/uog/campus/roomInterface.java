package edu.uog.campus;

import java.util.List;
import java.util.Scanner;

public interface roomInterface {
	
	public static void RoomMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=5) {
			System.out.println("=====================================================");
			System.out.println("                Room Menu         ");
			System.out.println("=====================================================");
			
			System.out.println("1.      ADD Room");
			System.out.println("2.      SHOW Room");
			System.out.println("3.      SEARCH ROOM");
			System.out.println("4.      DELETE ROOM");
			System.out.println("5.      Back To Main Menu ");
			System.out.print("Enter Your Choice [1-5]: ");
			choice =input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Room");
				System.out.println("---------------------------------");
				Room room = new Room();
				
				System.out.println("Enter Room Name: ");
				String name =input.nextLine();
				name+=input.nextLine();
				room.setROOM_NAME(name);

				System.out.println("Enter Room Floor: ");
				int floor =input.nextInt();
				room.setROOM_FLOUR(floor);

				System.out.println("Enter Room Capacity: ");
				int capacity =input.nextInt();
				room.setROOM_CAPACITY(capacity);

				System.out.println("Enter Room Type: ");
				String type =input.nextLine();
				type+=input.nextLine();
				room.setROOM_TYPE(type);

				room = roomData.Save(room);
				System.out.println(room.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Show All Rooms");
				System.out.println("---------------------------------");
				List<Room> rooms = roomData.findAll();
				for(int j=0;j<rooms.size();j++) {
				System.out.println(rooms.get(j).toString());
				}
				System.out.println("---------------------------------");
				
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Search Room by Room Name");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search =input.nextLine();
				search+=input.nextLine();
				List<Room> roomsearch = roomData.search(search);
				for (int i=0; i<roomsearch.size(); i++) {
					System.out.println(roomsearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;

			case 4:
				System.out.println("---------------------------------");
				System.out.println("Delete Room");
				System.out.println("---------------------------------");
				System.out.println("Enter Room ID: ");
				int room_ID =input.nextInt();
				
				Room roomdelete = roomData.deleteOne(room_ID);
				System.out.println(roomdelete.toString());
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
