package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.permissions.PermissibleBase\$RemoveAttachmentRunnable"])
@PlatformSide(Platform.BUKKIT)
object FnPermissibleBaseRemoveAttachmentRunnable {

    private val clazz = Class.forName("org.bukkit.permissions.PermissibleBase\$RemoveAttachmentRunnable")


    val TYPE = Type.fromClass(clazz)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(clazz)
                // static
        }
    }
}
