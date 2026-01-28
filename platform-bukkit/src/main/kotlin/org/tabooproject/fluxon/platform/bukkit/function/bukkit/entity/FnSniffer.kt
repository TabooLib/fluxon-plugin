package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Sniffer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Sniffer"])
@PlatformSide(Platform.BUKKIT)
object FnSniffer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sniffer::class.java)
                .function("exploredLocations", returnsObject().noParams()) { it.setReturnRef(it.target?.exploredLocations) }
                .function("removeExploredLocation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeExploredLocation(it.getRef(0) as Location)) }
                .function("addExploredLocation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addExploredLocation(it.getRef(0) as Location)) }
                .function("state", returnsObject().noParams()) { it.setReturnRef(it.target?.state) }
                .function("setState", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setState(it.getRef(0) as Sniffer.State)) }
                .function("findPossibleDigLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.findPossibleDigLocation()) }
                .function("canDig", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.canDig()) }
        }
    }
}
