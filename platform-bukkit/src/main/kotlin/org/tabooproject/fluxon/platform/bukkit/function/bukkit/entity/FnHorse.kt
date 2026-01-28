package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Horse
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Horse"])
@PlatformSide(Platform.BUKKIT)
object FnHorse {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Horse::class.java)
                .function("color", returnsObject().noParams()) { it.target?.color }
                .function("setColor", returnsObject().params(Type.OBJECT)) { it.target?.setColor(it.getRef(0) as Horse.Color) }
                .function("style", returnsObject().noParams()) { it.target?.style }
                .function("setStyle", returnsObject().params(Type.OBJECT)) { it.target?.setStyle(it.getRef(0) as Horse.Style) }
                .function("isCarryingChest", returns(Type.Z).noParams()) { it.target?.isCarryingChest }
                .function("setCarryingChest", returnsObject().params(Type.OBJECT)) { it.target?.setCarryingChest(it.getBool(0)) }
                .function("inventory", returnsObject().noParams()) { it.target?.inventory }
        }
    }
}
