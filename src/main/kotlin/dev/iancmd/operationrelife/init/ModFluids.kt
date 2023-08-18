package dev.iancmd.operationrelife.init

import dev.iancmd.operationrelife.core.OperationRelife
import dev.iancmd.operationrelife.fluid.BasicFluidType
import dev.iancmd.operationrelife.fluid.ColdFluid
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.material.Fluid
import net.minecraftforge.fluids.FluidType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ModFluids {
  fun getFluidRegister(): DeferredRegister<Fluid> {
    return FluidRegistry.REGISTER
  }
  fun getFluidTypeRegister(): DeferredRegister<FluidType> {
    return FluidTypeRegistry.REGISTER
  }
  val WATER_STILL = ResourceLocation("block/water_still")
  val WATER_FLOWING = ResourceLocation("block/water_flow")
  object FluidRegistry {
    private val register: DeferredRegister<Fluid> =
      DeferredRegister.create(ForgeRegistries.FLUIDS, OperationRelife.Companion.MODID)
    val COLD_FLUID_SOURCE: RegistryObject<ColdFluid> = register.register(
      "cold_fluid_source"
    ) {
      ColdFluid.Source()
    }
    val COLD_FLUID_FLOWING: RegistryObject<ColdFluid> = register.register(
      "cold_fluid_flowing"
    ) {
      ColdFluid.Flowing()
    }
    val REGISTER: DeferredRegister<Fluid>
      get() = register
  }
  object FluidTypeRegistry {
    private val register: DeferredRegister<FluidType> =
      DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, OperationRelife.Companion.MODID)
    val COLD_FLUID_TYPE: RegistryObject<FluidType> = register.register("cold_fluid_type") {
      BasicFluidType(
        WATER_STILL,
        WATER_FLOWING,
        FluidType.Properties.create().temperature(1)
      )
    }
    val REGISTER: DeferredRegister<FluidType>
      get() = register
  }
}
