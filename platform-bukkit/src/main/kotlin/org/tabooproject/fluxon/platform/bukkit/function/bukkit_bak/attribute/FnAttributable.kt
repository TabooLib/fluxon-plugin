package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.Attributable
import org.bukkit.attribute.Attribute
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnAttributable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Attributable::class.java)
                .function("getAttribute", 0) { it.target?.getAttribute(it.getArgument(0) as Attribute) }
        }
    }
}