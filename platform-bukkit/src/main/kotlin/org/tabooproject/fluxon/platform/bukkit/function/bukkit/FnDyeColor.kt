package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Color
import org.bukkit.DyeColor
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.DyeColor"])
@PlatformSide(Platform.BUKKIT)
object FnDyeColor : FnEnumGetter<DyeColor>() {

    override val enumClass: Class<DyeColor> = DyeColor::class.java

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DyeColor::class.java)
                .function("woolData", returns(Type.I).noParams()) { it.setReturnInt(it.target?.woolData?.toInt() ?: 0) }
                .function("dyeData", returns(Type.I).noParams()) { it.setReturnInt(it.target?.dyeData?.toInt() ?: 0) }
                .function("color", returns(FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("fireworkColor", returns(FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.fireworkColor) }
            registerFunction("dyeColorByFireworkColor", returns(TYPE).params(FnColor.TYPE)) { it.setReturnRef(DyeColor.getByFireworkColor(it.getRef(0) as Color)) }
                // static
            registerFunction("dyeColorByColor", returns(TYPE).params(FnColor.TYPE)) { it.setReturnRef(DyeColor.getByColor(it.getRef(0) as Color)) }
        }
    }
}
