package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.Statistic
import org.bukkit.scoreboard.Criteria
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCriteria {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Criteria::class.java)
                .function("name", 0) { it.target?.name }
                .function("isReadOnly", 0) { it.target?.isReadOnly }
                .function("defaultRenderType", 0) { it.target?.defaultRenderType }
                // static
                .function("statistic", 2) {
                    // static Criteria statistic(@NotNull Statistic statistic, @NotNull Material material)
                    // static Criteria statistic(@NotNull Statistic statistic, @NotNull EntityType entityType)
                    TODO()
                }
                // static
                .function("statistic", 1) { Criteria.statistic(it.getArgument(0) as Statistic) }
                // static
                .function("create", 1) { Criteria.create(it.getString(0)!!) }
        }
    }
}
