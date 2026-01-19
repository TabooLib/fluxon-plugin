package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Keyed
import org.bukkit.Tag
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnTag {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tag::class.java)
                .function("isTagged", 1) { (it.target as? Tag<Keyed>)?.isTagged(it.getArgument(0) as Keyed) }
                .function("values", 0) { it.target?.getValues() }
        }
    }
}
