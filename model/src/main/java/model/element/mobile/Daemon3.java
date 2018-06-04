package model.element.mobile;

import java.awt.Image;


import javax.swing.ImageIcon;

import model.Mobile;

public class Daemon3 extends Mobile{

	Image Monster3;

	public Daemon3(int Startx, int Starty){

		x = Startx;
		y = Starty;
		
		ImageIcon iMonster3 = new ImageIcon("Images/monster_3.png");
		Monster3 = iMonster3.getImage();
		
	}

	public Image getImage(){
		return Monster3;
	}
	
}