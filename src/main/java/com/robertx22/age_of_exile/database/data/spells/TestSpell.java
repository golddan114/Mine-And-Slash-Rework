package com.robertx22.age_of_exile.database.data.spells;

import com.robertx22.age_of_exile.aoe_data.database.spells.PartBuilder;
import com.robertx22.age_of_exile.aoe_data.database.spells.SpellBuilder;
import com.robertx22.age_of_exile.aoe_data.database.spells.SpellCalcs;
import com.robertx22.age_of_exile.database.data.spells.components.Spell;
import com.robertx22.age_of_exile.database.data.spells.components.SpellConfiguration;
import com.robertx22.age_of_exile.database.data.spells.components.actions.SpellAction;
import com.robertx22.age_of_exile.database.data.spells.map_fields.MapField;
import com.robertx22.age_of_exile.database.data.spells.spell_classes.CastingWeapon;
import com.robertx22.age_of_exile.mmorpg.registers.common.SlashEntities;
import com.robertx22.age_of_exile.tags.all.SpellTags;
import com.robertx22.age_of_exile.uncommon.enumclasses.Elements;
import com.robertx22.age_of_exile.uncommon.enumclasses.PlayStyle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;

import java.util.Arrays;

public class TestSpell {

    public static String USE_THIS_EXACT_ID = "test_spell"; // USE THE EXACT "ID" HERE OR THE TEST SPELL GEM WONT WORK

    public static Spell get() {
        return
                SpellBuilder.of(USE_THIS_EXACT_ID, PlayStyle.INT, SpellConfiguration.Builder.instant(7, 20)
                                        .setSwingArm()
                                        .applyCastSpeedToCooldown(), "Poison Ball",
                                Arrays.asList(SpellTags.projectile, SpellTags.damage))
                        .weaponReq(CastingWeapon.MAGE_WEAPON)

                        .onCast(PartBuilder.playSound(SoundEvents.BLAZE_SHOOT, 1D, 0.6D))
                        .onCast(PartBuilder.justAction(SpellAction.SUMMON_PROJECTILE.create(Items.AIR, 1D, 3D, SlashEntities.SIMPLE_PROJECTILE.get(), 10D, false)
                                .put(MapField.EXPIRE_ON_ENTITY_HIT, false)))
                        .onTick(PartBuilder.particleOnTick(1D, ParticleTypes.SMOKE, 1D, 0.1D))
                        .onTick(PartBuilder.particleOnTick(1D, ParticleTypes.ASH, 1D, 0.3D))

                        .onHit(PartBuilder.damageInAoe(SpellCalcs.FIREBALL, Elements.Fire, 2D))
                        .onHit(PartBuilder.playSound(SoundEvents.GENERIC_HURT, 1D, 1D))
                        .onHit(PartBuilder.aoeParticles(ParticleTypes.SMOKE, 5D, 0.5D))

                        .weight(0)
                        .buildForEffect();

    }
}
