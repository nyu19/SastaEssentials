package me.nyu19.SastaEssentials.commands;

import me.nyu19.SastaEssentials.Main;
import me.nyu19.SastaEssentials.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Heal implements CommandExecutor {
    public void cleanTarget(Player target){
        target.addPotionEffect(PotionEffectType.SATURATION.createEffect(60,2));
        target.setHealth(target.getHealthScale());
        target.setFoodLevel(20);
    }
    private Main plugin;
    public Heal(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("heal").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)){
            plugin.getLogger().info(plugin.getConfig().getString("console_error_message"));
            return true;
        }
        if (strings.length == 1 && p.hasPermission("SE.commands.heal.others")){
            Player target = Bukkit.getPlayerExact(strings[0]);
            cleanTarget(target);
            target.sendMessage(ChatUtils.chatColor("&eYou Have been healed By the Minecraft Gods."));
            return true;
        }
        else if (p.hasPermission("SE.commands.heal")) {
            cleanTarget(p);
            p.sendMessage(ChatUtils.chatColor("&eYou Have been healed By the Minecraft Gods."));
            return true;
        }
        else{
            p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("permission_error")));
        }
        return false;
    }
}
