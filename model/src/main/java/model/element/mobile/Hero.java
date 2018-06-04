package model.element.mobile;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.Mobile;

public class Hero extends Mobile {
	public static Object lorann;

	Image LorannImg;
	ImageIcon iLorannDown = new ImageIcon("Images/lorann_b.png");
	ImageIcon iLorannDownLeft = new ImageIcon("Images/lorann_bl.png");
	ImageIcon iLorannDownRight = new ImageIcon("Images/lorann_br.png");
	ImageIcon iLorannRight = new ImageIcon("Images/lorann_r.png");
	ImageIcon iLorannLeft = new ImageIcon("Images/lorann_l.png");
	ImageIcon iLorannUp = new ImageIcon("Images/lorann_u.png");
	ImageIcon iLorannUpLeft = new ImageIcon("Images/lorann_ul.png");
	ImageIcon iLorannUpRight = new ImageIcon("Images/lorann_ur.png");

	/**
	 * Define the Hero location.
	 * @param Startx
	 * @param Starty
	 */
	public Hero(int Startx, int Starty) {
		this.x = Startx;
		this.y = Starty;

		ImageIcon iLorannImg = new ImageIcon("Images/lorann_b.png");
		LorannImg = iLorannImg.getImage();
	}

	/**
	 * get the Hero's sprite.
	 * @return
	 */
	public Image getImage() {
		if (this.getDir() == "DOWN") {
			LorannImg = iLorannDown.getImage();
		} else if (this.getDir() == "DOWNLEFT") {
			LorannImg = iLorannDownLeft.getImage();
		} else if (this.getDir() == "DOWNRIGHT") {
			LorannImg = iLorannDownRight.getImage();
		} else if (this.getDir() == "RIGHT") {
			LorannImg = iLorannRight.getImage();
		} else if (this.getDir() == "LEFT") {
			LorannImg = iLorannLeft.getImage();
		} else if (this.getDir() == "UP") {
			LorannImg = iLorannUp.getImage();
		} else if (this.getDir() == "UPLEFT") {
			LorannImg = iLorannUpLeft.getImage();
		} else if (this.getDir() == "UPRIGHT") {
			LorannImg = iLorannUpRight.getImage();
		}
		return LorannImg;
	}

}