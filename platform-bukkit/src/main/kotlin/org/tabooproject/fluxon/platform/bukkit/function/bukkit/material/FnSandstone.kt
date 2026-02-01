package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.SandstoneType
import org.bukkit.material.Sandstone
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

@Requires(classes = ["org.bukkit.material.Sandstone"])
@PlatformSide(Platform.BUKKIT)
object FnSandstone {

    val TYPE = Type.fromClass(Sandstone::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sandstone::class.java)
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("setType", returnsVoid().params(Type.OBJECT)) { it.target?.setType(it.getRef(0) as SandstoneType) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
