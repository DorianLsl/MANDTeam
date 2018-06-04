package model.element.motionless;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Door {

	int x, y;

	Image Door;

	String State = "CLOSED";
	ImageIcon iDoor = new ImageIcon("Images/gate_closed.png");
	ImageIcon iDoorOpen = new ImageIcon("Images/gate_open.png");

	public Door(int Startx, int Starty) {
		x = Startx;
		y = Starty;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Rectangle getBounds() {
		Rectangle Box = new Rectangle(x, y, 32, 32);
		return Box;
	}

	public String getEtat() {
		return State;
	}

	public void setEtat(String newState) {
		this.State = newState;
	}

	public Image getImage() {
		if (State == "CLOSED") {
			Door = iDoor.getImage();
		} else if (State == "OPEN") {
			Door = iDoorOpen.getImage();
		}
		return Door;

	}
}
