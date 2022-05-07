package com.github.ianiiaannn.operationrelife;


import com.github.ianiiaannn.operationrelife.handlers.ModEventHandler;
import com.github.ianiiaannn.operationrelife.handlers.RegistryHandler;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;

@Mod(OperationRelife.MODID)
public class OperationRelife {
  public static final String MODID="operation_relife";
  public static final ResourceKey<Level> TEST_DIM_KEY=ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("operation_relife", "test_dimension"));
  public OperationRelife(){
    ModEventHandler.registerAll();
    RegistryHandler.registerAll();
  }
}
