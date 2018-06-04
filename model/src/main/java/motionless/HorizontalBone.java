package model.element.motionless;

import java.awt.Image;

import javax.swing.ImageIcon;

public class HorizontalBone extends Wall {

	Image bone2;

	public HorizontalBone(int Startx, int Starty) {

		this.x = Startx;
		this.y = Starty;

		ImageIcon ibone2Img = new ImageIcon("Images/horizontal_bone.png");
		bone2 = ibone2Img.getImage();
	}

	public Image getImage() {
		return bone2;
	}
}
