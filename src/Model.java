import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;



public class Model extends Observable {

	private String schtringHausaufgaben = "";
	private String schtringPuefungen = "";
	private String schtringSonstiges = "";

	
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
	
	
	
	public void readStuff() {
		String filename = "temp.txt";
		String workingDirectory = System.getProperty("user.dir");
			
		//****************//
			
		String absoluteFilePath = "";
			
		//absoluteFilePath = workingDirectory + System.getProperty("file.separator") + filename;
		absoluteFilePath = workingDirectory + File.separator + filename;


        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(absoluteFilePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
            	if (line.equals("----------THIS_IS_A_NEW_TAB---------")) {
            		i++;
            	}
            	else if(i==0) {
            		schtringHausaufgaben += line;
            	}
            	else if(i==1) {
            		schtringPuefungen += line;
            	}
            	else if(i==2) {
            		schtringSonstiges += line;
            	}
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                		absoluteFilePath + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + absoluteFilePath + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
	
	
	public void saveData() {        
        String filename = "temp.txt";
		String workingDirectory = System.getProperty("user.dir");
			
		//****************//
			
		String absoluteFilePath = "";
			
		//absoluteFilePath = workingDirectory + System.getProperty("file.separator") + filename;
		absoluteFilePath = workingDirectory + File.separator + filename;

		System.out.println("Final filepath : " + absoluteFilePath);
		
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(absoluteFilePath);
            
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            
            // Note that write() does not automatically
            // append a newline character.
            
            bufferedWriter.write(schtringHausaufgaben);
            bufferedWriter.newLine();
            bufferedWriter.write("----------THIS_IS_A_NEW_TAB---------");
            
            bufferedWriter.write(schtringPuefungen);
            bufferedWriter.newLine();
            bufferedWriter.write("----------THIS_IS_A_NEW_TAB---------");
            
            bufferedWriter.write(schtringSonstiges);
            bufferedWriter.newLine();
            bufferedWriter.write("----------THIS_IS_A_NEW_TAB---------");
            
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + absoluteFilePath + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
	}



	public void setTextFromHausaufgaben(String schtring) {
		schtringHausaufgaben = schtring;
	}
	
	public String getTextHausaufgaben() {
		return schtringHausaufgaben;
	}
	
	public String getTextPruefungen() {
		return schtringPuefungen;
	}
	
	public String getTextSonstiges() {
		return schtringSonstiges;
	}

}
