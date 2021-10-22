package de.SlamWeasel.BuildersHelpers.main;

import de.SlamWeasel.BuildersHelpers.command.CmdBack;
import de.SlamWeasel.BuildersHelpers.command.CmdBuildersHelpersWand;
import de.SlamWeasel.BuildersHelpers.listener.*;
import de.SlamWeasel.BuildersHelpers.util.ServerStartTimer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.SlamWeasel.BuildersHelpers.command.CmdBuildersHelpersMain;

public class Main extends JavaPlugin
{
    private static Main plugin;

    public void onEnable()
    {
        plugin = this;

        this.getCommand("menu").setExecutor(new CmdBuildersHelpersMain());
        this.getCommand("wand").setExecutor(new CmdBuildersHelpersWand());
        this.getCommand("back").setExecutor(new CmdBack());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BlockListener(), this);
        pm.registerEvents(new EntityListener(), this);
        pm.registerEvents(new GUIListener(), this);
        pm.registerEvents(new PlayerListener(), this);

        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Builder's Helpers wurde geladen");

        ServerStartTimer.Stoplag();
    }
    public void onDisable()
    {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Builder's Helpers wurde entladen");
    }

    public static Main getplugin()
    {
        return plugin;
    }
}
