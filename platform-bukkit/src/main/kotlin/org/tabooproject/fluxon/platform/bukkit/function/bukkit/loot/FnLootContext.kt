package org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot

import org.bukkit.entity.Entity
import org.bukkit.entity.HumanEntity
import org.bukkit.loot.LootContext
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLootContext {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootContext::class.java)
                .function("location", 0) { it.target?.location }
                .function("luck", 0) { it.target?.luck }
                .function("lootingModifier", 0) { it.target?.lootingModifier }
                .function("lootedEntity", 0) { it.target?.lootedEntity }
                .function("killer", 0) { it.target?.killer }

            registerExtension(LootContext.Builder::class.java)
                .function("luck", 1) { it.target?.luck(it.getNumber(0).toFloat()) }
                .function("lootingModifier", 1) { it.target?.lootingModifier(it.getNumber(0).toInt()) }
                .function("lootedEntity", 1) { it.target?.lootedEntity(it.getArgument(0) as Entity) }
                .function("killer", 1) { it.target?.killer(it.getArgument(0) as HumanEntity) }
                .function("build", 0) { it.target?.build() }
        }
    }
}
