package dev.iancmd.operationrelife;


import dev.iancmd.operationrelife.handlers.ModEventHandler;
import dev.iancmd.operationrelife.handlers.RegistryHandler;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


@Mod(OperationRelife.MODID)
public class OperationRelife {
  public static final String MODID="operation_relife";
  public static final ResourceKey<Level> TEST_DIM_KEY=ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("operation_relife", "terminal_isle"));

  public static final Logger logger = LogManager.getLogger(OperationRelife.MODID);

  public OperationRelife(){
    ModEventHandler.registerAll();
    RegistryHandler.registerAll();
  }
}
