package com.robertx22.age_of_exile.capability.bases;

import com.robertx22.age_of_exile.capability.entity.EntityData;
import com.robertx22.age_of_exile.capability.player.EntitySpellData;
import com.robertx22.age_of_exile.uncommon.datasaving.Load;
import net.minecraft.world.entity.player.Player;

public class CapSyncUtil {

    public static void syncPerSecond(Player player) {
        syncSpells(player);
        syncEntityCap(player);
        syncRpgStats(player);
    }

    public static void syncAll(Player player) {
        syncEntityCap(player);
        syncSpells(player);
        syncRpgStats(player);
    }

    public static void syncSpells(Player player) {
        EntitySpellData.ISpellsCap data = Load.spells(player);
        data.syncToClient(player);
    }

    public static void syncEntityCap(Player player) {
        EntityData data = Load.Unit(player);
        data.syncToClient(player);
    }

    public static void syncRpgStats(Player player) {
        Load.playerRPGData(player)
                .syncToClient(player);
    }

}
