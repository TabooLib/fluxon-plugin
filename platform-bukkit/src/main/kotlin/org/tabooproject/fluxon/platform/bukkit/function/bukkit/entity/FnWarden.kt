package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.Warden
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Warden"])
@PlatformSide(Platform.BUKKIT)
object FnWarden {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Warden::class.java)
                .function("anger", returnsObject().noParams()) { it.setReturnRef(it.target?.anger) }
                .function("getAnger", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getAnger(it.getRef(0) as Entity)) }
                .function("increaseAnger", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.increaseAnger(
                        it.getRef(0) as Entity,
                        it.getInt(1).toInt()
                    ))
                }
                .function("setAnger", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.setAnger(it.getRef(0) as Entity, it.getInt(1).toInt())) }
                .function("clearAnger", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.clearAnger(it.getRef(0) as Entity)) }
                .function("entityAngryAt", returnsObject().noParams()) { it.setReturnRef(it.target?.entityAngryAt) }
                .function("setDisturbanceLocation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDisturbanceLocation(it.getRef(0) as Location)) }
                .function("angerLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.angerLevel) }
        }
    }
}
