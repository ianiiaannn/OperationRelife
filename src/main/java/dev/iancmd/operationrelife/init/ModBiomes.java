package dev.iancmd.operationrelife.init;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Optional;

import static dev.iancmd.operationrelife.core.OperationRelife.MODID;
import static dev.iancmd.operationrelife.worldgen.biomes.PlaceHolderBiome.placeHolderBiome;

public class ModBiomes {
  static HolderGetter<PlacedFeature> placedFeatureHolderGetter = new HolderGetter<PlacedFeature>() {
    @Override
    public Optional<Holder.Reference<PlacedFeature>> get(ResourceKey<PlacedFeature> p_255645_) {
      return Optional.empty();
    }
    @Override
    public Optional<HolderSet.Named<PlacedFeature>> get(TagKey<PlacedFeature> p_256283_) {
      return Optional.empty();
    }
  };
  static HolderGetter<ConfiguredWorldCarver<?>> carverHolderGetter = new HolderGetter<ConfiguredWorldCarver<?>>() {
    @Override
    public Optional<Holder.Reference<ConfiguredWorldCarver<?>>> get(ResourceKey<ConfiguredWorldCarver<?>> p_255645_) {
      return Optional.empty();
    }
    @Override
    public Optional<HolderSet.Named<ConfiguredWorldCarver<?>>> get(TagKey<ConfiguredWorldCarver<?>> p_256283_) {
      return Optional.empty();
    }
  };
  public static DeferredRegister<Biome> getRegister() {
    return BiomesRegistry.REGISTER;
  }
  public static void registerKey() {
    ResourceKey<Biome> PLACEHOLDER_BIOME_RESOURCEKEY = ResourceKey.create(ForgeRegistries.Keys.BIOMES, new ResourceLocation(MODID, "placeholder_biome"));
  }
  public static class BiomesRegistry {
    public static final DeferredRegister<Biome> REGISTER = DeferredRegister.create(ForgeRegistries.BIOMES, MODID);
    public static final RegistryObject<Biome> PLACEHOLDER_BIOME = REGISTER.register("placeholder_biome", () -> placeHolderBiome(placedFeatureHolderGetter, carverHolderGetter));
  }
}
