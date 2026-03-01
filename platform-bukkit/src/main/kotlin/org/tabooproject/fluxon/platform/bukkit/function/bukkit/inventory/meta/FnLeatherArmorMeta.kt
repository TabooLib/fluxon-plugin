package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.Color
import org.bukkit.inventory.meta.LeatherArmorMeta
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

@Requires(classes = ["org.bukkit.inventory.meta.LeatherArmorMeta"])
@PlatformSide(Platform.BUKKIT)
object FnLeatherArmorMeta {

    val TYPE = Type.fromClass(LeatherArmorMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LeatherArmorMeta::class.java)
                .function("color",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE)) { it.target?.setColor(it.getRef(0) as Color) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnLeatherArmorMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
