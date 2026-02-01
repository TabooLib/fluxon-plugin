package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Beehive
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Beehive"])
@PlatformSide(Platform.BUKKIT)
object FnBeehive {

    val TYPE = Type.fromClass(Beehive::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Beehive::class.java)
                .function("honeyLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.honeyLevel ?: 0) }
                .function("setHoneyLevel", returnsVoid().params(Type.I)) { it.target?.setHoneyLevel(it.getInt(0).toInt()) }
                .function("maximumHoneyLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumHoneyLevel ?: 0) }
        }
    }
}
