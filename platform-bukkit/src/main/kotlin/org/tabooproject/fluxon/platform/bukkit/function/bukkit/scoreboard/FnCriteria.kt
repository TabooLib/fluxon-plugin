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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.scoreboard.Criteria"])
@PlatformSide(Platform.BUKKIT)
object FnCriteria {

    val TYPE = Type.fromClass(Criteria::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Criteria::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("isReadOnly", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isReadOnly ?: false) }
                .function("defaultRenderType", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnRenderType.TYPE).noParams()) { it.setReturnRef(it.target?.defaultRenderType) }
                // static
                .function("statistic",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnCriteria.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE)) {
                    it.setReturnRef(Criteria.statistic(it.getRef(0) as Statistic))
                }
                .function("statistic", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnCriteria.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnRef(Criteria.statistic(it.getRef(0) as Statistic, it.getRef(1) as Material)) }
                .function("statistic", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnCriteria.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE)) { it.setReturnRef(Criteria.statistic(it.getRef(0) as Statistic, it.getRef(1) as EntityType)) }
                .function("statistic", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnCriteria.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.enumValue(it.getString(1))?.let { p1 ->
                        it.setReturnRef(Criteria.statistic(it.getRef(0) as Statistic, p1))
                    } ?: org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.enumValue(it.getString(1))?.let { p1 ->
                        it.setReturnRef(Criteria.statistic(it.getRef(0) as Statistic, p1))
                    }
                }
                // static
                .function("create",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnCriteria.TYPE).params(Type.STRING)) { it.setReturnRef(Criteria.create(it.getString(0)!!)) }
        }
    }
}
