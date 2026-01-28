package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Command
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Command"])
@PlatformSide(Platform.BUKKIT)
object FnCommand {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Command::class.java)
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isPowered) }
                .function("setPowered", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPowered(it.getBool(0))) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
