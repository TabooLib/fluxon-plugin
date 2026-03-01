package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.bukkit.persistence.PersistentDataAdapterContext
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.persistence.PersistentDataAdapterContext"])
@PlatformSide(Platform.BUKKIT)
object FnPersistentDataAdapterContext {

    val TYPE = Type.fromClass(PersistentDataAdapterContext::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataAdapterContext::class.java)
                .function("newPersistentDataContainer",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataContainer.TYPE).noParams()) { it.setReturnRef(it.target?.newPersistentDataContainer()) }
        }
    }
}
