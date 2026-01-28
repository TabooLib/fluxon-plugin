package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Structure
import org.bukkit.block.structure.Mirror
import org.bukkit.block.structure.StructureRotation
import org.bukkit.block.structure.UsageMode
import org.bukkit.entity.LivingEntity
import org.bukkit.util.BlockVector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Structure"])
@PlatformSide(Platform.BUKKIT)
object FnStructure {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Structure::class.java)
                .function("structureName", returnsObject().noParams()) { it.target?.structureName }
                .function("setStructureName", returnsObject().params(Type.OBJECT)) { it.target?.setStructureName(it.getString(0)!!) }
                .function("author", returnsObject().noParams()) { it.target?.author }
                .function("setAuthor", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.author = var1
                        is LivingEntity -> it.target?.setAuthor(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 LivingEntity 类型")
                    }
                }
                .function("relativePosition", returnsObject().noParams()) { it.target?.relativePosition }
                .function("setRelativePosition", returnsObject().params(Type.OBJECT)) { it.target?.setRelativePosition(it.getRef(0) as BlockVector) }
                .function("structureSize", returnsObject().noParams()) { it.target?.structureSize }
                .function("setStructureSize", returnsObject().params(Type.OBJECT)) { it.target?.setStructureSize(it.getRef(0) as BlockVector) }
                .function("setMirror", returnsObject().params(Type.OBJECT)) { it.target?.setMirror(it.getRef(0) as Mirror) }
                .function("mirror", returnsObject().noParams()) { it.target?.mirror }
                .function("setRotation", returnsObject().params(Type.OBJECT)) { it.target?.setRotation(it.getRef(0) as StructureRotation) }
                .function("rotation", returnsObject().noParams()) { it.target?.rotation }
                .function("setUsageMode", returnsObject().params(Type.OBJECT)) { it.target?.setUsageMode(it.getRef(0) as UsageMode) }
                .function("usageMode", returnsObject().noParams()) { it.target?.usageMode }
                .function("setIgnoreEntities", returnsObject().params(Type.OBJECT)) { it.target?.setIgnoreEntities(it.getBool(0)) }
                .function("isIgnoreEntities", returns(Type.Z).noParams()) { it.target?.isIgnoreEntities }
                .function("setShowAir", returnsObject().params(Type.OBJECT)) { it.target?.setShowAir(it.getBool(0)) }
                .function("isShowAir", returns(Type.Z).noParams()) { it.target?.isShowAir }
                .function("setBoundingBoxVisible", returnsObject().params(Type.OBJECT)) { it.target?.setBoundingBoxVisible(it.getBool(0)) }
                .function("isBoundingBoxVisible", returns(Type.Z).noParams()) { it.target?.isBoundingBoxVisible }
                .function("setIntegrity", returnsObject().params(Type.OBJECT)) { it.target?.setIntegrity(it.getFloat(0)) }
                .function("integrity", returnsObject().noParams()) { it.target?.integrity }
                .function("setSeed", returnsObject().params(Type.OBJECT)) { it.target?.setSeed(it.getInt(0).toLong()) }
                .function("seed", returnsObject().noParams()) { it.target?.seed }
                .function("setMetadata", returnsObject().params(Type.OBJECT)) { it.target?.setMetadata(it.getString(0)!!) }
                .function("metadata", returnsObject().noParams()) { it.target?.metadata }
        }
    }
}
