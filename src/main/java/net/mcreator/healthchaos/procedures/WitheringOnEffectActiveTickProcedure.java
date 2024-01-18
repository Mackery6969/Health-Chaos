package net.mcreator.healthchaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.healthchaos.network.HealthChaosModVariables;
import net.mcreator.healthchaos.init.HealthChaosModMobEffects;
import net.mcreator.healthchaos.configuration.TimeConfiguration;

public class WitheringOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double newMaxHealth = 0;
		HealthChaosModVariables.MapVariables.get(world).remaining_ticks = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(HealthChaosModMobEffects.WITHERING.get())
				? _livEnt.getEffect(HealthChaosModMobEffects.WITHERING.get()).getDuration()
				: 0;
		HealthChaosModVariables.MapVariables.get(world).syncData(world);
		newMaxHealth = ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(HealthChaosModMobEffects.WITHERING.get()) ? _livEnt.getEffect(HealthChaosModMobEffects.WITHERING.get()).getDuration() : 0)
				/ (double) TimeConfiguration.EFFECT_TICKS.get()) * 19 * 0.95 + 1;
		if (newMaxHealth < (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 1);
		}
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(newMaxHealth);
	}
}
