package dev.iancmd.operationrelife.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DragonEggBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

import static dev.iancmd.operationrelife.core.OperationRelife.getLogger;
import static org.apache.logging.log4j.Level.DEBUG;

public class DragonEgg extends DragonEggBlock {
  protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
  public DragonEgg() {
    super(BlockBehaviour.Properties.of(Material.EGG, MaterialColor.COLOR_BLACK).strength(3.0F, 9.0F).lightLevel((p_50840_) -> {
      return 1;
    }).noOcclusion());
  }
  @Override
  public InteractionResult use(BlockState p_52923_, Level p_52924_, BlockPos p_52925_, Player p_52926_, InteractionHand p_52927_, BlockHitResult p_52928_) {
    this.teleport(p_52923_, p_52924_, p_52925_);
    return InteractionResult.sidedSuccess(p_52924_.isClientSide);
  }
  @Override
  public void attack(BlockState p_52918_, Level p_52919_, BlockPos p_52920_, Player p_52921_) {
    this.teleport(p_52918_, p_52919_, p_52920_);
  }
  private void teleport(BlockState p_52936_, Level p_52937_, BlockPos p_52938_) {
    getLogger().log(DEBUG, p_52937_.getBlockState(p_52938_));
    WorldBorder worldborder = p_52937_.getWorldBorder();
    for (int i = 0; i < 1000; ++i) {
      BlockPos blockpos = p_52938_.offset(p_52937_.random.nextInt(16) - p_52937_.random.nextInt(16), p_52937_.random.nextInt(8) - p_52937_.random.nextInt(8), p_52937_.random.nextInt(16) - p_52937_.random.nextInt(16));
      if (p_52937_.getBlockState(blockpos).isAir() && worldborder.isWithinBounds(blockpos)) {
        if (p_52937_.isClientSide) {
          for (int j = 0; j < 128; ++j) {
            double d0 = p_52937_.random.nextDouble();
            float f = (p_52937_.random.nextFloat() - 0.5F) * 0.2F;
            float f1 = (p_52937_.random.nextFloat() - 0.5F) * 0.2F;
            float f2 = (p_52937_.random.nextFloat() - 0.5F) * 0.2F;
            double d1 = Mth.lerp(d0, blockpos.getX(), p_52938_.getX()) + (p_52937_.random.nextDouble() - 0.5D) + 0.5D;
            double d2 = Mth.lerp(d0, blockpos.getY(), p_52938_.getY()) + p_52937_.random.nextDouble() - 0.5D;
            double d3 = Mth.lerp(d0, blockpos.getZ(), p_52938_.getZ()) + (p_52937_.random.nextDouble() - 0.5D) + 0.5D;
            p_52937_.addParticle(ParticleTypes.PORTAL, d1, d2, d3, f, f1, f2);
          }
        } else {
          p_52937_.setBlock(blockpos, p_52936_, 2);
          p_52937_.removeBlock(p_52938_, false);
        }
        return;
      }
    }
  }
}
