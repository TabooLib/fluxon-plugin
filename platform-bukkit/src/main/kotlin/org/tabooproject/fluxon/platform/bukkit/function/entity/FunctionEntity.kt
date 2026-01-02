package org.tabooproject.fluxon.platform.bukkit.function.entity

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FunctionEntity {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Entity::class.java)
                .function("uniqueId", 0) {
                    it.target?.uniqueId
                }
                .function("type", 0) {
                    it.target?.type
                }
                .function("name", 0) {
                    it.target?.name
                }
                .function("vehicle", 0) {
                    it.target?.vehicle
                }
                .function("passengers", 0) {
                    it.target?.passengers
                }

                // 位置
                .function("world", 0) {
                    it.target?.world
                }
                .function("location", 0) {
                    it.target?.location
                }
                .syncFunction("teleport", 1) {
                    it.target?.teleport(it.getArgumentByType(0, Location::class.java)!!)
                }
                .function("velocity", 0) {
                    it.target?.velocity
                }
                .syncFunction("setVelocity", 1) {
                    it.target?.setVelocity(it.getArgumentByType(0, Vector::class.java)!!)
                }
        }
    }
}