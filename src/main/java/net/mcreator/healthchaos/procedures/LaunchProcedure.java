package net.mcreator.healthchaos.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.healthchaos.network.HealthChaosModVariables;
import net.mcreator.healthchaos.init.HealthChaosModMobEffects;
import net.mcreator.healthchaos.configuration.TimeConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LaunchProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (HealthChaosModVariables.MapVariables.get(world).remaining_ticks != 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(HealthChaosModMobEffects.WITHERING.get(), (int) HealthChaosModVariables.MapVariables.get(world).remaining_ticks, 0));
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(HealthChaosModMobEffects.WITHERING.get(), (int) (double) TimeConfiguration.EFFECT_TICKS.get(), 0));
		}
	}
}
