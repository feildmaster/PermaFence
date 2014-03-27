package feildmaster.PermaFence;

import org.bukkit.plugin.java.JavaPlugin;

public class PermaFence extends JavaPlugin {
    public void onDisable() {}

    public void onEnable() {
        new BreakListen(this);
        new TnTListen(this);
        System.out.println("PermaFence v"+getDescription().getVersion()+": Enabled. Fences are invincible!");
    }
}
