package dev.iancmd.operationrelife.handlers;

import dev.iancmd.operationrelife.init.ModBlocks;
import dev.iancmd.operationrelife.init.ModDimensions;
import dev.iancmd.operationrelife.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static dev.iancmd.operationrelife.core.OperationRelife.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class RegistryHandler {
  private static final IEventBus BUS = FMLJavaModLoadingContext.get().getModEventBus();
  public static void registerAll() {
    ModBlocks.getRegister().register(RegistryHandler.BUS);
    ModBlocks.getOverrideRegister().register(RegistryHandler.BUS);
    ModItems.getRegister().register(RegistryHandler.BUS);
    ModDimensions.DimensionRegistry();
    // Entities.getRegister().register(RegistryHandler.BUS);
  }
}
