package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Horse
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Horse"])
@PlatformSide(Platform.BUKKIT)
object FnHorse {

    val TYPE = Type.fromClass(Horse::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Horse::class.java)
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsVoid().params(Type.OBJECT)) { it.target?.setColor(it.getRef(0) as Horse.Color) }
                .function("style", returnsObject().noParams()) { it.setReturnRef(it.target?.style) }
                .function("setStyle", returnsVoid().params(Type.OBJECT)) { it.target?.setStyle(it.getRef(0) as Horse.Style) }
                .function("isCarryingChest", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCarryingChest ?: false) }
                .function("setCarryingChest", returnsVoid().params(Type.Z)) { it.target?.setCarryingChest(it.getBool(0)) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
