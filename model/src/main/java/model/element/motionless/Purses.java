package model.element.motionless;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Purses extends Collectable {
	Image Purses;

	public Purses(int Startx, int Starty) {
		x = Startx;
		y = Starty;

		ImageIcon iPurses = new ImageIcon("Images/purse.png");
		Purses = iPurses.getImage();
	}

	public Image getImage() {
		return Purses;
	}

}
