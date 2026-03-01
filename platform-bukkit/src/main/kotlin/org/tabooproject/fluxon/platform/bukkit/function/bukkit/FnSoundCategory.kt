package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.SoundCategory
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.SoundCategory"])
@PlatformSide(Platform.BUKKIT)
object FnSoundCategory : FnEnumGetter<SoundCategory>() {

    override val enumClass: Class<SoundCategory> = SoundCategory::class.java
}
