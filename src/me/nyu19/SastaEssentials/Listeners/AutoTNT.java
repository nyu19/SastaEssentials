package me.nyu19.SastaEssentials.Listeners;

import me.nyu19.SastaEssentials.Main;
import me.nyu19.SastaEssentials.utils.ChatUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class AutoTNT implements Listener {
    private Main plugin;
    public AutoTNT(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        if (plugin.getConfig().getBoolean("Auto_TNT_Ignite.status")){
            Block b = e.getBlock();
            Material m = b.getType();
            if (m.equals(Material.TNT)) {
                Location l = b.getLocation();
                b.setType(Material.AIR);
                b.getWorld().spawnEntity(l,EntityType.PRIMED_TNT);
            }
        }else{
            e.getPlayer().sendMessage(ChatUtils.chatColor(plugin.getConfig().getString("Auto_TNT_Ignite.disabled_msg")));
            return;
        }
    }
}
