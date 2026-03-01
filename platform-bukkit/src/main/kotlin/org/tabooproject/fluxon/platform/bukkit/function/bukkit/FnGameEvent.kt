package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.GameEvent
import org.bukkit.NamespacedKey
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.GameEvent"])
@PlatformSide(Platform.BUKKIT)
object FnGameEvent {

    val TYPE = Type.fromClass(GameEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GameEvent::class.java)
                // static
                .function("getByKey",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnGameEvent.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.setReturnRef(GameEvent.getByKey(it.getRef(0) as NamespacedKey)) }
                // static
                .function("values",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(GameEvent.values()) }
        }
    }
}
