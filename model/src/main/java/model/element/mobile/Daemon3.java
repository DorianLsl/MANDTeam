package model.element.mobile;

import java.awt.Image;


import javax.swing.ImageIcon;

import model.Mobile;

public class Daemon3 extends Mobile{

	Image Monster3;

	/**
	 * Define the monster location.
	 * @param Startx
	 * @param Starty
	 */
	public Daemon3(int Startx, int Starty){

		x = Startx;
		y = Starty;
		
		ImageIcon iMonster3 = new ImageIcon("Images/monster_3.png");
		Monster3 = iMonster3.getImage();
		
	}

	/**
	 * get the monster's sprite.
	 * @return
	 */
	public Image getImage(){
		return Monster3;
	}
	
}