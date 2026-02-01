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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Structure"])
@PlatformSide(Platform.BUKKIT)
object FnStructure {

    val TYPE = Type.fromClass(Structure::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Structure::class.java)
                .function("structureName", returnsObject().noParams()) { it.setReturnRef(it.target?.structureName) }
                .function("setStructureName", returnsVoid().params(Type.STRING)) { it.target?.setStructureName(it.getString(0)!!) }
                .function("author", returnsObject().noParams()) { it.setReturnRef(it.target?.author) }
                .function("setAuthor", returnsVoid().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.author = var1
                        is LivingEntity -> it.target?.setAuthor(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 LivingEntity 类型")
                    }
                }
                .function("relativePosition", returnsObject().noParams()) { it.setReturnRef(it.target?.relativePosition) }
                .function("setRelativePosition", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setRelativePosition(it.getRef(0) as BlockVector)
                }
                .function("structureSize", returnsObject().noParams()) { it.setReturnRef(it.target?.structureSize) }
                .function("setStructureSize", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setStructureSize(it.getRef(0) as BlockVector)
                }
                .function("setMirror", returnsVoid().params(Type.OBJECT)) { it.target?.setMirror(it.getRef(0) as Mirror) }
                .function("mirror", returnsObject().noParams()) { it.setReturnRef(it.target?.mirror) }
                .function("setRotation", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setRotation(it.getRef(0) as StructureRotation)
                }
                .function("rotation", returnsObject().noParams()) { it.setReturnRef(it.target?.rotation) }
                .function("setUsageMode", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setUsageMode(it.getRef(0) as UsageMode)
                }
                .function("usageMode", returnsObject().noParams()) { it.setReturnRef(it.target?.usageMode) }
                .function("setIgnoreEntities", returnsVoid().params(Type.Z)) { it.target?.setIgnoreEntities(it.getBool(0)) }
                .function("isIgnoreEntities", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isIgnoreEntities ?: false) }
                .function("setShowAir", returnsVoid().params(Type.Z)) { it.target?.setShowAir(it.getBool(0)) }
                .function("isShowAir", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isShowAir ?: false) }
                .function("setBoundingBoxVisible", returnsVoid().params(Type.Z)) { it.target?.setBoundingBoxVisible(it.getBool(0)) }
                .function("isBoundingBoxVisible", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBoundingBoxVisible ?: false) }
                .function("setIntegrity", returnsVoid().params(Type.F)) { it.target?.setIntegrity(it.getFloat(0)) }
                .function("integrity", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.integrity ?: 0.0f) }
                .function("setSeed", returnsVoid().params(Type.J)) { it.target?.setSeed(it.getLong(0)) }
                .function("seed", returns(Type.J).noParams()) { it.setReturnLong(it.target?.seed ?: 0L) }
                .function("setMetadata", returnsVoid().params(Type.STRING)) { it.target?.setMetadata(it.getString(0)!!) }
                .function("metadata", returnsObject().noParams()) { it.setReturnRef(it.target?.metadata) }
        }
    }
}
