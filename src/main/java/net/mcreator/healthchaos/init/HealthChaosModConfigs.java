package net.mcreator.healthchaos.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.healthchaos.configuration.TimeConfiguration;
import net.mcreator.healthchaos.HealthChaosMod;

@Mod.EventBusSubscriber(modid = HealthChaosMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HealthChaosModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TimeConfiguration.SPEC, "withering.toml");
		});
	}
}
