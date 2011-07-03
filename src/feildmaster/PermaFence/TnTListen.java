package feildmaster.PermaFence;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityExplodeEvent;

class TnTListen extends EntityListener {
    public TnTListen() {}

    public void onEntityExplode(EntityExplodeEvent event) {
        for(Block block : event.blockList())
            if(block.getType() == Material.FENCE) {
                event.setCancelled(true);
                break;
            }

    }
}
