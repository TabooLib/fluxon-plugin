package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.Bed"])
@PlatformSide(Platform.BUKKIT)
object FnBed {

    val TYPE = Type.fromClass(org.bukkit.block.Bed::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.block.Bed::class.java)
                .function("getColor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE).noParams()) { it.setReturnRef(it.target?.getColor()) }
                .function("setColor", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE)) { it.target?.setColor(it.getRef(0) as org.bukkit.DyeColor) }
                .function("setColor", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.enumValue(it.getString(0))?.let { p0 -> it.target?.setColor(p0) } }
        }
    }
}
