package net.testusuke.hoppersystem;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;

public class HopperMovingEvent implements Listener {

    private final HopperSystem plugin;
    public HopperMovingEvent(HopperSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryMovingItem(InventoryMoveItemEvent event){
        if(event.getDestination().getType() != InventoryType.HOPPER) return;
        if(event.getSource().getType() != InventoryType.HOPPER) return;
        //  getMode
        if(!plugin.mode)return;
        event.setCancelled(true);
    }

}
