package net.slasherxt.bugsadv.client.render;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLoader {
	public static final int BUTTON_WIDTH = 300, BUTTON_HEIGHT = 125;
	
	public static Image buttonOverlay;
	public static Image buttonOutline;
	public static Image title;
	
	public static Image BUGS_DOWN;
	public static Image BUGS_UP;
	public static Image BUGS_RIGHT;
	public static Image BUGS_LEFT;
	public static Image BUGS_FULL;
	
	
	public static void initImages() throws SlickException {
		buttonOverlay = new Image("res/buttons/buttonHighlightOverlay.png");
		buttonOutline = new Image("res/buttons/buttonOutline.png");
		title = new Image("res/labels/titleBlock.png");
		
		BUGS_DOWN = new Image("res/chars/bugs/walk_down.png");
		BUGS_UP = new Image("res/chars/bugs/walk_up.png");
		BUGS_RIGHT = new Image("res/chars/bugs/walk_right.png");
		BUGS_LEFT = new Image("res/chars/bugs/walk_left.png");
		BUGS_FULL = new Image("res/chars/bugs/full_move.png");
	}
}
