package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Dolphin"])
@PlatformSide(Platform.BUKKIT)
object FnDolphin {

    val TYPE = Type.fromClass(org.bukkit.entity.Dolphin::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.entity.Dolphin::class.java)
                // .function("getMoistness", returns(Type.I).noParams()) { it.setReturnInt(it.target?.getMoistness() ?: 0) }
                // .function("setMoistness", returnsVoid().params(Type.I)) { it.target?.setMoistness(it.getInt(0).toInt()) }
                // .function("setHasFish", returnsVoid().params(Type.Z)) { it.target?.setHasFish(it.getBool(0)) }
                // .function("hasFish", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasFish() ?: false) }
                // .function("getTreasureLocation", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.getTreasureLocation()) }
                // .function("setTreasureLocation", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.target?.setTreasureLocation(it.getRef(0) as org.bukkit.Location) }
        }
    }
}
