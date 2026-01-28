package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.Damageable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.Damageable"])
@PlatformSide(Platform.BUKKIT)
object FnDamageable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Damageable::class.java)
                .function("hasDamage", returns(Type.Z).noParams()) { it.target?.hasDamage() }
                .function("damage", returnsObject().noParams()) { it.target?.damage }
                .function("setDamage", returnsObject().params(Type.OBJECT)) { it.target?.setDamage(it.getInt(0).toInt()) }
                .function("hasMaxDamage", returns(Type.Z).noParams()) { it.target?.hasMaxDamage() }
                .function("maxDamage", returnsObject().noParams()) { it.target?.maxDamage }
                .function("setMaxDamage", returnsObject().params(Type.OBJECT)) { it.target?.setMaxDamage(it.getInt(0).toInt()) }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
