package oopPackage;

public class Task {
	//attribute
	protected String title;
	protected boolean completed;

	//constructor
	public Task(String title) {
		this.title= title;
		this.completed = false;
	}
	
	//getters
	public String getTitle() {
		return title;
	}
	public boolean isCompleted() {
		return completed;
	}
	
	//methods
	public void display() {
		System.out.println(title);
	}
	
	

}

