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

@Requires(classes = ["org.bukkit.GameEvent"])
@PlatformSide(Platform.BUKKIT)
object FnGameEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GameEvent::class.java)
                // static
                .function("getByKey", returnsObject().params(Type.OBJECT)) { GameEvent.getByKey(it.getRef(0) as NamespacedKey) }
                // static
                .function("values", returnsObject().noParams()) { GameEvent.values() }
        }
    }
}
