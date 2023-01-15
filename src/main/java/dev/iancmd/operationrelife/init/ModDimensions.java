package dev.iancmd.operationrelife.init;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

import static dev.iancmd.operationrelife.core.OperationRelife.MODID;
import static dev.iancmd.operationrelife.core.OperationRelife.getLogger;
import static net.minecraft.core.registries.Registries.DIMENSION;
import static net.minecraft.core.registries.Registries.DIMENSION_TYPE;
import static org.apache.logging.log4j.Level.DEBUG;

public class ModDimensions {
  public static final ResourceKey<Level> TERMINAL_ISLE_KEY = ResourceKey.create(DIMENSION, new ResourceLocation(MODID, "terminal_isle"));
  public static final ResourceKey<DimensionType> TERMINAL_ISLE_TYPE = ResourceKey.create(DIMENSION_TYPE, new ResourceLocation(MODID, "terminal_isle"));
  public static void DimensionRegistry() {
    getLogger().log(DEBUG, "Registering dimensions...");
  }
}
