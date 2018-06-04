package model;

import java.awt.Rectangle;

public class Mobile {

	public int x, y;
	public String direction;

	/**
	 * get the number of pixel for each element.
	 * @return
	 */
	public Rectangle getBounds() {
		Rectangle Box = new Rectangle(x, y, 32, 32);
		return Box;
	}

	/**
	 * get the X value.
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * set the X value.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * get the Y value.
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * set the Y value.
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * get the direction.
	 * @return
	 */
	public String getDir() {
		return direction;
	}

	/**
	 * set the direction.
	 * @param direction
	 */
	public void setDir(String direction) {
		this.direction = direction;
	}

	/**
	 * define the possible movement.
	 */
	public void move() {
		switch (this.getDir()) {
		case "UP":
			this.moveUp();
			break;
		case "RIGHT":
			this.moveRight();
			break;
		case "DOWN":
			this.moveDown();
			break;
		case "LEFT":
			this.moveLeft();
			break;
		case "UPLEFT":
			this.moveUpLeft();
			break;
		case "DOWNLEFT":
			this.moveDownLeft();
			break;
		case "UPRIGHT":
			this.moveUpRight();
			break;
		case "DOWNRIGHT":
			this.moveDownRight();
			break;
		default:
			break;
		}
	}

	/**
	 * method to move up.
	 */
	void moveUp() {
		this.setY(getY() - 32);
	}

	/**
	 * method to move right.
	 */
	void moveRight() {
		this.setX(getX() + 32);
	}

	/**
	 * method to move down.
	 */
	void moveDown() {
		this.setY(getY() + 32);
	}

	/**
	 * method to move left.
	 */
	void moveLeft() {
		this.setX(getX() - 32);
	}

	/**
	 * method to move up right.
	 */
	void moveUpRight() {
		this.setY(getY() - 32);
		this.setX(getX() + 32);
	}

	/**
	 * method to move down right.
	 */
	void moveDownRight() {
		this.setX(getX() + 32);
		this.setY(getY() + 32);
	}

	/**
	 * method to move down left.
	 */
	void moveDownLeft() {
		this.setY(getY() + 32);
		this.setX(getX() - 32);
	}

	/**
	 * method to move up left.
	 */
	void moveUpLeft() {
		this.setY(getY() - 32);
		this.setX(getX() - 32);
	}
}
