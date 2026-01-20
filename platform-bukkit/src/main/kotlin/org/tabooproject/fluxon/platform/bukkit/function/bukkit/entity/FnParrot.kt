package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Parrot
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnParrot {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Parrot::class.java)
                .function("variant", 0) { it.target?.variant }
                .function("setVariant", 1) { it.target?.setVariant(it.getArgument(0) as Parrot.Variant) }
                .function("isDancing", 0) { it.target?.isDancing }
        }
    }
}
