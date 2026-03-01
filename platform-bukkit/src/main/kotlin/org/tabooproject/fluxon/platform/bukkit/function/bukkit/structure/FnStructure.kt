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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.structure.Structure"])
@PlatformSide(Platform.BUKKIT)
object FnStructure {

    val TYPE = Type.fromClass(Structure::class.java)
    private val RANDOM = Type.fromClass(Random::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Structure::class.java)
                .function("size",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBlockVector.TYPE).noParams()) { it.setReturnRef(it.target?.size) }
                .function("palettes",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.palettes) }
                .function("paletteCount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.paletteCount ?: 0) }
                .function("entities",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.entities) }
                .function("entityCount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.entityCount ?: 0) }
                .function("place",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.Z, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure.FnStructureRotation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure.FnMirror.TYPE, Type.I, Type.F, RANDOM)) {
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
                .function("place",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnRegionAccessor.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBlockVector.TYPE, Type.Z, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure.FnStructureRotation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure.FnMirror.TYPE, Type.I, Type.F, RANDOM)) {
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
                .function("fill", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.Z)) { it.target?.fill(it.getRef(0) as Location, it.getRef(1) as Location, it.getBool(2)) }
                .function("fill", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBlockVector.TYPE, Type.Z)) { it.target?.fill(it.getRef(0) as Location, it.getRef(1) as BlockVector, it.getBool(2)) }
        }
    }
}
