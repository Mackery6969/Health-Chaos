package net.mcreator.healthchaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.healthchaos.network.HealthChaosModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetTicksProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		HealthChaosModVariables.MapVariables.get(world).remaining_ticks = DoubleArgumentType.getDouble(arguments, "ticks");
		HealthChaosModVariables.MapVariables.get(world).syncData(world);
	}
}
