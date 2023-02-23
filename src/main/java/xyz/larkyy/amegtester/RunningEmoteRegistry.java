package xyz.larkyy.amegtester;

import org.bukkit.entity.Player;
import xyz.larkyy.aquaticmodelengine.api.model.spawned.player.PlayerModel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RunningEmoteRegistry {

    private final Map<UUID,RunningEmote> runningEmotes = new HashMap<>();

    public void addEmote(RunningEmote runningEmote) {
        runningEmotes.put(runningEmote.getPlayer().getUniqueId(), runningEmote);
    }

    public void removeEmote(UUID uuid) {
        runningEmotes.remove(uuid);
    }

    public void removeEmote(RunningEmote runningEmote) {
        removeEmote(runningEmote.getPlayer().getUniqueId());
    }

    public void removeEmote(PlayerModel playerModel) {
        removeEmote(playerModel.getModelHolder().getUniqueId());
    }

    public RunningEmote getRunningEmote(UUID uuid) {
        return runningEmotes.get(uuid);
    }

    public RunningEmote getRunningEmote(Player player) {
        return getRunningEmote(player.getUniqueId());
    }

    public RunningEmote getRunningEmote(PlayerModel playerModel) {
        return getRunningEmote(playerModel.getModelHolder().getUniqueId());
    }


}
