package dev.iancmd.operationrelife.core;

import dev.iancmd.operationrelife.handlers.ModEventHandler;
import dev.iancmd.operationrelife.handlers.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(OperationRelife.MODID)
public class OperationRelife {
  public static final String MODID = "operation_relife";
  // public static final ResourceKey<Level> TERMINAL_ISLE = ResourceKey.create(ForgeRegistries.Keys., new ResourceLocation(MODID, "terminal_isle"));
  // public static final ResourceKey<Biome> PLACEHOLDER_BIOME = ResourceKey.create(ForgeRegistries.Keys.BIOMES, new ResourceLocation(MODID, "placeholder_biome"));
  private static final Logger logger = LogManager.getLogger(OperationRelife.class);
  public OperationRelife() {
    ModEventHandler.registerAll();
    RegistryHandler.registerAll();
  }
  public static Logger getLogger() {
    return logger;
  }
}
