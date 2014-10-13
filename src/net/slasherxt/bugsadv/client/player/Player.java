package net.slasherxt.bugsadv.client.player;

import net.slasherxt.bugsadv.client.main.Client;
import net.slasherxt.bugsadv.client.render.ImageLoader;

import org.newdawn.slick.Image;

public class Player {
	private final Client client;	
	private int x = 20, y = 20;	
	private final int CHAR_SIZE = 32;
	private String name;
	private int health, money, level, exp;
	private int[][] down = {{0, 0}, {1, 0}, {2, 0}};
	private int[][] left = {{0, 1}, {1, 1}, {2, 1}};
	private int[][] right = {{0, 2}, {1, 2}, {2, 2}};
	private int[][] up = {{0, 3}, {1, 3}, {2, 3}};
	private int motion = 1;
	private int currentDir = 0;
	public boolean isMoving = false;
	
	public Player(Client client) {
		this.client = client;
	}
	
	public void createPlayer(String name) {
		System.err.println("Creating Player: " + name);
		this.name = name;
		health = 10;
		money = 0;
		level = 1;
		exp = 0;
	}
	
	public Image getImage() {
		int[] imagePos = new int[]{motion, currentDir};
		
		Image player = ImageLoader.BUGS_FULL.getSubImage(imagePos[0] * CHAR_SIZE, imagePos[1] * CHAR_SIZE, CHAR_SIZE, CHAR_SIZE);
		
		return player;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public int getExp() {
		return exp;
	}
	
	public void movePlayer(Direction dir) {
		currentDir = dir.getDir();
		
		moveUntilStopped(dir);
		
		//isMoving = false;
	}
	
	private void moveUntilStopped(Direction dir) {
		if(isMoving) {
			while(isMoving) {
				if(dir == Direction.UP) {
					if(y > 0) {
						y--;
					}
				}
				if(dir == Direction.DOWN) {
					System.err.println("Y: " + y);
					System.err.println("Height: " + client.getHeight());
					if(y < client.height) {
						y++;
					}
				}
				if(dir == Direction.LEFT) {
					if(x > 0) {
						x--;
					}
				}
				if(dir == Direction.RIGHT) {
					if(x < client.width) {
						x++;
					}
				}
			}
		} else {
			System.err.println("Called when not moving");
		}
	}
}
