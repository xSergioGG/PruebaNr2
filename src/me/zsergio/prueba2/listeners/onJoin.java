package me.zsergio.prueba2.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.zsergio.prueba2.Main;
import me.zsergio.prueba2.manage.PlayerManager;

public class onJoin implements Listener {
	
	private Main plugin = Main.getInstance();
	private PlayerManager playerManager = plugin.getPlayerManager();
	
	@EventHandler
	public void onEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		playerManager.joinPlayer(player);
	}

}
