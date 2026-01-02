package org.tabooproject.fluxon.function.platform

import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.getDataFolder
import taboolib.common.platform.function.isPrimaryThread
import taboolib.common.platform.function.server

object FunctionIO {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("isPrimaryThread", 0) { isPrimaryThread }
            registerFunction("server", 0) { server() }
            registerFunction("dataFolder", 0) { getDataFolder() }
        }
    }
}