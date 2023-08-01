package dev.iancmd.operationrelife.init

import dev.iancmd.operationrelife.blocks.BlueSoulHolder
import dev.iancmd.operationrelife.blocks.DragonEgg
import dev.iancmd.operationrelife.blocks.RedSoulHolder
import dev.iancmd.operationrelife.blocks.world.UpperSurfaceIce
import dev.iancmd.operationrelife.core.OperationRelife
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ModBlocks {
  fun getRegister(): DeferredRegister<Block> {
    return BlockRegistry.REGISTER
  }

  fun getOverrideRegister(): DeferredRegister<Block> {
    return BlockRegistry.OVERRIDE_REGISTER
  }


  object BlockRegistry {
    private val register: DeferredRegister<Block> =
      DeferredRegister.create(ForgeRegistries.BLOCKS, OperationRelife.Companion.MODID)
    val REGISTER: DeferredRegister<Block>
      get() = register

    val OVERRIDE_REGISTER: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft")

    val RED_SOUL_HOLDER: RegistryObject<RedSoulHolder> = register.register("red_soul_holder") { RedSoulHolder() }
    val BLUE_SOUL_HOLDER: RegistryObject<BlueSoulHolder> = register.register("blue_soul_holder") { BlueSoulHolder() }
    val UPPER_SURFACE_ICE: RegistryObject<UpperSurfaceIce> =
      register.register("upper_surface_ice") { UpperSurfaceIce() }

    // Override blocks
    val DRAGON_EGG = OVERRIDE_REGISTER.register("dragon_egg") { DragonEgg() }
  }
}
