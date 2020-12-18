package me.zsergio.prueba2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.zsergio.prueba2.Main;
import me.zsergio.prueba2.manage.Arena;
import me.zsergio.prueba2.manage.ArenaManager;

public class listArenasCMD implements CommandExecutor {
	
	private Main plugin = Main.getInstance();
	private ArenaManager arenaManager = plugin.getArenaManager();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("pruebanr2.list")) {
			sender.sendMessage("Lista:");
			for(Arena all : arenaManager.getArenas().values()) {
				sender.sendMessage("- "+all.getName());
			}
			
		}
		return true;
	}

}
