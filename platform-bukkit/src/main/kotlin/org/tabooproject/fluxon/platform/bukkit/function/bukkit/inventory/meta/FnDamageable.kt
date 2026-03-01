package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.Damageable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.Damageable"])
@PlatformSide(Platform.BUKKIT)
object FnDamageable {

    val TYPE = Type.fromClass(Damageable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Damageable::class.java)
                .function("hasDamage", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasDamage() ?: false) }
                .function("damage", returns(Type.I).noParams()) { it.setReturnInt(it.target?.damage ?: 0) }
                .function("setDamage", returnsVoid().params(Type.I)) { it.target?.setDamage(it.getInt(0)) }
                .function("hasMaxDamage", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasMaxDamage() ?: false) }
                .function("maxDamage", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxDamage ?: 0) }
                .function("setMaxDamage", returnsVoid().params(Type.I)) { it.target?.setMaxDamage(it.getInt(0)) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnDamageable.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
