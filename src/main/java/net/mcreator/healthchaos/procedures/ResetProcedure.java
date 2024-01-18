package net.mcreator.healthchaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.healthchaos.network.HealthChaosModVariables;
import net.mcreator.healthchaos.init.HealthChaosModMobEffects;
import net.mcreator.healthchaos.configuration.TimeConfiguration;

public class ResetProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(HealthChaosModMobEffects.WITHERING.get());
		HealthChaosModVariables.MapVariables.get(world).remaining_ticks = (double) TimeConfiguration.EFFECT_TICKS.get();
		HealthChaosModVariables.MapVariables.get(world).syncData(world);
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(20);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(HealthChaosModMobEffects.WITHERING.get(), (int) HealthChaosModVariables.MapVariables.get(world).remaining_ticks, 0));
	}
}
