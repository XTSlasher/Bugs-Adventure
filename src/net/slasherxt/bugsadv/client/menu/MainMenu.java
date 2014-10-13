package net.slasherxt.bugsadv.client.menu;

import javax.swing.JOptionPane;

import net.slasherxt.bugsadv.client.main.Client;
import net.slasherxt.bugsadv.client.profile.ProfileHandler;
import net.slasherxt.bugsadv.client.render.ImageLoader;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {

	private final int menuID;
	private final Client client;
	private final ProfileHandler profile;
	private boolean isClicked = false;
	
	public MainMenu(Client client, ProfileHandler profile, int id) {
		this.menuID = id;
		this.client = client;
		this.profile = profile;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {		
		ImageLoader.title.draw(client.width / 2 - 250, 150);
		ImageLoader.buttonOutline.draw(client.width / 2 - 350, 250); // Top Left - Play (New Game)
		ImageLoader.buttonOutline.draw(client.width / 2 - 350, 400); // Bottom Left - Play (Load Game)  
		ImageLoader.buttonOutline.draw(client.width / 2 + 25, 250); // Top Right - Options
		ImageLoader.buttonOutline.draw(client.width / 2 + 25, 400); // Bottom Right - Exit (Quit Game)
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int x = Mouse.getX();
		int y = Mouse.getY();
		
		if((!isClicked) && (Mouse.isButtonDown(0))) {
			isClicked = true;
			
			// New Game
			if ((x > ((client.width / 2) - 350) && (x < ((client.width / 2) - 350) + 300)) && ((y > client.height - (250 + 125)) && (y < client.height - 250))) {
				System.err.println("Inside Play (New Game)");
				String playerName = JOptionPane.showInputDialog(null, "Please Enter Your Name", "Player Name Input!");
				profile.createProfile(playerName);
				sbg.enterState(client.gameScreen);
			}
			
			// Load Game
			if ((x > ((client.width / 2) + 25) && (x < ((client.width / 2) + 25) + 300)) && ((y > client.height - (250 + 125)) && (y < client.height - 250))) {
				System.err.println("Inside Play (Load Game)");
				profile.loadProfile();
				sbg.enterState(client.gameScreen);
			}
			
			// Options
			if ((x > ((client.width / 2) - 350) && (x < ((client.width / 2) - 350) + 300)) && ((y > client.height - (400 + 125)) && (y < client.height - 400))) {
				System.err.println("Inside Options");
			}
			
			// Exit Game
			if ((x > ((client.width / 2) + 25) && (x < ((client.width / 2) + 25) + 300)) && ((y > client.height - (400 + 125)) && (y < client.height - 400))) {
				System.err.println("Inside Exit Game");
			}
		}
		
		in.clearMousePressedRecord();
		//isClicked = false;
	}

	@Override
	public int getID() {
		return menuID;
	}
	
}
