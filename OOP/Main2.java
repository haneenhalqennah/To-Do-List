package oopPackage;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		//variables
		int numOfTaskD;
		int numOfTaskC;
		String choose;
		
		//objects
		Scanner scan = new Scanner(System.in); 
		ControlUnit TheManager = new ControlUnit();
		
		//structure design
		System.out.println("\n---------------wellcome to the TODOLIST application-----------------");
		
		do {
			System.out.println("- Enter A to add a task\n- Enter D to delete a task\n- Enter C to check the task\n- Enter N to see the tasks you havn't done\n- Enter E to exit the application");
			choose = scan.next().toUpperCase();
			if ( !choose.equals("A") && !choose.equals("D") && !choose.equals("C") && !choose.equals("S") && !choose.equals("E") && !choose.equals("N")) {
				System.out.println("Invalid input");
				continue;
			}
			switch (choose) {
				case "A": {
					scan.nextLine();
					System.out.println("Enter your task: ");
					TheManager.addT(scan.nextLine());
					TheManager.seeT();
					break;
				}
				case "D": {
					System.out.println("Enter the number of the task you want to delete: ");
					numOfTaskD = scan.nextInt()- 1;
					TheManager.deleteT(numOfTaskD);
					TheManager.seeT();
					break;
				}
				case "C": {
					System.out.println("Enter the number of the task you have done: ");
					numOfTaskC = scan.nextInt() - 1;
					TheManager.checkT(numOfTaskC);
					TheManager.seeT();
				    break;
				}
				case "N": {
					TheManager.seeTNDone();
					break;
				}
			}
			
		}while (!choose.equals("E"));
		System.out.println("Thank you for using our application");
		scan.close();
		
	}

}
