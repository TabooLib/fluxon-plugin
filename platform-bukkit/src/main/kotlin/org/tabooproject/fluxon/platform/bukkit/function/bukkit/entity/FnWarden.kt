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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Warden"])
@PlatformSide(Platform.BUKKIT)
object FnWarden {

    val TYPE = Type.fromClass(Warden::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Warden::class.java)
                .function("anger", returns(Type.I).noParams()) { it.setReturnInt(it.target?.anger ?: 0) }
                .function("getAnger", returns(Type.I).params(Type.OBJECT)) { it.setReturnInt(it.target?.getAnger(it.getRef(0) as Entity) ?: 0) }
                .function("increaseAnger", returnsVoid().params(Type.OBJECT, Type.I)) {
                    it.target?.increaseAnger(
                        it.getRef(0) as Entity,
                        it.getInt(1).toInt()
                    )
                }
                .function("setAnger", returnsVoid().params(Type.OBJECT, Type.I)) {
                    it.target?.setAnger(it.getRef(0) as Entity, it.getInt(1).toInt())
                }
                .function("clearAnger", returnsVoid().params(Type.OBJECT)) { it.target?.clearAnger(it.getRef(0) as Entity) }
                .function("entityAngryAt", returnsObject().noParams()) { it.setReturnRef(it.target?.entityAngryAt) }
                .function("setDisturbanceLocation", returnsVoid().params(Type.OBJECT)) { it.target?.setDisturbanceLocation(it.getRef(0) as Location) }
                .function("angerLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.angerLevel) }
        }
    }
}
