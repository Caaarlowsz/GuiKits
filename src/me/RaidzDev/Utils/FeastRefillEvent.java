package me.RaidzDev.Utils;

import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;

import me.RaidzDev.Main;

public class FeastRefillEvent extends Event {
	static HandlerList handlers;

	static {
		FeastRefillEvent.handlers = new HandlerList();
	}

	public int getChestAmount() {
		return FeastHandler.chests;
	}

	public Inventory getRefilledChests() {
		Chunk[] loadedChunks;
		for (int length = (loadedChunks = Main.instance.getServer()
				.getWorld(Main.instance.FeastConfig.getString("Settings.FeastWorld")).getLoadedChunks()).length,
				i = 0; i < length; ++i) {
			final Chunk chunk = loadedChunks[i];
			BlockState[] tileEntities;
			for (int length2 = (tileEntities = chunk.getTileEntities()).length, j = 0; j < length2; ++j) {
				final BlockState entities = tileEntities[j];
				if (entities instanceof Chest) {
					return ((Chest) entities).getInventory();
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
