package dev.iancmd.operationrelife.worldgen.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

import javax.swing.text.StyleConstants;

public class PlaceHolderBiome {
  // thanks https://github.com/DenisMasterHerobrine/MagicalForest !
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

  public static Biome placeHolderBiome() {
    MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
    BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();

    spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.END_CRYSTAL, 10, 8, 8));


    BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeFeatures);
    BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
    BiomeDefaultFeatures.addDefaultMonsterRoom(biomeFeatures);
    BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
    BiomeDefaultFeatures.addDefaultSprings(biomeFeatures);
    BiomeDefaultFeatures.addSurfaceFreezing(biomeFeatures);

    BiomeDefaultFeatures.addDefaultOres(biomeFeatures);
    BiomeDefaultFeatures.addDefaultSoftDisks(biomeFeatures);

    BiomeDefaultFeatures.addForestFlowers(biomeFeatures);
    BiomeDefaultFeatures.addWaterTrees(biomeFeatures);
    BiomeDefaultFeatures.addGroveTrees(biomeFeatures);

    BiomeDefaultFeatures.addFerns(biomeFeatures);

    BiomeDefaultFeatures.addMossyStoneBlock(biomeFeatures);

    BiomeDefaultFeatures.addMushroomFieldVegetation(biomeFeatures);
    BiomeDefaultFeatures.addMeadowVegetation(biomeFeatures);

    BiomeDefaultFeatures.addDefaultMushrooms(biomeFeatures);
    BiomeDefaultFeatures.addDefaultExtraVegetation(biomeFeatures);
    BiomeDefaultFeatures.addCommonBerryBushes(biomeFeatures);
    BiomeDefaultFeatures.addJungleMelons(biomeFeatures);


    return biome(Biome.Precipitation.RAIN, 0.5F, 0.7F, StyleConstants.ColorConstants.ALIGN_CENTER, StyleConstants.ColorConstants.ALIGN_CENTER, StyleConstants.ColorConstants.ALIGN_CENTER, StyleConstants.ColorConstants.ALIGN_CENTER, spawnSettings, biomeFeatures);
  }
}
