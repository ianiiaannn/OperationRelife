package dev.iancmd.operationrelife.handlers;

import dev.iancmd.operationrelife.blocks.Blocks;
import dev.iancmd.operationrelife.items.Items;
import dev.iancmd.operationrelife.worldgen.ModFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RegistryHandler {
  private static final IEventBus BUS = FMLJavaModLoadingContext.get().getModEventBus();

  public static void registerAll() {
    Blocks.getRegister().register(RegistryHandler.BUS);
    Blocks.getOverrideRegister().register(RegistryHandler.BUS);
    Items.getRegister().register(RegistryHandler.BUS);
    ModFeature.getFeatureRegister().register(RegistryHandler.BUS);
    ModFeature.getPlacedRegister().register(RegistryHandler.BUS);
    // Entities.getRegister().register(RegistryHandler.BUS);
  }
}
