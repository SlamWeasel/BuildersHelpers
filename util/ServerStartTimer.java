package de.SlamWeasel.BuildersHelpers.util;

import de.SlamWeasel.BuildersHelpers.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Server;

public class ServerStartTimer
{
    static int BN = 0;
    static boolean done = false;

    public static void Stoplag()
    {
        Server server = Bukkit.getServer();
        server.getScheduler().scheduleSyncRepeatingTask(Main.getplugin(), new Runnable() {
            public void run()
            {
                if(!done)
                {
                    server.dispatchCommand(server.getConsoleSender(), "stoplag");
                    server.getConsoleSender().sendMessage("Stoplag wurde automatisch aktiviert");
                    done = true;
                }
                else return;
            }
        }, 0L, 1400L);
    }
}
