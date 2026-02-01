package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.SeaPickle
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

@Requires(classes = ["org.bukkit.block.data.type.SeaPickle"])
@PlatformSide(Platform.BUKKIT)
object FnSeaPickle {

    val TYPE = Type.fromClass(SeaPickle::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SeaPickle::class.java)
                .function("pickles", returns(Type.I).noParams()) { it.setReturnInt(it.target?.pickles ?: 0) }
                .function("setPickles", returnsVoid().params(Type.I)) { it.target?.setPickles(it.getInt(0).toInt()) }
                .function("minimumPickles", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minimumPickles ?: 0) }
                .function("maximumPickles", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumPickles ?: 0) }
        }
    }
}
