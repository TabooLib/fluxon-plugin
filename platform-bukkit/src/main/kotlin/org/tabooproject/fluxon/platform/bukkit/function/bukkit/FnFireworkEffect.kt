package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Color
import org.bukkit.FireworkEffect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.FireworkEffect"])
@PlatformSide(Platform.BUKKIT)
object FnFireworkEffect {

    val TYPE = Type.fromClass(FireworkEffect::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkEffect::class.java)
                // static
                .function("builder",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectBuilder.TYPE).noParams()) { it.setReturnRef(FireworkEffect.builder()) }
                .function("hasFlicker", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasFlicker() ?: false) }
                .function("hasTrail", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasTrail() ?: false) }
                .function("colors",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.colors) }
                .function("fadeColors",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.fadeColors) }
                .function("type", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                // static
                .function("deserialize", returns(Type.fromClass(org.bukkit.configuration.serialization.ConfigurationSerializable::class.java)).params(Type.MAP)) { it.setReturnRef(FireworkEffect.deserialize(it.getRef(0) as Map<String, Any>)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}

@Requires(classes = ["org.bukkit.FireworkEffect\$Builder"])
@PlatformSide(Platform.BUKKIT)
object FnFireworkEffectBuilder {

    val TYPE = Type.fromClass(FireworkEffect.Builder::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkEffect.Builder::class.java)
                .function("with", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectBuilder.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectType.TYPE)) { it.setReturnRef(it.target?.with(it.getRef(0) as FireworkEffect.Type))  }
                .function("with", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectBuilder.TYPE).params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectType.enumValue(it.getString(0))?.let { p0 -> it.setReturnRef(it.target?.with(p0))  } }
                .function("withFlicker", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectBuilder.TYPE).noParams()) { it.setReturnRef(it.target?.withFlicker()) }
                .function("flicker", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectBuilder.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.flicker(it.getBool(0))) }
                .function("withTrail", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectBuilder.TYPE).noParams()) { it.setReturnRef(it.target?.withTrail()) }
                .function("trail", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectBuilder.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.trail(it.getBool(0))) }
                .function("withColor",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectBuilder.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE)) { it.setReturnRef(it.target?.withColor(it.getRef(0) as Color)) }
                .function("withFade",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffectBuilder.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE)) { it.setReturnRef(it.target?.withFade(it.getRef(0) as Color)) }
                .function("build", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffect.TYPE).noParams()) { it.setReturnRef(it.target?.build()) }
        }
    }
}
