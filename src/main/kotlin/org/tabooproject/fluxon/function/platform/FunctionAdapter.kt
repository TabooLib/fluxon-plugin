package org.tabooproject.fluxon.function.platform

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.*

object FunctionAdapter {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("console", returnsObject().noParams()) { console() }
            registerFunction("onlinePlayers", returns(Type.LIST).noParams()) { onlinePlayers() }
            registerFunction("adaptPlayer", returnsObject().params(Type.OBJECT)) { adaptPlayer(it.getRef(0)!!) }
            registerFunction("adaptCommandSender", returnsObject().params(Type.OBJECT)) { adaptCommandSender(it.getRef(0)!!) }
            registerFunction("adaptLocation", returnsObject().params(Type.OBJECT)) { adaptLocation(it.getRef(0)!!) }
            registerFunction("allWorlds", returns(Type.LIST).noParams()) { allWorlds() }
        }
    }
}