package net.slasherxt.bugsadv.client.main;

import net.slasherxt.bugsadv.client.game.Play;
import net.slasherxt.bugsadv.client.input.KeyHandler;
import net.slasherxt.bugsadv.client.menu.MainMenu;
import net.slasherxt.bugsadv.client.player.Player;
import net.slasherxt.bugsadv.client.profile.ProfileHandler;
import net.slasherxt.bugsadv.client.render.ImageLoader;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Client extends StateBasedGame {
	public final int height = 600, width = 800, charSize = 32;
	
	public static Client client;
	public static final Player player = new Player(client);
	public static final ProfileHandler profile = new ProfileHandler(player, client);
	public final KeyHandler KEY_HANDLER = new KeyHandler(player);
	
	public static final String gameName = "BugsAdventure";
	public static final int mainMenu = 0;
	public static final int gameScreen = 1;
	public static final int pauseMenu = 2;
	
	public Client(String gameName) throws SlickException {
		super(gameName);
		
		client = this;
		
		this.addState(new MainMenu(client, profile, mainMenu));
		this.addState(new Play(client, profile, player, gameScreen));
		//this.addState(new PauseMenu(client, pauseMenu));
	}
	
	private void init() {
		try {
			ImageLoader.initImages();
		} catch (SlickException e) {
			System.err.println("Error Loading Images");
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.getState(gameScreen).init(gc, this);
		//this.getState(pauseMenu).init(gc, this);
		
		this.enterState(mainMenu);
		
		init();
	}
	
	public static void main(String[] args) {
		AppGameContainer agc;
		
		try {
			agc = new AppGameContainer(new Client(gameName));
			agc.setDisplayMode(800, 600, false);
			agc.setShowFPS(false);
			agc.start();
		} catch(SlickException se) {
			System.err.println("Error on startup!");
		}
	}

	public int getHeight() { return height; }
}
