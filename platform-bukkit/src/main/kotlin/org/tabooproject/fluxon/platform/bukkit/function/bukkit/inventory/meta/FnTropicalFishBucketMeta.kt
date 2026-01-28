package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.DyeColor
import org.bukkit.entity.TropicalFish
import org.bukkit.inventory.meta.TropicalFishBucketMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.TropicalFishBucketMeta"])
@PlatformSide(Platform.BUKKIT)
object FnTropicalFishBucketMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TropicalFishBucketMeta::class.java)
                .function("patternColor", returnsObject().noParams()) { it.target?.patternColor }
                .function("setPatternColor", returnsObject().params(Type.OBJECT)) { it.target?.setPatternColor(it.getRef(0) as DyeColor) }
                .function("bodyColor", returnsObject().noParams()) { it.target?.bodyColor }
                .function("setBodyColor", returnsObject().params(Type.OBJECT)) { it.target?.setBodyColor(it.getRef(0) as DyeColor) }
                .function("setPattern", returnsObject().params(Type.OBJECT)) { it.target?.setPattern(it.getRef(0) as TropicalFish.Pattern) }
                .function("hasVariant", returns(Type.Z).noParams()) { it.target?.hasVariant() }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
