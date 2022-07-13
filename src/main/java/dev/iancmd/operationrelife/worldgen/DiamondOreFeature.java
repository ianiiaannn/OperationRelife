package dev.iancmd.operationrelife.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class DiamondOreFeature extends Feature<NoneFeatureConfiguration> {
  public DiamondOreFeature(Codec<NoneFeatureConfiguration> configurationCodec) {
    super(configurationCodec);
  }

  public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
    BlockPos blockpos = featurePlaceContext.origin();
    WorldGenLevel worldgenlevel = featurePlaceContext.level();
    Random random = featurePlaceContext.random();
    worldgenlevel.setBlock(blockpos, Blocks.DIAMOND_ORE.defaultBlockState(), 2);

    for (int i = 0; i < 200; ++i) {
      int j = random.nextInt(5) - random.nextInt(6);
      int k = 3;
      if (j < 2) {
        k += j / 2;
      }

      if (k >= 1) {
        BlockPos blockpos1 = blockpos.offset(random.nextInt(k) - random.nextInt(k), j, random.nextInt(k) - random.nextInt(k));
        BlockState blockstate = worldgenlevel.getBlockState(blockpos1);
        if (blockstate.getMaterial() == Material.AIR || blockstate.is(Blocks.WATER) || blockstate.is(Blocks.PACKED_ICE) || blockstate.is(Blocks.ICE)) {
          for (Direction direction1 : Direction.values()) {
            BlockState blockstate1 = worldgenlevel.getBlockState(blockpos1.relative(direction1));
            if (blockstate1.is(Blocks.DIAMOND_ORE)) {
              worldgenlevel.setBlock(blockpos1, Blocks.DIAMOND_ORE.defaultBlockState(), 2);
              break;
            }
          }
        }
      }
    }
    return true;
  }
}

