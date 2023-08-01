package dev.iancmd.operationrelife.blocks

import dev.iancmd.operationrelife.core.OperationRelife
import net.minecraft.core.BlockPos
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.util.Mth
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.DragonEggBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.border.WorldBorder
import net.minecraft.world.level.material.MapColor
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.shapes.VoxelShape

class DragonEgg :
  DragonEggBlock(
    Properties.of().mapColor(MapColor.PLANT).strength(3.0f, 9.0f).lightLevel { 1 }
      .noOcclusion()
  ) {
  override fun use(
    p_52923_: BlockState,
    p_52924_: Level,
    p_52925_: BlockPos,
    p_52926_: Player,
    p_52927_: InteractionHand,
    p_52928_: BlockHitResult
  ): InteractionResult {
    teleport(p_52923_, p_52924_, p_52925_)
    return InteractionResult.sidedSuccess(p_52924_.isClientSide)
  }

  override fun attack(blockState: BlockState, level: Level, blockPos: BlockPos, player: Player) {
    teleport(blockState, level, blockPos)
  }

  private fun teleport(blockState: BlockState, level: Level, blockPos: BlockPos) {
    OperationRelife.Companion.getLogger().log(org.apache.logging.log4j.Level.DEBUG, level.getBlockState(blockPos))
    val worldborder: WorldBorder = level.worldBorder
    @Suppress("UNUSED_VARIABLE")
    for (i in 0..999) {
      val blockpos: BlockPos = blockPos.offset(
        level.random.nextInt(16) - level.random.nextInt(16),
        level.random.nextInt(8) - level.random.nextInt(8),
        level.random.nextInt(16) - level.random.nextInt(16)
      )
      if (level.getBlockState(blockpos).isAir && worldborder.isWithinBounds(blockpos)) {
        @Suppress("UNUSED_VARIABLE")
        if (level.isClientSide) {
          for (j in 0..127) {
            val d0 = level.random.nextDouble()
            val f = (level.random.nextFloat() - 0.5f) * 0.2f
            val f1 = (level.random.nextFloat() - 0.5f) * 0.2f
            val f2 = (level.random.nextFloat() - 0.5f) * 0.2f
            val d1: Double = Mth.lerp(
              d0,
              blockpos.x.toDouble(),
              blockPos.x.toDouble()
            ) + (level.random.nextDouble() - 0.5) + 0.5
            val d2: Double =
              Mth.lerp(d0, blockpos.y.toDouble(), blockPos.y.toDouble()) + level.random.nextDouble() - 0.5
            val d3: Double = Mth.lerp(
              d0,
              blockpos.z.toDouble(),
              blockPos.z.toDouble()
            ) + (level.random.nextDouble() - 0.5) + 0.5
            level.addParticle(ParticleTypes.PORTAL, d1, d2, d3, f.toDouble(), f1.toDouble(), f2.toDouble())
          }
        } else {
          level.setBlock(blockpos, blockState, 2)
          level.removeBlock(blockPos, false)
        }
        return
      }
    }
  }

  companion object {
    protected val SHAPE: VoxelShape = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0)
  }
}
