package model.element.motionless;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Key extends Collectable {
	Image Key;

	public Key(int Startx, int Starty) {
		x = Startx;
		y = Starty;

		ImageIcon iKey = new ImageIcon("Images/crystal_ball.png");
		Key = iKey.getImage();
	}

	public Image getImage() {
		return Key;
	}
}
