package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Attachable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.material.Attachable"])
@PlatformSide(Platform.BUKKIT)
object FnAttachable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Attachable::class.java)
                .function("attachedFace", returnsObject().noParams()) { it.target?.attachedFace }
        }
    }
}
