
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.healthchaos.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.healthchaos.potion.WitheringMobEffect;
import net.mcreator.healthchaos.HealthChaosMod;

public class HealthChaosModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, HealthChaosMod.MODID);
	public static final RegistryObject<MobEffect> WITHERING = REGISTRY.register("withering", () -> new WitheringMobEffect());
}
