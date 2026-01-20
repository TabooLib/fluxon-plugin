package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.StringUtil
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnStringUtil {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StringUtil::class.java)
                // static
                .function("startsWithIgnoreCase", 2) {
                    StringUtil.startsWithIgnoreCase(
                        it.getString(0)!!,
                        it.getString(1)!!
                    )
                }
        }
    }
}
