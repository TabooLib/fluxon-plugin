package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.Location
import org.bukkit.generator.LimitedRegion
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.generator.LimitedRegion"])
@PlatformSide(Platform.BUKKIT)
object FnLimitedRegion {

    val TYPE = Type.fromClass(LimitedRegion::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LimitedRegion::class.java)
                .function("buffer", returnsObject().noParams()) { it.setReturnRef(it.target?.buffer) }
                .function("isInRegion", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.isInRegion(it.getRef(0) as Location) ?: false)
                }
                .function("isInRegion", returns(Type.Z).params(Type.I, Type.I, Type.I)) {
                    it.setReturnBool(it.target?.isInRegion(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ) ?: false)
                }
                .function("tileEntities", returnsObject().noParams()) { it.setReturnRef(it.target?.tileEntities) }
        }
    }
}
