import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Taschenrechner extends JFrame {
	private static final long serialVersionUID = 1L;

	public Taschenrechner() {
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller);
		model.addObserver(view);
		
		getContentPane().add(view);

		// Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				Taschenrechner frame = new Taschenrechner();
				frame.setUndecorated(false);
				//frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("DoDo Tool");
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}
