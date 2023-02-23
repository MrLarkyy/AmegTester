package xyz.larkyy.amegtester;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.larkyy.amegtester.commands.Commands;

public final class Amegtester extends JavaPlugin {

    private static Amegtester instance;
    private EmoteHandler emoteHandler;

    @Override
    public void onLoad() {
        instance = this;
        emoteHandler = new EmoteHandler();
    }

    @Override
    public void onEnable() {
        getCommand("amegtester").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Amegtester getInstance() {
        return instance;
    }

    public EmoteHandler getEmoteHandler() {
        return emoteHandler;
    }
}
