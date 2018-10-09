import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

public class View extends JPanel implements Observer, ActionListener, KeyListener{

	private Controller controller;
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	
	private JTextField tfR1 = new JTextField();
	
	
	 
	private JTextArea tfFriday = new JTextArea(5, 20);
	
	
	private JButton btSave = new JButton("save");

	
	public View(Controller ctrl) {
		super(new GridBagLayout());
		//setBorder(MyBorderFactory.createMyBorder(" GridBagLayoutPanel "));
		this.controller = ctrl;
		
		
		panel1.setPreferredSize(new Dimension(200, 0));
		//panel1.setBorder(MyBorderFactory.createMyBorder(" Panel 1 "));
		
		
		panel1.setLayout(new GridBagLayout());
		// x, y, x-span, y-span, x-weight, y-weight, anchor, fill, insets(int top, int left, int bottom, int right), internal padding x, internal padding y. 
		panel1.add(new JLabel("R1"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		panel1.add(tfR1, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		panel1.add(new JLabel("Ohm"), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		panel1.add(new JLabel(), new GridBagConstraints(1, 1, 1, 1, 0.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(10, 10, 10, 10), 0, 0));

		// x, y, x-span, y-span, x-weight, y-weight, anchor, fill, insets(int top, int left, int bottom, int right), internal padding x, internal padding y. 
		add(panel1, new GridBagConstraints(0, 0, 1, 2, 0.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(10, 10, 10, 10), 0, 0));

		panel2.setPreferredSize(new Dimension(80, 0));
		panel2.setBorder(MyBorderFactory.createMyBorder(" Panel 2 "));
		// x, y, x-span, y-span, x-weight, y-weight, anchor, fill, insets(int top, int left, int bottom, int right), internal padding x, internal padding y. 
		add(panel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(10, 10, 10, 10), 0, 0));

		panel3.setPreferredSize(new Dimension(80, 0));
		panel3.setBorder(MyBorderFactory.createMyBorder(" Panel 3 "));
		// x, y, x-span, y-span, x-weight, y-weight, anchor, fill, insets(int top, int left, int bottom, int right), internal padding x, internal padding y. 
		add(panel3, new GridBagConstraints(1, 1, 1, 1, 0.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(10, 10, 10, 10), 0, 0));

		panel4.setPreferredSize(new Dimension(120, 400));
		panel4.setLayout(new GridBagLayout());
		panel4.setBorder(MyBorderFactory.createMyBorder(" Friday "));
		tfFriday.addKeyListener(this);
		JScrollPane scrollPane = new JScrollPane(tfFriday);
		panel4.add(scrollPane, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
		btSave.addActionListener(this);
		panel4.add(btSave, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		add(panel4, new GridBagConstraints(2, 0, 1, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
		
		
		// x, y, x-span, y-span, x-weight, y-weight, anchor, fill, insets(int top, int left, int bottom, int right), internal padding x, internal padding y. 
		// x-weight, y-weight: 	Geben an wie die ZELLEN in x resp. y - Richtung wachsen!
		// anchor:				Gibt an, wie die Komponente innerhab der zugehörigen Zellen verankert ist!
		// fill:				Gibt an, wie die KOMPONENTE sich an die zugehörigen Zellen anpasst!
	}
	
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Grüezi");
		controller.writeStuff();
		controller.readStuff();
	}

	public void update(Observable modelObject, Object dataObject) {
		Model model = (Model) modelObject;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println("Type");
	}
}
