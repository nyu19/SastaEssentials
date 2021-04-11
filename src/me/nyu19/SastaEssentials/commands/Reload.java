package me.nyu19.SastaEssentials.commands;

import me.nyu19.SastaEssentials.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {
    private Main plugin;
    public Reload(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("reload").setExecutor(this);
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label , String[] arg){
        plugin.reloadConfig();
        return true;
    }
}
