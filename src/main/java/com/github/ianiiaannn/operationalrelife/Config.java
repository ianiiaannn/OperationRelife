package com.github.ianiiaannn.operationalrelife;

import net.minecraftforge.common.ForgeConfigSpec;

public final class Config {
  public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
  public static final ForgeConfigSpec SPEC;

  public static final ForgeConfigSpec.ConfigValue<Float> baseFogDensity;
  public static final ForgeConfigSpec.ConfigValue<Float> baseFogRed;
  public static final ForgeConfigSpec.ConfigValue<Float> baseFogGreen;
  public static final ForgeConfigSpec.ConfigValue<Float> baseFogBlue;

  static {
    BUILDER.push("Config for Operational Relife");
    baseFogDensity=BUILDER.define("baseFogDensity",(float)125);
    baseFogRed=BUILDER.define("baseFogRed",(float)95);
    baseFogGreen=BUILDER.define("baseFogGreen",(float)131);
    baseFogBlue=BUILDER.define("baseFogBlue",(float)134);
    BUILDER.pop();
    SPEC=BUILDER.build();
  }
}
