package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Chunk
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.Chunk\$LoadLevel"])
@PlatformSide(Platform.BUKKIT)
object FnChunkLoadLevel : FnEnumGetter<Chunk.LoadLevel>() {

    override val enumClass: Class<Chunk.LoadLevel> = Chunk.LoadLevel::class.java
}
