package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.DyeColor
import org.bukkit.block.Banner
import org.bukkit.block.banner.Pattern
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Banner"])
@PlatformSide(Platform.BUKKIT)
object FnBanner {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Banner::class.java)
                .function("baseColor", returnsObject().noParams()) { it.setReturnRef(it.target?.baseColor) }
                .function("setBaseColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBaseColor(it.getRef(0) as DyeColor)) }
                .function("patterns", returnsObject().noParams()) { it.setReturnRef(it.target?.patterns) }
                .function("setPatterns", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPatterns(it.getRef(0) as List<Pattern>)) }
                .function("addPattern", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addPattern(it.getRef(0) as Pattern)) }
                .function("getPattern", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getPattern(it.getInt(0).toInt())) }
                .function("removePattern", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removePattern(it.getInt(0).toInt())) }
                .function("setPattern", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setPattern(
                        it.getInt(0).toInt(),
                        it.getRef(1) as Pattern
                    ))
                }
                .function("numberOfPatterns", returnsObject().noParams()) { it.setReturnRef(it.target?.numberOfPatterns()) }
        }
    }
}
