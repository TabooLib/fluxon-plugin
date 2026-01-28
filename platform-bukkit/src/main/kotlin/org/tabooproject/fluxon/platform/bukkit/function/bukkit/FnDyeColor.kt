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
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.DyeColor"])
@PlatformSide(Platform.BUKKIT)
object FnDyeColor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DyeColor::class.java)
                .function("woolData", returnsObject().noParams()) { it.target?.woolData }
                .function("dyeData", returnsObject().noParams()) { it.target?.dyeData }
                .function("color", returnsObject().noParams()) { it.target?.color }
                .function("fireworkColor", returnsObject().noParams()) { it.target?.fireworkColor }
                // static
                .function("getByWoolData", returnsObject().params(Type.OBJECT)) { DyeColor.getByWoolData(it.getInt(0).toByte()) }
                // static
                .function("getByDyeData", returnsObject().params(Type.OBJECT)) { DyeColor.getByDyeData(it.getInt(0).toByte()) }
                // static
                .function("getByColor", returnsObject().params(Type.OBJECT)) { DyeColor.getByColor(it.getRef(0) as Color) }
                // static
                .function("getByFireworkColor", returnsObject().params(Type.OBJECT)) { DyeColor.getByFireworkColor(it.getRef(0) as Color) }
                // static
                .function("legacyValueOf", returnsObject().params(Type.OBJECT)) { DyeColor.legacyValueOf(it.getString(0)) }
        }
    }
}
