package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.ArmorMeta
import org.bukkit.inventory.meta.trim.ArmorTrim
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

@Requires(classes = ["org.bukkit.inventory.meta.ArmorMeta"])
@PlatformSide(Platform.BUKKIT)
object FnArmorMeta {

    val TYPE = Type.fromClass(ArmorMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ArmorMeta::class.java)
                .function("hasTrim", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasTrim() ?: false) }
                .function("setTrim",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.trim.FnArmorTrim.TYPE)) { it.target?.setTrim(it.getRef(0) as ArmorTrim) }
                .function("trim", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.trim.FnArmorTrim.TYPE).noParams()) { it.setReturnRef(it.target?.trim) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnArmorMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
