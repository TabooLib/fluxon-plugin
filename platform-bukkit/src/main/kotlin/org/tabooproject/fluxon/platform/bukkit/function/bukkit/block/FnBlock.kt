package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.FluidCollisionMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Biome
import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.block.data.BlockData
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
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


@Requires(classes = ["org.bukkit.block.Block"])
@PlatformSide(Platform.BUKKIT)
object FnBlock {

    val TYPE = Type.fromClass(Block::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Block::class.java)
                .function("data", returnsObject().noParams()) { it.setReturnRef(it.target?.data) }
                .function("blockData", returnsObject().noParams()) { it.setReturnRef(it.target?.blockData) }
                .function("getRelative", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getRelative(it.getRef(0) as BlockFace))
                }
                .function("getRelative", returnsObject().params(Type.OBJECT, Type.I)) {
                    it.setReturnRef(it.target?.getRelative(
                        it.getRef(0) as BlockFace,
                        it.getInt(1)
                    ))
                }
                .function("getRelative", returnsObject().params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getRelative(
                        it.getInt(0),
                        it.getInt(1),
                        it.getInt(2)
                    ))
                }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("lightLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lightLevel?.toInt() ?: 0) }
                .function("lightFromSky", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lightFromSky?.toInt() ?: 0) }
                .function("lightFromBlocks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lightFromBlocks?.toInt() ?: 0) }
                .function("world", returnsObject().noParams()) { it.setReturnRef(it.target?.world) }
                .function("x", returns(Type.I).noParams()) { it.setReturnInt(it.target?.x ?: 0) }
                .function("y", returns(Type.I).noParams()) { it.setReturnInt(it.target?.y ?: 0) }
                .function("z", returns(Type.I).noParams()) { it.setReturnInt(it.target?.z ?: 0) }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
                .function("getLocation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getLocation(it.getRef(0) as Location)) }
                .function("chunk", returnsObject().noParams()) { it.setReturnRef(it.target?.chunk) }
                .function("setBlockData", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setBlockData(it.getRef(0) as BlockData)
                }
                .function("setBlockData", returnsVoid().params(Type.OBJECT, Type.Z)) {
                    it.target?.setBlockData(it.getRef(0) as BlockData, it.getBool(1))
                }
                .function("setType", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setType(it.getRef(0) as Material)
                }
                .function("setType", returnsVoid().params(Type.OBJECT, Type.Z)) {
                    it.target?.setType(it.getRef(0) as Material, it.getBool(1))
                }
                .function("getFace", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getFace(it.getRef(0) as Block)) }
                .function("state", returnsObject().noParams()) { it.setReturnRef(it.target?.state) }
                .function("biome", returnsObject().noParams()) { it.setReturnRef(it.target?.biome) }
                .function("setBiome", returnsVoid().params(Type.OBJECT)) { it.target?.setBiome(it.getRef(0) as Biome) }
                .function("isBlockPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBlockPowered ?: false) }
                .function("isBlockIndirectlyPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBlockIndirectlyPowered ?: false) }
                .function("isBlockFacePowered", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.isBlockFacePowered(it.getRef(0) as BlockFace) ?: false)
                }
                .function("isBlockFaceIndirectlyPowered", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.isBlockFaceIndirectlyPowered(it.getRef(0) as BlockFace) ?: false)
                }
                .function("blockPower", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockPower ?: 0) }
                .function("getBlockPower", returns(Type.I).params(Type.OBJECT)) {
                    it.setReturnInt(it.target?.getBlockPower(it.getRef(0) as BlockFace) ?: 0)
                }
                .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEmpty ?: false) }
                .function("isLiquid", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLiquid ?: false) }
                .function("temperature", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.temperature ?: 0.0) }
                .function("humidity", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.humidity ?: 0.0) }
                .function("pistonMoveReaction", returnsObject().noParams()) { it.setReturnRef(it.target?.pistonMoveReaction) }
                .function("breakNaturally", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.breakNaturally() ?: false)
                }
                .function("breakNaturally", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.breakNaturally(it.getRef(0) as ItemStack) ?: false)
                }
                .function("applyBoneMeal", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.applyBoneMeal(it.getRef(0) as BlockFace) ?: false)
                }
                .function("drops", returnsObject().noParams()) { it.setReturnRef(it.target?.drops) }
                .function("getDrops", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getDrops(it.getRef(0) as ItemStack))
                }
                .function("getDrops", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getDrops(
                        it.getRef(0) as ItemStack,
                        it.getRef(1) as Entity
                    ))
                }
                .function("isPreferredTool", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.isPreferredTool(it.getRef(0) as ItemStack) ?: false)
                }
                .function("getBreakSpeed", returns(Type.F).params(Type.OBJECT)) {
                    it.setReturnFloat(it.target?.getBreakSpeed(it.getRef(0) as Player) ?: 0.0f)
                }
                .function("isPassable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPassable ?: false) }
                .function("rayTrace", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.D, Type.OBJECT)) {
                    it.setReturnRef(it.target?.rayTrace(
                        it.getRef(0) as Location,
                        it.getRef(1) as Vector,
                        it.getDouble(2),
                        it.getRef(3) as FluidCollisionMode
                    ))
                }
                .function("boundingBox", returnsObject().noParams()) { it.setReturnRef(it.target?.boundingBox) }
                .function("collisionShape", returnsObject().noParams()) { it.setReturnRef(it.target?.collisionShape) }
                .function("canPlace", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.canPlace(it.getRef(0) as BlockData) ?: false)
                }
        }
    }
}
