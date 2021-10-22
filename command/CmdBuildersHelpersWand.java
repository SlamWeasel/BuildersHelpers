package de.SlamWeasel.BuildersHelpers.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CmdBuildersHelpersWand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player p = (Player) sender;

                ItemStack wand = new ItemStack(Material.BLAZE_ROD);
                ItemMeta wandMeta = wand.getItemMeta();
                wandMeta.setDisplayName("§3Builder's Wand");
                wandMeta.setLore(Arrays.asList("Hiermit kannst du fast schon zaubern", "Finde mehr heraus mit /bh ?"));
                wand.setItemMeta(wandMeta);

                if(p.getInventory().contains(Material.BLAZE_ROD))
                {
                    p.getInventory().remove(Material.BLAZE_ROD);
                    p.getInventory().addItem(wand);
                }
                else
                    p.getInventory().addItem(wand);
            }
        else
            System.out.println("Dies ist ein Command für Spieler");
        return false;
    }

}
