package de.SlamWeasel.BuildersHelpers.listener;

import de.SlamWeasel.BuildersHelpers.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerListener implements Listener
{
    @EventHandler
    public void onClick(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        if((e.getAction() == Action.LEFT_CLICK_AIR) && (e.getItem().getType() == Material.WOOD_AXE))
            Bukkit.getServer().dispatchCommand(p, "/pos1");
        if((e.getAction() == Action.RIGHT_CLICK_AIR) && (e.getItem().getType() == Material.WOOD_AXE))
            Bukkit.getServer().dispatchCommand(p, "/pos2");
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e)
    {
        Util.BeenLoc.put(e.getPlayer(), e.getFrom());
    }
}
