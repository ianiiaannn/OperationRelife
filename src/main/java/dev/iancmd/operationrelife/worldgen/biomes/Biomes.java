package dev.iancmd.operationrelife.worldgen.biomes;

import dev.iancmd.operationrelife.OperationRelife;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Biomes {
  public static DeferredRegister<Biome> getRegister() {
    return BiomesRegisters.REGISTER;
  }

  public static class BiomesRegisters {
    public static final DeferredRegister<Biome> REGISTER = DeferredRegister.create(ForgeRegistries.BIOMES, OperationRelife.MODID);

    public static final RegistryObject<Biome> PLACEHOLDER_1 = REGISTER.register("placeholder_biome", PlaceHolderBiome::placeHolderBiome);

  }
}
