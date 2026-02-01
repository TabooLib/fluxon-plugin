package org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement

import org.bukkit.advancement.Advancement
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.advancement.Advancement"])
@PlatformSide(Platform.BUKKIT)
object FnAdvancement {

    val TYPE = Type.fromClass(Advancement::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Advancement::class.java)
                .function("criteria", returns(StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.criteria) }
                .function("display", returns(FnAdvancementDisplay.TYPE).noParams()) { it.setReturnRef(it.target?.display) }
        }
    }
}
