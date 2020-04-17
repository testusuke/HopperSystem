package net.testusuke.hoppersystem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class HopperBuildEvent implements Listener {
    private final HopperSystem plugin;
    public HopperBuildEvent(HopperSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBuild(BlockPlaceEvent event){
        if(event.getBlock().getType() != Material.HOPPER)return;
        Player player = event.getPlayer();
        //  getMode
        if(!plugin.mode)return;
        player.sendMessage(plugin.prefix + "§cホッパーは置けません。You can not place Hopper.");
        event.setCancelled(true);
    }
}
