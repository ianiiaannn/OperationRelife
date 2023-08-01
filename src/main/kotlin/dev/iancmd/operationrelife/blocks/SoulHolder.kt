package dev.iancmd.operationrelife.blocks

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.HorizontalDirectionalBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BooleanProperty
import net.minecraft.world.level.block.state.properties.DirectionProperty
import net.minecraft.world.level.material.MapColor
import net.minecraftforge.common.extensions.IForgeBlock

open class SoulHolder : Block(Properties.of().mapColor(MapColor.METAL)),
  IForgeBlock {
  init {
    registerDefaultState(
      stateDefinition.any()
        .setValue(FACING, Direction.NORTH)
        .setValue(SOUL, false)
    )
  }

  override fun getStateForPlacement(context: BlockPlaceContext): BlockState? {
    return defaultBlockState().setValue(FACING, context.horizontalDirection.opposite)
  }

  override fun createBlockStateDefinition(blockStateBuilder: StateDefinition.Builder<Block, BlockState>) {
    blockStateBuilder.add(FACING, SOUL)
  }

  override fun propagatesSkylightDown(blockState: BlockState, blockGetter: BlockGetter, blockPos: BlockPos): Boolean {
    return true
  }

  companion object {
    val FACING: DirectionProperty = HorizontalDirectionalBlock.FACING
    val SOUL: BooleanProperty = BooleanProperty.create("soul")
  }
}
