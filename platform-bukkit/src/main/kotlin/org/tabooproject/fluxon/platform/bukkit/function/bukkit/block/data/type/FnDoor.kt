package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Door
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

@Requires(classes = ["org.bukkit.block.data.type.Door"])
@PlatformSide(Platform.BUKKIT)
object FnDoor {

    val TYPE = Type.fromClass(Door::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Door::class.java)
                .function("hinge", returns(FnDoorHinge.TYPE).noParams()) { it.setReturnRef(it.target?.hinge) }
                .function("setHinge", returnsVoid().params(FnDoorHinge.TYPE)) { it.target?.setHinge(it.getRef(0) as Door.Hinge) }
                .function("setHinge", returnsVoid().params(Type.STRING)) { FnDoorHinge.enumValue(it.getString(0))?.let { p0 -> it.target?.setHinge(p0) } }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.Door\$Hinge"])
@PlatformSide(Platform.BUKKIT)
object FnDoorHinge : FnEnumGetter<Door.Hinge>() {

    override val enumClass: Class<Door.Hinge> = Door.Hinge::class.java
}
