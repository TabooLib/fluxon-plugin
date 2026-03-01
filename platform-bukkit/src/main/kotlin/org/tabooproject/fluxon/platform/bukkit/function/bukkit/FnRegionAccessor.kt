package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.HeightMap
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.RegionAccessor
import org.bukkit.block.Biome
import org.bukkit.block.data.BlockData
import org.bukkit.entity.EntityType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.RegionAccessor"])
@PlatformSide(Platform.BUKKIT)
object FnRegionAccessor {

    val TYPE = Type.fromClass(RegionAccessor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RegionAccessor::class.java)
                .function("getBiome",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnRef(it.target?.getBiome(it.getRef(0) as Location))
                }
                .function("getBiome", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBiome(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .syncFunction("setBiome",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE)) {
                    it.target?.setBiome(
                        it.getRef(0) as Location,
                        it.getRef(1) as Biome
                    )
                }
                .syncFunction("setBiome",returnsVoid().params(Type.I, Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE)) {
                    it.target?.setBiome(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getRef(3) as Biome
                    )
                }
                .function("getBlockState",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnRef(it.target?.getBlockState(it.getRef(0) as Location))
                }
                .function("getBlockState", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBlockState(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getBlockData",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnRef(it.target?.getBlockData(it.getRef(0) as Location))
                }
                .function("getBlockData", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBlockData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("getType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnRef(it.target?.getType(it.getRef(0) as Location))
                }
                .function("getType", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getType(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .syncFunction("setBlockData",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE)) {
                    it.target?.setBlockData(
                        it.getRef(0) as Location,
                        it.getRef(1) as BlockData
                    )
                }
                .syncFunction("setBlockData",returnsVoid().params(Type.I, Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE)) {
                    it.target?.setBlockData(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getRef(3) as BlockData
                    )
                }
                .syncFunction("setType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) {
                    it.target?.setType(
                        it.getRef(0) as Location,
                        it.getRef(1) as Material
                    )
                }
                .syncFunction("setType",returnsVoid().params(Type.I, Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) {
                    it.target?.setType(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getRef(3) as Material
                    )
                }
                .syncFunction("generateTree",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.fromClass(java.util.Random::class.java), org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTreeType.TYPE)) {
                    it.setReturnBool(it.target?.generateTree(
                        it.getRef(0) as Location,
                        it.getRef(1) as java.util.Random,
                        it.getRef(2) as org.bukkit.TreeType
                    ) ?: false)
                }
                .syncFunction("generateTree",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.fromClass(java.util.Random::class.java), Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTreeType.enumValue(it.getString(2))?.let { p2 ->
                        it.setReturnBool(it.target?.generateTree(it.getRef(0) as Location, it.getRef(1) as java.util.Random, p2) ?: false)
                    }
                }
                .syncFunction("spawnEntity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE)) {
                    it.setReturnRef(it.target?.spawnEntity(
                        it.getRef(0) as Location,
                        it.getRef(1) as EntityType
                    ))
                }
                .syncFunction("spawnEntity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE, Type.Z)) {
                    it.setReturnRef(it.target?.spawnEntity(
                        it.getRef(0) as Location,
                        it.getRef(1) as EntityType,
                        it.getBool(2)
                    ))
                }
                .function("entities", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.entities) }
                .function("livingEntities", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.livingEntities) }
                .function("entitiesByClasses", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.getEntitiesByClasses()) }
                .function("getHighestBlockYAt",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnInt(it.target?.getHighestBlockYAt(it.getRef(0) as Location) ?: 0)
                }
                .function("getHighestBlockYAt", returns(Type.I).params(Type.I, Type.I)) {
                    it.setReturnInt(it.target?.getHighestBlockYAt(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ) ?: 0)
                }
                .function("getHighestBlockYAt",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnHeightMap.TYPE)) {
                    it.setReturnInt(it.target?.getHighestBlockYAt(
                        it.getRef(0) as Location,
                        it.getRef(1) as HeightMap
                    ) ?: 0)
                }
                .function("getHighestBlockYAt", returns(Type.I).params(Type.I, Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnHeightMap.TYPE)) {
                    it.setReturnInt(it.target?.getHighestBlockYAt(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as HeightMap
                    ) ?: 0)
                }
        }
    }
}
