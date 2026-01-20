package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.Material
import org.bukkit.Statistic
import org.bukkit.entity.EntityType
import org.bukkit.scoreboard.Criteria
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCriteria {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Criteria::class.java)
                .function("name", 0) { it.target?.name }
                .function("isReadOnly", 0) { it.target?.isReadOnly }
                .function("defaultRenderType", 0) { it.target?.defaultRenderType }
                // static
                .function("statistic", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        Criteria.statistic(it.getArgument(0) as Statistic)
                    } else {
                        when (val var2 = it.getArgument(1)) {
                            is Material -> Criteria.statistic(it.getArgument(0) as Statistic, var2)
                            is EntityType -> Criteria.statistic(it.getArgument(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("第二个参数必须是 Material 或 EntityType 类型")
                        }
                    }
                }
                // static
                .function("create", 1) { Criteria.create(it.getString(0)!!) }
        }
    }
}
