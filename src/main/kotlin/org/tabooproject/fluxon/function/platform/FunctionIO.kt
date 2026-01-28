package org.tabooproject.fluxon.function.platform

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.getDataFolder
import taboolib.common.platform.function.isPrimaryThread
import taboolib.common.platform.function.server

object FunctionIO {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("isPrimaryThread", returns(Type.Z).noParams()) { isPrimaryThread }
            registerFunction("server", returnsObject().noParams()) { server() }
            registerFunction("dataFolder", returns(Type.FILE).noParams()) { getDataFolder() }
        }
    }
}