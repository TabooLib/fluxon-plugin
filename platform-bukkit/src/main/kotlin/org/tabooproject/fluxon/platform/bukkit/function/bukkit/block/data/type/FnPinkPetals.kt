package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.PinkPetals
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

@Requires(classes = ["org.bukkit.block.data.type.PinkPetals"])
@PlatformSide(Platform.BUKKIT)
object FnPinkPetals {

    val TYPE = Type.fromClass(PinkPetals::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PinkPetals::class.java)
                .function("flowerAmount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.flowerAmount ?: 0) }
                .function("setFlowerAmount", returnsVoid().params(Type.I)) { it.target?.setFlowerAmount(it.getInt(0).toInt()) }
                .function("maximumFlowerAmount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumFlowerAmount ?: 0) }
        }
    }
}
