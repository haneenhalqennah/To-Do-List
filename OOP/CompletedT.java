package oopPackage;

public class CompletedT extends Task {
	//constructors
	public CompletedT(String title) {
		super(title);
		this.completed = true;
	}
	
	//methods
	public void display() {
		System.out.println(title + " [Done]");
	}

}
