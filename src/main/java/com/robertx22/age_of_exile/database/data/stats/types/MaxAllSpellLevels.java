package com.robertx22.age_of_exile.database.data.stats.types;

import com.robertx22.age_of_exile.database.data.stats.Stat;
import com.robertx22.age_of_exile.uncommon.enumclasses.Elements;

public class MaxAllSpellLevels extends Stat {

    public static String DESC = "Adds to Spell Levels. Each spell can only have +5 levels above their normal maximum!";

    public MaxAllSpellLevels() {
        this.is_perc = false;

        this.show_in_gui = false;
    }

    @Override
    public Elements getElement() {
        return Elements.Physical;
    }

    @Override
    public String locDescForLangFile() {
        return DESC;
    }

    @Override
    public String locNameForLangFile() {
        return "To All Spells";
    }

    @Override
    public String GUID() {
        return "plus_lvl_all_spells";
    }

}
