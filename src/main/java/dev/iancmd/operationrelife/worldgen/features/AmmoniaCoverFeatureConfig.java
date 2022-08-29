package dev.iancmd.operationrelife.worldgen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

// https://github.com/devs-immortal/Paradise-Lost/blob/a7c7cebc770be2ca0e9ba1b2113686df67916fea/src/main/java/net/id/aether/world/feature/configs/ProjectedOrganicCoverConfig.java
public record AmmoniaCoverFeatureConfig(BlockStateProvider cover, IntProvider branchLength, IntProvider projection,
                                        IntProvider tries, double heuristic) implements FeatureConfiguration {
  public static final Codec<AmmoniaCoverFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> {
    return instance.group(BlockStateProvider.CODEC.fieldOf("cover").forGetter(AmmoniaCoverFeatureConfig::cover),
            IntProvider.CODEC.fieldOf("branchLength").forGetter(AmmoniaCoverFeatureConfig::branchLength),
            IntProvider.CODEC.fieldOf("projection").forGetter(AmmoniaCoverFeatureConfig::projection),
            IntProvider.CODEC.fieldOf("tries").forGetter(AmmoniaCoverFeatureConfig::tries),
            Codec.DOUBLE.fieldOf("heuristic").forGetter(AmmoniaCoverFeatureConfig::heuristic)).apply(instance, AmmoniaCoverFeatureConfig::new);
  });
}