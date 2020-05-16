import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class menu {
	public static void main(String[] args) {
		
		Scanner identity = new Scanner(System.in);
		
		ArrayList<Patient> List = new ArrayList<Patient>();
		ArrayList<Patient> most = new ArrayList<Patient>();
		ArrayList<Patient> mid = new ArrayList<Patient>();
		ArrayList<Patient> least = new ArrayList<Patient>();
		int choice=0;
		int o = 0;
		int attempt=1;
		
		
			    	while (true){//We have to make the while come back first otherwise the program will be terminated after Mismatching in a certain fashion
			    		try{
			    		System.out.println("Welcome! Who may this be? \n1) Patient\n2) Appointment Organizer");
			    		choice=identity.nextInt();

			    		if(choice<1 || choice >2) {//If we fail this we start from scratch. We do this so its easier for the user to see whats he's supposed to do after failing a lot
			    			System.out.println("WRONG INPUT, Please choose correctly (Attempt "+ attempt +")");
			    			attempt++;
			    			if(attempt==6) {
			    				System.out.println("You have failed 5 times. Program Ending...");
			    				return;
			    			}
			    			continue;
			    			}    
			    		if(choice==1) { 									// I am a Patient so now an appointment will be scheduled
			    			Patient p = new Patient();
			    			p.setAppointment(p,List,most,mid,least);
			    			clear();										//clear up screen so its near empty after appointment is done
			    		}
			    		if(choice==2) {									// I AM ORGANIZER (List is shown to organizer and organizer can remove the first patient
			    			System.out.println("This is the current list: \n");	//Since its first in first out, we dont have to stress on how to remove since we will only need to remove the first element
			    			displayList(List);
			    			if(List.isEmpty()) {
			    				System.out.println("There are NO patients. Break time!! :D\n");
			    			}
			    			else {	//Removes healed Patient. We made it a method since there will be a few mismatch exceptions in this program
			    				takeout(o,List);
			    				clear();
			    			}
			    		}
			    	}
			    	catch(InputMismatchException e){//This is so the user does not lose the list as restarting the program erases the list data
						System.out.println("Please put a number answer ");
					      identity.nextLine();
					    }
			    }
			    
			
		}
		private static void displayList(ArrayList<Patient> list) {
		for(int i=0;i<list.size();i++) {
			int counter=i+1;
			System.out.println(counter+") "+list.get(i).getName()+" | "+list.get(i).getIssue()+" | "+list.get(i).getPriority());
		}
		
	}
	public static void clear() {//explained in line 35
		Scanner clear= new Scanner(System.in);
		String cl;
		System.out.println("Please click ENTER to restart");
		cl=clear.nextLine();
		for(int i=0;i<50;i++) System.out.println();
	}
	public static void takeout(int o, ArrayList<Patient> List) {//	Organizer reminded if its okay to remove. try and catch mismatch exception is applied here
		Scanner over = new Scanner(System.in);
		try {
			while(o<1||o>2) {
			
				while(true) {
					System.out.println("Is the appointment over?\n1) Yes\n2) No");
					o=over.nextInt();

					if(o==1) {
						System.out.println(List.get(0).getName()+ " has been removed!");
						List.remove(0);
						break;
					}
					if(o==2){
						System.out.println("Removal not initiated!");
						break;
					}
					if(o<1||o>2) {
						System.out.println("THIS DOES NOT COUNT. REDO!!!");
					}
				}
				
			}
			
		}
		catch(InputMismatchException a) {
			System.out.println("Please put a number down. It has to be between 1-2");
			over.nextLine();
		}
	}
}
