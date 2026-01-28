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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkEffect::class.java)
                // static
                .function("builder", returnsObject().noParams()) { it.setReturnRef(FireworkEffect.builder()) }
                .function("hasFlicker", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasFlicker()) }
                .function("hasTrail", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasTrail()) }
                .function("colors", returnsObject().noParams()) { it.setReturnRef(it.target?.colors) }
                .function("fadeColors", returnsObject().noParams()) { it.setReturnRef(it.target?.fadeColors) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                // static
                .function("deserialize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(FireworkEffect.deserialize(it.getRef(0) as Map<String, Any>)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnRef(it.target?.hashCode()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
        }
    }
}

@Requires(classes = ["org.bukkit.FireworkEffect.Builder"])
@PlatformSide(Platform.BUKKIT)
object FnFireworkEffectBuilder {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkEffect.Builder::class.java)
                .function("with", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.with(it.getRef(0) as FireworkEffect.Type)) }
                .function("withFlicker", returnsObject().noParams()) { it.setReturnRef(it.target?.withFlicker()) }
                .function("flicker", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.flicker(it.getBool(0))) }
                .function("withTrail", returnsObject().noParams()) { it.setReturnRef(it.target?.withTrail()) }
                .function("trail", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.trail(it.getBool(0))) }
                .function("withColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.withColor(it.getRef(0) as Color)) }
                .function("withFade", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.withFade(it.getRef(0) as Color)) }
                .function("build", returnsObject().noParams()) { it.setReturnRef(it.target?.build()) }
        }
    }
}
