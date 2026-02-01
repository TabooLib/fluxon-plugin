package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.EndPortalFrame
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.type.EndPortalFrame"])
@PlatformSide(Platform.BUKKIT)
object FnEndPortalFrame {

    val TYPE = Type.fromClass(EndPortalFrame::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EndPortalFrame::class.java)
                .function("hasEye", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasEye() ?: false) }
                .function("setEye", returnsVoid().params(Type.Z)) { it.target?.setEye(it.getBool(0)) }
        }
    }
}
