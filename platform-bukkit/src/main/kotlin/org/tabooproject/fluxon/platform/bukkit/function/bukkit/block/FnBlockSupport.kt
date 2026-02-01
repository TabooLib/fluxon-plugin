package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BlockSupport
import org.tabooproject.fluxon.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.BlockSupport"])
@PlatformSide(Platform.BUKKIT)
object FnBlockSupport : FnEnumGetter<BlockSupport>() {

    override val enumClass: Class<BlockSupport> = BlockSupport::class.java
}