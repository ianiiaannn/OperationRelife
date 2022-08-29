package dev.iancmd.operationrelife.items;

import dev.iancmd.operationrelife.OperationRelife;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemTab {
  public static CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab(OperationRelife.MODID + ".items") {
    @Override
    public ItemStack makeIcon() {
      return new ItemStack(Items.ItemRegistry.RED_SOUL_HOLDER.get());
    }
  };
}
