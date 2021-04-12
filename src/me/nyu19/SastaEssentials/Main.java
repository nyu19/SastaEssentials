package me.nyu19.SastaEssentials;

import me.nyu19.SastaEssentials.commands.FlyCommand;
import me.nyu19.SastaEssentials.commands.Heal;
import me.nyu19.SastaEssentials.commands.Reload;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        saveDefaultConfig();
        new FlyCommand(this);
        new Heal(this);
        new Reload(this);
        getLogger().info("[Sasta Essentials]: Plugin Enabled Successfully.");
    }
    public void onDisable(){

    }
}
