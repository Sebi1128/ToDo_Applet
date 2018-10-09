import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;



public class Model extends Observable {


	
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

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
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
	
	
	public void writeStuff() {        
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
            bufferedWriter.write("Hello there,");
            bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");

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

}
