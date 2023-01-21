package dev.iancmd.operationrelife.blocks.world;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class UpperSurfaceIce extends AbstractIceBlock {
  public UpperSurfaceIce() {
    super(Properties.of(Material.STONE));
  }
  @Override
  public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
    return 100;
  }
}
