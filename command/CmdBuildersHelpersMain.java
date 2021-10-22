package de.SlamWeasel.BuildersHelpers.command;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.SlamWeasel.BuildersHelpers.util.Util;

public class CmdBuildersHelpersMain implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player p = (Player) sender;

            Inventory Menu = Bukkit.getServer().createInventory(p, Util.Reihe[5], "§8Builder's Helpers Feature Menü");
            ItemStack Fill = new ItemStack(Material.STAINED_GLASS_PANE, 1 ,(short) 8);
            ItemMeta FillMeta = Fill.getItemMeta();
            FillMeta.setDisplayName(" ");
            Fill.setItemMeta(FillMeta);
            ItemStack SnowHelper = new ItemStack(Material.SNOW);
            ItemMeta SnowHelperMeta = SnowHelper.getItemMeta();
            SnowHelperMeta.setDisplayName("§3SnowHelper");
            SnowHelperMeta.setLore(Arrays.asList("§c└ → §lCLICK: §r" + "§fSchneelayer mehr",
                    "§c└ ← §lCLICK: §r" + "§fSchneelayer weniger",
                    "§c   → §lCLICK: §r" + "§fSchnee platzieren",
                    "§c   ← §lCLICK: §r" + "§fBlöcke abbauen",
                    "§4§lItem: §r" + "§fSchneelayer-block",
                    "§8§l-----------------------------------------",
                    "Ist diese Funktion aktiviert, so wird automatisch",
                    "die ausgewählte Anzahl an Schneelayern platziert",
                    "§8§l-----------------------------------------",
                    "§fDieses Feature ist im Moment aktiviert"));
            SnowHelper.setItemMeta(SnowHelperMeta);
            ItemStack SlabHelper = new ItemStack(Material.WOOD_STEP);
              ItemMeta SlabHelperMeta = SlabHelper.getItemMeta();
                SlabHelperMeta.setDisplayName("§3SlabHelper");
                SlabHelperMeta.setLore(Arrays.asList("§c   ← §lCLICK: §r" + "§fNur einen Slab abbauen",
                        "§4§lItem: §r" + "§fJeder beliebige Half-Slab",
                        "§8§l-----------------------------------------",
                        "Damit wird, beim abbauen, nur der angesehene Slab",
                        "von einem Doubleslab-Block entfernt",
                        "§8§l-----------------------------------------",
                        "§fDieses Feature ist im Moment aktiviert"));
              SlabHelper.setItemMeta(SlabHelperMeta);

            for(int index = 0; index < Util.Reihe[5]; index++)
                Menu.setItem(index, Fill);
            Menu.setItem(10, SnowHelper);
            Menu.setItem(12, SlabHelper);

            p.openInventory(Menu);
        }
        else
            System.out.println("Dies ist ein Command für Spieler");
        return false;
    }
}
