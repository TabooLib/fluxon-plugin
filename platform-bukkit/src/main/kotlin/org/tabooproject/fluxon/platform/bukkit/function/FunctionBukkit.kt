package org.tabooproject.fluxon.platform.bukkit.function

import org.bukkit.Bukkit
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FunctionBukkit {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("bukkit", returnsObject().noParams()) { Bukkit.getServer() }
            registerFunction("server", returnsObject().noParams()) { Bukkit.getServer() }
            registerFunction("broadcast", returns(Type.I).params(Type.STRING)) {
                Bukkit.broadcastMessage(it.getString(0)!!)
            }
        }
    }
}