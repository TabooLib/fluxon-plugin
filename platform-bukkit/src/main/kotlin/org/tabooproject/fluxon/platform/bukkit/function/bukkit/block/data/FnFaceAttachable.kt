package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.FaceAttachable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFaceAttachable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FaceAttachable::class.java)
                .function("attachedFace", 0) { it.target?.attachedFace }
                .function(
                    "setAttachedFace",
                    1
                ) { it.target?.setAttachedFace(it.getArgument(0) as FaceAttachable.AttachedFace) }
        }
    }
}
