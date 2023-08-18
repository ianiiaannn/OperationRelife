package dev.iancmd.operationrelife.fluid

import dev.iancmd.operationrelife.init.ModBlocks.BlockRegistry.COLD_FLUID_BLOCK
import dev.iancmd.operationrelife.init.ModFluids.FluidRegistry.COLD_FLUID_FLOWING
import dev.iancmd.operationrelife.init.ModFluids.FluidRegistry.COLD_FLUID_SOURCE
import dev.iancmd.operationrelife.init.ModFluids.FluidTypeRegistry.COLD_FLUID_TYPE
import dev.iancmd.operationrelife.init.ModItems.ItemRegistry.COLD_FLUID_BUCKET
import net.minecraft.core.BlockPos
import net.minecraft.core.BlockPos.MutableBlockPos
import net.minecraft.core.Direction
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.util.RandomSource
import net.minecraft.world.item.Item
import net.minecraft.world.level.*
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.LiquidBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.material.FlowingFluid
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.FluidState
import net.minecraft.world.phys.Vec3
import net.minecraftforge.fluids.FluidType
import java.util.*

open class ColdFluid: FlowingFluid(){
  val defaultAmount = 8
  override fun getFluidType(): FluidType {
    return COLD_FLUID_TYPE.get()
  }
  override fun getFlowing(): Fluid {
    return COLD_FLUID_FLOWING.get()
  }
  override fun getSource(): Fluid {
    return COLD_FLUID_SOURCE.get()
  }

  override fun getBucket(): Item {
    return COLD_FLUID_BUCKET.get()
  }

  public override fun animateTick(pLevel: Level, pPos: BlockPos, pState: FluidState, pRandom: RandomSource) {
    if (!pState.isSource && !pState.getValue(FALLING)) {
      if (pRandom.nextInt(64) == 0) {
        pLevel.playLocalSound(
          pPos.x.toDouble() + 0.5,
          pPos.y.toDouble() + 0.5,
          pPos.z.toDouble() + 0.5,
          SoundEvents.WATER_AMBIENT,
          SoundSource.BLOCKS,
          pRandom.nextFloat() * 0.25f + 0.75f,
          pRandom.nextFloat() + 0.5f,
          false
        )
      }
    } else if (pRandom.nextInt(10) == 0) {
      pLevel.addParticle(
        ParticleTypes.UNDERWATER,
        pPos.x.toDouble() + pRandom.nextDouble(),
        pPos.y.toDouble() + pRandom.nextDouble(),
        pPos.z.toDouble() + pRandom.nextDouble(),
        0.0,
        0.0,
        0.0
      )
    }
  }

  public override fun getDripParticle(): ParticleOptions? {
    return ParticleTypes.DRIPPING_WATER
  }
  override fun canConvertToSource(pLevel: Level): Boolean {
    return pLevel.gameRules.getBoolean(GameRules.RULE_WATER_SOURCE_CONVERSION)
  }

  override fun beforeDestroyingBlock(pLevel: LevelAccessor, pPos: BlockPos, pState: BlockState) {
    val blockentity = if (pState.hasBlockEntity()) pLevel.getBlockEntity(pPos) else null
    Block.dropResources(pState, pLevel, pPos, blockentity)
  }

  public override fun getSlopeFindDistance(pLevel: LevelReader): Int {
    return 4
  }

