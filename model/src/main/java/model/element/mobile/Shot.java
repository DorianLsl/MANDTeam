package model.element.mobile;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.Mobile;

public class Shot extends Mobile {

	Image Shot;
	public int StateShot = 0;

	ImageIcon iShot1 = new ImageIcon("Images/fireball_1.png");
	ImageIcon iShot2 = new ImageIcon("Images/fireball_2.png");
	ImageIcon iShot3 = new ImageIcon("Images/fireball_3.png");
	ImageIcon iShot4 = new ImageIcon("Images/fireball_4.png");
	ImageIcon iShot5 = new ImageIcon("Images/fireball_5.png");

	public Shot(int Startx, int Starty) {
		x = Startx;
		y = Starty;

		ImageIcon iShot = new ImageIcon("Images/fireball_1.png");
		Shot = iShot.getImage();
	}

	public Image getImage() {
		if (StateShot == 0) {
			Shot = iShot1.getImage();
		} else if (StateShot == 1) {
			Shot = iShot2.getImage();
		} else if (StateShot == 2) {
			Shot = iShot3.getImage();
		} else if (StateShot == 4) {
			Shot = iShot4.getImage();
		} else if (StateShot == 5) {
			Shot = iShot5.getImage();
		}
		return Shot;
	}
}