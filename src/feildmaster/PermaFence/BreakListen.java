package feildmaster.PermaFence;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

class BreakListen extends BlockListener {
    public void onBlockBreak(BlockBreakEvent event) {
        if(event.getBlock().getType() == Material.FENCE) {
            Player player = event.getPlayer();
            if(player.hasPermission("permafence.break") && player.getItemInHand().getType() == Material.GOLD_PICKAXE)
                event.setCancelled(false);
            else if(!event.isCancelled())
                event.setCancelled(true);
        }
    }

    public void onBlockIgnite(BlockIgniteEvent event) {
        if(next2Fence(event.getBlock()))
            event.setCancelled(true);
    }

    public void onBlockPistonExtend(BlockPistonExtendEvent event) {
        for(Block block : event.getBlocks())
            if(block.getType() == Material.FENCE)
                event.setCancelled(true);
    }

    public void onBlockPistonRetract(BlockPistonRetractEvent event) {
        if(event.getBlock().getRelative(event.getDirection(),2).getType() == Material.FENCE)
            event.setCancelled(true);
    }

    private Boolean next2Fence(Block block) {
        if(block.getRelative(BlockFace.UP).getType() == Material.FENCE
                || block.getRelative(BlockFace.DOWN).getType() == Material.FENCE
                || block.getRelative(BlockFace.NORTH).getType() == Material.FENCE
                || block.getRelative(BlockFace.SOUTH).getType() == Material.FENCE
                || block.getRelative(BlockFace.EAST).getType() == Material.FENCE
                || block.getRelative(BlockFace.WEST).getType() == Material.FENCE) return true;
        return false;
    }
}
