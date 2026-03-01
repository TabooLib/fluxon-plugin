package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.bukkit.persistence.PersistentDataHolder
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.persistence.PersistentDataHolder"])
@PlatformSide(Platform.BUKKIT)
object FnPersistentDataHolder {

    val TYPE = Type.fromClass(PersistentDataHolder::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataHolder::class.java)
                .function("persistentDataContainer",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataContainer.TYPE).noParams()) { it.setReturnRef(it.target?.persistentDataContainer) }
        }
    }
}
