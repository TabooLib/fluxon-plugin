package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Cake
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Cake"])
@PlatformSide(Platform.BUKKIT)
object FnCake {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cake::class.java)
                .function("slicesEaten", returnsObject().noParams()) { it.target?.slicesEaten }
                .function("slicesRemaining", returnsObject().noParams()) { it.target?.slicesRemaining }
                .function("setSlicesEaten", returnsObject().params(Type.OBJECT)) { it.target?.setSlicesEaten(it.getInt(0).toInt()) }
                .function("setSlicesRemaining", returnsObject().params(Type.OBJECT)) { it.target?.setSlicesRemaining(it.getInt(0).toInt()) }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
