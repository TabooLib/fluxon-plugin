package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Command
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

@Requires(classes = ["org.bukkit.material.Command"])
@PlatformSide(Platform.BUKKIT)
object FnCommand {

    val TYPE = Type.fromClass(Command::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Command::class.java)
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPowered ?: false) }
                .function("setPowered", returnsVoid().params(Type.Z)) { it.target?.setPowered(it.getBool(0)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
