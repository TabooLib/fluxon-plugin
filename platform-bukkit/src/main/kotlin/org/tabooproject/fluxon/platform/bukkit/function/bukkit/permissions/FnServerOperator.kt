package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.ServerOperator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.permissions.ServerOperator"])
@PlatformSide(Platform.BUKKIT)
object FnServerOperator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerOperator::class.java)
                .function("isOp", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isOp) }
                .function("setOp", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setOp(it.getBool(0))) }
        }
    }
}
