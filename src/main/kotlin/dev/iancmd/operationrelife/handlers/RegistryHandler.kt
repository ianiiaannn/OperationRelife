package dev.iancmd.operationrelife.handlers

import dev.iancmd.operationrelife.core.OperationRelife
import dev.iancmd.operationrelife.init.ModBlocks
import dev.iancmd.operationrelife.init.ModDimensions
import dev.iancmd.operationrelife.init.ModItems
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@EventBusSubscriber(modid = OperationRelife.Companion.MODID)
object RegistryHandler {

  private val BUS = FMLJavaModLoadingContext.get().modEventBus
  fun registerAll() {
    ModBlocks.getRegister().register(BUS)
    ModBlocks.getOverrideRegister().register(BUS)
    ModItems.getRegister().register(BUS)
    ModDimensions.dimensionRegistry()
    // Entities.getRegister().register(RegistryHandler.BUS);
  }
}
