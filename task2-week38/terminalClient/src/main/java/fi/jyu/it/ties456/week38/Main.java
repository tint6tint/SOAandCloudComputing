package fi.jyu.it.ties456.week38;

import java.util.List;
import java.util.Scanner;

import fi.jyu.it.ties456.week38.services.courses.CreateCourse;
import fi.jyu.it.ties456.week38.services.courses.StudentIS;
import fi.jyu.it.ties456.week38.services.courses.StudentISService;
import fi.jyu.it.ties456.week38.services.people.PeopleRegistry;
import fi.jyu.it.ties456.week38.services.people.PeopleRegistryService;
import fi.jyu.it.ties456.week38.services.people.PersonInfoType;

public class Main {

	public static void main(String[] args) {
		
		PeopleRegistryService  namelist = new PeopleRegistryService();
		PeopleRegistry registry = namelist.getPeopleRegistryPort();
		StudentISService student = new StudentISService();
		StudentIS stdenti =student.getStudentISPort();
		CreateCourse cc = new CreateCourse();
		
		String input;
		do {
			input = choose();
			if (input.equals("1")) {
				search(registry);
			} else if (input.equals("2")) {
				create(stdenti);
			}
		} while (!input.equals("3"));
	}
	
	public static String choose() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Chooes a number find your destnation!");
		
		System.out.println("[1]Search");
		System.out.println("[2]Create");
		System.out.println("[3]Quit");
		System.out.println(">>");
		String a = input.nextLine();

		return a;
	}	  
	
	public static void search(PeopleRegistry registry ){
		
		      Scanner input = new Scanner(System.in);
			  System.out.println("Who you want search?");
			  System.out.println("Type the name here:");
			  String b = input.nextLine();
			  List<PersonInfoType> info = registry.searchForPerson(b);
			  if (info.isEmpty() == true) System.out.println("No match found");
			  else{  
				  for (PersonInfoType person : info) {
						System.out.println("Teacher ID: " + person.getId());
						System.out.println("First name: " + person.getFirstname());
						System.out.println("Last name: " + person.getSurname());
						System.out.println("Email: " + person.getEmailAddress());
					}
					System.out.println();
			  
				  
			  }
			 		
		}
		
	public static void create(StudentIS stdenti) {
		  Scanner input = new Scanner(System.in);
		  System.out.println("Create course name.");
		  String c = input.nextLine();
		  System.out.println ("Create teachers ID");
		  String d = input.nextLine();
		  System.out.println("Number of Credits ?");
		  int e = input.nextInt();
		  System.out.println("Description)..");
		  String f = input.nextLine();
		  
		  System.out.println("name: "+c + " teacherID "+d + " numberOfCredits: "+e + " descripttion "+f);
		  
		 String showid =stdenti.createCourse(c, d, e, f);
		 System.out.println(showid);
		 System.out.println("--------------------------------------------------------------------------");
				 
	}	
		
		
	
}	    
		
		
		
		
		
		
		
		
    
 


