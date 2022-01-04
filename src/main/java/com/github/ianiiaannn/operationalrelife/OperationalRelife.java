package com.github.ianiiaannn.operationalrelife;


import com.github.ianiiaannn.operationalrelife.handlers.ModEventHandler;
import com.github.ianiiaannn.operationalrelife.handlers.RegistryHandler;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;

@Mod(OperationalRelife.MODID)
public class OperationalRelife {
  public static final String MODID="operational_relife";
  public static final ResourceKey<Level> TEST_DIM_KEY=ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("operational_relife", "test_dimension"));
  public OperationalRelife(){
    ModEventHandler.registerAll();
    RegistryHandler.registerAll();
  }
}
