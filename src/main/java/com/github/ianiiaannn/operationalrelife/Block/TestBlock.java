package com.github.ianiiaannn.operationalrelife.Block;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.util.datafix.fixes.BlockRenameFix;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class TestBlock extends Block {
  public TestBlock(){
    super(BlockBehaviour.Properties.of(Material.STONE));


  }
  @SubscribeEvent
  public static void onClientSetupEvent(FMLClientSetupEvent event){
    RenderType.cutoutMipped();
  }
}
