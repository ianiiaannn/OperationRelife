package dev.iancmd.operationrelife.worldgen.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DiamondBlockFeature extends Feature<NoneFeatureConfiguration> {
  public DiamondBlockFeature(Codec<NoneFeatureConfiguration> configurationCodec) {
    super(configurationCodec);
  }

  public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
    BlockPos blockpos = featurePlaceContext.origin();
    WorldGenLevel worldgenlevel = featurePlaceContext.level();
    RandomSource randomSource = featurePlaceContext.random();
    worldgenlevel.setBlock(blockpos, Blocks.DIAMOND_ORE.defaultBlockState(), 2);
    return true;
  }
}

