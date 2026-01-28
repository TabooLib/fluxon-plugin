package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Breedable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Breedable"])
@PlatformSide(Platform.BUKKIT)
object FnBreedable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Breedable::class.java)
                .function("setAgeLock", returnsObject().params(Type.OBJECT)) { it.target?.setAgeLock(it.getBool(0)) }
                .function("ageLock", returnsObject().noParams()) { it.target?.ageLock }
                .function("canBreed", returns(Type.Z).noParams()) { it.target?.canBreed() }
                .function("setBreed", returnsObject().params(Type.OBJECT)) { it.target?.setBreed(it.getBool(0)) }
        }
    }
}
