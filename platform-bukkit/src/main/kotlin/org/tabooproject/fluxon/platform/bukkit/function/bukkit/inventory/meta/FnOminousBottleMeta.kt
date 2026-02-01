package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.OminousBottleMeta
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

@Requires(classes = ["org.bukkit.inventory.meta.OminousBottleMeta"])
@PlatformSide(Platform.BUKKIT)
object FnOminousBottleMeta {

    val TYPE = Type.fromClass(OminousBottleMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OminousBottleMeta::class.java)
                .function("hasAmplifier", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasAmplifier() ?: false) }
                .function("amplifier", returns(Type.I).noParams()) { it.setReturnInt(it.target?.amplifier ?: 0) }
                .function("setAmplifier", returnsVoid().params(Type.I)) { it.target?.setAmplifier(it.getInt(0).toInt()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
