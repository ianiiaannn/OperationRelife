package dev.iancmd.operationrelife.items

import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import java.util.function.Supplier

class ModItemTabs(private val iconGenerator: Supplier<ItemStack>) {
  private var iconItemStack: ItemStack? = null
  val iconItem: ItemStack?
    get() {
      if (iconItemStack == null) {
        iconItemStack = iconGenerator.get()
      }
      return iconItemStack
    }

  companion object {
    var CREATIVE_MODE_TAB = CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 0)
      .title(Component.translatable("itemGroup.buildingBlocks"))
  }
}
