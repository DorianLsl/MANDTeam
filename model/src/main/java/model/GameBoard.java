package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.element.mobile.Daemon1;
import model.element.mobile.Daemon2;
import model.element.mobile.Daemon3;
import model.element.mobile.Daemon4;
import model.element.mobile.Hero;
import model.element.mobile.Shot;
import model.element.motionless.Door;
import model.element.motionless.HorizontalBone;
import model.element.motionless.Key;
import model.element.motionless.Purses;
import model.element.motionless.Rock;
import model.element.motionless.VerticalBone;

public class GameBoard extends JPanel implements KeyListener, IModel {

	private static final long serialVersionUID = 1L;
	String Game[][] = new String[24][24];
	int level = 1;
	int score = 0;

	boolean shoot = false;
	boolean touch = false;
	boolean prisond1 = false;
	boolean prisond2 = false;
	boolean prisond3 = false;
	boolean prisond4 = false;

	private static ArrayList<Rock> Rock;
	private static ArrayList<HorizontalBone> HorizontalBone;
	private static ArrayList<VerticalBone> VerticalBone;
	private static ArrayList<Key> Key;
	private static ArrayList<Purses> Purses;
	private static ArrayList<Daemon1> Daemon1;
	private static ArrayList<Daemon2> Daemon2;
	private static ArrayList<Daemon3> Daemon3;
	private static ArrayList<Daemon4> Daemon4;
	private static ArrayList<Door> Door;
	private static ArrayList<Shot> Shot;

	Rock rock;
	HorizontalBone horizontalBone;
	VerticalBone verticalBone;
	Hero hero;
	Key key;
	Purses purses;
	Daemon1 daemon1;
	Daemon2 daemon2;
	Daemon3 daemon3;
	Daemon4 daemon4;
	Door door;
	Shot shot;
	Font levelFont = new Font("SansSerif", Font.BOLD, 30);
	FileReader fr;

	public GameBoard() {
		this.setBackground(Color.BLACK);
		generateLevel();
		setFocusable(true);
		addKeyListener(this);
	}

