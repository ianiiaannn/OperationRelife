package dev.iancmd.operationrelife.worldgen.dimensions;

import dev.iancmd.operationrelife.OperationRelife;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class Dimensions {
  public static final ResourceKey<Level> AFTER_LIFE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(OperationRelife.MODID, "after_life"));
}
