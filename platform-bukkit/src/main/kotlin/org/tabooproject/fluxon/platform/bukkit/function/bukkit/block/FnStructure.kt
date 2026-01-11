package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Structure
import org.bukkit.block.structure.Mirror
import org.bukkit.block.structure.StructureRotation
import org.bukkit.block.structure.UsageMode
import org.bukkit.util.BlockVector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnStructure {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Structure::class.java)
                .function("structureName", 0) { it.target?.structureName }
                .function("setStructureName", 1) { it.target?.setStructureName(it.getString(0)!!) }
                .function("author", 0) { it.target?.author }
                .function("setAuthor", 1) {
                    // void setAuthor(@NotNull String var1)
                    // void setAuthor(@NotNull LivingEntity var1)
                    TODO()
                }
                .function("relativePosition", 0) { it.target?.relativePosition }
                .function("setRelativePosition", 1) { it.target?.setRelativePosition(it.getArgument(0) as BlockVector) }
                .function("structureSize", 0) { it.target?.structureSize }
                .function("setStructureSize", 1) { it.target?.setStructureSize(it.getArgument(0) as BlockVector) }
                .function("setMirror", 1) { it.target?.setMirror(it.getArgument(0) as Mirror) }
                .function("mirror", 0) { it.target?.mirror }
                .function("setRotation", 1) { it.target?.setRotation(it.getArgument(0) as StructureRotation) }
                .function("rotation", 0) { it.target?.rotation }
                .function("setUsageMode", 1) { it.target?.setUsageMode(it.getArgument(0) as UsageMode) }
                .function("usageMode", 0) { it.target?.usageMode }
                .function("setIgnoreEntities", 1) { it.target?.setIgnoreEntities(it.getBoolean(0)) }
                .function("isIgnoreEntities", 0) { it.target?.isIgnoreEntities }
                .function("setShowAir", 1) { it.target?.setShowAir(it.getBoolean(0)) }
                .function("isShowAir", 0) { it.target?.isShowAir }
                .function("setBoundingBoxVisible", 1) { it.target?.setBoundingBoxVisible(it.getBoolean(0)) }
                .function("isBoundingBoxVisible", 0) { it.target?.isBoundingBoxVisible }
                .function("setIntegrity", 1) { it.target?.setIntegrity(it.getNumber(0).toFloat()) }
                .function("integrity", 0) { it.target?.integrity }
                .function("setSeed", 1) { it.target?.setSeed(it.getNumber(0).toLong()) }
                .function("seed", 0) { it.target?.seed }
                .function("setMetadata", 1) { it.target?.setMetadata(it.getString(0)!!) }
                .function("metadata", 0) { it.target?.metadata }
        }
    }
}
