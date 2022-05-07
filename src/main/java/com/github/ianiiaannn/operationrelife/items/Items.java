package com.github.ianiiaannn.operationrelife.items;

import com.github.ianiiaannn.operationrelife.blocks.Blocks;
import com.github.ianiiaannn.operationrelife.OperationRelife;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryObject;

@ObjectHolder(OperationRelife.MODID)
public class Items {
  public static DeferredRegister<Item> getRegister(){
    return Items.ItemRegistry.REGISTER;
  }
  public static class ItemRegistry{
    public static final DeferredRegister<Item> REGISTER= DeferredRegister.create(ForgeRegistries.ITEMS, OperationRelife.MODID);

    public static final RegistryObject<Item> OBJ_TESTBLOCK = ItemRegistry.REGISTER.register("test_block",()->new BlockItem(Blocks.BlockRegistry.OBJ_TESTBLOCK.get(),new Item.Properties().rarity(Rarity.EPIC)));
  }
}
