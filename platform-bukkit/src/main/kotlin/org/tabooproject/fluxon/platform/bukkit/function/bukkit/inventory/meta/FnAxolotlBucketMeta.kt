package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.entity.Axolotl
import org.bukkit.inventory.meta.AxolotlBucketMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAxolotlBucketMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AxolotlBucketMeta::class.java)
                .function("setVariant", 1) { it.target?.setVariant(it.getArgument(0) as Axolotl.Variant) }
                .function("hasVariant", 0) { it.target?.hasVariant() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
