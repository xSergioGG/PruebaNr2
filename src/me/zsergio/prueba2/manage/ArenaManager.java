package me.zsergio.prueba2.manage;

import java.io.File;
import java.util.HashMap;

import org.bukkit.entity.Player;

import me.zsergio.prueba2.Main;

public class ArenaManager {
	
	private Main plugin = Main.getInstance();
	private File arenasdir;
	private HashMap<String, Arena> arenas = new HashMap<>();
	
	public ArenaManager() {
		this.arenasdir = new File(plugin.getDataFolder()+"//arenas");
		regAllArenas();
	}
	
	public HashMap<String, Arena> getArenas() {
		return arenas;
	}
	
	public Arena getArena(String name) {
		return arenas.get(name);
	}

	public void createArena(String name) {
		if(!arenas.containsKey(name)) {
			arenas.put(name, new Arena(name));
		}
	}
	
	public boolean isOnGame(Player player) {
		for(Arena all : arenas.values()) {
			if(all.getPlayers().contains(player)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public Arena getPArena(Player player) {
		for(Arena all : arenas.values()) {
			if(all.getPlayers().contains(player)) {
				return arenas.get(all.toString());
			} else {
				return null;
			}
		}
		return null;
		
	}
	
	private void regAllArenas() {
		
		if(!arenasdir.exists()) {
			arenasdir.mkdirs();
		}
		
		for(File all : arenasdir.listFiles()){
			String name = all.getName().replace(".yml", "");
			createArena(name);
			System.out.println("§aARENA "+name+" REGISTERED");
		}
	}
	
}
