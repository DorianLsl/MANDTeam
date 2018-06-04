package model.element.mobile;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.Mobile;

public class Daemon2 extends Mobile{

	Image Monster2;

	/**
	 * Define the monster location.
	 * @param Startx
	 * @param Starty
	 */
	public Daemon2(int Startx, int Starty){
		
		x = Startx;
		y = Starty;
		
		ImageIcon iMonster2 = new ImageIcon("Images/monster_2.png");
		Monster2 = iMonster2.getImage();
	}

	/**
	 * get the monster's sprite.
	 * @return
	 */
	public Image getImage(){
		return Monster2;
	}
}
