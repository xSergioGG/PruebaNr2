package me.zsergio.prueba2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.zsergio.prueba2.Main;
import me.zsergio.prueba2.manage.Arena;
import me.zsergio.prueba2.manage.ArenaManager;

public class quitArenaCMD implements CommandExecutor {
	
	private Main plugin = Main.getInstance();
	private ArenaManager arenaManager = plugin.getArenaManager();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Arena arena = arenaManager.getArena(player);
			
			arena.quitPlayer(player);
			sender.sendMessage("§cHas salido de la arena.");
		}
		return true;
	}

}
