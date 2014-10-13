package net.slasherxt.bugsadv.client.game;

import net.slasherxt.bugsadv.client.input.KeyHandler;
import net.slasherxt.bugsadv.client.main.Client;
import net.slasherxt.bugsadv.client.player.Player;
import net.slasherxt.bugsadv.client.profile.ProfileHandler;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

	private final int playID;
	private final Client client;
	private final Player player;
	private final ProfileHandler profile;
	
	public Play(Client client, ProfileHandler profile, Player player, int id) {
		this.playID = id;
		this.client = client;
		this.profile = profile;
		this.player = player;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		gc.getInput().addKeyListener(new KeyHandler(player));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(player.getImage(), player.getX(), player.getY());
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		
	}
	
	@Override
	public int getID() {
		return playID;
	}
	
}
