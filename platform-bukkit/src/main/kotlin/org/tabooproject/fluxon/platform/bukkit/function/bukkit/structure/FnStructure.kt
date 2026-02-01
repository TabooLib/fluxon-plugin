package org.tabooproject.fluxon.platform.bukkit.function.bukkit.structure

import org.bukkit.Location
import org.bukkit.RegionAccessor
import org.bukkit.block.structure.Mirror
import org.bukkit.block.structure.StructureRotation
import org.bukkit.structure.Structure
import org.bukkit.util.BlockVector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.structure.Structure"])
@PlatformSide(Platform.BUKKIT)
object FnStructure {

    val TYPE = Type.fromClass(Structure::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Structure::class.java)
                .function("size", returnsObject().noParams()) { it.setReturnRef(it.target?.size) }
                .function("palettes", returnsObject().noParams()) { it.setReturnRef(it.target?.palettes) }
                .function("paletteCount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.paletteCount ?: 0) }
                .function("entities", returnsObject().noParams()) { it.setReturnRef(it.target?.entities) }
                .function("entityCount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.entityCount ?: 0) }
                .function("place", returnsVoid().params(Type.OBJECT, Type.Z, Type.OBJECT, Type.OBJECT, Type.I, Type.F, Type.OBJECT)) {
                    it.target?.place(
                        it.getRef(0) as Location,
                        it.getBool(1),
                        it.getRef(2) as StructureRotation,
                        it.getRef(3) as Mirror,
                        it.getInt(4).toInt(),
                        it.getFloat(5),
                        it.getRef(6) as Random
                    )
                }
                .function("place", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.Z, Type.OBJECT, Type.OBJECT, Type.I, Type.F, Type.OBJECT)) {
                    it.target?.place(
                        it.getRef(0) as RegionAccessor,
                        it.getRef(1) as BlockVector,
                        it.getBool(2),
                        it.getRef(3) as StructureRotation,
                        it.getRef(4) as Mirror,
                        it.getInt(5).toInt(),
                        it.getFloat(6),
                        it.getRef(7) as Random
                    )
                }
                .function("fill", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.Z)) {
                    when (val var2 = it.getRef(1)) {
                        is Location -> it.target?.fill(it.getRef(0) as Location, var2, it.getBool(2))
                        is BlockVector -> it.target?.fill(it.getRef(0) as Location, var2, it.getBool(2))
                        else -> throw IllegalArgumentException("第二个参数必须是 Location 或 BlockVector 类型")
                    }
                }
        }
    }
}
