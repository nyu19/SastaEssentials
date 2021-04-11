package me.nyu19.SastaEssentials.utils;

import org.bukkit.ChatColor;

public class ChatUtils {
    public static String chatColor(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }
}
