package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.Location
import org.bukkit.inventory.meta.CompassMeta
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

@Requires(classes = ["org.bukkit.inventory.meta.CompassMeta"])
@PlatformSide(Platform.BUKKIT)
object FnCompassMeta {

    val TYPE = Type.fromClass(CompassMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CompassMeta::class.java)
                .function("hasLodestone", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasLodestone() ?: false) }
                .function("lodestone", returnsObject().noParams()) { it.setReturnRef(it.target?.lodestone) }
                .function("setLodestone", returnsVoid().params(Type.OBJECT)) { it.target?.setLodestone(it.getRef(0) as Location) }
                .function("isLodestoneTracked", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLodestoneTracked ?: false) }
                .function("setLodestoneTracked", returnsVoid().params(Type.Z)) { it.target?.setLodestoneTracked(it.getBool(0)) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
