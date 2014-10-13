package net.slasherxt.bugsadv.client.input;

import net.slasherxt.bugsadv.client.player.Direction;
import net.slasherxt.bugsadv.client.player.Player;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class KeyHandler implements KeyListener {

	private final Player player;
	
	public KeyHandler(Player player) {
		this.player = player;
	}
	
	@Override
	public void inputEnded() {}

	@Override
	public void inputStarted() {}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void setInput(Input arg0) {}

	@Override
	public void keyPressed(int keyCode, char keyName) {		
		if(keyCode == 200) {
			if(!player.isMoving) {
				player.isMoving = true;
				player.movePlayer(Direction.UP);
			}
		}
		if(keyCode == 203) {
			if(!player.isMoving) {
				player.isMoving = true;
				player.movePlayer(Direction.LEFT);
			}
		}
		if(keyCode == 205) {
			if(!player.isMoving) {
				player.isMoving = true;
				player.movePlayer(Direction.RIGHT);
			}
		}
		if(keyCode == 208) {
			if(!player.isMoving) {
				player.isMoving = true;
				player.movePlayer(Direction.DOWN);
			}
		}
	}
	
	@Override
	public void keyReleased(int keyCode, char keyChar) {
		if(keyCode == 200) {
			if(!player.isMoving) {
				player.isMoving = false;
			}
		}
		if(keyCode == 203) {
			if(!player.isMoving) {
				player.isMoving = false;
			}
		}
		if(keyCode == 205) {
			if(!player.isMoving) {
				player.isMoving = false;
			}
		}
		if(keyCode == 208) {
			if(!player.isMoving) {
				player.isMoving = false;
			}
		}
	}
	
}
