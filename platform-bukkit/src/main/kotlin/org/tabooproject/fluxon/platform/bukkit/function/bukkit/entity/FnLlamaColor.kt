package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Llama\$Color"])
@PlatformSide(Platform.BUKKIT)
object FnLlamaColor : FnEnumGetter<org.bukkit.entity.Llama.Color>() {

    override val enumClass: Class<org.bukkit.entity.Llama.Color> = org.bukkit.entity.Llama.Color::class.java
}
