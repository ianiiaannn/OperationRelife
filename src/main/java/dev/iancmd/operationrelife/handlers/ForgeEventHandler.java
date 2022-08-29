package dev.iancmd.operationrelife.handlers;

import dev.iancmd.operationrelife.OperationRelife;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeEventHandler {
  // private static final float red = Config.baseFogRed.get(), green = Config.baseFogGreen.get(), blue = Config.baseFogBlue.get();
  // private static final float density = Config.baseFogDensity.get();
  private static final IEventBus BUS = MinecraftForge.EVENT_BUS;

  public static void registerEvents() {
    ForgeEventHandler.BUS.register(ForgeEventHandler.class);
    ForgeEventHandler.BUS.register(new ForgeEventHandler());
    // ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "operation-relife.toml");
  }

  @SubscribeEvent
  public static void onChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
    System.out.println(event.getEntity().level.dimension());
    if (isWorld(event.getEntity().level, OperationRelife.TERMINAL_ISLE.location())) {

    }
  }

  /*
    @SubscribeEvent
    public static void onFogDensityE(EntityViewRenderEvent.RenderFogEvent event) {
      if (event.getCamera().getEntity() instanceof Player) {
        if (isWorld(event.getCamera().getEntity().level, OperationRelife.TERMINAL_ISLE.location())) {
          event.setFarPlaneDistance(density);
          event.setCanceled(true);
        }
      }
    }

    @SubscribeEvent
    public static void onFogColors(EntityViewRenderEvent.FogColors event) {
      if (event.getCamera().getEntity() instanceof Player) {
        if (isWorld(event.getCamera().getEntity().level, OperationRelife.TERMINAL_ISLE.location())) {
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
/*
  @SubscribeEvent
  public static void onJoinWorld(EntityJoinWorldEvent event) {
    if (event.getEntity() instanceof Player) {
      if (isWorld(event.getEntity().level, OperationRelife.TERMINAL_ISLE.location())) {
        // EntityRenderers.createPlayerRenderers();
      }
    }
  }

  @SubscribeEvent
  public static void onRenderFog(EntityViewRenderEvent.RenderFogEvent event) {
    // System.out.println(java.lang.Thread.currentThread().getThreadGroup()== SidedThreadGroups.CLIENT);
    /*GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_LINEAR);
    GL11.glFogf(GL11.GL_FOG_START, 0.0F);
    GL11.glFogf(GL11.GL_FOG_END, 30f);

  }
*/
  public static boolean isWorld(Level world, ResourceLocation loc) {
    return world.dimension() == ResourceKey.create(Registry.DIMENSION_REGISTRY, loc);
  }

}
