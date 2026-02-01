package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Bee
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

@Requires(classes = ["org.bukkit.entity.Bee"])
@PlatformSide(Platform.BUKKIT)
object FnBee {

    val TYPE = Type.fromClass(Bee::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bee::class.java)
                .function("hive", returnsObject().noParams()) { it.setReturnRef(it.target?.hive) }
                .function("setHive", returnsVoid().params(Type.OBJECT)) { it.target?.setHive(it.getRef(0) as Location) }
                .function("flower", returnsObject().noParams()) { it.setReturnRef(it.target?.flower) }
                .function("setFlower", returnsVoid().params(Type.OBJECT)) { it.target?.setFlower(it.getRef(0) as Location) }
                .function("hasNectar", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasNectar() ?: false) }
                .function("setHasNectar", returnsVoid().params(Type.Z)) { it.target?.setHasNectar(it.getBool(0)) }
                .function("hasStung", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasStung() ?: false) }
                .function("setHasStung", returnsVoid().params(Type.Z)) { it.target?.setHasStung(it.getBool(0)) }
                .function("anger", returns(Type.I).noParams()) { it.setReturnInt(it.target?.anger ?: 0) }
                .function("setAnger", returnsVoid().params(Type.I)) { it.target?.setAnger(it.getInt(0).toInt()) }
                .function("cannotEnterHiveTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.cannotEnterHiveTicks ?: 0) }
                .function("setCannotEnterHiveTicks", returnsVoid().params(Type.I)) { it.target?.setCannotEnterHiveTicks(it.getInt(0).toInt()) }
        }
    }
}
