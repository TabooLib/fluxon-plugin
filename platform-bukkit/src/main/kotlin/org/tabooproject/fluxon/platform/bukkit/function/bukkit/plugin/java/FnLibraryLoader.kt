package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.java

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.plugin.java.LibraryLoader"])
@PlatformSide(Platform.BUKKIT)
object FnLibraryLoader {

    private val clazz = Class.forName("org.bukkit.plugin.java.LibraryLoader")


    val TYPE = Type.fromClass(clazz)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(clazz)
                // static
        }
    }
}
