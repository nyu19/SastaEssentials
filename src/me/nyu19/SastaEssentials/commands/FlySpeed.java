package me.nyu19.SastaEssentials.commands;
import me.nyu19.SastaEssentials.Main;
import me.nyu19.SastaEssentials.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class FlySpeed implements CommandExecutor {
    private Main plugin;
    public FlySpeed(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginCommand("flyspeed").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] arg) {
        Player p = (Player) sender;
        float speed = Float.parseFloat(arg[0]);
        speed = (float) (Math.floor(speed * 10)/100);
//        if (arg.length == 2){
//            Player target = Bukkit.getPlayerExact(arg[1]);
//
//            if (p.hasPermission("SE.commands.god.others") && speed <= 1){
//                target.setFlySpeed(speed);
//                target.sendMessage(ChatUtils.chatColor("&eFly Speed set to &5" + speed*10));
//                return true;
//            }
//            else {
//                p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("permission_error")));
//                return false;
//            }
//        }
        if (p.hasPermission("SE.commands.god") && speed <= 1){
            if (!(sender instanceof Player)){
                plugin.getLogger().info(plugin.getConfig().getString("console_error_message"));
                return true;
            }
            p.setFlySpeed(speed);
            p.sendMessage(ChatUtils.chatColor("&eFly Speed set to &5" + speed*10));
            return true;
        }
        else {
            p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("permission_error")));
            return false;
        }
    }
}
