package commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Smite implements CommandExecutor{
	
	public String name = "Location";

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 0) { //self smite with no input
		Player player = (Player)sender;
		player.getWorld().strikeLightning(player.getLocation());
		} else if(args.length == 1) { //smite other player
			for(Player player : Bukkit.getOnlinePlayers()) {
				if(player.getName().equalsIgnoreCase(args[0])) {
					player.getWorld().strikeLightning(player.getLocation());
				}
			}
		}
		return false;
	}
}
