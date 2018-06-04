package model.element.mobile;

import java.awt.Image;


import javax.swing.ImageIcon;

import model.Mobile;

public class Daemon1 extends Mobile {

	Image Monster1;

	/**
	 * Define the monster location.
	 * @param Startx
	 * @param Starty
	 */
	public Daemon1(int Startx, int Starty){
		x = Startx;
		y = Starty;
		
		ImageIcon iMonster1 = new ImageIcon("Images/monster_1.png");
		Monster1 = iMonster1.getImage();
	}

	/**
	 * get the monster's sprite.
	 * @return
	 */
	public Image getImage(){
		return Monster1;
	}
}
