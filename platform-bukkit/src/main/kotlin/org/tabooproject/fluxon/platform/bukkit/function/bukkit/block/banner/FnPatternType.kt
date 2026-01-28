package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.banner

import org.bukkit.block.banner.PatternType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.banner.PatternType"])
@PlatformSide(Platform.BUKKIT)
object FnPatternType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PatternType::class.java)
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
                .function("identifier", returnsObject().noParams()) { it.setReturnRef(it.target?.identifier) }
        }
    }
}
