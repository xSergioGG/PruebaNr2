package me.zsergio.prueba2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.zsergio.prueba2.Main;
import me.zsergio.prueba2.manage.ArenaManager;

public class createArenaCMD implements CommandExecutor {
	
	private Main plugin = Main.getInstance();
	private ArenaManager arenaManager = plugin.getArenaManager();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("pruebanre2.createarena")) {
				if(args.length == 1) {
					String name = args[0];
					arenaManager.createArena(name);
					arenaManager.getArena(name).setEnabled(true);
					sender.sendMessage("§aArena "+name+" creada correctamente!");
				} else {
					player.sendMessage("§cUso correcto: /createarena <nombre>");
				}
			} else {
				player.sendMessage("§cNo tienes permisos para ejecutar este comando.");
			}
		} else {
			sender.sendMessage("§cSolo un jugador puede hacer esto.");
		}
		return true;
	}

}
