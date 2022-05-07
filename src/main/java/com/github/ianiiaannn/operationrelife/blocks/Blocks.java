package com.github.ianiiaannn.operationrelife.blocks;

import com.github.ianiiaannn.operationrelife.OperationRelife;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryObject;

@ObjectHolder(OperationRelife.MODID)
public class Blocks {
  public static final TestBlock TEST_BLOCK=null;
  public static DeferredRegister<Block> getRegister(){
    return BlockRegistry.REGISTER;
  }
  public static class BlockRegistry{
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, OperationRelife.MODID);
    public static final RegistryObject<Block> OBJ_TESTBLOCK = BlockRegistry.REGISTER.register("test_block", TestBlock::new);
  }
}
