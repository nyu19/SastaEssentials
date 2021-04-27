package me.nyu19.SastaEssentials.Listeners;

import me.nyu19.SastaEssentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SnowBoom implements Listener {
    private Main plugin;
    public SnowBoom(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    public void explode(ProjectileHitEvent ev){
        Block hitBlock = ev.getHitBlock();
        hitBlock.getWorld().createExplosion(hitBlock.getLocation(), 4, true, true);
    }
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e){
        if(!(plugin.getConfig().getBoolean("Explosive_Projectile.status"))){
            return;
        }else {
            if(plugin.getConfig().getString("Explosive_Projectile.entity") == e.getEntity().getName().replace("minecraft:","")){
                explode(e);
            }
            else{
                return;
            }
        }
    }
}
