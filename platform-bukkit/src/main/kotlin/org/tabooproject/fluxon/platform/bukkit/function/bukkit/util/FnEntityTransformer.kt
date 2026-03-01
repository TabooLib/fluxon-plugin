package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.entity.Entity
import org.bukkit.generator.LimitedRegion
import org.bukkit.util.EntityTransformer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.EntityTransformer"])
@PlatformSide(Platform.BUKKIT)
object FnEntityTransformer {

    val TYPE = Type.fromClass(EntityTransformer::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityTransformer::class.java)
                .function("transform",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnLimitedRegion.TYPE, Type.I, Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, Type.Z)) {
                    it.setReturnRef(it.target?.transform(
                        it.getRef(0) as LimitedRegion,
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as Entity,
                        it.getBool(5)
                    ))
                }
        }
    }
}
