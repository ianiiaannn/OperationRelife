package dev.iancmd.operationrelife.items;

import dev.iancmd.operationrelife.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

import static net.minecraft.world.item.CreativeModeTab.Row.TOP;

public class ModItemTabs {
  public static CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab.Builder(TOP, 0)
            .title(Component.translatable("itemGroup.buildingBlocks"))
            .icon(() -> {
              return new ItemStack(Blocks.BRICKS);
            }).displayItems((p_259897_, p_259444_, p_259072_) -> {
              p_259444_.accept(ModItems.ItemRegistry.BLUE_SOUL_HOLDER.get());
              p_259444_.accept(ModItems.ItemRegistry.RED_SOUL_HOLDER.get());
            }).build();
  private final Supplier<ItemStack> iconGenerator;
  private ItemStack iconItemStack;
  public ModItemTabs(Supplier<ItemStack> iconGenerator) {
    this.iconGenerator = iconGenerator;
  }
  public ItemStack getIconItem() {
    if (this.iconItemStack == null) {
      this.iconItemStack = this.iconGenerator.get();
    }
    return this.iconItemStack;
  }
}
