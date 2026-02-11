package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Axis
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.Axis"])
@PlatformSide(Platform.BUKKIT)
object FnAxis : FnEnumGetter<Axis>() {

    override val enumClass: Class<Axis> = Axis::class.java
}