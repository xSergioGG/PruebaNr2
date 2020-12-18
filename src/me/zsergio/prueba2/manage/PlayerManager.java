package me.zsergio.prueba2.manage;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class PlayerManager {
	
	private HashMap<UUID, CustomPlayer> players = new HashMap<>();
	
	public HashMap<UUID, CustomPlayer> getPlayers() {
		return players;
	}
	
	public CustomPlayer getPlayer(Player player) {
		return players.get(player.getUniqueId());
	}
	
	public void joinPlayer(Player player) {
		if(!players.containsKey(player.getUniqueId())) {
			players.put(player.getUniqueId(), new CustomPlayer(player));
		}
	}
	
	public void quitPlayer(Player player) {
		if(players.containsKey(player.getUniqueId())) {
			players.remove(player.getUniqueId());
		}
	}

}