	public void generateLevel() {
		try {
			fr = new FileReader("Maps/level" + level + ".level");
			int x = 0, y = 0, i = 0;
			touch = false;
			shoot = false;
			prisond1 = false;
			prisond2 = false;
			prisond3 = false;
			prisond4 = false;

			Rock = new ArrayList<Rock>();
			HorizontalBone = new ArrayList<HorizontalBone>();
			VerticalBone = new ArrayList<VerticalBone>();
			Key = new ArrayList<Key>();
			Purses = new ArrayList<Purses>();
			Daemon1 = new ArrayList<Daemon1>();
			Daemon2 = new ArrayList<Daemon2>();
			Daemon3 = new ArrayList<Daemon3>();
			Daemon4 = new ArrayList<Daemon4>();
			Door = new ArrayList<Door>();
			Shot = new ArrayList<Shot>();

			while ((i = fr.read()) != -1) {
				char strImg = (char) i;

				switch (strImg) {
				case 'O':
					Game[x][y] = "WALLS";
					rock = new Rock(x * 32, y * 32);
					Rock.add(rock);
					break;
				case '-':
					Game[x][y] = "WALLS";
					horizontalBone = new HorizontalBone(x * 32, y * 32);
					HorizontalBone.add(horizontalBone);
					break;
				case '|':
					Game[x][y] = "WALLS";
					verticalBone = new VerticalBone(x * 32, y * 32);
					VerticalBone.add(verticalBone);
					break;
				case 'H':
					Game[x][y] = "HERO";
					hero = new Hero(x * 32, y * 32);
					break;
				case 'K':
					Game[x][y] = "KEY";
					key = new Key(x * 32, y * 32);
					Key.add(key);
					break;
				case 'P':
					Game[x][y] = "PURSES";
					purses = new Purses(x * 32, y * 32);
					Purses.add(purses);
					break;
				case 'W':
					Game[x][y] = "DAEMON1";
					daemon1 = new Daemon1(x * 32, y * 32);
					Daemon1.add(daemon1);
					break;
				case 'X':
					Game[x][y] = "DAEMON2";
					daemon2 = new Daemon2(x * 32, y * 32);
					Daemon2.add(daemon2);
					break;
				case 'C':
					Game[x][y] = "DAEMON3";
					daemon3 = new Daemon3(x * 32, y * 32);
					Daemon3.add(daemon3);
					break;
				case 'V':
					Game[x][y] = "DAEMON4";
					daemon4 = new Daemon4(x * 32, y * 32);
					Daemon4.add(daemon4);
					break;
				case 'D':
					Game[x][y] = "DOOR";
					door = new Door(x * 32, y * 32);
					Door.add(door);
					break;
				case ' ':
					Game[x][y] = null;
					break;
				case '\n':
					x--;
					break;
				case '\r':
					x--;
					break;
				}

				if (x == 23) {
					y++;
					x = 0;
				} else {
					x++;
				}
			}
		} catch (Exception ex) {
			repaint();
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i < Rock.size(); i++) {
			rock = (Rock) Rock.get(i);
			g2d.drawImage(rock.getImage(), rock.getX(), rock.getY(), null);
		}
		for (int i = 0; i < HorizontalBone.size(); i++) {
			horizontalBone = (HorizontalBone) HorizontalBone.get(i);
			g2d.drawImage(horizontalBone.getImage(), horizontalBone.getX(), horizontalBone.getY(), null);
		}
		for (int i = 0; i < VerticalBone.size(); i++) {
			verticalBone = (VerticalBone) VerticalBone.get(i);
			g2d.drawImage(verticalBone.getImage(), verticalBone.getX(), verticalBone.getY(), null);
		}
		for (int i = 0; i < Key.size(); i++) {
			key = (Key) Key.get(i);
			g2d.drawImage(key.getImage(), key.getX(), key.getY(), null);
		}
		for (int i = 0; i < Purses.size(); i++) {
			purses = (Purses) Purses.get(i);
			g2d.drawImage(purses.getImage(), purses.getX(), purses.getY(), null);
		}
		for (int i = 0; i < Daemon1.size(); i++) {
			daemon1 = (Daemon1) Daemon1.get(i);
			g2d.drawImage(daemon1.getImage(), daemon1.getX(), daemon1.getY(), null);
		}
		for (int i = 0; i < Daemon2.size(); i++) {
			daemon2 = (Daemon2) Daemon2.get(i);
			g2d.drawImage(daemon2.getImage(), daemon2.getX(), daemon2.getY(), null);
		}
		for (int i = 0; i < Daemon3.size(); i++) {
			daemon3 = (Daemon3) Daemon3.get(i);
			g2d.drawImage(daemon3.getImage(), daemon3.getX(), daemon3.getY(), null);
		}
		for (int i = 0; i < Daemon4.size(); i++) {
			daemon4 = (Daemon4) Daemon4.get(i);
			g2d.drawImage(daemon4.getImage(), daemon4.getX(), daemon4.getY(), null);
		}
		for (int i = 0; i < Shot.size(); i++) {
			shot = (Shot) Shot.get(i);
			g2d.drawImage(shot.getImage(), shot.getX(), shot.getY(), null);
		}

		try {
			g2d.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);
			g2d.drawImage(door.getImage(), door.getX(), door.getY(), null);
		} catch (Exception ex) {
		}
		g.setColor(Color.CYAN);
		g.setFont(levelFont);
		g.drawString("LEVEL : " + level + " / Score : " + score, 240, 400);

		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int Key = arg0.getKeyCode();
		int x = 0;
		int y = 0;

		switch (Key) {
		case KeyEvent.VK_DOWN:
			if (!CheckCollision("DOWN") && !DaemonEat(daemon1) && !DaemonEat(daemon2) && !DaemonEat(daemon3)
					&& !DaemonEat(daemon4)) {
				hero.setDir("DOWN");
				hero.move();
				Objectif();
			}
			break;
		case KeyEvent.VK_UP:
			if (!CheckCollision("UP") && !DaemonEat(daemon1) && !DaemonEat(daemon2) && !DaemonEat(daemon3)) {
				hero.setDir("UP");
				hero.move();
				Objectif();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (!CheckCollision("RIGHT") && !DaemonEat(daemon1) && !DaemonEat(daemon2) && !DaemonEat(daemon3)) {
				hero.setDir("RIGHT");
				hero.move();
				Objectif();
			}
			break;
		case KeyEvent.VK_LEFT:
			if (!CheckCollision("LEFT") && !DaemonEat(daemon1) && !DaemonEat(daemon2) && !DaemonEat(daemon3)) {
				hero.setDir("LEFT");
				hero.move();
				Objectif();
			}
			break;
		case KeyEvent.VK_SPACE:
			if (shoot == false) {
				shoot = true;
				shot = new Shot(x * 32, y * 32);
				Shot.add(shot);
				Shoot();
			} else if (shoot == true) {
				ShotRemove();
				touch = true;
			}
			break;
		}
		repaint();
	}

