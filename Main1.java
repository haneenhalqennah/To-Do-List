package proceduralPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
	static void seeMyTasks(ArrayList<String> tasks, ArrayList<Integer> tasksN) {
		System.out.println("\nThese are your tasks: ");
		for (int i = 0; i < tasks.size(); i++) {
			System.out.println(i+1 +"- "+tasks.get(i)+"["+tasksN.get(i)+"]");
		}
		System.out.println("------------------------------------");
	}

	public static void main(String[] args) {
		ArrayList<String> tasks = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> tasksN = new ArrayList<Integer>();
		String choose = "";
		int numOfTaskC = 0;
		int numOfTaskD = 0;
		
		System.out.println("---------------wellcome to the TODOLIST application-----------------");
		
		do {
			System.out.println("- Enter A to add a task\n- Enter D to delete a task\n- Enter C to check the task\n- Enter E to exit the application");
			choose = scan.next().toUpperCase();
			if ( !choose.equals("A") && !choose.equals("D") && !choose.equals("C") && !choose.equals("S") && !choose.equals("E") ) {
				System.out.println("Invalid input");
				continue;
			}
			switch (choose) {
				case "A": {
					scan.nextLine();
					System.out.println("Enter your task: ");
					tasks.add(scan.nextLine());
					tasksN.add(0);
					seeMyTasks(tasks,tasksN);
					break;
				}
				case "D": {
					System.out.println("Enter the number of the task you want to delete: ");
					numOfTaskD = scan.nextInt()- 1;
					tasks.remove(numOfTaskD);
					tasksN.remove(numOfTaskD);
					
					seeMyTasks(tasks,tasksN);
					break;
				}
				case "C": {
					System.out.println("Enter the number of the task you have done: ");
					numOfTaskC = scan.nextInt() - 1;
					tasksN.set(numOfTaskC, 1);
					seeMyTasks(tasks,tasksN);
					break;
				}
				
			}
			
		} while (!choose.equals("E"));
		
		System.out.println("Thank you for using our application");
		
	
	}

}
