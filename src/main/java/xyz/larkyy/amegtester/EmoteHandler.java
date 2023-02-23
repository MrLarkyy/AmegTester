package xyz.larkyy.amegtester;

import org.bukkit.entity.Player;
import xyz.larkyy.aquaticmodelengine.api.AquaticModelEngineAPI;

public class EmoteHandler {

    private final RunningEmoteRegistry registry = new RunningEmoteRegistry();

    public boolean playEmote(Player player, String emoteName, String preAnimation, String animation, String postAnimation, boolean rotateHead) {
        var emote = registry.getRunningEmote(player);
        if (emote != null) {
            return false;
        }

        player.setInvisible(true);
        var holder = AquaticModelEngineAPI.getModelHandler().getModelHolder(player);
        var spawned = AquaticModelEngineAPI.getModelHandler()
                .spawnEmote(holder, player, emoteName, preAnimation, animation, postAnimation, rotateHead);
        registry.addEmote(new RunningEmote(player, spawned));
        return true;
    }

    public boolean playEmote(Player player, String emoteName, String animation, boolean rotateHead) {
        return playEmote(player, emoteName, null, animation, null, rotateHead);
    }

    public boolean playEmote(Player player, String emoteName, String animation) {
        return playEmote(player, emoteName, null, animation, null, false);
    }

    public void stopEmote(Player player) {
        var emote = registry.getRunningEmote(player);
        if (emote == null) {
            return;
        }

        var animationHandler = emote.getPlayerModel().getAnimationHandler();

        if (animationHandler.getRunningAnimations().size() == 1) {
            forceStopEmote(player);
            return;
        }
        animationHandler.stopAnimation();
    }

    public void forceStopEmote(Player player) {
        var emote = registry.getRunningEmote(player);
        if (emote == null) {
            return;
        }

        AquaticModelEngineAPI.getModelHandler().deleteHolder(emote.getPlayerModel().getModelHolder());
        player.setInvisible(false);
        registry.removeEmote(emote);
    }
}
