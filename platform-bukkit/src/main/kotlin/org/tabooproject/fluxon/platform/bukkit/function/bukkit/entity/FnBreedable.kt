package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Breedable
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

@Requires(classes = ["org.bukkit.entity.Breedable"])
@PlatformSide(Platform.BUKKIT)
object FnBreedable {

    val TYPE = Type.fromClass(Breedable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Breedable::class.java)
                .function("setAgeLock", returnsVoid().params(Type.Z)) { it.target?.setAgeLock(it.getBool(0)) }
                .function("ageLock", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.ageLock ?: false) }
                .function("canBreed", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canBreed() ?: false) }
                .function("setBreed", returnsVoid().params(Type.Z)) { it.target?.setBreed(it.getBool(0)) }
        }
    }
}
