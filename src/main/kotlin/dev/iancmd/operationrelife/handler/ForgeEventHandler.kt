package dev.iancmd.operationrelife.handler

import dev.iancmd.operationrelife.core.OperationRelife.Companion.getLogger
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.Level.DEBUG
import thedarkcolour.kotlinforforge.forge.FORGE_BUS

class ForgeEventHandler {
  @SubscribeEvent
  fun onChangeDimension(event: PlayerEvent.PlayerChangedDimensionEvent) {
    getLogger().log(DEBUG, "Player ${event.entity.name} changed dimension from ${event.from} to ${event.to}")
  }

  companion object {
    fun registerAll() {
      getLogger().log(Level.DEBUG, "Registering forge event handler...")
      FORGE_BUS.register(ForgeEventHandler())
    }
  }
}
