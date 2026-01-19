package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Attachable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnAttachable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Attachable::class.java)
                .function("attachedFace", 0) { it.target?.attachedFace }
        }
    }
}
