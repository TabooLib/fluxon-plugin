package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Statistic
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.Statistic"])
@PlatformSide(Platform.BUKKIT)
object FnStatistic {

    val TYPE = Type.fromClass(Statistic::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Statistic::class.java)
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("isSubstatistic", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSubstatistic ?: false) }
                .function("isBlock", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBlock ?: false) }
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
        }
    }
}
