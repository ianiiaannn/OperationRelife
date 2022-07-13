package dev.iancmd.operationrelife.worldgen;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockPileConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static dev.iancmd.operationrelife.OperationRelife.MODID;

@ObjectHolder(MODID)

public class ModFeature {
  public static DeferredRegister<ConfiguredFeature<?, ?>> getFeatureRegister() {
    return FeatureRegister.CONFIGURED_FEATURES;
  }

  public static DeferredRegister<PlacedFeature> getPlacedRegister() {
    return FeatureRegister.PLACED_FEATURES;
  }


  public static class FeatureRegister {
    private static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, MODID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MODID);
    public static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_SOME_DIAMOND_ORE = CONFIGURED_FEATURES.register("some_diamond_ore", () -> new ConfiguredFeature<>(Feature.BLOCK_PILE, new BlockPileConfiguration(BlockStateProvider.simple(Blocks.TNT))));
    private static final RegistryObject<PlacedFeature> PLACED_TNT_PILE =
            PLACED_FEATURES.register("some_diamond_ore",
                    () -> new PlacedFeature(CONFIGURED_SOME_DIAMOND_ORE.getHolder().get(),
                            List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP)));
  }
}
