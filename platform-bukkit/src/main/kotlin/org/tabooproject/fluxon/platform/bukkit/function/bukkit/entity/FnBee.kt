package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Bee
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Bee"])
@PlatformSide(Platform.BUKKIT)
object FnBee {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bee::class.java)
                .function("hive", returnsObject().noParams()) { it.target?.hive }
                .function("setHive", returnsObject().params(Type.OBJECT)) { it.target?.setHive(it.getRef(0) as Location) }
                .function("flower", returnsObject().noParams()) { it.target?.flower }
                .function("setFlower", returnsObject().params(Type.OBJECT)) { it.target?.setFlower(it.getRef(0) as Location) }
                .function("hasNectar", returns(Type.Z).noParams()) { it.target?.hasNectar() }
                .function("setHasNectar", returnsObject().params(Type.OBJECT)) { it.target?.setHasNectar(it.getBool(0)) }
                .function("hasStung", returns(Type.Z).noParams()) { it.target?.hasStung() }
                .function("setHasStung", returnsObject().params(Type.OBJECT)) { it.target?.setHasStung(it.getBool(0)) }
                .function("anger", returnsObject().noParams()) { it.target?.anger }
                .function("setAnger", returnsObject().params(Type.OBJECT)) { it.target?.setAnger(it.getInt(0).toInt()) }
                .function("cannotEnterHiveTicks", returnsObject().noParams()) { it.target?.cannotEnterHiveTicks }
                .function("setCannotEnterHiveTicks", returnsObject().params(Type.OBJECT)) { it.target?.setCannotEnterHiveTicks(it.getInt(0).toInt()) }
        }
    }
}
