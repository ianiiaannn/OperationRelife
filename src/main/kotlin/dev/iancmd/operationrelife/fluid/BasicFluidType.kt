package dev.iancmd.operationrelife.fluid

import net.minecraft.resources.ResourceLocation
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions
import net.minecraftforge.fluids.FluidType
import java.util.function.Consumer


/**
 * Basic implementation of [FluidType] that supports specifying still and flowing textures in the constructor.
 *
 * @author Choonster
 */
class BasicFluidType(
  val stillTextureA: ResourceLocation,
  val flowingTextureA: ResourceLocation,
  properties: Properties
) :
  FluidType(properties) {
  override fun initializeClient(consumer: Consumer<IClientFluidTypeExtensions>) {
    consumer.accept(object : IClientFluidTypeExtensions {
      override fun getStillTexture(): ResourceLocation {
        return stillTextureA
      }

      override fun getFlowingTexture(): ResourceLocation {
        return flowingTextureA
      }
    })
  }
}
