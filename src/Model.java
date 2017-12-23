import java.util.Observable;

public class Model extends Observable {


	
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}

}
