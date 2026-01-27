package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Axolotl
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Axolotl"])
@PlatformSide(Platform.BUKKIT)
object FnAxolotl {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Axolotl::class.java)
                .function("isPlayingDead", 0) { it.target?.isPlayingDead }
                .function("setPlayingDead", 1) { it.target?.setPlayingDead(it.getBoolean(0)) }
                .function("variant", 0) { it.target?.variant }
                .function("setVariant", 1) { it.target?.setVariant(it.getArgument(0) as Axolotl.Variant) }
        }
    }
}
