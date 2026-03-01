package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Bukkit
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.Bukkit"])
@PlatformSide(Platform.BUKKIT)
object FnBukkit {

    val TYPE = Type.fromClass(Bukkit::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
//            registerExtension(org.bukkit.Bukkit::class.java)
            registerFunction("bukkit", returns(FnServer.TYPE).noParams()) { it.setReturnRef(Bukkit.getServer()) }
            registerFunction("server", returns(FnServer.TYPE).noParams()) { it.setReturnRef(Bukkit.getServer()) }
            registerFunction("broadcast", returns(Type.I).params(Type.STRING)) { it.setReturnInt(Bukkit.broadcastMessage(it.getString(0)!!)) }
        }
    }
}
