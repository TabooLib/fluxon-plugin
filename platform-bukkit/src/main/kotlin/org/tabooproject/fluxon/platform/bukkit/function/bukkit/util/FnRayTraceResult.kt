package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.RayTraceResult
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.RayTraceResult"])
@PlatformSide(Platform.BUKKIT)
object FnRayTraceResult {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RayTraceResult::class.java)
                .function("hitPosition", returnsObject().noParams()) { it.target?.hitPosition }
                .function("hitBlock", returnsObject().noParams()) { it.target?.hitBlock }
                .function("hitBlockFace", returnsObject().noParams()) { it.target?.hitBlockFace }
                .function("hitEntity", returnsObject().noParams()) { it.target?.hitEntity }
                .function("hashCode", returns(Type.I).noParams()) { it.target?.hashCode() }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.target?.equals(it.getRef(0)) }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
        }
    }
}
