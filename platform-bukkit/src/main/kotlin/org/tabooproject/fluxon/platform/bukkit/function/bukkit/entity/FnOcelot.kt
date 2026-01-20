package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Ocelot
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnOcelot {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ocelot::class.java)
                .function("isTrusting", 0) { it.target?.isTrusting }
                .function("setTrusting", 1) { it.target?.setTrusting(it.getBoolean(0)) }
                .function("catType", 0) { it.target?.catType }
                .function("setCatType", 1) { it.target?.setCatType(it.getArgument(0) as Ocelot.Type) }

            registerExtension(Ocelot.Type::class.java)
                .function("id", 0) { it.target?.id }
                // static
                .function("type", 1) { Ocelot.Type.getType(it.getNumber(0).toInt()) }
        }
    }
}
