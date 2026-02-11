package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.FaceAttachable
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.FaceAttachable"])
@PlatformSide(Platform.BUKKIT)
object FnFaceAttachable {

    val TYPE = Type.fromClass(FaceAttachable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FaceAttachable::class.java)
                .function("attachedFace", returns(FnAttachedFace.TYPE).noParams()) { it.setReturnRef(it.target?.attachedFace) }
                .function("setAttachedFace", returnsVoid().params(FnAttachedFace.TYPE)) { it.target?.setAttachedFace(it.getRef(0) as FaceAttachable.AttachedFace) }
                .function("setAttachedFace", returnsVoid().params(Type.STRING)) {
                    FnAttachedFace.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.setAttachedFace(
                            p0)
                    }
                }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.FaceAttachable.AttachedFace"])
@PlatformSide(Platform.BUKKIT)
object FnAttachedFace : FnEnumGetter<FaceAttachable.AttachedFace>() {

    override val enumClass: Class<FaceAttachable.AttachedFace> = FaceAttachable.AttachedFace::class.java
}