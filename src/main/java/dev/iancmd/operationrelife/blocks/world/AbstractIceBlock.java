package dev.iancmd.operationrelife.blocks.world;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.extensions.IForgeBlock;

public class AbstractIceBlock extends Block implements IForgeBlock {
  public AbstractIceBlock(Properties of) {
    super(BlockBehaviour.Properties.of(Material.ICE_SOLID).friction(10.0F));
  }
}
