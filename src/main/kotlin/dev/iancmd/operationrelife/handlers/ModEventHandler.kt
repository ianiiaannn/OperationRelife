package dev.iancmd.operationrelife.handlers

import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

class ModEventHandler {


  @SubscribeEvent
  @Suppress("UNUSED_PARAMETER")
  fun onCommonSetup(event: FMLCommonSetupEvent?) {
    ForgeEventHandler.registerEvents()
  }
  companion object {
    private val BUS: IEventBus = FMLJavaModLoadingContext.get().modEventBus
    fun registerAll() {
      BUS.register(ModEventHandler::class.java)
    }
  }
}
