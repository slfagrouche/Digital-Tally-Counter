package DigitalCounterGUI;

/** Digital Counter
 * @author Said Lfagrouche
 * 
 * Digital Counter is a Java Swing application that allows the user to keep track of any type of count. 
 * It features a user-friendly interface with a button for incrementing the count and a label for displaying the current count.
 * The user can reset the count to zero, save the current count, and change the color and font size of the UI. 
 * The program also includes a ComboBox to select between different count types (Counter, Push-ups Count, Prayer, Other).
 * This program makes use of the following libraries:
 * java.awt: provides support for creating and managing UI elements such as buttons, labels, and panels
 * java.awt.event: provides support for handling events such as clicks and selections in the UI
 * javax.swing: provides additional UI elements and functionality such as color choosers and input dialogs
 * javax.swing.border: provides support for creating and applying borders to UI elements
 * javax.swing.event: provides support for handling events in the UI
*/

import java.awt.BorderLayout; 		  // for positioning components in a container
import java.awt.Color; 				  // for setting the color of components
import java.awt.Font; 				  // for setting the font of components
import java.awt.GridLayout; 		  // for arranging components in a grid
import java.awt.event.ActionEvent; 	  // for handling action events
import java.awt.event.ActionListener; // for implementing the ActionListener interface
import javax.swing.BorderFactory; 	  // for creating borders for components
import javax.swing.JButton; 		  // for creating button components
import javax.swing.JColorChooser; 	  // for choosing colors
import javax.swing.JComboBox; 		  // for creating dropdown menus
import javax.swing.JFrame; 			  // for creating the main window for the application
import javax.swing.JLabel; 			  // for creating label components
import javax.swing.JOptionPane; 	  // for displaying dialog boxes
import javax.swing.JPanel;    	   	  // for creating panels for grouping components
import javax.swing.SwingConstants; 	  // for aligning components in a container

public class DigitalCounter implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	private JButton countButton;
	private JButton resetButton;
	private JButton saveButton;
	private JButton colorButton;
	private JButton fontButton;
	private JComboBox<String> countTypes;
	private JLabel countLabel;
	private int count = 0;

	public DigitalCounter() {
		// create a frame and panel for the UI
		frame = new JFrame();
		panel = new JPanel();

		// set the border and layout for the panel
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));
		panel.setLayout(new GridLayout(0, 1));

		// add the panel to the frame and set the frame properties
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Digital Counter");
		
		
		// create a label to display the current count and add it to the panel
		countLabel = new JLabel("0", SwingConstants.CENTER);
		panel.add(countLabel);

		// default background color
		panel.setBackground(new Color(239, 245, 247));
		panel.setOpaque(true);

		// create a button to increase the count and add it to the panel
		countButton = new JButton("Count");
		panel.add(countButton);
		// add an action listener to the button to handle clicks
		countButton.addActionListener(this);

		// create a button to reset the count to 0 and add it to the panel
		resetButton = new JButton("Reset");
		panel.add(resetButton);
		// add an action listener to the button to handle clicks
		resetButton.addActionListener(this);

		// create a button to save the current count and add it to the panel
		saveButton = new JButton("Save");
		panel.add(saveButton);
		// add an action listener to the button to handle clicks
		saveButton.addActionListener(this);

		// create a button to change the color of the panel and add it to the panel
		colorButton = new JButton("Change Color");
		panel.add(colorButton);
		// add an action listener to the button to handle clicks
		colorButton.addActionListener(this);

		// create a button to change the font size of the count label and add it to the
		// panel
		fontButton = new JButton("Change Font Size");
		panel.add(fontButton);
		// add an action listener to the button to handle clicks
		fontButton.addActionListener(this);

		// create a ComboBox to select the count type and add it to the panel
		String[] countOptions = { "Counter", "Push-ups", "Tasbihat", "Prayer", "Other"};
		countTypes = new JComboBox<>(countOptions);
		panel.add(countTypes);
		// add an action listener to the ComboBox to handle selections
		countTypes.addActionListener(this);
		
		// pack the frame and make it visible
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * actionPerformed is a method that handles actions performed on UI elements in
	 * the Digital Counter application. When a user clicks a button or makes
	 * a selection in the ComboBox, this method is called to handle the action. The
	 * method determines which UI element was the source of the action and executes
	 * the appropriate code in response.
	 * 
	 * @param e the ActionEvent object that contains information about the action
	 *          performed (e.g. which UI element was clicked)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == countButton) {
			// increase the count and update the label
			count++;
			countLabel.setText(String.valueOf(count));
		} else if (e.getSource() == resetButton) {
			// reset the count to 0 and update the label
			count = 0;
			countLabel.setText(String.valueOf(count));
		} else if (e.getSource() == saveButton) {
			// code to save the current count
		} else if (e.getSource() == colorButton) {
			// show a color chooser dialog and set the panel color to the chosen color
			Color newColor = JColorChooser.showDialog(frame, "Pick a Color", panel.getBackground());
			panel.setBackground(newColor);
		} else if (e.getSource() == fontButton) {
			// show an input dialog to enter a font size and set the font size of the count
			// label
			try {
				String input = JOptionPane.showInputDialog(frame, "Enter a Font Size (e.g. 12):");
				int size = Integer.parseInt(input);
				Font font = new Font(countLabel.getFont().getName(), countLabel.getFont().getStyle(), size);
				countLabel.setFont(font);
			} catch (Exception ex) {
				//Do nothing when the user enter's empty string
			}
		} else if (e.getSource() == countTypes) {
			// code to switch between different counts
		}
	}

	public static void main(String[] args) {
		// Creating a new DigitalCounter object, which will handle all the necessary tasks
		// for creating and displaying the Digital Counter interface
		new DigitalCounter();
	}
}
