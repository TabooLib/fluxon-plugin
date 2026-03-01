package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.entity.EntityType
import org.bukkit.material.SpawnEgg
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.SpawnEgg"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnEgg {

    val TYPE = Type.fromClass(SpawnEgg::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnEgg::class.java)
                .function("spawnedType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE).noParams()) { it.setReturnRef(it.target?.spawnedType) }
                .function("setSpawnedType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE)) { it.target?.setSpawnedType(it.getRef(0) as EntityType) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
