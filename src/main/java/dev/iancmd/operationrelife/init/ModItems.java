package dev.iancmd.operationrelife.init;

import dev.iancmd.operationrelife.core.OperationRelife;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
  public static DeferredRegister<Item> getRegister() {
    return ModItems.ItemRegistry.REGISTER;
  }
  public static class ItemRegistry {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, OperationRelife.MODID);
    public static final RegistryObject<Item> TEST_BLOCK = ItemRegistry.REGISTER.register("test_block", () -> new BlockItem(ModBlocks.BlockRegistry.TEST_BLOCK.get(), new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RED_SOUL_HOLDER = ItemRegistry.REGISTER.register("red_soul_holder", () -> new BlockItem(ModBlocks.BlockRegistry.RED_SOUL_HOLDER.get(), new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> BLUE_SOUL_HOLDER = ItemRegistry.REGISTER.register("blue_soul_holder", () -> new BlockItem(ModBlocks.BlockRegistry.BLUE_SOUL_HOLDER.get(), new Item.Properties().rarity(Rarity.COMMON)));
  }
}
