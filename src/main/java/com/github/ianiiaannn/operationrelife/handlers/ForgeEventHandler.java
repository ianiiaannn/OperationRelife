package com.github.ianiiaannn.operationrelife.handlers;

import com.github.ianiiaannn.operationrelife.Config;
import com.github.ianiiaannn.operationrelife.OperationRelife;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;


public class ForgeEventHandler {
  private static final float red=Config.baseFogRed.get(), green=Config.baseFogGreen.get(), blue=Config.baseFogBlue.get();
  private static float density= Config.baseFogDensity.get();
  private static final IEventBus BUS = MinecraftForge.EVENT_BUS;
  public static void registerEvents(){
    ForgeEventHandler.BUS.register(ForgeEventHandler.class);
    ForgeEventHandler.BUS.register(new ForgeEventHandler());
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "operation-relife.toml");
  }
  @SubscribeEvent
  public static void onChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
    System.out.println(event.getEntity().level.dimension());
    if(isWorld(event.getEntity().level, OperationRelife.TEST_DIM_KEY.location())){

    }
  }

  @SubscribeEvent
  public static void onFogDensity(EntityViewRenderEvent.FogDensity event){
    if(event.getCamera().getEntity() instanceof Player){
      if(isWorld(event.getCamera().getEntity().level, OperationRelife.TEST_DIM_KEY.location())){
        event.setDensity(density);
        event.setCanceled(true);
      }
    }
  }
  @SubscribeEvent
  public static void onFogColors(EntityViewRenderEvent.FogColors event){
    if(event.getCamera().getEntity() instanceof Player){
      if(isWorld(event.getCamera().getEntity().level, OperationRelife.TEST_DIM_KEY.location())) {
        event.setRed(red / 256);
        event.setGreen(green / 256);
        event.setBlue(blue / 256);
      }
    }
  }
  /*
  @SubscribeEvent
  public static void onChat(ClientChatEvent event){
    String msg=event.getMessage();
    density= Float.parseFloat(msg);

  }*/

  @SubscribeEvent
  public static void onJoinWorld(EntityJoinWorldEvent event){
    if (event.getEntity() instanceof Player) {
      if(isWorld(event.getEntity().level, OperationRelife.TEST_DIM_KEY.location())){
        // EntityRenderers.createPlayerRenderers();
      }
    }
  }
  @SubscribeEvent
  public static void onRenderFog(EntityViewRenderEvent.RenderFogEvent event){
    // System.out.println(java.lang.Thread.currentThread().getThreadGroup()== SidedThreadGroups.CLIENT);
    /*GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_LINEAR);
    GL11.glFogf(GL11.GL_FOG_START, 0.0F);
    GL11.glFogf(GL11.GL_FOG_END, 30f);
     */
  }

  public static boolean isWorld(Level world, ResourceLocation loc) {
    return world.dimension() == ResourceKey.create(Registry.DIMENSION_REGISTRY, loc);
  }
}
