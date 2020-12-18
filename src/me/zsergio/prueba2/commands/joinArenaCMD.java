package me.zsergio.prueba2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.zsergio.prueba2.Main;
import me.zsergio.prueba2.manage.Arena;
import me.zsergio.prueba2.manage.ArenaManager;

public class joinArenaCMD implements CommandExecutor {
	
	private Main plugin = Main.getInstance();
	private ArenaManager arenaManager = plugin.getArenaManager();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(args.length == 1) {
				String name = args[0];
				if(arenaManager.getArenas().containsKey(name)) {
					Arena arena = arenaManager.getArena(name);
					if(arena.isEnabled() == true && arena.isStarted() == false) {
						arena.joinPlayer(player);
					} else {
						sender.sendMessage("§cArena en juego.");
					}
				} else {
					sender.sendMessage("§cEsa arena no existe.");
				}
			} else {
				sender.sendMessage("§cUso correcto: /joinarena <nombre>");
			}
		}
		return true;
	}

}
