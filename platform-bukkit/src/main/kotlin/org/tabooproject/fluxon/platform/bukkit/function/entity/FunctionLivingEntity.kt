package org.tabooproject.fluxon.platform.bukkit.function.entity

import org.bukkit.entity.LivingEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common5.cbool
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FunctionLivingEntity {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LivingEntity::class.java)
                .function("health", 0) {
                    it.target?.health
                }
                .function("maxHealth", 0) {
                    it.target?.maxHealth
                }
                .syncFunction("damage", 1) {
                    it.target?.damage(it.getNumber(0).toDouble())
                }
                .syncFunction("setHealth", 1) {
                    it.target?.setHealth(it.getNumber(0).toDouble())
                }
                .function("isCollidable", 0) {
                    it.target?.isCollidable
                }
                .function("setCollidable", 1) {
                    it.target?.apply { isCollidable = it.getArgument(0).cbool }
                }
        }
    }
}
