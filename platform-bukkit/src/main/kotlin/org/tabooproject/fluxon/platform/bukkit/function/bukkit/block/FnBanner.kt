package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.DyeColor
import org.bukkit.block.Banner
import org.bukkit.block.banner.Pattern
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.banner.FnPattern
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Banner"])
@PlatformSide(Platform.BUKKIT)
object FnBanner {

    val TYPE = Type.fromClass(Banner::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Banner::class.java)
                .function("baseColor", returns(FnDyeColor.TYPE).noParams()) { it.setReturnRef(it.target?.baseColor) }
                .function("setBaseColor", returnsVoid().params(FnDyeColor.TYPE)) { it.target?.setBaseColor(it.getRef(0) as DyeColor) }
                .function("setBaseColor", returnsVoid().params(Type.STRING)) { FnDyeColor.enumValue(it.getString(0))?.let { p0 -> it.target?.setBaseColor(p0) } }
                .function("patterns", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.patterns) }
                .function("setPatterns", returnsVoid().params(Type.LIST)) { it.target?.setPatterns(it.getRef(0) as List<Pattern>) }
                .function("addPattern", returnsVoid().params(FnPattern.TYPE)) { it.target?.addPattern(it.getRef(0) as Pattern) }
                .function("getPattern", returns(FnPattern.TYPE).params(Type.I)) { it.setReturnRef(it.target?.getPattern(it.getInt(0).toInt())) }
                .function("removePattern", returns(FnPattern.TYPE).params(Type.I)) { it.setReturnRef(it.target?.removePattern(it.getInt(0).toInt())) }
                .function("setPattern", returnsVoid().params(Type.I, FnPattern.TYPE)) {
                    it.target?.setPattern(
                        it.getInt(0).toInt(),
                        it.getRef(1) as Pattern
                    )
                }
                .function("numberOfPatterns", returns(Type.I).noParams()) { it.setReturnInt(it.target?.numberOfPatterns() ?: 0) }
        }
    }
}
