package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.AnaloguePowerable
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

@Requires(classes = ["org.bukkit.block.data.AnaloguePowerable"])
@PlatformSide(Platform.BUKKIT)
object FnAnaloguePowerable {

    val TYPE = Type.fromClass(AnaloguePowerable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AnaloguePowerable::class.java)
                .function("power", returns(Type.I).noParams()) { it.setReturnInt(it.target?.power ?: 0) }
                .function("setPower", returnsVoid().params(Type.I)) { it.target?.setPower(it.getInt(0).toInt()) }
                .function("maximumPower", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumPower ?: 0) }
        }
    }
}
