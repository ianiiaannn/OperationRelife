package dev.iancmd.operationrelife.blocks.world

import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.MapColor
import net.minecraftforge.common.extensions.IForgeBlock

@Suppress("UNUSED_PARAMETER")
open class AbstractIceBlock(of: Properties?) :
  Block(Properties.of().friction(10.0f).mapColor(MapColor.ICE)), IForgeBlock
