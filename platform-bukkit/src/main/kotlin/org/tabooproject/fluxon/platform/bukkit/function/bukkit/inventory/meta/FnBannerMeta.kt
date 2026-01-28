package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.block.banner.Pattern
import org.bukkit.inventory.meta.BannerMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.BannerMeta"])
@PlatformSide(Platform.BUKKIT)
object FnBannerMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BannerMeta::class.java)
                .function("patterns", returnsObject().noParams()) { it.target?.patterns }
                .function("setPatterns", returnsObject().params(Type.OBJECT)) { it.target?.setPatterns(it.getRef(0) as List<Pattern>) }
                .function("addPattern", returnsObject().params(Type.OBJECT)) { it.target?.addPattern(it.getRef(0) as Pattern) }
                .function("getPattern", returnsObject().params(Type.OBJECT)) { it.target?.getPattern(it.getInt(0).toInt()) }
                .function("removePattern", returnsObject().params(Type.OBJECT)) { it.target?.removePattern(it.getInt(0).toInt()) }
                .function("setPattern", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setPattern(
                        it.getInt(0).toInt(),
                        it.getRef(1) as Pattern
                    )
                }
                .function("numberOfPatterns", returnsObject().noParams()) { it.target?.numberOfPatterns() }
        }
    }
}
