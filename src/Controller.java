import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Controller {
	private Model model;
	private View hausaufgabenView;


	public Controller(Model model) {
		this.model = model;
	}
	
	
	public void readStuff() {
		model.readStuff();
	}
	
	public void saveData() {
		model.saveData();
	}


	public void saveTextFromHausaufgaben(String schtring) {
		model.setTextFromHausaufgaben(schtring);
	}


	public String getTextHausaufgaben() {
		return model.getTextHausaufgaben();
	}



}
