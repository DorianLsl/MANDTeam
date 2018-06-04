package main;

import controller.Controller;
import model.ModelFacade;
import view.ViewFacade;

public abstract class Main {

	public static void main(final String[] args) {

		ViewFacade view = new ViewFacade();

		new Controller(view, new ModelFacade());

		view.setVisible(true);
	}
}