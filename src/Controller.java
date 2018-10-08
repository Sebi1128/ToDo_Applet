import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller {
	private Model model;


	public Controller(Model model) {
		this.model = model;
	}
	
	
	public void readStuff() {
		model.readStuff();
	}
	
	public void writeStuff() {
		model.writeStuff();
	}

	

}
