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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.scoreboard.Criteria"])
@PlatformSide(Platform.BUKKIT)
object FnCriteria {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Criteria::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("isReadOnly", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isReadOnly) }
                .function("defaultRenderType", returnsObject().noParams()) { it.setReturnRef(it.target?.defaultRenderType) }
                // static
                .function("statistic", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        Criteria.statistic(it.getRef(0) as Statistic)
                    } else {
                        when (val var2 = it.getRef(1)) {
                            is Material -> Criteria.statistic(it.getRef(0) as Statistic, var2)
                            is EntityType -> Criteria.statistic(it.getRef(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("第二个参数必须是 Material 或 EntityType 类型")
                        }
                    })
                }
                .function("statistic", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        Criteria.statistic(it.getRef(0) as Statistic)
                    } else {
                        when (val var2 = it.getRef(1)) {
                            is Material -> Criteria.statistic(it.getRef(0) as Statistic, var2)
                            is EntityType -> Criteria.statistic(it.getRef(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("第二个参数必须是 Material 或 EntityType 类型")
                        }
                    })
                }
                // static
                .function("create", returnsObject().params(Type.OBJECT)) { it.setReturnRef(Criteria.create(it.getString(0)!!)) }
        }
    }
}
