package model.element.mobile;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.Mobile;

public class Daemon2 extends Mobile{

	Image Monster2;

	public Daemon2(int Startx, int Starty){
		
		x = Startx;
		y = Starty;
		
		ImageIcon iMonster2 = new ImageIcon("Images/monster_2.png");
		Monster2 = iMonster2.getImage();
	}

	public Image getImage(){
		return Monster2;
	}
}
