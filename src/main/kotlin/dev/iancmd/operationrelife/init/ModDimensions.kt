package dev.iancmd.operationrelife.init

import dev.iancmd.operationrelife.core.OperationRelife
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.dimension.DimensionType
import org.apache.logging.log4j.Level

object ModDimensions {
  val TERMINAL_ISLE_KEY = ResourceKey.create<net.minecraft.world.level.Level>(
    Registries.DIMENSION,
    ResourceLocation(OperationRelife.Companion.MODID, "terminal_isle")
  )
  val TERMINAL_ISLE_TYPE = ResourceKey.create<DimensionType>(
    Registries.DIMENSION_TYPE,
    ResourceLocation(OperationRelife.Companion.MODID, "terminal_isle")
  )

  fun dimensionRegistry() {
    OperationRelife.Companion.getLogger().log(Level.DEBUG, "Registering dimensions...")
  }
}
