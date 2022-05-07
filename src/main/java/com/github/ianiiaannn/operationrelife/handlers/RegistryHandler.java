package com.github.ianiiaannn.operationrelife.handlers;

import com.github.ianiiaannn.operationrelife.blocks.Blocks;
import com.github.ianiiaannn.operationrelife.items.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RegistryHandler {
  private static final IEventBus BUS = FMLJavaModLoadingContext.get().getModEventBus();
  public static void registerAll() {
    Blocks.getRegister().register(RegistryHandler.BUS);
    Items.getRegister().register(RegistryHandler.BUS);
    // Entities.getRegister().register(RegistryHandler.BUS);
  }
}
