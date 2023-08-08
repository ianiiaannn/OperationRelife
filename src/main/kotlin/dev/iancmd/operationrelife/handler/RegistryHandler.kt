package dev.iancmd.operationrelife.handler

import dev.iancmd.operationrelife.core.OperationRelife
import dev.iancmd.operationrelife.init.ModBlocks
import dev.iancmd.operationrelife.init.ModDimensions
import dev.iancmd.operationrelife.init.ModFluids
import dev.iancmd.operationrelife.init.ModItems
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import thedarkcolour.kotlinforforge.forge.MOD_CONTEXT

@EventBusSubscriber(modid = OperationRelife.Companion.MODID)
object RegistryHandler {

  private val BUS = MOD_CONTEXT.getKEventBus()
  fun registerAll() {
    ModBlocks.getRegister().register(BUS)
    ModBlocks.getOverrideRegister().register(BUS)
    ModItems.getRegister().register(BUS)
    ModFluids.getFluidRegister().register(BUS)
    ModFluids.getFluidTypeRegister().register(BUS)
    ModDimensions.dimensionRegistry()
  }
}
