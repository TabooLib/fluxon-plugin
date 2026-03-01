package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.potion.PotionEffectTypeWrapper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.potion.PotionEffectTypeWrapper"])
@PlatformSide(Platform.BUKKIT)
object FnPotionEffectTypeWrapper {

    val TYPE = Type.fromClass(PotionEffectTypeWrapper::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionEffectTypeWrapper::class.java)
                .function("type",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffectType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
        }
    }
}
