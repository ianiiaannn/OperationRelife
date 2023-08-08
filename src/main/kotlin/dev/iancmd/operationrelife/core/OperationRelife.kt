package dev.iancmd.operationrelife.core

import dev.iancmd.operationrelife.handler.ModEventHandler
import dev.iancmd.operationrelife.handler.RegistryHandler
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger


@Mod(OperationRelife.Companion.MODID)
class OperationRelife {
  init {
    ModEventHandler.registerAll()
    RegistryHandler.registerAll()
  }
  object Companion {
    const val MODID = "operation_relife"
    private val LOGGER: Logger = LogManager.getLogger(MODID)
    fun getLogger(): Logger {
      return LOGGER
    }
  }
}
