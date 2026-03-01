package org.tabooproject.fluxon.function.platform

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.*

object FunctionAdapter {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("console", returns(StandardTypes.PROXY_COMMAND_SENDER).noParams()) { it.setReturnRef(console()) }
            registerFunction("onlinePlayers", returns(Type.LIST).noParams()) { it.setReturnRef(onlinePlayers()) }
            registerFunction("adaptPlayer", returns(StandardTypes.PROXY_PLAYER).params(Type.OBJECT)) { it.setReturnRef(adaptPlayer(it.getRef(0)!!)) }
            registerFunction("adaptCommandSender", returns(StandardTypes.PROXY_COMMAND_SENDER).params(Type.OBJECT)) { it.setReturnRef(adaptCommandSender(it.getRef(0)!!)) }
            registerFunction("adaptLocation", returns(StandardTypes.PROXY_LOCATION).params(Type.OBJECT)) { it.setReturnRef(adaptLocation(it.getRef(0)!!)) }
            registerFunction("allWorlds", returns(Type.LIST).noParams()) { it.setReturnRef(allWorlds()) }
        }
    }
}