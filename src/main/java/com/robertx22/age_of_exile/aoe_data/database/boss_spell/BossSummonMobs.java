package com.robertx22.age_of_exile.aoe_data.database.boss_spell;

import net.minecraft.world.entity.LivingEntity;

public abstract class BossSummonMobs extends BossSpell {
    
    @Override
    public int castTicks() {
        return 60;
    }

    @Override
    public void onTick(LivingEntity en, int tick) {

    }

    @Override
    public void onFinish(LivingEntity en) {

    }


}
