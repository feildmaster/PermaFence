package feildmaster.PermaFence;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PermaFence extends JavaPlugin {
    final BreakListen blockListener = new BreakListen();
    final TnTListen entityListener = new TnTListen();
    public void onDisable() {}

    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Highest, this);
        pm.registerEvent(Event.Type.BLOCK_PISTON_EXTEND, blockListener, Event.Priority.Highest, this);
        pm.registerEvent(Event.Type.BLOCK_PISTON_RETRACT, blockListener, Event.Priority.Highest, this);
        pm.registerEvent(Event.Type.BLOCK_IGNITE, blockListener, Event.Priority.Lowest, this);
        pm.registerEvent(Event.Type.ENTITY_EXPLODE, entityListener, Event.Priority.Lowest, this);
        System.out.println("PermaFence v"+getDescription().getVersion()+": Enabled. Fences are invincible!");
    }
}
