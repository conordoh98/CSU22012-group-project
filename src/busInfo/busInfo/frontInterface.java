package busInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class frontInterface {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean exit=false;
		while(exit!=true) {
			System.out.println("To select option 1,2 or 3, type the number and hit enter\n" + "1. Find shortest paths between two stops\n"
					+ "2. Search for a bus stop\n" + "3. Search for all trips with a given arrival time\n"+"4. quit");
			try {
				int option = input.nextInt();

				if (option == 1) {
					System.out.println("Please enter 2 bus stop numbers to find the shortest path between them\n");
					if (!input.hasNextInt()) {
						System.out.println("Error invalid input,please check each stop number is valid\n");
					}
					int stop1 = input.nextInt();
					int stop2 = input.nextInt();
					ShortestPath sp = new ShortestPath("busInfo/transfers.txt","busInfo/stop_times.txt","busInfo/stops.txt");
					try {
						System.out.println(sp.getPathSequence(stop1, stop2));		
					}
					catch(Exception ArrayIndexOutOfBoundsException) {
						System.out.println("Error invalid input,please check each stop number is valid\n");
					}
				} 

				else if (option == 2) {
					System.out.println("Please enter the bus stop name or the first few characters of the stop name in all caps\n");
					String tmp=input.nextLine();
					assert tmp=="2";
					String stopName = input.nextLine();
					
					Scanner scanner = new Scanner(new File("busInfo/stops.txt")).useDelimiter(",");
					ArrayList<String> stops = new ArrayList<String>();
					ArrayList<String> stopNames = new ArrayList<String>();
					String newString="";
					BusStopSearch a = new BusStopSearch();
					int key = 9;

					while(scanner.hasNext())
					{
						String temp = scanner.next();
						stops.add(temp);
					}
					for(int i=11; i<stops.size(); i+=9)
					{
						stopNames.add(stops.get(i));
					}
					for(int i=0; i<stopNames.size(); i++)
					{
						if(stopNames.get(i).charAt(2) == ' ')
						{
							newString = stopNames.get(i).substring(3) + " " + stopNames.get(i).substring(0, 2);
							stopNames.set(i, newString);
						}
						a.insert(stopNames.get(i), key);
						key += 9;
					}
					a.match(stopName,stops);
				}

				else if (option == 3) {
					System.out.println("Please enter an arrival time in the format HH:MM:SS to find the trips which match\n");
					String arrivalTime = input.next();	
					if(!Character.isDigit(arrivalTime.charAt(0))||!Character.isDigit(arrivalTime.charAt(1))||arrivalTime.charAt(2)!=':'||
							!Character.isDigit(arrivalTime.charAt(3))||!Character.isDigit(arrivalTime.charAt(4))||arrivalTime.charAt(5)!=':'||
							!Character.isDigit(arrivalTime.charAt(6))||!Character.isDigit(arrivalTime.charAt(7))) {
						System.out.println("Error invalid input,please enter the arrival time in the format HH:MM:SS\n");
					}
					else {
						String outputString="";
						ArrayList<String[]> returnList= tripSearch.search(arrivalTime);
						if(returnList.get(0)[0]==null) {
							System.out.println("There does not appear to be any trips matching this time");
						}
						else {
							System.out.println("Trip ID\t\tArrival time\tDeparture time\tStop ID\tStop Sequence\tDropoff type\tShape Distance Travelled");
							for(int i=0;i<returnList.size();i++) {
								for(int j=0;j<8;j++) {
									if(j==5) {
										outputString+="\t";
									}
									else if(j==6) {
										outputString+=returnList.get(i)[j]+",\t\t";
									}
									else {
										outputString+=returnList.get(i)[j]+",\t";
									}
								}
								if(i==returnList.size()-1) {
									outputString=outputString.substring(0, outputString.length()-2)+"\n";
								}
								else outputString+="\n";
							}
							System.out.println(outputString);
						}
					}
				}
				else if(option == 4) {
					System.out.println("Goodbye!");
					exit=true;
				}
				else System.out.println("Error invalid input,please select a valid option\n");
			}
			catch(Exception InputMismatchException) {
				System.out.println("Error invalid input,please select a valid option\n");
				input.nextLine();
			}
		}
	}
}



