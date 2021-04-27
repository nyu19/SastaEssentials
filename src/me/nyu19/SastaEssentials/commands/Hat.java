package me.nyu19.SastaEssentials.commands;

import me.nyu19.SastaEssentials.Main;
import me.nyu19.SastaEssentials.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Hat implements CommandExecutor {
    private Main plugin;
    public Hat(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginCommand("hat").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (!(sender instanceof Player)){
            plugin.getLogger().info(plugin.getConfig().getString("console_error_message"));
            return true;
        }
        Player p = (Player) sender;
        if(p.hasPermission("SE.commands.hat")){
            ItemStack hatItem = p.getInventory().getItemInMainHand();
            ItemStack mainItem = p.getInventory().getHelmet();
            p.getInventory().setHelmet(hatItem);
            p.getInventory().setItemInMainHand(mainItem);
            p.sendMessage(ChatUtils.chatColor("&eEnjoy Your New Hat."));
        }
        else {
            p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("permission_error")));
        }
        return false;
    }

}
