package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.World
import org.bukkit.block.BlockType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.BlockType"])
@PlatformSide(Platform.BUKKIT)
object FnBlockType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockType::class.java)
                .function("typed", returnsObject().noParams()) { it.target?.typed() }
                .function("hasItemType", returns(Type.Z).noParams()) { it.target?.hasItemType() }
                .function("itemType", returnsObject().noParams()) { it.target?.itemType }
                .function("createBlockData", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.createBlockData()
                    } else {
                        it.target?.createBlockData(it.getString(0))
                    }
                }
                .function("createBlockData", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.createBlockData()
                    } else {
                        it.target?.createBlockData(it.getString(0))
                    }
                }
                .function("isSolid", returns(Type.Z).noParams()) { it.target?.isSolid }
                .function("isFlammable", returns(Type.Z).noParams()) { it.target?.isFlammable }
                .function("isBurnable", returns(Type.Z).noParams()) { it.target?.isBurnable }
                .function("isOccluding", returns(Type.Z).noParams()) { it.target?.isOccluding }
                .function("hasGravity", returns(Type.Z).noParams()) { it.target?.hasGravity() }
                .function("isInteractable", returns(Type.Z).noParams()) { it.target?.isInteractable }
                .function("hardness", returnsObject().noParams()) { it.target?.hardness }
                .function("blastResistance", returnsObject().noParams()) { it.target?.blastResistance }
                .function("slipperiness", returnsObject().noParams()) { it.target?.slipperiness }
                .function("isAir", returns(Type.Z).noParams()) { it.target?.isAir }
                .function("isEnabledByFeature", returns(Type.Z).params(Type.OBJECT)) { it.target?.isEnabledByFeature(it.getRef(0) as World) }
                .function("asMaterial", returnsObject().noParams()) { it.target?.asMaterial() }
                .function("blockDataClass", returnsObject().noParams()) { it.target?.blockDataClass }
        }
    }
}

@Requires(classes = ["org.bukkit.block.BlockType.Typed"])
@PlatformSide(Platform.BUKKIT)
object FnBlockTypeTyped {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockType.Typed::class.java)
                .function("blockDataClass", returnsObject().noParams()) { it.target?.blockDataClass }
                .function("createBlockData", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.createBlockData()
                    } else {
                        (it.target as? BlockType.Typed<*>)?.createBlockData(it.getString(0))
                    }
                }
                .function("createBlockData", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.createBlockData()
                    } else {
                        (it.target as? BlockType.Typed<*>)?.createBlockData(it.getString(0))
                    }
                }
        }
    }
}