	public void Shoot() {

		if (shoot == true) {
			switch (hero.getDir()) {
			case "DOWN":
				shot.setY(hero.getY() - 32);
				shot.setX(hero.getX());
				shot.setDir("UP");
				break;
			case "UP":
				shot.setY(hero.getY() + 32);
				shot.setX(hero.getX());
				shot.setDir("DOWN");
				break;
			case "LEFT":
				shot.setY(hero.getY());
				shot.setX(hero.getX() + 32);
				shot.setDir("RIGHT");
				break;
			case "RIGHT":
				shot.setY(hero.getY());
				shot.setX(hero.getX() - 32);
				shot.setDir("LEFT");
				break;
			/*
			 * case "DOWNRIGHT": shot.setY(hero.getY() - 32);
			 * shot.setX(hero.getX() - 32); shot.setDir("UPLEFT"); break;
			 * 
			 * case "DOWNLEFT": shot.setY(hero.getY() - 32);
			 * shot.setX(hero.getX() + 32); shot.setDir("UPRIGHT"); break; case
			 * "UPRIGHT": shot.setY(hero.getY() + 32); shot.setX(hero.getX() -
			 * 32); shot.setDir("UPLEFT"); break; case "UPLEFT":
			 * shot.setY(hero.getY() + 32); shot.setX(hero.getX() + 32);
			 * shot.setDir("DOWNRIGHT"); break;
			 */
			}
		}

	}

	public void FollowShoot() {

		if (shoot == true) {
			if (shot.StateShot > 4)
				shot.StateShot = 0;
			switch (shot.getDir()) {
			case "RIGHT":
				if (CheckShot("RIGHT") == false && touch == false) {
					shot.StateShot++;
					shot.move();
				} else {
					touch = true;
				}
				break;
			case "LEFT":
				if (CheckShot("LEFT") == false && touch == false) {
					shot.StateShot++;
					shot.move();
				} else {
					touch = true;
				}
				break;
			case "UP":
				if (CheckShot("UP") == false && touch == false) {
					shot.StateShot++;
					shot.move();
				} else {
					touch = true;
				}
				break;
			case "DOWN":
				if (CheckShot("DOWN") == false && touch == false) {
					shot.StateShot++;
					shot.move();
				} else {
					touch = true;
				}
				break;
			case "DOWNLEFT":
				if (CheckShot("DOWNLEFT") == false && touch == false) {
					shot.StateShot++;
					shot.move();
				} else {
					touch = true;
				}
				break;
			case "DOWNRIGHT":
				if (CheckShot("DOWNRIGHT") == false && touch == false) {
					shot.StateShot++;
					shot.move();
				} else {
					touch = true;
				}
				break;
			case "UPRIGHT":
				if (CheckShot("UPRIGHT") == false && touch == false) {
					shot.StateShot++;
					shot.move();
				} else {
					touch = true;
				}
				break;
			case "UPLEFT":
				if (CheckShot("UPLEFT") == false && touch == false) {
					shot.StateShot++;
					shot.move();
				} else {
					touch = true;
				}
				break;
			}
			if (touch == true) {
				CheckShot(shot.getDir());
				shot.StateShot++;
				pathToHero1(shot);
				ShotRemove();
			}
		}
	}

