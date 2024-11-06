package net.alekthehero.claustrophobiautility.poop;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static net.alekthehero.claustrophobiautility.ClaustrophobiaUtility.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PoopEvent {
    private static final Map<UUID, Boolean> wasCrouching = new HashMap<>();
    private static final Map<UUID, Integer> crouchingTicks = new HashMap<>();
    private static final int REQUIRED_CROUCHING_TICKS = 1000;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        UUID playerUUID = player.getUUID();

        boolean wasPlayerCrouching = wasCrouching.getOrDefault(playerUUID, false);
        int playerCrouchingTicks = crouchingTicks.getOrDefault(playerUUID, 0);

        if (player.isCrouching()) {
            if (!wasPlayerCrouching) {
                wasCrouching.put(playerUUID, true);
                crouchingTicks.put(playerUUID, 0);
            } else {
                playerCrouchingTicks++;
                if (playerCrouchingTicks >= REQUIRED_CROUCHING_TICKS) {
                    // Give the player the item
                    player.addItem(new ItemStack(PoopRegistration.POOP.get()));
                    // Make a sound
                    player.playSound(SoundEvents.AMBIENT_UNDERWATER_ENTER, 1.0f, 3.0f);
                    crouchingTicks.put(playerUUID, 0); // Reset the counter
                } else {
                    crouchingTicks.put(playerUUID, playerCrouchingTicks);
                }
            }
        } else {
            wasCrouching.put(playerUUID, false);
            crouchingTicks.put(playerUUID, 0);
        }
    }
}
