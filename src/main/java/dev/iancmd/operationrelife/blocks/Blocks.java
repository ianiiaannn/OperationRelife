package dev.iancmd.operationrelife.blocks;

import dev.iancmd.operationrelife.OperationRelife;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// @ObjectHolder(OperationRelife.MODID)
public class Blocks {
  public static DeferredRegister<Block> getRegister() {
    return BlockRegistry.REGISTER;
  }

  public static DeferredRegister<Block> getOverrideRegister() {
    return BlockRegistry.OVERRIDE_REGISTER;
  }

  public static class BlockRegistry {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, OperationRelife.MODID);
    public static final RegistryObject<Block> TEST_BLOCK = REGISTER.register("test_block", TestBlock::new);
    public static final RegistryObject<Block> RED_SOUL_HOLDER = REGISTER.register("red_soul_holder", RedSoulHolder::new);
    public static final RegistryObject<Block> BLUE_SOUL_HOLDER = REGISTER.register("blue_soul_holder", BlueSoulHolder::new);


    public static final DeferredRegister<Block> OVERRIDE_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
    public static final RegistryObject<Block> DRAGON_EGG = OVERRIDE_REGISTER.register("dragon_egg", DragonEgg::new);
  }
}