	public boolean CheckCollision(String direction) {
		Rectangle heroRec = hero.getBounds();

		switch (direction) {
		case "RIGHT":
			heroRec.setBounds(heroRec.x + 32, heroRec.y, heroRec.width, heroRec.height);
			break;
		case "LEFT":
			heroRec.setBounds(heroRec.x - 32, heroRec.y, heroRec.width, heroRec.height);
			break;
		case "UP":
			heroRec.setBounds(heroRec.x, heroRec.y - 32, heroRec.width, heroRec.height);
			break;
		case "DOWN":
			heroRec.setBounds(heroRec.x, heroRec.y + 32, heroRec.width, heroRec.height);
			break;
		}

		for (int i = 0; i < Rock.size(); i++) {
			rock = (Rock) Rock.get(i);
			Rectangle rockRec = rock.getBounds();
			if (heroRec.intersects(rockRec)) {
				return true;
			}
		}
		for (int i = 0; i < HorizontalBone.size(); i++) {
			horizontalBone = (HorizontalBone) HorizontalBone.get(i);
			Rectangle horizontalBoneRec = horizontalBone.getBounds();
			if (heroRec.intersects(horizontalBoneRec)) {
				return true;
			}
		}
		for (int i = 0; i < VerticalBone.size(); i++) {
			verticalBone = (VerticalBone) VerticalBone.get(i);
			Rectangle verticalBoneRec = verticalBone.getBounds();
			if (heroRec.intersects(verticalBoneRec)) {
				return true;
			}
		}
		for (int i = 0; i < Shot.size(); i++) {
			shot = (Shot) Shot.get(i);
			Rectangle sortilegesRec = shot.getBounds();
			if (heroRec.intersects(sortilegesRec)) {
				touch = false;
				shoot = false;
				shot.setX(0);
				shot.setY(0);
			}
		}
		return false;
	}

	public boolean DaemonEat(Mobile mobile) {
		Rectangle mobileRec = mobile.getBounds();
		if (mobile.getX() < hero.getX()) {
			mobileRec.setBounds(mobileRec.x + 32, mobileRec.y, mobileRec.width, mobileRec.height);
		} else if (mobile.getX() > hero.getX()) {
			mobileRec.setBounds(mobileRec.x - 32, mobileRec.y, mobileRec.width, mobileRec.height);
		} else if (mobile.getY() > hero.getY()) {
			mobileRec.setBounds(mobileRec.x, mobileRec.y - 32, mobileRec.width, mobileRec.height);
		} else if (mobile.getY() < hero.getY()) {
			mobileRec.setBounds(mobileRec.x, mobileRec.y + 32, mobileRec.width, mobileRec.height);
		}

		Rectangle heroRec = hero.getBounds();
		if (mobileRec.intersects(heroRec)) {
			score = 0;
			generateLevel();
			return true;
		}

		return false;
	}

	public boolean ShotRemove() {
		Rectangle sortilegesRec = shot.getBounds();
		if (shot.getX() < hero.getX()) {
			sortilegesRec.setBounds(sortilegesRec.x + 32, sortilegesRec.y, sortilegesRec.width, sortilegesRec.height);
		} else if (shot.getX() > hero.getX()) {
			sortilegesRec.setBounds(sortilegesRec.x - 32, sortilegesRec.y, sortilegesRec.width, sortilegesRec.height);
		} else if (shot.getY() > hero.getY()) {
			sortilegesRec.setBounds(sortilegesRec.x, sortilegesRec.y - 32, sortilegesRec.width, sortilegesRec.height);
		} else if (shot.getY() < hero.getY()) {
			sortilegesRec.setBounds(sortilegesRec.x, sortilegesRec.y + 32, sortilegesRec.width, sortilegesRec.height);
		}

		Rectangle heroRec = hero.getBounds();
		if (sortilegesRec.intersects(heroRec)) {
			touch = false;
			shoot = false;
			shot.setX(0);
			shot.setY(0);
			Shot.remove(0);
			return true;
		}
		return false;
	}

