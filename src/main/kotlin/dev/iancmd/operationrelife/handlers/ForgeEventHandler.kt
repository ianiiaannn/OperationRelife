package dev.iancmd.operationrelife.handlers

import dev.iancmd.operationrelife.core.OperationRelife
import dev.iancmd.operationrelife.init.ModItems
import net.minecraft.world.item.CreativeModeTabs
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent

class ForgeEventHandler {
  @SubscribeEvent
  fun onRegisterCreativeModeTabs(event: BuildCreativeModeTabContentsEvent) {
    OperationRelife.Companion.getLogger().log(org.apache.logging.log4j.Level.DEBUG, "Registering creative mode tabs...")
    if (event.tabKey == CreativeModeTabs.BUILDING_BLOCKS) {
      event.accept(ModItems.ItemRegistry.BLUE_SOUL_HOLDER.get())
      event.accept(ModItems.ItemRegistry.RED_SOUL_HOLDER.get())
    }
  }

  companion object {
    private val BUS: IEventBus = MinecraftForge.EVENT_BUS
    fun registerEvents() {
      BUS.register(ForgeEventHandler())
    }

    @SubscribeEvent
    fun onChangeDimension(event: PlayerEvent.PlayerChangedDimensionEvent) {
      println(event.entity.getDimensions(event.entity.pose))
    }

  }
}
