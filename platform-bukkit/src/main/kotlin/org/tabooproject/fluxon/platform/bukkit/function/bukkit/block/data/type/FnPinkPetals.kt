package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.PinkPetals
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.PinkPetals"])
@PlatformSide(Platform.BUKKIT)
object FnPinkPetals {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PinkPetals::class.java)
                .function("flowerAmount", returnsObject().noParams()) { it.setReturnRef(it.target?.flowerAmount) }
                .function("setFlowerAmount", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFlowerAmount(it.getInt(0).toInt())) }
                .function("maximumFlowerAmount", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumFlowerAmount) }
        }
    }
}
