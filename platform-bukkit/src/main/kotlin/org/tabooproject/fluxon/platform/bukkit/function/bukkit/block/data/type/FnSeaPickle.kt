package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.SeaPickle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.SeaPickle"])
@PlatformSide(Platform.BUKKIT)
object FnSeaPickle {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SeaPickle::class.java)
                .function("pickles", returnsObject().noParams()) { it.target?.pickles }
                .function("setPickles", returnsObject().params(Type.OBJECT)) { it.target?.setPickles(it.getInt(0).toInt()) }
                .function("minimumPickles", returnsObject().noParams()) { it.target?.minimumPickles }
                .function("maximumPickles", returnsObject().noParams()) { it.target?.maximumPickles }
        }
    }
}
