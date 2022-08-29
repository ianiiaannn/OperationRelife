package dev.iancmd.operationrelife.worldgen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record DiamondBlockFeatureConfig(int size) implements FeatureConfiguration {
  public static final Codec<DiamondBlockFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> {
    return return instance.group(BlockStateProvider.CODEC.fieldOf("size").forGetter(DiamondBlockFeatureConfig::size);
  });
}
