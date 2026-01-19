package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.DyeColor
import org.bukkit.entity.Cat
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCat {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cat::class.java)
                .function("catType", 0) { it.target?.catType }
                .function("setCatType", 1) { it.target?.setCatType(it.getArgument(0) as Cat.Type) }
                .function("collarColor", 0) { it.target?.collarColor }
                .function("setCollarColor", 1) { it.target?.setCollarColor(it.getArgument(0) as DyeColor) }

            registerExtension(Cat.Type::class.java)
                .function("key", 0) { it.target?.key }
        }
    }
}
