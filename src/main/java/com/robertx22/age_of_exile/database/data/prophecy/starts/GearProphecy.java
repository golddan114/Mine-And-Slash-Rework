package com.robertx22.age_of_exile.database.data.prophecy.starts;

import com.robertx22.age_of_exile.database.data.prophecy.ProphecyModifierType;
import com.robertx22.age_of_exile.database.data.prophecy.ProphecyStart;
import com.robertx22.age_of_exile.database.registry.ExileDB;
import com.robertx22.age_of_exile.loot.LootInfo;
import com.robertx22.age_of_exile.loot.blueprints.GearBlueprint;
import com.robertx22.age_of_exile.loot.blueprints.ItemBlueprint;

public class GearProphecy extends ProphecyStart {


    public String league = "";

    @Override
    public ItemBlueprint create(int lvl, int tier) {
        var info = LootInfo.ofLevel(lvl);
        if (ExileDB.LeagueMechanics().isRegistered(league)) {
            info.league = ExileDB.LeagueMechanics().get(league);
        }
        info.map_tier = tier;
        return new GearBlueprint(info);
    }

    @Override
    public boolean acceptsModifier(ProphecyModifierType type) {
        return true;
    }

    @Override
    public String GUID() {
        return "gear";
    }

    @Override
    public int Weight() {
        return 1000;
    }

    @Override
    public String locNameForLangFile() {
        return "Gear Prophecy";
    }
}
