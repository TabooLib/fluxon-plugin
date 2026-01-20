package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.AuthorNagException
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAuthorNagException {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AuthorNagException::class.java)
                .function("message", 0) { it.target?.message }
        }
    }
}
