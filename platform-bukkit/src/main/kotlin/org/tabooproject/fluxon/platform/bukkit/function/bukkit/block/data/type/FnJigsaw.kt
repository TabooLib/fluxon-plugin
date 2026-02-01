package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Jigsaw
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Jigsaw"])
@PlatformSide(Platform.BUKKIT)
object FnJigsaw {

    val TYPE = Type.fromClass(Jigsaw::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Jigsaw::class.java)
                .function("orientation", returnsObject().noParams()) { it.setReturnRef(it.target?.orientation) }
                .function("setOrientation", returnsVoid().params(Type.OBJECT)) { it.target?.setOrientation(it.getRef(0) as Jigsaw.Orientation) }
        }
    }
}
