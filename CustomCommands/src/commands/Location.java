package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Location implements CommandExecutor{
	
	public String name = "Location";

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("op")) {
		if(args.length == 0) {
		Player player = (Player)sender;
		player.sendMessage(player.getLocation().toString());
		} else if(args.length == 1) {
			for(Player player : Bukkit.getOnlinePlayers()) {
				if(player.getName().equalsIgnoreCase(args[0])) {
					sender.sendMessage(player.getLocation().toString());
				}
			}
		}
		}else {
			sender.sendMessage(ChatColor.RED + "you don't have permission to execute this command");
		}
		return false;
	}

}
