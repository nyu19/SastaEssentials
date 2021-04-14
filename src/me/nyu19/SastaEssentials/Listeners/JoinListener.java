package me.nyu19.SastaEssentials.Listeners;

import me.nyu19.SastaEssentials.Main;
import me.nyu19.SastaEssentials.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private Main plugin;
    public JoinListener(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()) {
//            Bukkit.broadcastMessage(ChatUtils.chatColor(plugin.getConfig().getString("first_join_message").replace("%player%",p.getDisplayName())));
            e.setJoinMessage(ChatUtils.chatColor(plugin.getConfig().getString("Events.first_join_message").replace("%player%", p.getDisplayName())));
        }
        else {
            e.setJoinMessage(ChatUtils.chatColor(plugin.getConfig().getString("Events.join_message").replace("%player%", p.getDisplayName())));
        }
    }
}
