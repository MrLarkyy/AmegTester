package xyz.larkyy.amegtester;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.larkyy.aquaticmodelengine.api.event.EmoteEndEvent;

public class Listeners implements Listener {

    @EventHandler
    public void onEmoteEnd(EmoteEndEvent e) {
        var uuid = e.getPlayerModel().getModelHolder().getUniqueId();
        if (uuid == null) {
            return;
        }
        var player = Bukkit.getPlayer(uuid);
        if (player == null) {
            return;
        }
        Amegtester.getInstance().getEmoteHandler().forceStopEmote(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        var player = e.getPlayer();
        Amegtester.getInstance().getEmoteHandler().forceStopEmote(player);
    }

}
