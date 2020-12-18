package me.zsergio.prueba2;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.zsergio.prueba2.commands.createArenaCMD;
import me.zsergio.prueba2.commands.joinArenaCMD;
import me.zsergio.prueba2.commands.listArenasCMD;
import me.zsergio.prueba2.commands.quitArenaCMD;
import me.zsergio.prueba2.listeners.*;
import me.zsergio.prueba2.manage.*;

public class Main extends JavaPlugin {
	
	private static Main instance;
	private ArenaManager arenaManager;
	private PlayerManager playerManager;
	
	@Override
	public void onEnable() {
		instance = this;
		arenaManager = new ArenaManager();
		playerManager = new PlayerManager();
		
		regAll();
	}
	
	private void regAll() {
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new onJoin(), this);
		pm.registerEvents(new onQuit(), this);
		
		getCommand("createarena").setExecutor(new createArenaCMD());
		getCommand("joinarena").setExecutor(new joinArenaCMD());
		getCommand("quitarena").setExecutor(new quitArenaCMD());
		getCommand("listarenas").setExecutor(new listArenasCMD());
	}
	
	public ArenaManager getArenaManager() {
		return arenaManager;
	}
	
	public PlayerManager getPlayerManager() {
		return playerManager;
	}
	
	public static Main getInstance() {
		return instance;
	}

}
