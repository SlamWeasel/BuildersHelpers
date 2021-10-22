package de.SlamWeasel.BuildersHelpers.listener;

import java.util.Arrays;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.SlamWeasel.BuildersHelpers.util.Util;

public class BlockListener implements Listener
{
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e)
    {
        Player p = e.getPlayer();

        if(e.getBlock().getType() == Material.SNOW)
        {
            if(e.getItemInHand() == null)
                return;
            else if(e.getItemInHand().getItemMeta().getDisplayName() == null)
                return;
            else if(e.getItemInHand().getItemMeta().getDisplayName().equals("§l8/8"))
            {
                e.getBlock().setType(Material.SNOW);
                e.getBlock().setData((byte) 7);
            }
            else if(e.getItemInHand().getItemMeta().getDisplayName().equals("§l7/8"))
            {
                e.getBlock().setType(Material.SNOW);
                e.getBlock().setData((byte) 6);
            }
            else if(e.getItemInHand().getItemMeta().getDisplayName().equals("§l6/8"))
            {
                e.getBlock().setType(Material.SNOW);
                e.getBlock().setData((byte) 5);
            }
            else if(e.getItemInHand().getItemMeta().getDisplayName().equals("§l5/8"))
            {
                e.getBlock().setType(Material.SNOW);
                e.getBlock().setData((byte) 4);
            }
            else if(e.getItemInHand().getItemMeta().getDisplayName().equals("§l4/8"))
            {
                e.getBlock().setType(Material.SNOW);
                e.getBlock().setData((byte) 3);
            }
            else if(e.getItemInHand().getItemMeta().getDisplayName().equals("§l3/8"))
            {
                e.getBlock().setType(Material.SNOW);
                e.getBlock().setData((byte) 2);
            }
            else if(e.getItemInHand().getItemMeta().getDisplayName().equals("§l2/8"))
            {
                e.getBlock().setType(Material.SNOW);
                e.getBlock().setData((byte) 1);
            }
            else if(e.getItemInHand().getItemMeta().getDisplayName().equals("§l1/8"))
            {
                e.getBlock().setType(Material.SNOW);
                e.getBlock().setData((byte) 0);
            }
            else return;
        }
        else if((e.getBlock().getType() == Material.LOG) || (e.getBlock().getType() == Material.LOG_2))
        {
            if(!p.isSneaking())
            {
                switch(e.getItemInHand().getData().getData())
                {
                    case 0: p.playSound(p.getLocation(), "block.wood.place", 1f, 1f);
                            e.getBlockPlaced().setData((byte)12);
                            break;
                    case 1: p.playSound(p.getLocation(), "block.wood.place", 1f, 1f);
                            e.getBlockPlaced().setData((byte)13);
                            break;
                    case 2: p.playSound(p.getLocation(), "block.wood.place", 1f, 1f);
                            e.getBlockPlaced().setData((byte)14);
                            break;
                    case 3: p.playSound(p.getLocation(), "block.wood.place", 1f, 1f);
                            e.getBlockPlaced().setData((byte)15);
                            break;
                }
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e)
    {

        Player p = e.getPlayer();
        int SubID = 0;

        if( (p.getItemInHand().getType() == Material.PURPUR_SLAB) ||
            (p.getItemInHand().getType() == Material.STONE_SLAB2) ||
            (p.getItemInHand().getType() == Material.STEP) ||
            (p.getItemInHand().getType() == Material.WOOD_STEP))
        {
            switch(e.getBlock().getType().getId())
            {
                case 204:   e.setCancelled(true);
                            if(p.getLocation().getPitch() >= 0)
                            {
                                e.getBlock().setType(Material.PURPUR_SLAB);
                                e.getBlock().setData((byte) 0);
                            }
                            else if(p.getLocation().getPitch() < 0)
                            {
                                e.getBlock().setType(Material.PURPUR_SLAB);
                                e.getBlock().setData((byte) 8);
                            }
                            break;
                case 181:   e.setCancelled(true);
                            if(p.getLocation().getPitch() >= 0)
                            {
                                e.getBlock().setType(Material.STONE_SLAB2);
                                e.getBlock().setData((byte) 0);
                            }
                            else if(p.getLocation().getPitch() < 0)
                            {
                                e.getBlock().setType(Material.STONE_SLAB2);
                                e.getBlock().setData((byte) 8);
                            }
                            break;
                case 43:    e.setCancelled(true);
                            if(p.getLocation().getPitch() >= 0)
                            {
                                SubID = e.getBlock().getData();
                                e.getBlock().setType(Material.STEP);
                                e.getBlock().setData((byte)(SubID + 0));
                            }
                            if(p.getLocation().getPitch() <= 0)
                            {
                                SubID = e.getBlock().getData();
                                e.getBlock().setType(Material.STEP);
                                e.getBlock().setData((byte)(SubID + 8));
                            }
                            break;
                case 125:   e.setCancelled(true);
                            if(p.getLocation().getPitch() >= 0)
                            {
                                SubID = e.getBlock().getData();
                                e.getBlock().setType(Material.WOOD_STEP);
                                e.getBlock().setData((byte)(SubID + 0));
                            }
                            if(p.getLocation().getPitch() <= 0)
                            {
                                SubID = e.getBlock().getData();
                                e.getBlock().setType(Material.WOOD_STEP);
                                e.getBlock().setData((byte)(SubID + 8));
                            }
                            break;
            }
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onClick(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        Inventory i = p.getInventory();

        if(e.getHand() == EquipmentSlot.HAND)
        {
            if (e.getAction() == Action.RIGHT_CLICK_AIR)
            {
                if (p.isSneaking())
                {
                    if (p.getItemInHand().getType() == Material.SNOW)
                    {
                        e.setCancelled(true);

                        ItemStack I = new ItemStack(Material.SNOW);
                        ItemMeta IMeta = I.getItemMeta();
                        IMeta.setDisplayName("§l1/8");
                        I.setItemMeta(IMeta);
                        ItemStack II = new ItemStack(Material.SNOW);
                        ItemMeta IIMeta = II.getItemMeta();
                        IIMeta.setDisplayName("§l2/8");
                        II.setItemMeta(IIMeta);
                        ItemStack III = new ItemStack(Material.SNOW);
                        ItemMeta IIIMeta = III.getItemMeta();
                        IIIMeta.setDisplayName("§l3/8");
                        III.setItemMeta(IIIMeta);
                        ItemStack IV = new ItemStack(Material.SNOW);
                        ItemMeta IVMeta = IV.getItemMeta();
                        IVMeta.setDisplayName("§l4/8");
                        IV.setItemMeta(IVMeta);
                        ItemStack V = new ItemStack(Material.SNOW);
                        ItemMeta VMeta = V.getItemMeta();
                        VMeta.setDisplayName("§l5/8");
                        V.setItemMeta(VMeta);
                        ItemStack VI = new ItemStack(Material.SNOW);
                        ItemMeta VIMeta = VI.getItemMeta();
                        VIMeta.setDisplayName("§l6/8");
                        VI.setItemMeta(VIMeta);
                        ItemStack VII = new ItemStack(Material.SNOW);
                        ItemMeta VIIMeta = VII.getItemMeta();
                        VIIMeta.setDisplayName("§l7/8");
                        VII.setItemMeta(VIIMeta);
                        ItemStack VIII = new ItemStack(Material.SNOW);
                        ItemMeta VIIIMeta = VIII.getItemMeta();
                        VIIIMeta.setDisplayName("§l8/8");
                        VIII.setItemMeta(VIIIMeta);

                        if (i.contains(new ItemStack(Material.SNOW)))
                        {
                            i.remove(Material.SNOW);
                            i.addItem(I);
                        }

                        if (e.getItem().getItemMeta().getDisplayName().equals("§l1/8"))
                        {
                            i.remove(I);
                            i.addItem(II);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l2/8"))
                        {
                            i.remove(II);
                            i.addItem(III);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l3/8"))
                        {
                            i.remove(III);
                            i.addItem(IV);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l4/8"))
                        {
                            i.remove(IV);
                            i.addItem(V);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l5/8"))
                        {
                            i.remove(V);
                            i.addItem(VI);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l6/8"))
                        {
                            i.remove(VI);
                            i.addItem(VII);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l7/8"))
                        {
                            i.remove(VII);
                            i.addItem(VIII);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l8/8"))
                        {
                            i.remove(VIII);
                            i.addItem(I);
                        }
                        else return;
                    }
                    else if ((p.getItemInHand().getType() == Material.BLAZE_ROD) && (p.getItemInHand().getItemMeta().getDisplayName().equals("§3Builder's Wand")))
                    {
                        e.setCancelled(true);

                        Inventory Menu = Bukkit.getServer().createInventory(p, Util.Reihe[5], "§8Builder's Helpers Wand Menü");
                        ItemStack Fill = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
                        ItemMeta FillMeta = Fill.getItemMeta();
                        FillMeta.setDisplayName(" ");
                        Fill.setItemMeta(FillMeta);
                        ItemStack SnowHelper = new ItemStack(Material.SNOW);
                        ItemMeta SnowHelperMeta = SnowHelper.getItemMeta();
                        SnowHelperMeta.setDisplayName("§3SnowHelper");
                        SnowHelperMeta.setLore(Arrays.asList("§fSchau unter §c/bh menu§f die Funktionen nach!"));
                        SnowHelper.setItemMeta(SnowHelperMeta);

                        for (int index = 0; index < Util.Reihe[5]; index++)
                            Menu.setItem(index, Fill);
                        Menu.setItem(10, SnowHelper);

                        p.openInventory(Menu);
                    }
                    else return;
                }
                else return;
            }
            else if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK))
            {
                if (p.isSneaking())
                {
                    if (p.getItemInHand().getType() == Material.SNOW)
                    {
                        e.setCancelled(true);

                        ItemStack I = new ItemStack(Material.SNOW);
                        ItemMeta IMeta = I.getItemMeta();
                        IMeta.setDisplayName("§l1/8");
                        I.setItemMeta(IMeta);
                        ItemStack II = new ItemStack(Material.SNOW);
                        ItemMeta IIMeta = II.getItemMeta();
                        IIMeta.setDisplayName("§l2/8");
                        II.setItemMeta(IIMeta);
                        ItemStack III = new ItemStack(Material.SNOW);
                        ItemMeta IIIMeta = III.getItemMeta();
                        IIIMeta.setDisplayName("§l3/8");
                        III.setItemMeta(IIIMeta);
                        ItemStack IV = new ItemStack(Material.SNOW);
                        ItemMeta IVMeta = IV.getItemMeta();
                        IVMeta.setDisplayName("§l4/8");
                        IV.setItemMeta(IVMeta);
                        ItemStack V = new ItemStack(Material.SNOW);
                        ItemMeta VMeta = V.getItemMeta();
                        VMeta.setDisplayName("§l5/8");
                        V.setItemMeta(VMeta);
                        ItemStack VI = new ItemStack(Material.SNOW);
                        ItemMeta VIMeta = VI.getItemMeta();
                        VIMeta.setDisplayName("§l6/8");
                        VI.setItemMeta(VIMeta);
                        ItemStack VII = new ItemStack(Material.SNOW);
                        ItemMeta VIIMeta = VII.getItemMeta();
                        VIIMeta.setDisplayName("§l7/8");
                        VII.setItemMeta(VIIMeta);
                        ItemStack VIII = new ItemStack(Material.SNOW);
                        ItemMeta VIIIMeta = VIII.getItemMeta();
                        VIIIMeta.setDisplayName("§l8/8");
                        VIII.setItemMeta(VIIIMeta);

                        if (i.contains(new ItemStack(Material.SNOW)))
                        {
                            i.remove(Material.SNOW);
                            i.addItem(I);
                        }

                        if (e.getItem().getItemMeta().getDisplayName().equals("§l1/8"))
                        {
                            i.remove(I);
                            i.addItem(VIII);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l2/8"))
                        {
                            i.remove(II);
                            i.addItem(I);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l3/8"))
                        {
                            i.remove(III);
                            i.addItem(II);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l4/8"))
                        {
                            i.remove(IV);
                            i.addItem(III);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l5/8"))
                        {
                            i.remove(V);
                            i.addItem(IV);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l6/8"))
                        {
                            i.remove(VI);
                            i.addItem(V);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l7/8"))
                        {
                            i.remove(VII);
                            i.addItem(VI);
                        }
                        else if (e.getItem().getItemMeta().getDisplayName().equals("§l8/8"))
                        {
                            i.remove(VIII);
                            i.addItem(VII);
                        }
                        else return;
                    }
                    else return;
                }
                else return;
            }
            else if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
            {
                if ((p.getItemInHand().getType() == Material.BLAZE_ROD) && (p.getItemInHand().getItemMeta().getDisplayName().equals("§3Builder's Wand")))
                {
                    if (p.isSneaking())
                    {
                        e.setCancelled(true);

                        Inventory WandMenu = Bukkit.getServer().createInventory(p, Util.Reihe[5], "§8Builder's Helpers Wand Menü");
                        ItemStack Fill = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
                        ItemMeta FillMeta = Fill.getItemMeta();
                        FillMeta.setDisplayName(" ");
                        Fill.setItemMeta(FillMeta);
                        ItemStack SnowHelper = new ItemStack(Material.SNOW);
                        ItemMeta SnowHelperMeta = SnowHelper.getItemMeta();
                        SnowHelperMeta.setDisplayName("§3SnowHelper");
                        SnowHelperMeta.setLore(Arrays.asList("§fSchau unter §c/bh menu§f die Funktionen nach!"));
                        SnowHelper.setItemMeta(SnowHelperMeta);

                        for (int index = 0; index < Util.Reihe[5]; index++)
                            WandMenu.setItem(index, Fill);
                        WandMenu.setItem(10, SnowHelper);

                        p.openInventory(WandMenu);
                    }
                    else
                    {
                        Block b = p.getTargetBlock((HashSet<Material>) null, 100);
                        int count = 0;

                        switch (e.getBlockFace())
                        {
                            case NORTH:
                                count = 0;

                                while (new Location(e.getClickedBlock().getLocation().getWorld(),
                                        e.getClickedBlock().getLocation().getX(),
                                        e.getClickedBlock().getLocation().getY(),
                                        e.getClickedBlock().getLocation().getZ() + count
                                ).getBlock().getType() != Material.AIR)
                                {
                                    if (count > 100)
                                    {
                                        p.sendMessage(ChatColor.RED + "Der nächste freie Block ist zu weit entfernt");
                                        break;
                                    }
                                    count++;
                                }

                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, 0, count)).getBlock().setType(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, 0, count - 1)).getBlock().getType());
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, 0, count)).getBlock().setData(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, 0, count - 1)).getBlock().getData());

                                break;

                            case SOUTH:
                                count = 0;

                                while (new Location(e.getClickedBlock().getLocation().getWorld(),
                                        e.getClickedBlock().getLocation().getX(),
                                        e.getClickedBlock().getLocation().getY(),
                                        e.getClickedBlock().getLocation().getZ() - count
                                ).getBlock().getType() != Material.AIR)
                                {
                                    if (count > 100)
                                    {
                                        p.sendMessage(ChatColor.RED + "Der nächste freie Block ist zu weit entfernt");
                                        break;
                                    }
                                    count++;
                                }
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, 0, -count)).getBlock().setType(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, 0, -count + 1)).getBlock().getType());
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, 0, -count)).getBlock().setData(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, 0, -count + 1)).getBlock().getData());
                                break;

                            case EAST:
                                count = 0;

                                while (new Location(e.getClickedBlock().getLocation().getWorld(),
                                        e.getClickedBlock().getLocation().getX() - count,
                                        e.getClickedBlock().getLocation().getY(),
                                        e.getClickedBlock().getLocation().getZ()
                                ).getBlock().getType() != Material.AIR)
                                {
                                    if (count > 100)
                                    {
                                        p.sendMessage(ChatColor.RED + "Der nächste freie Block ist zu weit entfernt");
                                        break;
                                    }
                                    count++;
                                }
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), -count, 0, 0)).getBlock().setType(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), -count + 1, 0, 0)).getBlock().getType());
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), -count, 0, 0)).getBlock().setData(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), -count + 1, 0, 0)).getBlock().getData());
                                break;

                            case WEST:
                                count = 0;

                                while (new Location(e.getClickedBlock().getLocation().getWorld(),
                                        e.getClickedBlock().getLocation().getX() + count,
                                        e.getClickedBlock().getLocation().getY(),
                                        e.getClickedBlock().getLocation().getZ()
                                ).getBlock().getType() != Material.AIR)
                                {
                                    if (count > 100)
                                    {
                                        p.sendMessage(ChatColor.RED + "Der nächste freie Block ist zu weit entfernt");
                                        break;
                                    }
                                    count++;
                                }
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), count, 0, 0)).getBlock().setType(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), count - 1, 0, 0)).getBlock().getType());
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), count, 0, 0)).getBlock().setData(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), count - 1, 0, 0)).getBlock().getData());
                                break;

                            case UP:
                                count = 0;

                                while (new Location(e.getClickedBlock().getLocation().getWorld(),
                                        e.getClickedBlock().getLocation().getX(),
                                        e.getClickedBlock().getLocation().getY() - count,
                                        e.getClickedBlock().getLocation().getZ()
                                ).getBlock().getType() != Material.AIR)
                                {
                                    if (count > 100)
                                    {
                                        p.sendMessage(ChatColor.RED + "Der nächste freie Block ist zu weit entfernt");
                                        break;
                                    }
                                    count++;
                                }
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, -count, 0)).getBlock().setType(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, -count + 1, 0)).getBlock().getType());
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, -count, 0)).getBlock().setData(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, -count + 1, 0)).getBlock().getData());
                                break;

                            case DOWN:
                                count = 0;

                                while (new Location(e.getClickedBlock().getLocation().getWorld(),
                                        e.getClickedBlock().getLocation().getX(),
                                        e.getClickedBlock().getLocation().getY() + count,
                                        e.getClickedBlock().getLocation().getZ()
                                ).getBlock().getType() != Material.AIR)
                                {
                                    if (count > 100)
                                    {
                                        p.sendMessage(ChatColor.RED + "Der nächste freie Block ist zu weit entfernt");
                                        break;
                                    }
                                    count++;
                                }
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, count, 0)).getBlock().setType(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, count - 1, 0)).getBlock().getType());
                                e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, count, 0)).getBlock().setData(
                                        e.getClickedBlock().getLocation().add(new Location(b.getWorld(), 0, count - 1, 0)).getBlock().getData());
                                break;

                            default:
                                return;
                        }
                    }
                }
                else if (p.getItemInHand().getType() == Material.SNOW)
                {
                    if (p.isSneaking())
                    {
                        e.setCancelled(true);

                        ItemStack I = new ItemStack(Material.SNOW);
                        ItemMeta IMeta = I.getItemMeta();
                        IMeta.setDisplayName("§l1/8");
                        I.setItemMeta(IMeta);
                        ItemStack II = new ItemStack(Material.SNOW);
                        ItemMeta IIMeta = II.getItemMeta();
                        IIMeta.setDisplayName("§l2/8");
                        II.setItemMeta(IIMeta);
                        ItemStack III = new ItemStack(Material.SNOW);
                        ItemMeta IIIMeta = III.getItemMeta();
                        IIIMeta.setDisplayName("§l3/8");
                        III.setItemMeta(IIIMeta);
                        ItemStack IV = new ItemStack(Material.SNOW);
                        ItemMeta IVMeta = IV.getItemMeta();
                        IVMeta.setDisplayName("§l4/8");
                        IV.setItemMeta(IVMeta);
                        ItemStack V = new ItemStack(Material.SNOW);
                        ItemMeta VMeta = V.getItemMeta();
                        VMeta.setDisplayName("§l5/8");
                        V.setItemMeta(VMeta);
                        ItemStack VI = new ItemStack(Material.SNOW);
                        ItemMeta VIMeta = VI.getItemMeta();
                        VIMeta.setDisplayName("§l6/8");
                        VI.setItemMeta(VIMeta);
                        ItemStack VII = new ItemStack(Material.SNOW);
                        ItemMeta VIIMeta = VII.getItemMeta();
                        VIIMeta.setDisplayName("§l7/8");
                        VII.setItemMeta(VIIMeta);
                        ItemStack VIII = new ItemStack(Material.SNOW);
                        ItemMeta VIIIMeta = VIII.getItemMeta();
                        VIIIMeta.setDisplayName("§l8/8");
                        VIII.setItemMeta(VIIIMeta);

                        if (i.contains(new ItemStack(Material.SNOW)))
                        {
                            i.remove(Material.SNOW);
                            i.addItem(I);
                        }

                        try
                        {
                            if (e.getItem().getItemMeta().getDisplayName().equals("§l1/8"))
                            {
                                i.remove(I);
                                i.addItem(II);
                            }
                            else if (e.getItem().getItemMeta().getDisplayName().equals("§l2/8"))
                            {
                                i.remove(II);
                                i.addItem(III);
                            }
                            else if (e.getItem().getItemMeta().getDisplayName().equals("§l3/8"))
                            {
                                i.remove(III);
                                i.addItem(IV);
                            }
                            else if (e.getItem().getItemMeta().getDisplayName().equals("§l4/8"))
                            {
                                i.remove(IV);
                                i.addItem(V);
                            }
                            else if (e.getItem().getItemMeta().getDisplayName().equals("§l5/8"))
                            {
                                i.remove(V);
                                i.addItem(VI);
                            }
                            else if (e.getItem().getItemMeta().getDisplayName().equals("§l6/8"))
                            {
                                i.remove(VI);
                                i.addItem(VII);
                            }
                            else if (e.getItem().getItemMeta().getDisplayName().equals("§l7/8"))
                            {
                                i.remove(VII);
                                i.addItem(VIII);
                            }
                            else if (e.getItem().getItemMeta().getDisplayName().equals("§l8/8"))
                            {
                                i.remove(VIII);
                                i.addItem(I);
                            }
                            else return;
                        }
                        catch (NullPointerException n)
                        {
                            n.printStackTrace();
                        }
                    }
                    else return;
                }
                else if((e.getClickedBlock().getType() == Material.IRON_TRAPDOOR) || (e.getClickedBlock().getType() == Material.IRON_DOOR_BLOCK))
                {
                    if (!p.isSneaking())
                    {
                        e.setCancelled(true);
                        switch (e.getClickedBlock().getData())
                        {
                            case 0: e.getClickedBlock().setData((byte) 4);
                                    p.playSound(p.getLocation(), "block.iron_door.close", 1f, 1f);
                                    break;
                            case 1: e.getClickedBlock().setData((byte) 5);
                                    p.playSound(p.getLocation(), "block.iron_door.close", 1f, 1f);
                                    break;
                            case 2: e.getClickedBlock().setData((byte) 6);
                                    p.playSound(p.getLocation(), "block.iron_door.close", 1f, 1f);
                                    break;
                            case 3: e.getClickedBlock().setData((byte) 7);
                                    p.playSound(p.getLocation(), "block.iron_door.close", 1f, 1f);
                                    break;
                            case 4: e.getClickedBlock().setData((byte) 0);
                                    p.playSound(p.getLocation(), "block.iron_door.open", 1f, 1f);
                                    break;
                            case 5: e.getClickedBlock().setData((byte) 1);
                                    p.playSound(p.getLocation(), "block.iron_door.open", 1f, 1f);
                                    break;
                            case 6: e.getClickedBlock().setData((byte) 2);
                                    p.playSound(p.getLocation(), "block.iron_door.open", 1f, 1f);
                                    break;
                            case 7: e.getClickedBlock().setData((byte) 3);
                                    p.playSound(p.getLocation(), "block.iron_door.open", 1f, 1f);
                                    break;
                            case 8: e.getClickedBlock().setData((byte) 12);
                                    p.playSound(p.getLocation(), "block.iron_door.close", 1f, 1f);
                                    break;
                            case 9: e.getClickedBlock().setData((byte) 13);
                                    p.playSound(p.getLocation(), "block.iron_door.close", 1f, 1f);
                                    break;
                            case 10:e.getClickedBlock().setData((byte) 14);
                                    p.playSound(p.getLocation(), "block.iron_door.close", 1f, 1f);
                                    break;
                            case 11:e.getClickedBlock().setData((byte) 15);
                                    p.playSound(p.getLocation(), "block.iron_door.close", 1f, 1f);
                                    break;
                            case 12:e.getClickedBlock().setData((byte) 8);
                                    p.playSound(p.getLocation(), "block.iron_door.open", 1f, 1f);
                                    break;
                            case 13:e.getClickedBlock().setData((byte) 9);
                                    p.playSound(p.getLocation(), "block.iron_door.open", 1f, 1f);
                                    break;
                            case 14:e.getClickedBlock().setData((byte) 10);
                                    p.playSound(p.getLocation(), "block.iron_door.open", 1f, 1f);
                                    break;
                            case 15:e.getClickedBlock().setData((byte) 11);
                                    p.playSound(p.getLocation(), "block.iron_door.open", 1f, 1f);
                                    break;
                        }
                    }
                }
                else return;
            }
        }
    }

    private static String Corrector(String IN)
    {
        String OUT = new String();;

        switch(IN)
        {
            case "red_rose" : 		OUT = "red_flower";break;
            case "long_grass":		OUT = "tallgrass";break;
            case "dead_bush":		OUT = "deadbush";break;
            case "wood":			OUT = "planks";break;
            case "trap_door":		OUT = "trapdoor";break;
            case "step":			OUT = "stone_slab";break;
            case "double_step":		OUT = "double_stone_slab";break;
            case "wood_stairs":		OUT = "oak_stairs";break;
            case "spruce_wood_stairs":OUT = "spruce_stairs";break;
            case "birch_wood_stairs":OUT = "birch_stairs";break;
            case "jungle_wood_stairs":OUT = "jungle_stairs";break;
            case "smooth_stairs":	OUT = "stone_brick_stairs";break;
            case "jack_o_lantern":	OUT = "lit_pumpkin";break;
            case "stained_clay":	OUT = "stained_hardened_clay";break;
            case "smooth_brick":	OUT = "stonebrick";break;
            case "mycel":			OUT = "mycelium";break;
            case "ender_stone":		OUT = "end_stone";break;
            case "hard_clay":		OUT = "hardened_clay";break;
            case "log_2":			OUT = "log2";break;
            case "workbench":		OUT = "crafting_table";break;
            case "burning_furnace":	OUT = "lit_furnace";break;
            case "snow_block":		OUT = "snow";break;
            case "snow":			OUT = "snow_layer";break;
            case "ender_portal_frame":OUT = "end_portal_frame";break;
            case "iron_fence":		OUT = "iron_bars";break;
            case "thin_glass":		OUT = "glass_pane";break;
            case "water_lily":		OUT = "waterlily";break;
            case "nether_fence":	OUT = "nether_brick_fence";break;
            case "leaves_2":		OUT = "leaves2";break;
            case "sign_post":		OUT = "standing_sign";break;
            case "bed_block":		OUT = "bed";break;
            case "note_block":		OUT = "noteblock";break;
            case "piston_base":		OUT = "piston";break;
            case "piston_sticky_base":OUT = "sticky_base";break;
            case "piston_extension":OUT = "piston_head";break;
            case "stone_plate":		OUT = "stone_pressure_plate";break;
            case "wood_plate":		OUT = "wooden_pressure_plate";break;
            case "redstone_torch_on":OUT = "redstone_torch";break;
            case "redstone_torch_off":OUT = "unlit_redstone_torch";break;
            case "diode_block_on":	OUT = "powered_repeater";break;
            case "diode_block_off":	OUT = "unpowered_repeater";break;
            case "redstone_lamp_on":OUT = "lit_redstone_lamp";break;
            case "redstone_lamp_off":OUT = "restone_lamp";break;
            case "iron_plate":		OUT = "heavy_weighted_pressure_plate";break;
            case "gold_plate":		OUT = "light_weighted_pressure_plate";break;
            case "iron_door_block":	OUT = "iron_door";break;
            case "redstone_comparator_off":OUT = "unpowered_comparator";break;
            case "redstone_comparator_on":OUT = "powered_comparator";break;
            case "powered_rail":	OUT = "golden_rail";break;
            default: 				OUT = IN;break;
        }
        return OUT;
    }
}
