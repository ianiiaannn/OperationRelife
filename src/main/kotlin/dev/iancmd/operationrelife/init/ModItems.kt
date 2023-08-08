package dev.iancmd.operationrelife.init

import dev.iancmd.operationrelife.core.OperationRelife
import dev.iancmd.operationrelife.init.ModBlocks.BlockRegistry
import dev.iancmd.operationrelife.init.ModItems.ItemRegistry.REGISTER
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.BucketItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Rarity
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ModItems {
  fun getRegister(): DeferredRegister<Item> {
    return REGISTER
  }

  object ItemRegistry {
    private val register: DeferredRegister<Item> =
      DeferredRegister.create(ForgeRegistries.ITEMS, OperationRelife.Companion.MODID)
    val REGISTER: DeferredRegister<Item>
      get() = register

    val RED_SOUL_HOLDER: RegistryObject<Item> = register.register<Item>("red_soul_holder") {
      BlockItem(
        BlockRegistry.RED_SOUL_HOLDER.get(), Item.Properties().rarity(
          Rarity.COMMON
        )
      )
    }
    val BLUE_SOUL_HOLDER: RegistryObject<Item> = register.register<Item>("blue_soul_holder") {
      BlockItem(
        BlockRegistry.BLUE_SOUL_HOLDER.get(), Item.Properties().rarity(
          Rarity.COMMON
        )
      )
    }
    val UPPER_SURFACE_ICE: RegistryObject<Item> = register.register<Item>("upper_surface_ice") {
      BlockItem(
        BlockRegistry.UPPER_SURFACE_ICE.get(), Item.Properties().rarity(
          Rarity.COMMON
        )
      )
    }
    val COLD_FLUID_BUCKET: RegistryObject<Item> = register.register<Item>("cold_fluid_bucket") {
      BucketItem(
        ModFluids.FluidRegistry.COLD_FLUID_SOURCE, Item.Properties()
      )
    }
  }
}
