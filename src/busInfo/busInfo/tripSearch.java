import java.util.ArrayList;
package tripSearch.java
public class tripSearch{
	public static void search(String searchTerm) {
        try{
	    ArrayList<String[]> tripDetails = new ArrayList<>(0);
        File map = new File("stop_times.txt");
	    Scanner myReader = new Scanner(map);
    	myReader.nextLine();
        while (myReader.hasNextLine()) {
          String[] currentLine = myReader.nextLine.split(",");
          if(currentLine.length>2){
          if(currentLine[1].replace(" ","0").equals(searchTerm)){
              tripDetails.add({currentLine[0],currentLine[1].replace(" ","0"),currentLine[2].replace(" ","0"),currentLine[3]
              ,currentLine[4],currentLine[5],currentLine[6],currentLine[7],currentLine[8]})
          }}
        }
        myReader.close();  } catch (FileNotFoundException ex){
            return tripDetails;
        }
        return tripDetails;
}

}
