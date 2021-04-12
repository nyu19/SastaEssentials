package me.nyu19.SastaEssentials.commands;

import me.nyu19.SastaEssentials.Main;
import me.nyu19.SastaEssentials.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    private Main plugin;
    public FlyCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("fly").setExecutor(this);
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label , String[] arg){
        if (!(sender instanceof Player)){
            plugin.getLogger().info(plugin.getConfig().getString("console_error_message"));
            return true;
        }
        Player p = (Player) sender;
        if (arg.length == 1){
            Player target = Bukkit.getPlayerExact(arg[0]);

            if (p.hasPermission("SE.commands.fly.others")){
                if (target.isFlying()){
                    target.setAllowFlight(false);
                    target.setFlying(false);
                    p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.fly.fly_disable")));
                    target.sendMessage(ChatUtils.chatColor("&eYour Flight has been &cDisabled &e by " + p.getName()));
                    return true;
                }
                else{
                    target.setAllowFlight(true);
                    target.setFlying(true);
                    p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.fly.fly_enable")));
                    target.sendMessage(ChatUtils.chatColor("&eYour Flight has been &aEnabled &e by " + p.getName()));
                    return true;
                }
            }
            else {
                p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.permission_error")));
            }
        }
        if (p.hasPermission("SE.commands.fly")){
            if (p.isFlying()){
                p.setAllowFlight(false);
                p.setFlying(false);
                p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.fly.fly_disable")));
                return true;
            }
            else{
                p.setAllowFlight(true);
                p.setFlying(true);
                p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.fly.fly_enable")));
                return true;
            }
        }
        else {
            p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.permission_error")));
        }
        return false;
    }
}
