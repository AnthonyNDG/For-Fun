import java.util.*; 
public class Patient{
	private String name;
	private int priority;
	private String issue;
	public Patient() { //All that we need is the name, issue, and importance
		name="";
		issue="";
		priority=0;
	}
	public void patient(String n, String i, int p) {
		name=n;
		priority=p;
		issue=i;
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name=n;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String i) {
		issue=i;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int p) {
		priority=p;
	}
	public void setAppointment(Patient p, ArrayList<Patient> list,ArrayList<Patient> most, ArrayList<Patient>mid, ArrayList<Patient> least) {
		Scanner name = new Scanner(System.in); //We place our scanners here to fill in the data for every new patient that comes
		Scanner issue = new Scanner(System.in);
		Scanner priority = new Scanner(System.in);
		String i;
		String n;  
		int pr = 0;
		System.out.println("What is your name? "); //Patient is asked to input information which will be stored in an element just for him
		n=name.nextLine();
		p.setName(n);
		System.out.println("Injury? ");
		i=issue.nextLine();
		p.setIssue(i);
		
		while(pr<=0||pr>3) {
			try {	
				while(true) {
					System.out.println("A rating from 1-3? (1 being the highest in priority) ");
					pr=priority.nextInt();
					if(pr<1||pr>3) {
						System.out.println("Input the correct number!");
					}
					break;
				}
			}
			catch(InputMismatchException o) {
				System.out.println("Write a number answer");
				priority.nextLine();
			}
				
		}
		
		p.setPriority(pr);
		p.addToList(p,list,most,mid,least);
		System.out.println("You have been placed in the list!");
	}
	private void addToList(Patient p, ArrayList<Patient> list,ArrayList<Patient> most, ArrayList<Patient> mid,ArrayList<Patient> least) {//this helps decide how we should add our element
		list.add(p);	//to plain add if its empty or sort it if theres more than one element
		if(list.size()==1) return;	
		else {
			sortArray(list,most,mid,least);
		}
	}
	private void sortArray(ArrayList<Patient> list,ArrayList<Patient> most,ArrayList<Patient> mid,ArrayList<Patient> least) {
		for(int i=0;i<list.size();i++) {//we use the 3 extra arraylists and place each element from the main list and add it to the other arraylists. Separate from their priority number
			if(list.get(i).getPriority()==1) {
				most.add(list.get(i));
			}
			if(list.get(i).getPriority()==2) {
				mid.add(list.get(i));
			}
			if(list.get(i).getPriority()==3) {
				least.add(list.get(i));
			}
		}
		list.removeAll(list);//We have to empty the main list here now that we got the other lists added.
		for(int i=0;i<most.size();i++) {  //We go thru each list from most important to least and add those elements in the main list
			list.add(most.get(i));
		}
		for(int i=0;i<mid.size();i++) {
			list.add(mid.get(i));
		}
		for(int i=0;i<least.size();i++) {
			list.add(least.get(i));
		}
		most.removeAll(most); //Empty every extra list as since the next time we need this, names are repeated
		mid.removeAll(mid);
		least.removeAll(least);
	}
}
