package net.mcreator.healthchaos.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.healthchaos.init.HealthChaosModMobEffects;

public class StopEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(HealthChaosModMobEffects.WITHERING.get());
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(20);
	}
}
