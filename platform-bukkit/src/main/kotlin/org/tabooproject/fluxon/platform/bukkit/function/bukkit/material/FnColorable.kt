package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.DyeColor
import org.bukkit.material.Colorable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.material.Colorable"])
@PlatformSide(Platform.BUKKIT)
object FnColorable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Colorable::class.java)
                .function("color", returnsObject().noParams()) { it.target?.color }
                .function("setColor", returnsObject().params(Type.OBJECT)) { it.target?.setColor(it.getRef(0) as DyeColor) }
        }
    }
}
