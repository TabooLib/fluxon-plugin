package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.persistence.ListPersistentDataType"])
@PlatformSide(Platform.BUKKIT)
object FnListPersistentDataType {

    val TYPE = Type.fromClass(org.bukkit.persistence.ListPersistentDataType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.persistence.ListPersistentDataType::class.java)
                .function("elementType", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.elementType()) }
        }
    }
}
