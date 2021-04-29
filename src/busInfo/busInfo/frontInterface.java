package busInfo;

import java.util.Scanner;

public class frontInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out
				.println("To select option 1,2 or 3, enter the number\n" + "1. Find shortest paths between two stops\n"
						+ "2. Search for a bus stop\n" + "3. Search for all trops with a given arrival time\n");
		if (!input.hasNextInt()) {
			System.out.println("Error invalid input,please select a valid option\n");
		}
		int option = input.nextInt();
		if (option == 1) {
			System.out.println("Please enter 2 bus stop numbers to find the shortest path between them\n");
			if (!input.hasNextInt()) {
				System.out.println("Error invalid input,please select a stop number\n");
			}
			int stop1 = input.nextInt();
			int stop2 = input.nextInt();
			return shortestPath(stop1, stop2);
		} else if (option == 2) {
			System.out.println("Please enter the bus stop name or the first few characters of the stop name\n");
			String stopName = input.next();
			return ternarySearch(stopName);
		} else if (option == 3) {
			System.out.println("Please enter a trip ID to find its arrival time\n");
			if (!input.hasNextInt()) {
				System.out.println("Error invalid input,please enter a trip ID\n");
			}
			int tripID = input.nextInt();
			return arrivalTime(tripID);
		}
	}

}

// function names and parameters are just placeholders
