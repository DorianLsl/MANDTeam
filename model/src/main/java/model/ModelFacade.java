package model;

import java.util.Observable;

public class ModelFacade extends Observable implements IModel {

	public void triggerChange(String what) {
		this.setChanged();
		this.notifyObservers(what);
	}

	public void action() {
		triggerChange("action");
	}

	public ModelFacade() {
		super();
	}

}