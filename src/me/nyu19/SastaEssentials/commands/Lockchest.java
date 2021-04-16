package me.nyu19.SastaEssentials.commands;
import me.nyu19.SastaEssentials.Main;
import me.nyu19.SastaEssentials.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.Lockable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lockchest implements CommandExecutor/*,Lockable*/{
    private Main plugin;
    public Lockchest(Main plugin){
        this.plugin = plugin;
//        Bukkit.getPluginManager().addPermission(SE.commands.lockchest);
        Bukkit.getPluginCommand("lockchest").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        Player p = (Player) sender;
        if(p.hasPermission("SE.commands.lockchest")){
            Block targetBlock = p.getTargetBlock(null,10);
            
        }
        else{
            p.sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("commands.permission_error")));
        }
        return false;
    }
}
