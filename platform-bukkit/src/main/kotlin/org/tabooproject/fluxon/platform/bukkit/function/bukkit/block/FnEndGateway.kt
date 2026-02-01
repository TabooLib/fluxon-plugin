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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.EndGateway"])
@PlatformSide(Platform.BUKKIT)
object FnEndGateway {

    val TYPE = Type.fromClass(EndGateway::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EndGateway::class.java)
                .function("exitLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.exitLocation) }
                .function("setExitLocation", returnsVoid().params(Type.OBJECT)) { it.target?.setExitLocation(it.getRef(0) as Location) }
                .function("isExactTeleport", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isExactTeleport ?: false) }
                .function("setExactTeleport", returnsVoid().params(Type.Z)) { it.target?.setExactTeleport(it.getBool(0)) }
                .function("age", returns(Type.J).noParams()) { it.setReturnLong(it.target?.age ?: 0L) }
                .function("setAge", returnsVoid().params(Type.J)) { it.target?.setAge(it.getLong(0)) }
        }
    }
}
