package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.DyeColor
import org.bukkit.entity.TropicalFish
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.TropicalFish"])
@PlatformSide(Platform.BUKKIT)
object FnTropicalFish {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TropicalFish::class.java)
                .function("patternColor", returnsObject().noParams()) { it.setReturnRef(it.target?.patternColor) }
                .function("setPatternColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPatternColor(it.getRef(0) as DyeColor)) }
                .function("bodyColor", returnsObject().noParams()) { it.setReturnRef(it.target?.bodyColor) }
                .function("setBodyColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBodyColor(it.getRef(0) as DyeColor)) }
                .function("pattern", returnsObject().noParams()) { it.setReturnRef(it.target?.pattern) }
                .function("setPattern", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPattern(it.getRef(0) as TropicalFish.Pattern)) }
        }
    }
}
