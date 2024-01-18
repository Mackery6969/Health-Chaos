package net.mcreator.healthchaos.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class TimeConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> EFFECT_TICKS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SAFETY_NET;
	static {
		BUILDER.push("Gameplay");
		EFFECT_TICKS = BUILDER.comment("The amount of ticks the base event will take").define("Effect Ticks", (double) 12000);
		SAFETY_NET = BUILDER.comment("Prevents the health from hitting 0 and breaking the world").define("Safety Net", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
