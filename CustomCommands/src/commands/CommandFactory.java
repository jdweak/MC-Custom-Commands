package commands;

import org.bukkit.command.CommandExecutor;

public class CommandFactory {
	
	public CommandExecutor createCommand(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class<?> c = Class.forName("commands." + name);
		@SuppressWarnings("deprecation")
		CommandExecutor command = (CommandExecutor) c.newInstance();
		return command;
	}
}
