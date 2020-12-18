package me.zsergio.prueba2.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.zsergio.prueba2.Main;
import me.zsergio.prueba2.manage.ArenaManager;

public class onQuit implements Listener {
	
	private Main plugin = Main.getInstance();
	private ArenaManager arenaManager = plugin.getArenaManager();
	
	@EventHandler
	public void onEvent(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		
		if(arenaManager.isOnGame(player) == false) {
			
		}
	}

}
