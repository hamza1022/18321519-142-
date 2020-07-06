package edu.uog.person;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class personData {
	public static List<Person> findAll()  {
		List<Person> persons = new ArrayList<Person>();
		String line;

		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(Person.csvFile));

			while ((line = bufferreader.readLine()) != null) {
				Person person = new Person();

				String[] personRow = line.split(",");

				person.setPERSON_ID(Integer.parseInt(personRow[0]));
				person.setTITLE(personRow[1]);
				person.setFORE_NAME(personRow[2]);
				person.setSUR_NAME(personRow[3]);
				person.setADDRESS(personRow[4]);
				person.setAGE(Integer.parseInt(personRow[5]));
                person.setGENDER(personRow[6]);
               
				persons.add(person);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return persons;
	}

	@SuppressWarnings("resource")
	public static Person findOne(int person_ID)  {
		String line;

		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Person.csvFile));

			while ((line = bufferreader.readLine()) != null) {
				Person person = new Person();

				String[] personRow = line.split(",");

				if (Integer.parseInt(personRow[0]) == person_ID) {
					person.setPERSON_ID(Integer.parseInt(personRow[0]));
					person.setTITLE(personRow[1]);
					person.setFORE_NAME(personRow[2]);
					person.setSUR_NAME(personRow[3]);
					person.setADDRESS(personRow[4]);
					person.setAGE(Integer.parseInt(personRow[5]));
	                person.setGENDER(personRow[6]);
					return person;
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("resource")
	public static List<Person> search(String search)  {
		List<Person> persons = new ArrayList<Person>();
		String line;

		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Person.csvFile));

			while ((line = bufferreader.readLine()) != null) {
				Person person = new Person();

				String[] personRow = line.split(",");

				if (personRow[1].contains(search) == true) {
					person.setPERSON_ID(Integer.parseInt(personRow[0]));
					person.setTITLE(personRow[1]);
					person.setFORE_NAME(personRow[2]);
					person.setSUR_NAME(personRow[3]);
					person.setADDRESS(personRow[4]);
					person.setAGE(Integer.parseInt(personRow[5]));
	                person.setGENDER(personRow[6]);
					persons.add(person);
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return persons;
	}

	public static Person Save(Person person) {
		FileWriter filewriter;

		List<Person> persons = findAll();

		try {
			filewriter = new FileWriter(Person.csvFile);

			for (int i=0; i<persons.size(); i++) {
				filewriter.append(persons.get(i).toString());
				filewriter.append("\n");
			}
			if (persons.size()>0)
				person.setPERSON_ID(persons.get(persons.size()-1).getPERSON_ID()+1);
			else
				person.setPERSON_ID(1);
			filewriter.append(person.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}


		return person;
	}

	public static Person deleteOne(int person_ID) {
		FileWriter filewriter;

		List<Person> persons = findAll();
		Person person = findOne(person_ID);

		try {
			filewriter = new FileWriter(Person.csvFile);

			for (int i=0; i<persons.size(); i++) {
				if (persons.get(i).getPERSON_ID() != person_ID) {
					filewriter.append(persons.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return person;
	
	}
      
      
}


