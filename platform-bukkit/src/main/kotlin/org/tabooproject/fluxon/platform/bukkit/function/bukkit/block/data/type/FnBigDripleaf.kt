package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.BigDripleaf
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.BigDripleaf"])
@PlatformSide(Platform.BUKKIT)
object FnBigDripleaf {

    val TYPE = Type.fromClass(BigDripleaf::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BigDripleaf::class.java)
                .function("tilt", returns(FnBigDripleafTilt.TYPE).noParams()) { it.setReturnRef(it.target?.tilt) }
                .function("setTilt", returnsVoid().params(FnBigDripleafTilt.TYPE)) { it.target?.setTilt(it.getRef(0) as BigDripleaf.Tilt) }
                .function("setTilt", returnsVoid().params(Type.STRING)) {
                    FnBigDripleafTilt.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.setTilt(
                            p0)
                    }
                }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.BigDripleaf.Tilt"])
@PlatformSide(Platform.BUKKIT)
object FnBigDripleafTilt : FnEnumGetter<BigDripleaf.Tilt>() {

    override val enumClass: Class<BigDripleaf.Tilt> = BigDripleaf.Tilt::class.java
}
