package dev.iancmd.operationrelife.fluid

import dev.iancmd.operationrelife.init.ModBlocks.BlockRegistry.COLD_FLUID_BLOCK
import dev.iancmd.operationrelife.init.ModFluids.FluidRegistry.COLD_FLUID_FLOWING
import dev.iancmd.operationrelife.init.ModFluids.FluidRegistry.COLD_FLUID_SOURCE
import dev.iancmd.operationrelife.init.ModItems.ItemRegistry.COLD_FLUID_BUCKET
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.tags.FluidTags
import net.minecraft.util.RandomSource
import net.minecraft.world.item.Item
import net.minecraft.world.level.*
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.LiquidBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.material.*
import java.util.*

open class ColdFluid: FlowingFluid(){
  override fun getFlowing(): Fluid {
    return Flowing()
  }

  override fun getSource(): Fluid {
    return Source()
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
    return 1
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
    return pDirection == Direction.DOWN && !pFluid.`is`(FluidTags.WATER)
  }

  override fun getExplosionResistance(): Float {
    return 100.0f
  }

  override fun getPickupSound(): Optional<SoundEvent> {
    return Optional.of(SoundEvents.BUCKET_FILL)
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
    override fun createFluidStateDefinition(pBuilder: StateDefinition.Builder<Fluid, FluidState>) {
      super.createFluidStateDefinition(pBuilder)
      pBuilder.add(LEVEL)
    }
    override fun getAmount(pState: FluidState): Int {
      return 8
    }

    override fun isSource(pState: FluidState): Boolean {
      return true
    }
  }
}