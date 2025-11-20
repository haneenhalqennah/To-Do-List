package oopPackage;

	public class UncompletedT extends Task {
	        //constructors
			public UncompletedT(String title) {
				super(title);
			}
			
			//methods
			public void display() {
				System.out.println(title + " [Not done]");
			}

	}
