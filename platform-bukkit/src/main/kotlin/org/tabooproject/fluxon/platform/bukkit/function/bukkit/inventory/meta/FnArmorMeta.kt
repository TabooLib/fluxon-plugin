package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.ArmorMeta
import org.bukkit.inventory.meta.trim.ArmorTrim
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.ArmorMeta"])
@PlatformSide(Platform.BUKKIT)
object FnArmorMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ArmorMeta::class.java)
                .function("hasTrim", returns(Type.Z).noParams()) { it.target?.hasTrim() }
                .function("setTrim", returnsObject().params(Type.OBJECT)) { it.target?.setTrim(it.getRef(0) as ArmorTrim) }
                .function("trim", returnsObject().noParams()) { it.target?.trim }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
