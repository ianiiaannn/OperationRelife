package dev.iancmd.operationrelife.handlers;

import dev.iancmd.operationrelife.init.ModBlocks;
import dev.iancmd.operationrelife.init.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;

import static dev.iancmd.operationrelife.core.OperationRelife.MODID;
import static dev.iancmd.operationrelife.core.OperationRelife.getLogger;

public class ModEventHandler {
  private static final IEventBus BUS = FMLJavaModLoadingContext.get().getModEventBus();
  public static void registerAll() {
    ModEventHandler.BUS.register(ModEventHandler.class);
    ModEventHandler.BUS.register(new ModEventHandler());
  }
  @SubscribeEvent
  public static void onCommonSetup(FMLCommonSetupEvent event) {
    ForgeEventHandler.registerEvents();
  }
  @SubscribeEvent
  public static void onClientSetup(FMLClientSetupEvent event) {
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.BlockRegistry.BLUE_SOUL_HOLDER.get(), RenderType.translucent());
  }
  @SubscribeEvent
  public void onRegisterCreativeModeTabs(CreativeModeTabEvent.Register event) {
    getLogger().log(Level.DEBUG, "Registering creative mode tabs...");
    event.registerCreativeModeTab(new ResourceLocation(MODID, "creative_mod_tab"), (builder) -> builder
              .title(Component.translatable("itemGroup." + MODID + ".creative_mod_tab")).
              icon(() -> ModItems.ItemRegistry.RED_SOUL_HOLDER.get().getDefaultInstance())
              .displayItems((p_259897_, output, p_259072_) -> {
                output.accept(ModItems.ItemRegistry.BLUE_SOUL_HOLDER.get());
                output.accept(ModItems.ItemRegistry.RED_SOUL_HOLDER.get());
              }));
  }
}
