package dev.iancmd.operationrelife.worldgen.biomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PlaceHolderBiome extends Biomes {
  // https://github.com/DenisMasterHerobrine/MagicalForest
  private static int getSkyColorWithTemperatureModifier(float temperature) {
    float f = temperature / 3.0F;
    f = Mth.clamp(f, -1.0F, 1.0F);
    return Mth.hsvToRgb(0.6325F - f * 0.1F, 0.44F + f * 0.11F, 1F);
  }
  private static Biome biome(Biome.Precipitation precipitation, float temperature, float downfall, int waterColor, int waterFogColor, int grassColor, int foliageColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
    return (new Biome.BiomeBuilder())
              .precipitation(precipitation)
              .temperature(temperature)
              .downfall(downfall)
              .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(waterColor)
                        .waterFogColor(waterFogColor)
                        .fogColor(12638463)
                        .skyColor(getSkyColorWithTemperatureModifier(temperature))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .foliageColorOverride(foliageColor)
                        .grassColorOverride(grassColor)
                        .build())
              .mobSpawnSettings(spawnBuilder.build())
              .generationSettings(biomeBuilder.build())
              .build();
  }
  public static Biome placeHolderBiome(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> holderGetter) {
    MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
    BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, holderGetter);
    spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.END_CRYSTAL, 10, 8, 8));
    return biome(Biome.Precipitation.RAIN, 0.5F, 0.5F, 0x3F76E4, 0x50533, 0x4DBE2F, 0x4DBE2F, spawnSettings, generationSettings);
  }
}
