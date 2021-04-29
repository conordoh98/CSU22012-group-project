import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BusStopSearchTest {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("stops.txt")).useDelimiter(",");
		ArrayList<String> stops = new ArrayList<String>();
		ArrayList<String> stopNames = new ArrayList<String>();
		String newString;
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
		a.match("HASTINGS FS CLIFF AVE WB",stops);
	}

}
