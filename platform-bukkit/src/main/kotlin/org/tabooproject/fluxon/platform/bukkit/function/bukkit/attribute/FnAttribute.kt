package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.Attribute
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAttribute {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Attribute::class.java)
                .function("key", 0) { it.target?.key }
                .function("translationKey", 0) { it.target?.translationKey }
        }
    }
}
