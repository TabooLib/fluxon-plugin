package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Sniffer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Sniffer"])
@PlatformSide(Platform.BUKKIT)
object FnSniffer {

    val TYPE = Type.fromClass(Sniffer::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sniffer::class.java)
                .function("exploredLocations",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.exploredLocations) }
                .function("removeExploredLocation",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.target?.removeExploredLocation(it.getRef(0) as Location)
                }
                .function("addExploredLocation",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.target?.addExploredLocation(it.getRef(0) as Location)
                }
                .function("state", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSnifferState.TYPE).noParams()) { it.setReturnRef(it.target?.state) }
                .function("setState", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSnifferState.TYPE)) { it.target?.setState(it.getRef(0) as Sniffer.State)  }
                .function("setState", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSnifferState.enumValue(it.getString(0))?.let { p0 -> it.target?.setState(p0)  } }
                .function("findPossibleDigLocation",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.findPossibleDigLocation()) }
                .function("canDig", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canDig() ?: false) }
        }
    }
}
