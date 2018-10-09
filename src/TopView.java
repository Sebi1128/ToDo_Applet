import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTabbedPane;

class TopView extends JTabbedPane implements Observer {

	HausaufgabenView hausaufgaben;
	PruefungenView pruefungen; 
	SonstigesView sonstiges;
	
	
	public TopView(Controller controller) {
		setTabPlacement(JTabbedPane.TOP);

		hausaufgaben = new HausaufgabenView(controller);
		addTab("Hausaufgaben", hausaufgaben);
		setMnemonicAt(0, KeyEvent.VK_B);

		pruefungen = new PruefungenView(controller);
		addTab("Prüfungen", pruefungen);
		setMnemonicAt(1, KeyEvent.VK_I);

		sonstiges = new SonstigesView(controller);
		addTab("Sonstiges", sonstiges);
		setMnemonicAt(2, KeyEvent.VK_C);


		this.setSelectedComponent(hausaufgaben);
	}

	public void update(Observable obs, Object obj) {}

}