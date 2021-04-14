package me.nyu19.SastaEssentials.Listeners;

import me.nyu19.SastaEssentials.Main;
import me.nyu19.SastaEssentials.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {
    private Main plugin;
    public LeaveListener(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler
    public void onJoin(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(ChatUtils.chatColor(plugin.getConfig().getString("Events.leave_message").replace("%player%", p.getDisplayName())));
    }
}
