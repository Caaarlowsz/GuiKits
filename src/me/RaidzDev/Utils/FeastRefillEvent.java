package me.RaidzDev.Utils;

import org.bukkit.event.*;
import org.bukkit.inventory.*;
import me.RaidzDev.*;
import org.bukkit.*;
import org.bukkit.block.*;

public class FeastRefillEvent extends Event
{
    static HandlerList handlers;
    
    static {
        FeastRefillEvent.handlers = new HandlerList();
    }
    
    public int getChestAmount() {
        return FeastHandler.chests;
    }
    
    public Inventory getRefilledChests() {
        Chunk[] loadedChunks;
        for (int length = (loadedChunks = Main.instance.getServer().getWorld(Main.instance.FeastConfig.getString("Settings.FeastWorld")).getLoadedChunks()).length, i = 0; i < length; ++i) {
            final Chunk chunk = loadedChunks[i];
            BlockState[] tileEntities;
            for (int length2 = (tileEntities = chunk.getTileEntities()).length, j = 0; j < length2; ++j) {
                final BlockState entities = tileEntities[j];
                if (entities instanceof Chest) {
                    return ((Chest)entities).getInventory();
                }
            }
        }
        return null;
    }
    
    public HandlerList getHandlers() {
        return FeastRefillEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return FeastRefillEvent.handlers;
    }
}
