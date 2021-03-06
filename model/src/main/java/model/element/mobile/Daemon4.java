package model.element.mobile;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.Mobile;

public class Daemon4 extends Mobile{

	Image Monster4;

	/**
	 * Define the monster location.
	 * @param Startx
	 * @param Starty
	 */
	public Daemon4(int Startx, int Starty){

		x = Startx;
		y = Starty;
		
		ImageIcon iMonster4 = new ImageIcon("Images/monster_4.png");
		Monster4 = iMonster4.getImage();
		
	}

	/**
	 * get the monster's sprite.
	 * @return
	 */
	public Image getImage(){
		return Monster4;
	}
	
}