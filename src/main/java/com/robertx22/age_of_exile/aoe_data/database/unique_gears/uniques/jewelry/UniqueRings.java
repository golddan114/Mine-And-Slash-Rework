package com.robertx22.age_of_exile.aoe_data.database.unique_gears.uniques.jewelry;

import com.robertx22.age_of_exile.aoe_data.database.base_gear_types.BaseGearTypes;
import com.robertx22.age_of_exile.aoe_data.database.stats.Stats;
import com.robertx22.age_of_exile.aoe_data.database.stats.old.DatapackStats;
import com.robertx22.age_of_exile.aoe_data.database.unique_gears.UniqueGearBuilder;
import com.robertx22.age_of_exile.database.data.StatMod;
import com.robertx22.age_of_exile.database.data.stats.types.defense.DodgeRating;
import com.robertx22.age_of_exile.database.data.stats.types.generated.ElementalResist;
import com.robertx22.age_of_exile.database.data.stats.types.offense.SkillDamage;
import com.robertx22.age_of_exile.database.data.stats.types.resources.mana.ManaRegen;
import com.robertx22.age_of_exile.database.data.stats.types.special.SpecialStats;
import com.robertx22.age_of_exile.saveclasses.unit.ResourceType;
import com.robertx22.age_of_exile.uncommon.enumclasses.Elements;
import com.robertx22.age_of_exile.uncommon.enumclasses.ModType;
import com.robertx22.library_of_exile.registry.ExileRegistryInit;

import java.util.Arrays;

public class UniqueRings implements ExileRegistryInit {

    @Override
    public void registerAll() {

        UniqueGearBuilder.of(
                        "witch_brew",
                        "Witch's Brew",
                        BaseGearTypes.RING)

                .stats(Arrays.asList(
                        new StatMod(15, 25, new ElementalResist(Elements.Chaos), ModType.PERCENT),
                        new StatMod(25, 50, SpecialStats.BETTER_FOOD_BUFFS, ModType.FLAT),
                        new StatMod(10, 15, SkillDamage.getInstance(), ModType.FLAT),
                        new StatMod(5, 10, ManaRegen.getInstance(), ModType.PERCENT)

                ))

                .devComment("Food buff mage ring")
                .build();

        UniqueGearBuilder.of(
                        "ghostly_shores",
                        "Ghostly Shores",
                        BaseGearTypes.RING)
                .setReplacesName()
                .stats(Arrays.asList(
                        new StatMod(5, 15, Stats.ELEMENTAL_DAMAGE.get(Elements.Cold), ModType.FLAT),
                        new StatMod(6, 10, DodgeRating.getInstance(), ModType.PERCENT),
                        new StatMod(6, 15, Stats.RESOURCE_ON_KILL.get(ResourceType.mana), ModType.FLAT),
                        new StatMod(10, 15, Stats.CRIT_DAMAGE.get(), ModType.FLAT),
                        new StatMod(5, 10, Stats.COOLDOWN_REDUCTION.get(), ModType.FLAT),
                        new StatMod(-3, -6, DatapackStats.STR, ModType.FLAT)
                ))

                .build();

    }
}