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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.TropicalFishBucketMeta"])
@PlatformSide(Platform.BUKKIT)
object FnTropicalFishBucketMeta {

    val TYPE = Type.fromClass(TropicalFishBucketMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TropicalFishBucketMeta::class.java)
                .function("patternColor",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE).noParams()) { it.setReturnRef(it.target?.patternColor) }
                .function("setPatternColor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE)) { it.target?.setPatternColor(it.getRef(0) as DyeColor) }
                .function("bodyColor",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE).noParams()) { it.setReturnRef(it.target?.bodyColor) }
                .function("setBodyColor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE)) { it.target?.setBodyColor(it.getRef(0) as DyeColor) }
                .function("setPattern", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnTropicalFishPattern.TYPE)) { it.target?.setPattern(it.getRef(0) as TropicalFish.Pattern)  }
                .function("setPattern", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnTropicalFishPattern.enumValue(it.getString(0))?.let { p0 -> it.target?.setPattern(p0)  } }
                .function("hasVariant", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasVariant() ?: false) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnTropicalFishBucketMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
