package fi.jyu.it.ties456.week38.main;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import fi.jyu.it.ties456.week38.services.courses.*;
import fi.jyu.it.ties456.week38.services.people.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PeopleRegistryService peopleService = new PeopleRegistryService();
		PeopleRegistry peopleRegistry = peopleService.getPeopleRegistryPort();
		StudentISService studentService = new StudentISService();
		StudentIS student = studentService.getStudentISPort();
		
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		showOptions();
		String option = scanner.nextLine();
		String str;
        System.out.println("Option Selected: " + option);
		
        while(!option.equalsIgnoreCase("quit") && !option.equals("1"))
        {
        	if(option.equalsIgnoreCase("search") || option.equals("2"))
        	{
        		System.out.println("---------- SEARCH OPTION ------------");
        		System.out.println("1. Insert the First Name for Search: ");
        		str = scanner.nextLine();
        		if(str.equals(""))
        		{
        			System.out.println("You need to insert a Valid Name");
        		}
        		else
        		{
        			List<PersonInfoType> personList = peopleRegistry.searchForPerson(str);
        			if(personList.isEmpty())
        			{
        				System.out.println("There are no Person called " + str);
        			}
        			else
        			{
        				System.out.println("Search Results: ");
        				for(int i = 0;  i < personList.size(); i++){
        					System.out.print("  " + personList.get(i).getId());
        					System.out.print("  " + personList.get(i).getFirstname());
        					System.out.print("  " + personList.get(i).getSurname());
        					System.out.println("  " + personList.get(i).getEmailAddress());
        				}
        			}
        		}
        		System.out.println("---------- ------ ------ ------------");
        	}
        	else if(option.equalsIgnoreCase("create") || option.equals("3"))
        	{
        		System.out.println("---------- CREATE OPTION ------------");
        		System.out.println("ID Teacher: ");
        		String id = scanner.nextLine();
        		while(id.equals(""))
        		{
        			System.out.println("Invalid ID Teacher");
        			System.out.println("Insert a ID Teacher: ");
        			id = scanner.nextLine();
        		}
        		System.out.println("Number of Credits: ");
        		String cre = scanner.nextLine();
        		int credits;
        		boolean error;
        		try{
        				credits = Integer.parseInt(cre);
        				error = false;
        			}
        		catch(NumberFormatException ex){
        				System.out.println("Its not a valid Integer");
        				credits = 0;
        				error = true;
        		}
        			
        		while(error) {
        			System.out.println("Number of Credits: ");
            		cre = scanner.nextLine();
            		try{
        				credits = Integer.parseInt(cre);
        				error = false;
        			}
            		catch(NumberFormatException ex){
        				System.out.println("Its not a valid Integer");
        				error = true;
        				credits = 0;
            		}
        		}

        		System.out.println("Course Name: ");
        		String name = scanner.nextLine();
        		while(name.equals(""))
        		{
        			System.out.println("Invalid Course Name");
        			System.out.println("Insert a Course Name: ");
        			name = scanner.nextLine();
        		}
        		System.out.println("Description: ");
        		String description = scanner.nextLine();
        		while(description.equals(""))
        		{
        			System.out.println("Invalid Description");
        			System.out.println("Insert a Description: ");
        			description = scanner.nextLine();
        		}
        		
        		String IDCourse = student.createCourse(name, id, credits, description);
        		
        		System.out.println("Course was Created with ID: " + IDCourse);
        		System.out.println("---------- ------ ------ ------------");
        	}
        	else
        	{
        		System.out.println("--> INVALID OPTION <--");
        	}
        	
        	showOptions();
        	option = scanner.nextLine();
        }
        
        System.out.println("Program Finished");        
        scanner.close();
	}
	
	public static void showOptions() {
		System.out.println();
		System.out.println("You have three options for select:");
		System.out.println("\tquit or 1 -> Quits the application");
		System.out.println("\tsearch or 2 -> Search for people registry and prints the results");
		System.out.println("\tcreate or 3 -> Create a new course");
		
		System.out.println("Please enter your option: ");
	}
}
