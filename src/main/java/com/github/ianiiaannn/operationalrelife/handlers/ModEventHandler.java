package com.github.ianiiaannn.operationalrelife.handlers;


import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class ModEventHandler {
  private static final IEventBus BUS = FMLJavaModLoadingContext.get().getModEventBus();
  public static void registerAll(){
    ModEventHandler.BUS.register(ModEventHandler.class);
    ModEventHandler.BUS.register(new ModEventHandler());
  }
  @SubscribeEvent
  public  static  void onCommonSetup(FMLCommonSetupEvent event){
    ForgeEventHandler.registerEvents();
  }

}
