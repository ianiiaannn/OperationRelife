package com.github.ianiiaannn.operationalrelife.handlers;

import com.github.ianiiaannn.operationalrelife.Block.Blocks;
import com.github.ianiiaannn.operationalrelife.Item.Items;
import net.minecraft.world.level.block.Block;
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
