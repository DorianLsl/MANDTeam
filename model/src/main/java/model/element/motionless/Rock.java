package model.element.motionless;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Rock extends Wall {

	Image bone1;

	public Rock(int Startx, int Starty) {

		this.x = Startx;
		this.y = Starty;

		ImageIcon ibone1Img = new ImageIcon("Images/bone.png");
		bone1 = ibone1Img.getImage();
	}

	public Image getImage() {
		return bone1;
	}
}
