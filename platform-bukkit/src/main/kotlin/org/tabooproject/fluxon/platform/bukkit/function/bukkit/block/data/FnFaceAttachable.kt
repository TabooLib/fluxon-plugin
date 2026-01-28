package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.FaceAttachable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.FaceAttachable"])
@PlatformSide(Platform.BUKKIT)
object FnFaceAttachable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FaceAttachable::class.java)
                .function("attachedFace", returnsObject().noParams()) { it.target?.attachedFace }
                .function("setAttachedFace", returnsObject().params(Type.OBJECT)) { it.target?.setAttachedFace(it.getRef(0) as FaceAttachable.AttachedFace) }
        }
    }
}
