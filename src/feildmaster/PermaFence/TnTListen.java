package feildmaster.PermaFence;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

class TnTListen implements Listener {
    public TnTListen(PermaFence plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        for(Block block : event.blockList())
            if(block.getType() == Material.FENCE) {
                event.setCancelled(true);
                break;
            }

    }
}
