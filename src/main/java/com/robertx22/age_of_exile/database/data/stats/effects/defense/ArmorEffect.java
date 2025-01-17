package com.robertx22.age_of_exile.database.data.stats.effects.defense;

import com.robertx22.age_of_exile.database.data.stats.IUsableStat;
import com.robertx22.age_of_exile.database.data.stats.Stat;
import com.robertx22.age_of_exile.database.data.stats.effects.base.InCodeStatEffect;
import com.robertx22.age_of_exile.database.data.stats.layers.StatLayers;
import com.robertx22.age_of_exile.database.data.stats.priority.StatPriority;
import com.robertx22.age_of_exile.saveclasses.unit.StatData;
import com.robertx22.age_of_exile.uncommon.effectdatas.DamageEvent;
import com.robertx22.age_of_exile.uncommon.effectdatas.rework.EventData;
import com.robertx22.age_of_exile.uncommon.enumclasses.Elements;
import com.robertx22.age_of_exile.uncommon.interfaces.EffectSides;
import net.minecraft.util.Mth;

public class ArmorEffect extends InCodeStatEffect<DamageEvent> {

    public ArmorEffect() {

        super(DamageEvent.class);
    }

    @Override
    public StatPriority GetPriority() {
        return StatPriority.Damage.DAMAGE_LAYERS;
    }

    @Override
    public EffectSides Side() {
        return EffectSides.Target;
    }

    @Override
    public DamageEvent activate(DamageEvent effect, StatData data, Stat stat) {
        float pene = effect.getPenetration();


        IUsableStat armor = (IUsableStat) stat;

        float EffectiveArmor = armor.getUsableValue(effect.targetData.getUnit(), (int) (data.getValue() - pene), effect.sourceData.getLevel());

        EffectiveArmor = Mth.clamp(EffectiveArmor, 0, armor.getMaxMulti());

        float defense = EffectiveArmor * 100F;

        effect.getLayer(StatLayers.Defensive.PHYS_MITIGATION, EventData.NUMBER, Side()).reduce(defense);

        return effect;
    }

    @Override
    public boolean canActivate(DamageEvent effect, StatData data, Stat stat) {
        return effect.GetElement() == Elements.Physical;
    }

}
