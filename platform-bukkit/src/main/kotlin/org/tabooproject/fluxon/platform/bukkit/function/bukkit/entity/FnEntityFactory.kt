package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EntityFactory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.EntityFactory"])
@PlatformSide(Platform.BUKKIT)
object FnEntityFactory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityFactory::class.java)
                .function("createEntitySnapshot", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.createEntitySnapshot(it.getString(0)!!)) }
        }
    }
}
