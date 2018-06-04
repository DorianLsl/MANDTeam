package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.GameBoard;
import model.IModel;

public class ViewFacade extends JFrame implements Observer, IView {

	private static final long serialVersionUID = 1L;
	private IModel model;

	public ViewFacade() {
		super();
		initialize();
	}

	public void initialize() {
		this.setTitle("Lorann");
		this.setSize(800, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(new GameBoard());
		this.setResizable(false);
	}

	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("action")) {
			displayMessage("Action!");
		}

	}

}
