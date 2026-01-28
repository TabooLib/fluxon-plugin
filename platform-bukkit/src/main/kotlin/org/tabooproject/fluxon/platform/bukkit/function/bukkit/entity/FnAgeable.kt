package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Ageable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Ageable"])
@PlatformSide(Platform.BUKKIT)
object FnAgeable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ageable::class.java)
                .function("age", returnsObject().noParams()) { it.setReturnRef(it.target?.age) }
                .function("setAge", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAge(it.getInt(0).toInt())) }
                .function("setAgeLock", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAgeLock(it.getBool(0))) }
                .function("ageLock", returnsObject().noParams()) { it.setReturnRef(it.target?.ageLock) }
                .function("setBaby", returnsObject().noParams()) { it.setReturnRef(it.target?.setBaby()) }
                .function("setAdult", returnsObject().noParams()) { it.setReturnRef(it.target?.setAdult()) }
                .function("isAdult", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isAdult) }
                .function("canBreed", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.canBreed()) }
                .function("setBreed", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBreed(it.getBool(0))) }
        }
    }
}
