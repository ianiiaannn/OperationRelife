package dev.iancmd.operationrelife.handler

import dev.iancmd.operationrelife.core.OperationRelife.Companion.getLogger
import dev.iancmd.operationrelife.init.ModItems
import net.minecraft.world.item.CreativeModeTabs
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.Level.DEBUG
import thedarkcolour.kotlinforforge.forge.MOD_BUS

class ModEventHandler {
  @SubscribeEvent
  fun onRegisterCreativeModeTabs(event: BuildCreativeModeTabContentsEvent) {
    getLogger().log(DEBUG, "Registering creative mode tabs...")
    if (event.tabKey === CreativeModeTabs.FUNCTIONAL_BLOCKS) {
      event.accept(ModItems.ItemRegistry.BLUE_SOUL_HOLDER)
      event.accept(ModItems.ItemRegistry.RED_SOUL_HOLDER)
    }
  }
  @SubscribeEvent
  @Suppress("UNUSED_PARAMETER")
  fun onClientSetup(event: FMLClientSetupEvent) {
    ForgeEventHandler.registerAll()
  }
  companion object {
    fun registerAll() {
      getLogger().log(DEBUG, "Registering mod event handler...")
      MOD_BUS.register(ModEventHandler())
    }
  }
}
