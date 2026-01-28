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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Statistic::class.java)
                .function("type", returnsObject().noParams()) { it.target?.type }
                .function("isSubstatistic", returns(Type.Z).noParams()) { it.target?.isSubstatistic }
                .function("isBlock", returns(Type.Z).noParams()) { it.target?.isBlock }
                .function("key", returnsObject().noParams()) { it.target?.key }
        }
    }
}
