package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Location
import org.bukkit.block.EndGateway
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.EndGateway"])
@PlatformSide(Platform.BUKKIT)
object FnEndGateway {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EndGateway::class.java)
                .function("exitLocation", returnsObject().noParams()) { it.target?.exitLocation }
                .function("setExitLocation", returnsObject().params(Type.OBJECT)) { it.target?.setExitLocation(it.getRef(0) as Location) }
                .function("isExactTeleport", returns(Type.Z).noParams()) { it.target?.isExactTeleport }
                .function("setExactTeleport", returnsObject().params(Type.OBJECT)) { it.target?.setExactTeleport(it.getBool(0)) }
                .function("age", returnsObject().noParams()) { it.target?.age }
                .function("setAge", returnsObject().params(Type.OBJECT)) { it.target?.setAge(it.getInt(0).toLong()) }
        }
    }
}
