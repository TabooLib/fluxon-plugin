package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Bee
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBee {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bee::class.java)
                .function("hive", 0) { it.target?.hive }
                .function("setHive", 1) { it.target?.setHive(it.getArgument(0) as Location) }
                .function("flower", 0) { it.target?.flower }
                .function("setFlower", 1) { it.target?.setFlower(it.getArgument(0) as Location) }
                .function("hasNectar", 0) { it.target?.hasNectar() }
                .function("setHasNectar", 1) { it.target?.setHasNectar(it.getBoolean(0)) }
                .function("hasStung", 0) { it.target?.hasStung() }
                .function("setHasStung", 1) { it.target?.setHasStung(it.getBoolean(0)) }
                .function("anger", 0) { it.target?.anger }
                .function("setAnger", 1) { it.target?.setAnger(it.getNumber(0).toInt()) }
                .function("cannotEnterHiveTicks", 0) { it.target?.cannotEnterHiveTicks }
                .function("setCannotEnterHiveTicks", 1) { it.target?.setCannotEnterHiveTicks(it.getNumber(0).toInt()) }
        }
    }
}
