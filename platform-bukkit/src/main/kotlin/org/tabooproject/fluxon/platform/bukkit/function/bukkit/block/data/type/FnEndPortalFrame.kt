package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.EndPortalFrame
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.EndPortalFrame"])
@PlatformSide(Platform.BUKKIT)
object FnEndPortalFrame {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EndPortalFrame::class.java)
                .function("hasEye", returns(Type.Z).noParams()) { it.target?.hasEye() }
                .function("setEye", returnsObject().params(Type.OBJECT)) { it.target?.setEye(it.getBool(0)) }
        }
    }
}
