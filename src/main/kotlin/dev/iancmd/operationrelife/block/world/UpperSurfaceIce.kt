package dev.iancmd.operationrelife.block.world

import net.minecraft.core.BlockPos
import net.minecraft.util.RandomSource
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.MapColor

class UpperSurfaceIce : AbstractIceBlock(Properties.of().mapColor(MapColor.ICE)) {
  override fun getExpDrop(
    state: BlockState,
    level: LevelReader,
    randomSource: RandomSource,
    pos: BlockPos,
    fortuneLevel: Int,
    silkTouchLevel: Int
  ): Int {
    return 100
  }
}
