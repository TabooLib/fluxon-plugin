package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure

import org.bukkit.block.structure.UsageMode
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.structure.UsageMode"])
@PlatformSide(Platform.BUKKIT)
object FnUsageMode : FnEnumGetter<UsageMode>() {

    override val enumClass: Class<UsageMode> = UsageMode::class.java
}