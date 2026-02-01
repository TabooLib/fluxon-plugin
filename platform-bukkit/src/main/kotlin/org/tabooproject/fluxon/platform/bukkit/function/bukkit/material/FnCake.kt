package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Cake
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

@Requires(classes = ["org.bukkit.material.Cake"])
@PlatformSide(Platform.BUKKIT)
object FnCake {

    val TYPE = Type.fromClass(Cake::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cake::class.java)
                .function("slicesEaten", returns(Type.I).noParams()) { it.setReturnInt(it.target?.slicesEaten ?: 0) }
                .function("slicesRemaining", returns(Type.I).noParams()) { it.setReturnInt(it.target?.slicesRemaining ?: 0) }
                .function("setSlicesEaten", returnsVoid().params(Type.I)) { it.target?.setSlicesEaten(it.getInt(0).toInt()) }
                .function("setSlicesRemaining", returnsVoid().params(Type.I)) { it.target?.setSlicesRemaining(it.getInt(0).toInt()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
