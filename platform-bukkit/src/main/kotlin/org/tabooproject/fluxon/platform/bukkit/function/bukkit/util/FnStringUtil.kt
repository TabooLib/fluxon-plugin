package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.StringUtil
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.StringUtil"])
@PlatformSide(Platform.BUKKIT)
object FnStringUtil {

    val TYPE = Type.fromClass(StringUtil::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StringUtil::class.java)
                // static
                .function("startsWithIgnoreCase",returns(Type.Z).params(Type.STRING, Type.STRING)) {
                    it.setReturnRef(StringUtil.startsWithIgnoreCase(
                        it.getString(0)!!,
                        it.getString(1)!!
                    ))
                }
        }
    }
}
