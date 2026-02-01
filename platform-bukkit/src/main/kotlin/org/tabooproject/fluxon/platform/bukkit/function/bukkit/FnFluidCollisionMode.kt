package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.FluidCollisionMode
import org.tabooproject.fluxon.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.FluidCollisionMode"])
@PlatformSide(Platform.BUKKIT)
object FnFluidCollisionMode : FnEnumGetter<FluidCollisionMode>() {

    override val enumClass: Class<FluidCollisionMode> = FluidCollisionMode::class.java
}