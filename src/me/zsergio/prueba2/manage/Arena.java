package me.zsergio.prueba2.manage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.zsergio.prueba2.Main;

public class Arena {

	private File cfile;
	private FileConfiguration config;
	private Main plugin = Main.getInstance();
	private ArenaManager arenaManager = plugin.getArenaManager();
	
	private String name;
	private boolean enabled;
	private boolean started;
	private ArrayList<Player> players = new ArrayList<>();
	private int maxplayers;
	
	public Arena(String name) {
		this.name = name;
		this.enabled = false;
		this.started = false;
		this.maxplayers = 12;
		
		regConfig();
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isStarted() {
		return started;
	}
	
	public void setStarted(boolean started) {
		this.started = started;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public int getMaxplayers() {
		return maxplayers;
	}
	
	public void joinPlayer(Player player) {
		if(arenaManager.isOnGame(player) == false) {
			if(!players.contains(player)) {
				players.add(player);
				
				for(Player current : players) {
					current.sendMessage("§eEl jugador "+player.getDisplayName()+" ha entrado §7("+players.size()+"/"+maxplayers+")");
				}
				
			}
		} else {
			player.sendMessage("§cYa estás en juego!");
		}
	}
	
	public void quitPlayer(Player player) {
		if(arenaManager.isOnGame(player) == true) {
			if(players.contains(player)) {
				players.remove(player);
				
				for(Player current : players) {
					current.sendMessage("§eEl jugador "+player.getDisplayName()+" ha salido §7("+players.size()+"/"+maxplayers+")");
				}
				
			}
		} else {
			player.sendMessage("§cNo estás en juego!");
		}
	}
	
	private void regConfig() {
		cfile = new File(plugin.getDataFolder()+"//arenas", name+".yml");
		
		if(!cfile.exists()) {
			try {
				cfile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		config = YamlConfiguration.loadConfiguration(cfile);
		getDefaultsConfig();
	}
	
	private void saveConfig() {
		try {
			config.save(cfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getDefaultsConfig() {
		if(!config.contains("maxplayers")) {
			config.set("maxplayers", maxplayers);
		} if(!config.contains("enabled")) {
			config.set("enabled", enabled);
		}
		
		this.maxplayers = config.getInt("maxplayers");
		this.enabled = config.getBoolean("enabled");
		
		saveConfig();
	}
	
}
