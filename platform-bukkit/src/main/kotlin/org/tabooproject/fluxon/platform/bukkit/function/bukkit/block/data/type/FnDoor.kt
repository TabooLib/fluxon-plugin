package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Door
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Door"])
@PlatformSide(Platform.BUKKIT)
object FnDoor {

    val TYPE = Type.fromClass(Door::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Door::class.java)
                .function("hinge", returnsObject().noParams()) { it.setReturnRef(it.target?.hinge) }
                .function("setHinge", returnsVoid().params(Type.OBJECT)) { it.target?.setHinge(it.getRef(0) as Door.Hinge) }
        }
    }
}
