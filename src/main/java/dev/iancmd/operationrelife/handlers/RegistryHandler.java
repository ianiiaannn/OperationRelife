package dev.iancmd.operationrelife.handlers;

import dev.iancmd.operationrelife.blocks.Blocks;
import dev.iancmd.operationrelife.items.Items;
import dev.iancmd.operationrelife.worldgen.biomes.Biomes;
import dev.iancmd.operationrelife.worldgen.features.Features;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static dev.iancmd.operationrelife.OperationRelife.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class RegistryHandler {
  private static final IEventBus BUS = FMLJavaModLoadingContext.get().getModEventBus();

  public static void registerAll() {
    Blocks.getRegister().register(RegistryHandler.BUS);
    Blocks.getOverrideRegister().register(RegistryHandler.BUS);
    Items.getRegister().register(RegistryHandler.BUS);
    Features.getFeatureRegister().register(RegistryHandler.BUS);
    Features.getPlacedRegister().register(RegistryHandler.BUS);
    Biomes.getRegister().register(RegistryHandler.BUS);
    // Entities.getRegister().register(RegistryHandler.BUS);
  }
}
