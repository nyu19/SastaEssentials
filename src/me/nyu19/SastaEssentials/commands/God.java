package me.nyu19.SastaEssentials.commands;

import me.nyu19.SastaEssentials.Main;
import me.nyu19.SastaEssentials.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {
    private Main plugin;

    public God(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginCommand("god").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] arg) {
        if (!(sender instanceof Player)){
            plugin.getLogger().info(plugin.getConfig().getString("console_error_message"));
            return true;
        }
        else if (((Player) sender).getGameMode() == GameMode.CREATIVE){
            sender.sendMessage(ChatUtils.chatColor("&eYou Are Already in &aCreative."));
        }
        else {
            Entity p = (Player) sender;
            if (arg.length == 1) {
                Entity target = Bukkit.getPlayerExact(arg[0]);
                if (p.hasPermission("SE.commands.god.others")) {
                    if (target.isInvulnerable()) {
                        target.setInvulnerable(false);
                        p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.god.god_disable")));
                        target.sendMessage(ChatUtils.chatColor("&eYour God Mode has been &cDisabled &e by " + p.getName()));
                        return true;
                    } else {
                        target.setInvulnerable(true);
                        p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.god.god_enable")));
                        target.sendMessage(ChatUtils.chatColor("&eYour God Mode has been &aEnabled &e by " + p.getName()));
                        return true;
                    }
                }
            }
            else if (p.hasPermission("SE.commands.god")) {
                if (p.isInvulnerable()) {
                    p.setInvulnerable(false);
//                p.setGlowing(false);
                    p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.god.god_disable")));
                    return true;
                } else {
                    p.setInvulnerable(true);
//                p.setGlowing(true);
                    p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.god.god_enable")));
                    return true;
                }
            }
            else {
                p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("permission_error")));
            }
        }
        return false;
    }
}
