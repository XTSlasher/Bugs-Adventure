package net.slasherxt.bugsadv.client.profile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.slasherxt.bugsadv.client.main.Client;
import net.slasherxt.bugsadv.client.player.Player;

import org.jnbt.IntTag;
import org.jnbt.NBTInputStream;
import org.jnbt.NBTOutputStream;
import org.jnbt.StringTag;
import org.jnbt.Tag;

public class ProfileHandler {
	private final Player player;
	private final Client client;
	private final String dirPath = "thingus/";
	private final String savePath = "saves/";
	private final String dataPath = "data/";
	private final String profPath = dirPath + savePath + "profile.dat";
	
	public ProfileHandler(Player player, Client client) {
		this.player = player;
		this.client = client;
	}
	
	public void createProfile(String playerName) {
		player.createPlayer(playerName);
		saveProfile();
	}
	
	public void saveProfile() {
		if(!new File(dirPath + savePath).exists()) new File(dirPath + savePath).mkdirs();
		
		try {
			NBTOutputStream out = new NBTOutputStream(new FileOutputStream(new File(profPath)));
			
			out.writeTag(createTag("PlayerName", player.getName(), 0));
			out.writeTag(createTag("PlayerHealth", null, player.getHealth()));
			out.writeTag(createTag("PlayerMoney", null, player.getMoney()));
			out.writeTag(createTag("PlayerLevel", null, player.getLevel()));
			out.writeTag(createTag("PlayerExp", null, player.getExp()));
			out.close();
			
		} catch (IOException e) {
			System.err.println("Error Saving Profile: " + player.getName());
		}
	}
	
	public void loadProfile() {
		boolean fileFound = new File(profPath).exists();
		
		if(!fileFound) { return; }
		
		NBTInputStream in = null;
		try {
			in = new NBTInputStream(new FileInputStream(new File(profPath)));
			ArrayList<Tag> tags = new ArrayList<Tag>();
			
			try { 
				Tag tag;
				while((tag = in.readTag()) != null) {
					tags.add(tag);
				}
				in.close();
			} catch (Exception e) {
				System.err.println("Error Reading Tag.");
			}
			
			player.setName(getTag(tags, "PlayerName").getValue().toString());
			player.setHealth((int) getTag(tags, "PlayerHealth").getValue());
			player.setMoney((int) getTag(tags, "PlayerMoney").getValue());
			player.setLevel((int) getTag(tags, "PlayerLevel").getValue());
			player.setExp((int) getTag(tags, "PlayerExp").getValue());
		} catch (Exception e) {
			System.err.println("Error Loading Profile");
		}
	}
	
	private Tag createTag(String tagName, String var1, int var2) {
		Tag tag = null;		
		
		if(var1 != null) {
			tag = new StringTag(tagName, var1);
		} else {
			tag = new IntTag(tagName, var2);
		}
		
		return tag;
	}
	
	public Tag getTag(ArrayList<Tag> tags, String str) {
		for(Tag tag: tags) {
			if(tag.getName().equals(str)) {
				return tag;
			}
		}
		return null;
	}
}
