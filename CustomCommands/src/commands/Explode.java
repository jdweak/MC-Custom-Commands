package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Explode implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("op")) {
		if(args.length == 1) { //self explosion
		Player player = (Player)sender;
		float x = Float.valueOf(args[0]);
		player.getWorld().createExplosion(player.getLocation(), x);
		} else if(args.length == 2) { //explode other player
			for(Player player : Bukkit.getOnlinePlayers()) {
				if(player.getName().equalsIgnoreCase(args[0])) {
					float x = Float.valueOf(args[1]);
					player.getWorld().createExplosion(player.getLocation(), x);
			}
			}
		}
		}else {
			sender.sendMessage(ChatColor.RED + "you don't have permission to execute this command");
		}
		return false;
	}
}

