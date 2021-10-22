package de.SlamWeasel.BuildersHelpers.command;

import de.SlamWeasel.BuildersHelpers.util.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdBack implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player p = (Player)sender;
            try
            {
                p.teleport(Util.BeenLoc.get(p));
            }
            catch(NullPointerException n)
            {
                p.sendMessage(ChatColor.RED + "Du warst an keinem Ort vorher, an den du dich teleportieren könntest");
            }
        }
        return false;
    }
}
