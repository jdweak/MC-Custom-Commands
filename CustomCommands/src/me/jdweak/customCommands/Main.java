package me.jdweak.customCommands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import commands.CommandFactory;

public class Main extends JavaPlugin{
	
	private static Main instance;
	private CommandFactory commandFactory;
	
	public static Main getInstance() {
		return instance;
	}
	
	private CommandExecutor generateCommand(String commandName) {
		try {
			return commandFactory.createCommand(commandName);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("command factory fail");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		
		commandFactory = new CommandFactory();
		getCommand("custom_enchant").setExecutor(generateCommand("CustomEnchant"));
		getCommand("location").setExecutor(generateCommand("Location"));
		getCommand("smite").setExecutor(generateCommand("Smite"));
		getCommand("explode").setExecutor(generateCommand("Explode"));
		
		System.out.println("plugin enabled with updates");
	}
	
	
}