  public override fun createLegacyBlock(pState: FluidState): BlockState {
    return COLD_FLUID_BLOCK.get().defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(pState))
  }

  override fun isSource(pState: FluidState): Boolean {
    return false
  }

  override fun getAmount(pState: FluidState): Int {
    return 8
  }

  override fun isSame(pFluid: Fluid): Boolean {
    return pFluid === COLD_FLUID_SOURCE.get() || pFluid === COLD_FLUID_FLOWING.get()
  }

  public override fun getDropOff(pLevel: LevelReader): Int {
    return 1
  }

  override fun getTickDelay(pLevel: LevelReader): Int {
    return 5
  }

  public override fun canBeReplacedWith(
    pFluidState: FluidState,
    pBlockReader: BlockGetter,
    pPos: BlockPos,
    pFluid: Fluid,
    pDirection: Direction
  ): Boolean {
    return true
  }

  override fun getExplosionResistance(): Float {
    return 0.1f
  }

  override fun getPickupSound(): Optional<SoundEvent> {
    return Optional.of(SoundEvents.BUCKET_FILL)
  }

  override fun getFlow(pBlockReader: BlockGetter, pPos: BlockPos?, pFluidState: FluidState): Vec3 {
    var d0 = 0.0
    var d1 = 0.0
    val `blockpos$mutableblockpos` = MutableBlockPos()
    for (direction in Direction.Plane.HORIZONTAL) {
      `blockpos$mutableblockpos`.setWithOffset(pPos, direction)
      val fluidstate = pBlockReader.getFluidState(`blockpos$mutableblockpos`)
      if (affectsFlow(fluidstate)) {
        var f = fluidstate.ownHeight
        var f1 = 0.0f
        if (f == 0.0f) {
          if (!pBlockReader.getBlockState(`blockpos$mutableblockpos`).blocksMotion()) {
            val blockpos = `blockpos$mutableblockpos`.below()
            val fluidstate1 = pBlockReader.getFluidState(blockpos)
            if (affectsFlow(fluidstate1)) {
              f = fluidstate1.ownHeight
              if (f > 0.0f) {
                f1 = pFluidState.ownHeight - (f - 0.8888889f)
              }
            }
          }
        } else if (f > 0.0f) {
          f1 = pFluidState.ownHeight - f
        }
        if (f1 != 0.0f) {
          d0 += (direction.stepX.toFloat() * f1).toDouble()
          d1 += (direction.stepZ.toFloat() * f1).toDouble()
        }
      }
    }
    var vec3 = Vec3(d0, 0.0, d1)
    if (pFluidState.getValue(FALLING)) {
      for (direction1 in Direction.Plane.HORIZONTAL) {
        if (pPos != null) {
          `blockpos$mutableblockpos`.setWithOffset(pPos, direction1)
        }
        if (isSolidFace(pBlockReader, `blockpos$mutableblockpos`, direction1) || isSolidFace(
            pBlockReader,
            `blockpos$mutableblockpos`.below(),
            direction1
          )
        ) {
          vec3 = vec3.normalize().add(0.0, -6.0, 0.0)
          break
        }
      }
    }
    return vec3.normalize()
  }
  private fun affectsFlow(pState: FluidState): Boolean {
    return pState.isEmpty || pState.type.isSame(this)
  }
  override fun spread(pLevel: Level, pPos: BlockPos, pState: FluidState) {
    if (!pState.isEmpty) {
      val blockstate = pLevel.getBlockState(pPos)
      val blockpos = pPos.above()
      val blockstate1 = pLevel.getBlockState(blockpos)
      val fluidstate = getNewLiquid(pLevel, blockpos, blockstate1)
      if (canSpreadTo(
          pLevel,
          pPos,
          blockstate,
          Direction.UP,
          blockpos,
          blockstate1,
          pLevel.getFluidState(blockpos),
          fluidstate.type
        )
      ) {
        spreadTo(pLevel, blockpos, blockstate1, Direction.UP, fluidstate)
        spreadToSides(pLevel, pPos, pState, blockstate)
      } else if (pState.isSource) {
        spreadToSides(pLevel, pPos, pState, blockstate)
      }
    }
  }
  private fun spreadToSides(pLevel: Level, pPos: BlockPos, pFluidState: FluidState, pBlockState: BlockState) {
    var i = pFluidState.amount - getDropOff(pLevel)
    if (pFluidState.getValue(FALLING)) {
      i = 7
    }
    if (i > 0) {
      val map = getSpread(pLevel, pPos, pBlockState)
      for ((direction, fluidstate) in map) {
        val blockpos = pPos.relative(direction)
        val blockstate = pLevel.getBlockState(blockpos)
        if (canSpreadTo(
            pLevel,
            pPos,
            pBlockState,
            direction,
            blockpos,
            blockstate,
            pLevel.getFluidState(blockpos),
            fluidstate.type
          )
        ) {
          spreadTo(pLevel, blockpos, blockstate, direction, fluidstate)
        }
      }
    }
  }


  class Flowing : ColdFluid() {
    override fun createFluidStateDefinition(pBuilder: StateDefinition.Builder<Fluid, FluidState>) {
      super.createFluidStateDefinition(pBuilder)
      pBuilder.add(LEVEL)
    }

    override fun getAmount(pState: FluidState): Int {
      return pState.getValue(LEVEL)
    }

    override fun isSource(pState: FluidState): Boolean {
      return false
    }
  }
  class Source : ColdFluid() {
    override fun getAmount(pState: FluidState): Int {
      return defaultAmount
    }

    override fun isSource(pState: FluidState): Boolean {
      return true
    }
  }
}