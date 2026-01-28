package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.OminousBottleMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.OminousBottleMeta"])
@PlatformSide(Platform.BUKKIT)
object FnOminousBottleMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OminousBottleMeta::class.java)
                .function("hasAmplifier", returns(Type.Z).noParams()) { it.target?.hasAmplifier() }
                .function("amplifier", returnsObject().noParams()) { it.target?.amplifier }
                .function("setAmplifier", returnsObject().params(Type.OBJECT)) { it.target?.setAmplifier(it.getInt(0).toInt()) }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
