package feildmaster.PermaFence;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;

class BreakListen extends BlockListener {
    public BreakListen() {}
    
    public void onBlockBreak(BlockBreakEvent event) {
        if(event.getBlock().getType() == Material.FENCE) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            if(player.isOp() && player.getItemInHand().getType() == Material.GOLD_PICKAXE) {
                event.setCancelled(false);
            }
        }
    }

    public void onBlockIgnite(BlockIgniteEvent event) {
        if(next2Fence(event.getBlock())) {
            event.setCancelled(true);
        }
    }

    private Boolean next2Fence(Block block) {
        if(block.getFace(BlockFace.UP).getType() == Material.FENCE
                || block.getFace(BlockFace.DOWN).getType() == Material.FENCE
                || block.getFace(BlockFace.NORTH).getType() == Material.FENCE
                || block.getFace(BlockFace.SOUTH).getType() == Material.FENCE
                || block.getFace(BlockFace.EAST).getType() == Material.FENCE
                || block.getFace(BlockFace.WEST).getType() == Material.FENCE) return true;
        return false;
    }
}
