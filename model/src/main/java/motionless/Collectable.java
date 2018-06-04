package model.element.motionless;

import java.awt.Rectangle;

public class Collectable {

	int x, y;

	public Rectangle getBounds() {
		Rectangle Box = new Rectangle(x, y, 32, 32);
		return Box;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
