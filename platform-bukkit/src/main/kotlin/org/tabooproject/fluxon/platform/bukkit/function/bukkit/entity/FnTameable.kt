package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AnimalTamer
import org.bukkit.entity.Tameable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.entity.Tameable"])
@PlatformSide(Platform.BUKKIT)
object FnTameable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tameable::class.java)
//                .function("ownerUniqueId", returnsObject().noParams()) { it.target?.ownerUniqueId?.toString() }
                .function("isTamed", returns(Type.Z).noParams()) { it.target?.isTamed }
                .function("setTamed", returnsObject().params(Type.OBJECT)) { it.target?.setTamed(it.getBool(0)) }
                .function("owner", returnsObject().noParams()) { it.target?.owner }
                .function("setOwner", returnsObject().params(Type.OBJECT)) { it.target?.setOwner(it.getRef(0) as AnimalTamer) }
        }
    }
}
