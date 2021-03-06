package main;

import controller.Controller;
import model.ModelFacade;
import view.ViewFacade;

public abstract class Main {

	/**
	 * The main method
	 * @param args
	 */
	public static void main(final String[] args) {

		ViewFacade view = new ViewFacade();

		new Controller(view, new ModelFacade());

		view.setVisible(true);
	}
}