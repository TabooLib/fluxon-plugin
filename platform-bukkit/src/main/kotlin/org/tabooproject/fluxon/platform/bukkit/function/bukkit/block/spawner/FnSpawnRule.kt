package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.spawner

import org.bukkit.block.spawner.SpawnRule
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSpawnRule {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnRule::class.java)
                .function("minBlockLight", 0) { it.target?.minBlockLight }
                .function("setMinBlockLight", 1) { it.target?.setMinBlockLight(it.getNumber(0).toInt()) }
                .function("maxBlockLight", 0) { it.target?.maxBlockLight }
                .function("setMaxBlockLight", 1) { it.target?.setMaxBlockLight(it.getNumber(0).toInt()) }
                .function("minSkyLight", 0) { it.target?.minSkyLight }
                .function("setMinSkyLight", 1) { it.target?.setMinSkyLight(it.getNumber(0).toInt()) }
                .function("maxSkyLight", 0) { it.target?.maxSkyLight }
                .function("setMaxSkyLight", 1) { it.target?.setMaxSkyLight(it.getNumber(0).toInt()) }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("clone", 0) { it.target?.clone() }
                .function("deserialize", 1) { SpawnRule.deserialize(it.getArgument(0) as Map<String, Any>) }
        }
    }
}
