package org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage

import org.bukkit.damage.DamageEffect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.damage.DamageEffect"])
@PlatformSide(Platform.BUKKIT)
object FnDamageEffect {

    val TYPE = Type.fromClass(DamageEffect::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DamageEffect::class.java)
                .function("sound",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE).noParams()) { it.setReturnRef(it.target?.sound) }
        }
    }
}
