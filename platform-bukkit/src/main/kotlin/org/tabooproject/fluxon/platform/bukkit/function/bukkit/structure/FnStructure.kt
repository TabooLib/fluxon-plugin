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

object FnStructure {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Structure::class.java)
                .function("size", 0) { it.target?.size }
                .function("palettes", 0) { it.target?.palettes }
                .function("paletteCount", 0) { it.target?.paletteCount }
                .function("entities", 0) { it.target?.entities }
                .function("entityCount", 0) { it.target?.entityCount }
                .function("place", listOf(7, 8)) {
                    if (it.arguments.size == 7) {
                        it.target?.place(
                            it.getArgument(0) as Location,
                            it.getBoolean(1),
                            it.getArgument(2) as StructureRotation,
                            it.getArgument(3) as Mirror,
                            it.getNumber(4).toInt(),
                            it.getNumber(5).toFloat(),
                            it.getArgument(6) as Random
                        )
                    } else {
                        it.target?.place(
                            it.getArgument(0) as RegionAccessor,
                            it.getArgument(1) as BlockVector,
                            it.getBoolean(2),
                            it.getArgument(3) as StructureRotation,
                            it.getArgument(4) as Mirror,
                            it.getNumber(5).toInt(),
                            it.getNumber(6).toFloat(),
                            it.getArgument(7) as Random
                        )
                    }
                }
                .function("fill", 3) {
                    when (val var2 = it.getArgument(1)) {
                        is Location -> it.target?.fill(it.getArgument(0) as Location, var2, it.getBoolean(2))
                        is BlockVector -> it.target?.fill(it.getArgument(0) as Location, var2, it.getBoolean(2))
                        else -> throw IllegalArgumentException("第二个参数必须是 Location 或 BlockVector 类型")
                    }
                }
        }
    }
}
