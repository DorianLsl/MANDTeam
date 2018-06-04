package controller;

import model.IModel;
import view.IView;

public class Controller {
	private IModel model;
	private IView view;

	/**
	 * Instantiates a new controller facade.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 * 
	 */
	public Controller(IView v, IModel m) {
		view = v;
		model = m;
		model.action();
	}

	/*
	 * Start.
	 *
	 * @throws SQLException the SQL exception
	 * 
	 * public void start() throws SQLException {
	 * this.getView().displayMessage(this.getModel().getExampleById(1).toString(
	 * ));
	 * 
	 * this.getView().displayMessage(this.getModel().
	 * getExampleByName("Example 2").toString());
	 * 
	 * final List<Example> examples = this.getModel().getAllExamples(); final
	 * StringBuilder message = new StringBuilder(); for (final Example example :
	 * examples) { message.append(example); message.append('\n'); }
	 * this.getView().displayMessage(message.toString()); }
	 */

}
