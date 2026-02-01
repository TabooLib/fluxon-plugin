package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Structure
import org.bukkit.block.structure.Mirror
import org.bukkit.block.structure.StructureRotation
import org.bukkit.block.structure.UsageMode
import org.bukkit.entity.LivingEntity
import org.bukkit.util.BlockVector
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure.FnMirror
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure.FnStructureRotation
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure.FnUsageMode
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBlockVector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
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
                .function("structureName", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.structureName) }
                .function("setStructureName", returnsVoid().params(Type.STRING)) { it.target?.setStructureName(it.getString(0)!!) }
                .function("author", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.author) }
                .function("setAuthor", returnsVoid().params(Type.STRING)) {
                    it.target?.author = it.getString(0)
                }
                .function("setAuthor", returnsVoid().params(FnLivingEntity.TYPE)) {
                    it.target?.setAuthor(it.getRef(0) as LivingEntity)
                }
                .function("relativePosition", returns(FnBlockVector.TYPE).noParams()) { it.setReturnRef(it.target?.relativePosition) }
                .function("setRelativePosition", returnsVoid().params(FnBlockVector.TYPE)) {
                    it.target?.setRelativePosition(it.getRef(0) as BlockVector)
                }
                .function("structureSize", returns(FnBlockVector.TYPE).noParams()) { it.setReturnRef(it.target?.structureSize) }
                .function("setStructureSize", returnsVoid().params(FnBlockVector.TYPE)) {
                    it.target?.setStructureSize(it.getRef(0) as BlockVector)
                }
                .function("setMirror", returnsVoid().params(FnMirror.TYPE)) { it.target?.setMirror(it.getRef(0) as Mirror) }
                .function("setMirror", returnsVoid().params(Type.STRING)) { FnMirror.enumValue(it.getString(0))?.let { p0 -> it.target?.setMirror(p0) } }
                .function("mirror", returns(FnMirror.TYPE).noParams()) { it.setReturnRef(it.target?.mirror) }
                .function("setRotation", returnsVoid().params(FnStructureRotation.TYPE)) {
                    it.target?.setRotation(it.getRef(0) as StructureRotation)
                }
                .function("setRotation", returnsVoid().params(Type.STRING)) {
                    FnStructureRotation.enumValue(it.getString(0))?.let { p0 -> it.target?.setRotation(p0) }
                }
                .function("rotation", returns(FnStructureRotation.TYPE).noParams()) { it.setReturnRef(it.target?.rotation) }
                .function("setUsageMode", returnsVoid().params(FnUsageMode.TYPE)) {
                    it.target?.setUsageMode(it.getRef(0) as UsageMode)
                }
                .function("setUsageMode", returnsVoid().params(Type.STRING)) {
                    FnUsageMode.enumValue(it.getString(0))?.let { p0 -> it.target?.setUsageMode(p0) }
                }
                .function("usageMode", returns(FnUsageMode.TYPE).noParams()) { it.setReturnRef(it.target?.usageMode) }
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
        }
    }
}
