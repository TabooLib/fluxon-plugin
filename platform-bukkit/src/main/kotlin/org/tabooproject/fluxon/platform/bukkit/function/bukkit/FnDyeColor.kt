package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Color
import org.bukkit.DyeColor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.DyeColor"])
@PlatformSide(Platform.BUKKIT)
object FnDyeColor {

    val TYPE = Type.fromClass(DyeColor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DyeColor::class.java)
                .function("woolData", returns(Type.I).noParams()) { it.setReturnInt(it.target?.woolData?.toInt() ?: 0) }
                .function("dyeData", returns(Type.I).noParams()) { it.setReturnInt(it.target?.dyeData?.toInt() ?: 0) }
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("fireworkColor", returnsObject().noParams()) { it.setReturnRef(it.target?.fireworkColor) }
                // static
                .function("getByWoolData", returnsObject().params(Type.I)) { it.setReturnRef(DyeColor.getByWoolData(it.getInt(0).toByte())) }
                // static
                .function("getByDyeData", returnsObject().params(Type.I)) { it.setReturnRef(DyeColor.getByDyeData(it.getInt(0).toByte())) }
                // static
                .function("getByColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(DyeColor.getByColor(it.getRef(0) as Color)) }
                // static
                .function("getByFireworkColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(DyeColor.getByFireworkColor(it.getRef(0) as Color)) }
                // static
                .function("legacyValueOf", returnsObject().params(Type.STRING)) { it.setReturnRef(DyeColor.legacyValueOf(it.getString(0))) }
        }
    }
}
