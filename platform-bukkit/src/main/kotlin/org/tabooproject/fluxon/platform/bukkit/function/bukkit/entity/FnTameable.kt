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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.entity.Tameable"])
@PlatformSide(Platform.BUKKIT)
object FnTameable {

    val TYPE = Type.fromClass(Tameable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tameable::class.java)
//                .function("ownerUniqueId", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.ownerUniqueId?.toString()) }
                .function("isTamed", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTamed ?: false) }
                .function("setTamed", returnsVoid().params(Type.Z)) { it.target?.setTamed(it.getBool(0)) }
                .function("owner",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAnimalTamer.TYPE).noParams()) { it.setReturnRef(it.target?.owner) }
                .function("setOwner",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAnimalTamer.TYPE)) { it.target?.setOwner(it.getRef(0) as AnimalTamer) }
        }
    }
}
