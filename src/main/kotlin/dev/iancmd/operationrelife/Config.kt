package dev.iancmd.operationrelife

import net.minecraftforge.common.ForgeConfigSpec

object Config {
  val BUILDER = ForgeConfigSpec.Builder()
  var SPEC: ForgeConfigSpec? = null
  var baseFogDensity: ForgeConfigSpec.ConfigValue<Float>? = null
  var baseFogRed: ForgeConfigSpec.ConfigValue<Float>? = null
  var baseFogGreen: ForgeConfigSpec.ConfigValue<Float>? = null
  var baseFogBlue: ForgeConfigSpec.ConfigValue<Float>? = null

  init {
    BUILDER.push("Config for Operation Relife")
    baseFogDensity = BUILDER.define("baseFogDensity", 125f)
    baseFogRed = BUILDER.define("baseFogRed", 95f)
    baseFogGreen = BUILDER.define("baseFogGreen", 131f)
    baseFogBlue = BUILDER.define("baseFogBlue", 134f)
    BUILDER.pop()
    SPEC = BUILDER.build()
  }
}
