package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.ShulkerBox
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.ShulkerBox"])
@PlatformSide(Platform.BUKKIT)
object FnShulkerBox {

    val TYPE = Type.fromClass(ShulkerBox::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShulkerBox::class.java)
                .function("color", returns(FnDyeColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
        }
    }
}
