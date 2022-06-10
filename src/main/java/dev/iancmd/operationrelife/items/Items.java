package dev.iancmd.operationrelife.items;

import dev.iancmd.operationrelife.blocks.Blocks;
import dev.iancmd.operationrelife.OperationRelife;
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

    public static final RegistryObject<Item> TEST_BLOCK = ItemRegistry.REGISTER.register("test_block",()->new BlockItem(Blocks.BlockRegistry.TEST_BLOCK.get(),new Item.Properties().rarity(Rarity.EPIC)));
  }
}