package view;

import java.util.Observable;

public interface IView {

	void initialize();

	void update(Observable o, Object arg);
}
