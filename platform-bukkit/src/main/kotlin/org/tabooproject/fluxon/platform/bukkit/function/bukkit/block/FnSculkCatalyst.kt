package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Block
import org.bukkit.block.SculkCatalyst
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.SculkCatalyst"])
@PlatformSide(Platform.BUKKIT)
object FnSculkCatalyst {

    val TYPE = Type.fromClass(SculkCatalyst::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkCatalyst::class.java)
                .function("bloom", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.bloom(it.getRef(0) as Block, it.getInt(1).toInt())) }
        }
    }
}
