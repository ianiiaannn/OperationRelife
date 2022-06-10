package dev.iancmd.operationrelife.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class RedSoulHolder extends SoulHolder{
  public RedSoulHolder() {
    super(BlockBehaviour.Properties.of(Material.STONE));
  }
}