	public void Objectif() {
		Rectangle heroRec = hero.getBounds();
		for (int i = 0; i < Purses.size(); i++) {
			purses = (Purses) Purses.get(i);
			Rectangle pursesRec = purses.getBounds();
			if (heroRec.intersects(pursesRec)) {
				score += 100;
				Purses.remove(i);
				break;
			}
		}

		for (int i = 0; i < Key.size(); i++) {
			key = (Key) Key.get(i);
			Rectangle objectifRec = key.getBounds();
			if (heroRec.intersects(objectifRec)) {
				Key.remove(i);
				door.setEtat("OPEN");
			}
		}

		for (int i = 0; i < Door.size(); i++) {
			door = (Door) Door.get(i);
			Rectangle ouvertRec = door.getBounds();

			if (heroRec.intersects(ouvertRec) && door.getEtat() == "OPEN") {
				level++;
				generateLevel();
			}
		}
	}

	public boolean DaemonCollision(String direction, Mobile mobile) {
		Rectangle mobileRec = mobile.getBounds();

		switch (direction) {
		case "RIGHT":
			mobileRec.setBounds(mobileRec.x + 32, mobileRec.y, mobileRec.width, mobileRec.height);
			break;
		case "LEFT":
			mobileRec.setBounds(mobileRec.x - 32, mobileRec.y, mobileRec.width, mobileRec.height);
			break;
		case "UP":
			mobileRec.setBounds(mobileRec.x, mobileRec.y - 32, mobileRec.width, mobileRec.height);
			break;
		case "DOWN":
			mobileRec.setBounds(mobileRec.x, mobileRec.y + 32, mobileRec.width, mobileRec.height);
			break;
		case "DOWNLEFT":
			mobileRec.setBounds(mobileRec.x - 32, mobileRec.y + 32, mobileRec.width, mobileRec.height);
			break;
		case "DOWNRIGHT":
			mobileRec.setBounds(mobileRec.x + 32, mobileRec.y + 32, mobileRec.width, mobileRec.height);
			break;
		case "UPLEFT":
			mobileRec.setBounds(mobileRec.x - 32, mobileRec.y - 32, mobileRec.width, mobileRec.height);
			break;
		case "UPRIGHT":
			mobileRec.setBounds(mobileRec.x + 32, mobileRec.y - 32, mobileRec.width, mobileRec.height);
			break;
		}

		for (int i = 0; i < Rock.size(); i++) {
			rock = (Rock) Rock.get(i);
			Rectangle rockRec = rock.getBounds();
			if (mobileRec.intersects(rockRec)) {
				return true;
			}
		}
		for (int i = 0; i < HorizontalBone.size(); i++) {
			horizontalBone = (HorizontalBone) HorizontalBone.get(i);
			Rectangle horizontalBoneRec = horizontalBone.getBounds();
			if (mobileRec.intersects(horizontalBoneRec)) {
				return true;
			}
		}
		for (int i = 0; i < VerticalBone.size(); i++) {
			verticalBone = (VerticalBone) VerticalBone.get(i);
			Rectangle verticalBoneRec = verticalBone.getBounds();
			if (mobileRec.intersects(verticalBoneRec)) {
				return true;
			}
		}
		for (int i = 0; i < Daemon1.size(); i++) {
			daemon1 = (Daemon1) Daemon1.get(i);
			Rectangle daemon1Rec = daemon1.getBounds();
			if (mobileRec.intersects(daemon1Rec)) {
				return true;
			}
		}
		for (int i = 0; i < Daemon2.size(); i++) {
			daemon2 = (Daemon2) Daemon2.get(i);
			Rectangle daemon2Rec = daemon2.getBounds();
			if (mobileRec.intersects(daemon2Rec)) {
				return true;
			}
		}
		for (int i = 0; i < Daemon3.size(); i++) {
			daemon3 = (Daemon3) Daemon3.get(i);
			Rectangle daemon3Rec = daemon3.getBounds();
			if (mobileRec.intersects(daemon3Rec)) {
				return true;
			}
		}
		for (int i = 0; i < Daemon4.size(); i++) {
			daemon4 = (Daemon4) Daemon4.get(i);
			Rectangle daemon4Rec = daemon4.getBounds();
			if (mobileRec.intersects(daemon4Rec)) {
				return true;
			}
		}

		if (mobile == daemon1) {
			for (int i = 0; i < Shot.size(); i++) {
				shot = (Shot) Shot.get(i);
				Rectangle sortilegesRec = shot.getBounds();
				if (mobileRec.intersects(sortilegesRec)) {
					System.out.println(mobileRec);
					touch = true;
					prisond1 = true;
					daemon1.setX(0);
					daemon1.setY(0);
					Daemon1.remove(0);
					return true;
				}
			}
		} else if (mobile == daemon2) {
			for (int i = 0; i < Shot.size(); i++) {
				shot = (Shot) Shot.get(i);
				Rectangle sortilegesRec = shot.getBounds();
				if (mobileRec.intersects(sortilegesRec)) {
					System.out.println(mobileRec);
					touch = true;
					prisond2 = true;
					daemon2.setX(0);
					daemon2.setY(0);
					Daemon2.remove(0);
					return true;
				}
			}
		} else if (mobile == daemon3) {
			for (int i = 0; i < Shot.size(); i++) {
				shot = (Shot) Shot.get(i);
				Rectangle sortilegesRec = shot.getBounds();
				if (mobileRec.intersects(sortilegesRec)) {
					System.out.println(mobileRec);
					touch = true;
					prisond3 = true;
					daemon3.setX(0);
					daemon3.setY(0);
					Daemon3.remove(0);
					return true;
				}
			}
		} else if (mobile == daemon4) {
			for (int i = 0; i < Shot.size(); i++) {
				shot = (Shot) Shot.get(i);
				Rectangle sortilegesRec = shot.getBounds();
				if (mobileRec.intersects(sortilegesRec)) {
					System.out.println(mobileRec);
					touch = true;
					prisond4 = true;
					daemon4.setX(0);
					daemon4.setY(0);
					Daemon4.remove(0);
					return true;
				}
			}
		}
		return false;
	}

