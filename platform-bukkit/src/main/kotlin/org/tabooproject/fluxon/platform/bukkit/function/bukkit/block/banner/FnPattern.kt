package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.banner

import org.bukkit.block.banner.Pattern
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.banner.Pattern"])
@PlatformSide(Platform.BUKKIT)
object FnPattern {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Pattern::class.java)
                .function("color", returnsObject().noParams()) { it.target?.color }
                .function("pattern", returnsObject().noParams()) { it.target?.pattern }
                .function("hashCode", returns(Type.I).noParams()) { it.target?.hashCode() }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.target?.equals(it.getRef(0)) }
        }
    }
}
