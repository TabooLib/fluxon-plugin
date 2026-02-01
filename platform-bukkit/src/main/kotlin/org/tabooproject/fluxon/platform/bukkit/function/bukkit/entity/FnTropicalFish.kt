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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.TropicalFish"])
@PlatformSide(Platform.BUKKIT)
object FnTropicalFish {

    val TYPE = Type.fromClass(TropicalFish::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TropicalFish::class.java)
                .function("patternColor", returnsObject().noParams()) { it.setReturnRef(it.target?.patternColor) }
                .function("setPatternColor", returnsVoid().params(Type.OBJECT)) { it.target?.setPatternColor(it.getRef(0) as DyeColor) }
                .function("bodyColor", returnsObject().noParams()) { it.setReturnRef(it.target?.bodyColor) }
                .function("setBodyColor", returnsVoid().params(Type.OBJECT)) { it.target?.setBodyColor(it.getRef(0) as DyeColor) }
                .function("pattern", returnsObject().noParams()) { it.setReturnRef(it.target?.pattern) }
                .function("setPattern", returnsVoid().params(Type.OBJECT)) { it.target?.setPattern(it.getRef(0) as TropicalFish.Pattern) }
        }
    }
}
