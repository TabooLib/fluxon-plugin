package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Ageable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Ageable"])
@PlatformSide(Platform.BUKKIT)
object FnAgeable {

    val TYPE = Type.fromClass(Ageable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ageable::class.java)
                .function("age", returns(Type.I).noParams()) { it.setReturnInt(it.target?.age ?: 0) }
                .function("setAge", returnsVoid().params(Type.I)) { it.target?.setAge(it.getInt(0)) }
                .function("setAgeLock", returnsVoid().params(Type.Z)) { it.target?.setAgeLock(it.getBool(0)) }
                .function("ageLock", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.ageLock ?: false) }
                .function("setBaby", returnsVoid().noParams()) { it.target?.setBaby() }
                .function("setAdult", returnsVoid().noParams()) { it.target?.setAdult() }
                .function("isAdult", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAdult ?: false) }
                .function("canBreed", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canBreed() ?: false) }
                .function("setBreed", returnsVoid().params(Type.Z)) { it.target?.setBreed(it.getBool(0)) }
        }
    }
}
