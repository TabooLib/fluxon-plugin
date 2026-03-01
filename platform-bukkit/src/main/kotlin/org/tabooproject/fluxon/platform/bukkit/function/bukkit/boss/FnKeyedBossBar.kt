package org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.boss.KeyedBossBar"])
@PlatformSide(Platform.BUKKIT)
object FnKeyedBossBar {

    val TYPE = Type.fromClass(org.bukkit.boss.KeyedBossBar::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.boss.KeyedBossBar::class.java)
                // static
        }
    }
}
