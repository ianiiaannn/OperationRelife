package dev.iancmd.operationrelife;


import dev.iancmd.operationrelife.handlers.ModEventHandler;
import dev.iancmd.operationrelife.handlers.RegistryHandler;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(OperationRelife.MODID)
public class OperationRelife {
  public static final String MODID = "operation_relife";
  public static final ResourceKey<Level> TERMINAL_ISLE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("operation_relife", "terminal_isle"));
  public static final Logger logger = LogManager.getLogger(OperationRelife.MODID);

  public OperationRelife() {
    ModEventHandler.registerAll();
    RegistryHandler.registerAll();
  }

  public static Logger getLogger() {
    return logger;
  }
}
