package dev.iancmd.operationrelife.block

import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.server.level.ServerPlayer
import net.minecraft.stats.Stats
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Items.DRAGON_EGG
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.DragonEggBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.MapColor
import net.minecraft.world.level.material.PushReaction
import net.minecraft.world.phys.BlockHitResult

class DragonEgg :
  DragonEggBlock(
    Properties.of().mapColor(MapColor.COLOR_BLACK).strength(3.0f, 9.0f).lightLevel
    { 1 }.noOcclusion().pushReaction(PushReaction.BLOCK)
  ) {
  @Override
  override fun use(
    pState: BlockState,
    pLevel: Level,
    pPos: BlockPos,
    pPlayer: Player,
    pHand: InteractionHand,
    pHit: BlockHitResult
  ): InteractionResult {
    if (pPlayer is ServerPlayer) {
      pPlayer.awardStat(Stats.ITEM_PICKED_UP[DRAGON_EGG], 1)
      pPlayer.displayClientMessage(Component.nullToEmpty("Dragon egg used, ${pPlayer.stats.getValue(Stats.ITEM_PICKED_UP[DRAGON_EGG])}"), true)
    }
    return InteractionResult.sidedSuccess(pLevel.isClientSide)
  }
  @Override
  override fun attack(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player) {
    pPlayer.awardStat(Stats.ITEM_PICKED_UP[DRAGON_EGG],1)
  }
}
