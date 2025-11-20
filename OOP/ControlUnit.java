package oopPackage;

import java.util.ArrayList;

public class ControlUnit {
	//objects
	private ArrayList<Task> tasks;
	
	//constructors
	public ControlUnit() {
		this.tasks = new ArrayList<>();
	}
	
	//methods
	public void addT(String title) {
		Task newT = new UncompletedT(title); //create an object (newT)
		tasks.add(newT); //add the task in the ArrayList
	}
	public void deleteT(int numOfTaskD) {
		if (numOfTaskD >= 0 && numOfTaskD < tasks.size()) {
			tasks.remove(numOfTaskD);
		} else {
			System.out.println("The number is out the bound");
		}
	}
	public void checkT(int numOfTaskC) {
		if (numOfTaskC >= 0 && numOfTaskC < tasks.size()) {
			Task taskC = tasks.get(numOfTaskC); //new object
			tasks.set(numOfTaskC, new CompletedT(taskC.getTitle())); //moving the task to the completed tasks
		} else {
			System.out.println("The number is out the bound");
		}
	}
	public void seeT() {
		System.out.println("\nThese are your tasks: ");
		for (int i = 0; i < tasks.size(); i++) {
			System.out.print((i+1) +"- ");
			tasks.get(i).display();
		}
		System.out.println("------------------------------------");	
	}
	public void seeTNDone() {
	    System.out.println("\nThese are your tasks you havn't done: ");
	    int j=0;
	    for (Task task : tasks) {
	        if (task.isCompleted() == false) {
	        	System.out.print((j+1) + "- ");
	            task.display();
	        }
	        j++;
	    }
	    System.out.println("------------------------------------");	
	}

}























