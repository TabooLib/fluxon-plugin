package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.banner

import org.bukkit.block.banner.Pattern
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.banner.Pattern"])
@PlatformSide(Platform.BUKKIT)
object FnPattern {

    val TYPE = Type.fromClass(Pattern::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Pattern::class.java)
                .function("color", returns(FnDyeColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("pattern", returns(FnPatternType.TYPE).noParams()) { it.setReturnRef(it.target?.pattern) }
        }
    }
}