	public boolean CheckShot(String direction) {

		if (shoot == true) {
			Rectangle sortilegesRec = shot.getBounds();

			switch (direction) {
			case "RIGHT":
				sortilegesRec.setBounds(sortilegesRec.x + 32, sortilegesRec.y, sortilegesRec.width,
						sortilegesRec.height);
				break;
			case "LEFT":
				sortilegesRec.setBounds(sortilegesRec.x - 32, sortilegesRec.y, sortilegesRec.width,
						sortilegesRec.height);
				break;
			case "UP":
				sortilegesRec.setBounds(sortilegesRec.x, sortilegesRec.y - 32, sortilegesRec.width,
						sortilegesRec.height);
				break;
			case "DOWN":
				sortilegesRec.setBounds(sortilegesRec.x, sortilegesRec.y + 32, sortilegesRec.width,
						sortilegesRec.height);
				break;
			case "DOWNLEFT":
				sortilegesRec.setBounds(sortilegesRec.x - 32, sortilegesRec.y + 32, sortilegesRec.width,
						sortilegesRec.height);
				break;
			case "DOWNRIGHT":
				sortilegesRec.setBounds(sortilegesRec.x + 32, sortilegesRec.y + 32, sortilegesRec.width,
						sortilegesRec.height);
				break;
			case "UPLEFT":
				sortilegesRec.setBounds(sortilegesRec.x - 32, sortilegesRec.y - 32, sortilegesRec.width,
						sortilegesRec.height);
				break;
			case "UPRIGHT":
				sortilegesRec.setBounds(sortilegesRec.x + 32, sortilegesRec.y - 32, sortilegesRec.width,
						sortilegesRec.height);
				break;
			}

			for (int i = 0; i < Rock.size(); i++) {
				rock = (Rock) Rock.get(i);
				Rectangle rockRec = rock.getBounds();
				if (sortilegesRec.intersects(rockRec)) {
					return true;
				}
			}
			for (int i = 0; i < HorizontalBone.size(); i++) {
				horizontalBone = (HorizontalBone) HorizontalBone.get(i);
				Rectangle horizontalBoneRec = horizontalBone.getBounds();
				if (sortilegesRec.intersects(horizontalBoneRec)) {
					return true;
				}
			}
			for (int i = 0; i < VerticalBone.size(); i++) {
				verticalBone = (VerticalBone) VerticalBone.get(i);
				Rectangle verticalBoneRec = verticalBone.getBounds();
				if (sortilegesRec.intersects(verticalBoneRec)) {
					return true;
				}
			}

			for (int i = 0; i < Daemon1.size(); i++) {
				daemon1 = (Daemon1) Daemon1.get(i);
				Rectangle daemon1Rec = daemon1.getBounds();
				if (sortilegesRec.intersects(daemon1Rec)) {
					score += 250;
					touch = true;
					prisond1 = true;
					daemon1.setX(0);
					daemon1.setY(0);
					Daemon1.remove(0);
					return true;
				}
			}

			for (int i = 0; i < Daemon2.size(); i++) {
				daemon2 = (Daemon2) Daemon2.get(i);
				Rectangle daemon2Rec = daemon2.getBounds();
				if (sortilegesRec.intersects(daemon2Rec)) {
					score += 250;
					touch = true;
					prisond2 = true;
					daemon2.setX(0);
					daemon2.setY(0);
					Daemon2.remove(0);
					return true;
				}
			}

			for (int i = 0; i < Daemon3.size(); i++) {
				daemon3 = (Daemon3) Daemon3.get(i);
				Rectangle daemon3Rec = daemon3.getBounds();
				if (sortilegesRec.intersects(daemon3Rec)) {
					score += 250;
					touch = true;
					prisond3 = true;
					daemon3.setX(0);
					daemon3.setY(0);
					Daemon3.remove(0);
					return true;
				}
			}
			for (int i = 0; i < Daemon4.size(); i++) {
				daemon4 = (Daemon4) Daemon4.get(i);
				Rectangle daemon4Rec = daemon4.getBounds();
				if (sortilegesRec.intersects(daemon4Rec)) {
					score += 250;
					touch = true;
					prisond4 = true;
					daemon4.setX(0);
					daemon4.setY(0);
					Daemon4.remove(0);
					return true;
				}
			}
		}
		return false;
	}

