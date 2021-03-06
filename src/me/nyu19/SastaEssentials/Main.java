package me.nyu19.SastaEssentials;

import me.nyu19.SastaEssentials.Listeners.AutoTNT;
import me.nyu19.SastaEssentials.Listeners.JoinListener;
import me.nyu19.SastaEssentials.Listeners.LeaveListener;
import me.nyu19.SastaEssentials.Listeners.SnowBoom;
import me.nyu19.SastaEssentials.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        saveDefaultConfig();
        new FlyCommand(this);
        new Heal(this);
        new God(this);
        new FlySpeed(this);
        new Hat(this);
        new AutoTNT(this);
//        new Lockchest(this);
        new Reload(this);
        new JoinListener(this);
        new SnowBoom(this);
        new LeaveListener(this);
        getLogger().info("Plugin Enabled Successfully.");
    }
    public void onDisable(){

    }
}
