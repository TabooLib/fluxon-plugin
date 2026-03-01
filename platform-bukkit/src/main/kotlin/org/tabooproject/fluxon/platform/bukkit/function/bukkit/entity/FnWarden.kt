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
                .function("getAnger",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.setReturnInt(it.target?.getAnger(it.getRef(0) as Entity) ?: 0) }
                .function("increaseAnger",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, Type.I)) {
                    it.target?.increaseAnger(
                        it.getRef(0) as Entity,
                        it.getInt(1).toInt()
                    )
                }
                .function("setAnger",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, Type.I)) {
                    it.target?.setAnger(it.getRef(0) as Entity, it.getInt(1).toInt())
                }
                .function("clearAnger",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.target?.clearAnger(it.getRef(0) as Entity) }
                .function("entityAngryAt",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE).noParams()) { it.setReturnRef(it.target?.entityAngryAt) }
                .function("setDisturbanceLocation",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.target?.setDisturbanceLocation(it.getRef(0) as Location) }
                .function("angerLevel", returns(Type.fromClass(Warden.AngerLevel::class.java)).noParams()) { it.setReturnRef(it.target?.angerLevel) }
        }
    }
}