	public void pathToHero1(Mobile mobile) {

		int PlusRapide;
		PlusRapide = 2000;

		if (!DaemonCollision("UPLEFT", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() - 32)))
					+ Math.abs((hero.getY() - (mobile.getY() - 32)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() - 32)))
						+ Math.abs((hero.getY() - (mobile.getY() - 32)));
				mobile.setDir("UPLEFT");
			}
		}
		if (!DaemonCollision("UPRIGHT", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() + 32)))
					+ Math.abs((hero.getY() - (mobile.getY() - 32)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() + 32)))
						+ Math.abs((hero.getY() - (mobile.getY() - 32)));
				mobile.setDir("UPRIGHT");
			}
		}
		if (!DaemonCollision("DOWNLEFT", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() - 32)))
					+ Math.abs((hero.getY() - (mobile.getY() + 32)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() - 32)))
						+ Math.abs((hero.getY() - (mobile.getY() + 32)));
				mobile.setDir("DOWNLEFT");
			}
		}
		if (!DaemonCollision("DOWNRIGHT", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() + 32)))
					+ Math.abs((hero.getY() - (mobile.getY() + 32)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() + 32)))
						+ Math.abs((hero.getY() - (mobile.getY() + 32)));
				mobile.setDir("DOWNRIGHT");
			}
		}

		if (!DaemonCollision("DOWN", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() + 0)))
					+ Math.abs((hero.getY() - (mobile.getY() + 32)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() + 0)))
						+ Math.abs((hero.getY() - (mobile.getY() + 32)));
				mobile.setDir("DOWN");
			}
		}

		if (!DaemonCollision("LEFT", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() - 32)))
					+ Math.abs((hero.getY() - (mobile.getY() + 0)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() - 32)))
						+ Math.abs((hero.getY() - (mobile.getY() + 0)));
				mobile.setDir("LEFT");
			}
		}

		if (!DaemonCollision("UP", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() + 0)))
					+ Math.abs((hero.getY() - (mobile.getY() - 32)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() + 0)))
						+ Math.abs((hero.getY() - (mobile.getY() - 32)));
				mobile.setDir("UP");
			}
		}

		if (!DaemonCollision("RIGHT", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() + 32)))
					+ Math.abs((hero.getY() - (mobile.getY() + 0)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() + 32)))
						+ Math.abs((hero.getY() - (mobile.getY() + 0)));
				mobile.setDir("RIGHT");
			}
		}

		switch (mobile.getDir()) {
		case "UPLEFT":
			mobile.move();
			break;
		case "UPRIGHT":
			mobile.move();
			break;
		case "DOWNLEFT":
			mobile.move();
			break;
		case "DOWNRIGHT":
			mobile.move();
			break;
		case "DOWN":
			mobile.move();
			break;
		case "LEFT":
			mobile.move();
			break;
		case "UP":
			mobile.move();
			break;
		case "RIGHT":
			mobile.move();
			break;
		default:
			break;
		}
	}

	public void pathToHero2(Mobile mobile) {

		int PlusRapide;
		PlusRapide = 1500;

		if (!DaemonCollision("UPLEFT", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() - 32)))
					+ Math.abs((hero.getY() - (mobile.getY() - 32)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() - 32)))
						+ Math.abs((hero.getY() - (mobile.getY() - 32)));
				mobile.setDir("UPLEFT");
			}
		}
		if (!DaemonCollision("UPRIGHT", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() + 32)))
					+ Math.abs((hero.getY() - (mobile.getY() - 32)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() + 32)))
						+ Math.abs((hero.getY() - (mobile.getY() - 32)));
				mobile.setDir("UPRIGHT");
			}
		}
		if (!DaemonCollision("DOWNLEFT", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() - 32)))
					+ Math.abs((hero.getY() - (mobile.getY() + 32)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() - 32)))
						+ Math.abs((hero.getY() - (mobile.getY() + 32)));
				mobile.setDir("DOWNLEFT");
			}
		}
		if (!DaemonCollision("DOWNRIGHT", mobile)) {
			if (PlusRapide > Math.abs((hero.getX() - (mobile.getX() + 32)))
					+ Math.abs((hero.getY() - (mobile.getY() + 32)))) {
				PlusRapide = Math.abs((hero.getX() - (mobile.getX() + 32)))
						+ Math.abs((hero.getY() - (mobile.getY() + 32)));
				mobile.setDir("DOWNRIGHT");
			}
		}

		switch (mobile.getDir()) {

		case "UPLEFT":
			mobile.move();
			break;

		case "UPRIGHT":
			mobile.move();
			break;

		case "DOWNLEFT":
			mobile.move();
			break;

		case "DOWNRIGHT":
			mobile.move();
			break;

		default:
			break;
		}
	}

	public void pathToHero3(Mobile mobile) {
		if (mobile.getX() < hero.getX()) {
			if (!DaemonCollision("RIGHT", mobile)) {
				mobile.setDir("RIGHT");
				mobile.move();
			}
		} else if (mobile.getX() > hero.getX()) {
			if (!DaemonCollision("LEFT", mobile)) {
				mobile.setDir("LEFT");
				mobile.move();
			}
		} else if (mobile.getX() == hero.getX()) {
			if (mobile.getY() > hero.getY()) {
				if (!DaemonCollision("UP", mobile)) {
					mobile.setDir("UP");
					mobile.move();
				}
			} else if (mobile.getY() < hero.getY()) {
				if (!DaemonCollision("DOWN", mobile)) {
					mobile.setDir("DOWN");
					mobile.move();
				}
			}
		}
	}

	public void pathToHero4(Mobile mobile) {

		if (mobile.getY() < hero.getY()) {
			if (!DaemonCollision("DOWN", mobile)) {
				mobile.setDir("DOWN");
				mobile.move();
			}
		} else if (mobile.getY() > hero.getY()) {
			if (!DaemonCollision("UP", mobile)) {
				mobile.setDir("UP");
				mobile.move();
			}
		} else if (mobile.getY() == hero.getY()) {
			if (mobile.getX() > hero.getX()) {
				if (!DaemonCollision("LEFT", mobile)) {
					mobile.setDir("LEFT");
					mobile.move();
				}
			} else if (mobile.getY() < hero.getY()) {
				if (!DaemonCollision("RIGHT", mobile)) {
					mobile.setDir("RIGHT");
					mobile.move();
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		FollowShoot();
		if (!prisond1)
			pathToHero1(daemon1);
		if (!prisond2)
			pathToHero2(daemon2);
		if (!prisond3)
			pathToHero3(daemon3);
		if (!prisond4)
			pathToHero4(daemon4);
	}

	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}
}