package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.EntitySnapshot
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.EntitySnapshot"])
@PlatformSide(Platform.BUKKIT)
object FnEntitySnapshot {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntitySnapshot::class.java)
                .function("createEntity", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is World -> it.target?.createEntity(var1)
                        is Location -> it.target?.createEntity(var1)
                        else -> throw IllegalArgumentException("参数必须是 World 或 Location 类型")
                    }
                }
                .function("entityType", 0) { it.target?.entityType }
        }
    }
}
