package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.ArmorMeta
import org.bukkit.inventory.meta.trim.ArmorTrim
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnArmorMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ArmorMeta::class.java)
                .function("hasTrim", 0) { it.target?.hasTrim() }
                .function("setTrim", 1) { it.target?.setTrim(it.getArgument(0) as ArmorTrim) }
                .function("trim", 0) { it.target?.trim }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
