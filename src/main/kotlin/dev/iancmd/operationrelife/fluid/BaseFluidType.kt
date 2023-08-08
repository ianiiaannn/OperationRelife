package dev.iancmd.operationrelife.fluid

import com.mojang.blaze3d.shaders.FogShape
import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.Camera
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.renderer.FogRenderer.FogMode
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.material.FlowingFluid
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions
import net.minecraftforge.fluids.FluidType
import net.minecraftforge.registries.RegistryObject
import org.jetbrains.annotations.NotNull
import org.joml.Vector3f
import java.util.function.Consumer

class BaseFluidType(
  COLD_FLUID_SOURCE: RegistryObject<FlowingFluid>,
  COLD_FLUID_FLOWING: RegistryObject<FlowingFluid>,
  COLD_FLUID_OVERLAY: ResourceLocation,
  l: Long,
  vector3f: Vector3f
) : FluidType(Properties.create().lightLevel(5)) {
  private var stillTexture: ResourceLocation? = null
  private var flowingTexture: ResourceLocation? = null
  private var overlayTexture: ResourceLocation? = null
  private var tintColor = 0
  private var fogColor: Vector3f? = null
  fun getStillTexture(): ResourceLocation {
    return stillTexture!!
  }

  fun getFlowingTexture(): ResourceLocation {
    return flowingTexture!!
  }

  fun getTintColor(): Int {
    return tintColor
  }

  fun getOverlayTexture(): ResourceLocation {
    return overlayTexture!!
  }

  fun getFogColor(): Vector3f {
    return fogColor!!
  }
  override fun initializeClient(consumer: Consumer<IClientFluidTypeExtensions?>) {
    consumer.accept(object : IClientFluidTypeExtensions {
      @NotNull
      override fun modifyFogColor(
        camera: Camera, partialTick: Float, level: ClientLevel,
        renderDistance: Int, darkenWorldAmount: Float, fluidFogColor: Vector3f
      ): Vector3f {
        return fogColor!!
      }

      override fun modifyFogRender(
        camera: Camera, mode: FogMode, renderDistance: Float, partialTick: Float,
        nearDistance: Float, farDistance: Float, shape: FogShape
      ) {
        RenderSystem.setShaderFogStart(1f)
        RenderSystem.setShaderFogEnd(6f)
      }
    })
  }
}

