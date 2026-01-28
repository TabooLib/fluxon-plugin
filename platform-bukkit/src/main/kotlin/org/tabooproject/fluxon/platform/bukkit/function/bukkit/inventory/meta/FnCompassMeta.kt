package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.Location
import org.bukkit.inventory.meta.CompassMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.CompassMeta"])
@PlatformSide(Platform.BUKKIT)
object FnCompassMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CompassMeta::class.java)
                .function("hasLodestone", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasLodestone()) }
                .function("lodestone", returnsObject().noParams()) { it.setReturnRef(it.target?.lodestone) }
                .function("setLodestone", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLodestone(it.getRef(0) as Location)) }
                .function("isLodestoneTracked", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isLodestoneTracked) }
                .function("setLodestoneTracked", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLodestoneTracked(it.getBool(0))) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
