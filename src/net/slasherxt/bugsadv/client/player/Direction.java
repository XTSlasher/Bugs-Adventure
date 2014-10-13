package net.slasherxt.bugsadv.client.player;

public enum Direction {
	UP, LEFT, RIGHT, DOWN;
	
	public int getDir() {
		switch(this) {
		case UP:
			return 3;
		case LEFT:
			return 1;
		case RIGHT:
			return 2;
		case DOWN:
			return 0;
		default:
			return 0;
		}
	}
}
