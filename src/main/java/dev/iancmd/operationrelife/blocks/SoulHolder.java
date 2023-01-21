package dev.iancmd.operationrelife.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.extensions.IForgeBlock;
import org.jetbrains.annotations.NotNull;

public class SoulHolder extends Block implements IForgeBlock {
  public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
  public static final BooleanProperty SOUL = BooleanProperty.create("soul");
  public SoulHolder(Properties of) {
    super(BlockBehaviour.Properties.of(Material.METAL));
    this.registerDefaultState(this.stateDefinition.any()
              .setValue(FACING, Direction.NORTH)
              .setValue(SOUL, false)
    );
  }
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
  }
  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
    blockStateBuilder.add(FACING, SOUL);
  }
  @Override
  public boolean propagatesSkylightDown(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
    return true;
  }
}
