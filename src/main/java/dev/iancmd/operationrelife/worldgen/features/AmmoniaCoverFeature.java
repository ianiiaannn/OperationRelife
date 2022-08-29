package dev.iancmd.operationrelife.worldgen.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class AmmoniaCoverFeature extends Feature<AmmoniaCoverFeatureConfig> {
  public AmmoniaCoverFeature(Codec<AmmoniaCoverFeatureConfig> p_65786_) {
    super(p_65786_);
  }

  @Override
  public boolean place(FeaturePlaceContext<AmmoniaCoverFeatureConfig> context) {
    WorldGenLevel worldGenLevel = context.level();
    BlockPos blockPos = context.origin();
    worldGenLevel.setBlock(blockPos, Blocks.DIAMOND_BLOCK.defaultBlockState(), 2);

    return true;
  }
}
