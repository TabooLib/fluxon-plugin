package org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.World
import org.bukkit.entity.EntityType
import org.bukkit.packs.DataPackManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.packs.DataPackManager"])
@PlatformSide(Platform.BUKKIT)
object FnDataPackManager {

    val TYPE = Type.fromClass(DataPackManager::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DataPackManager::class.java)
                .function("dataPacks", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.dataPacks) }
                .function("getDataPack",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs.FnDataPack.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.setReturnRef(it.target?.getDataPack(it.getRef(0) as NamespacedKey)) }
                .function("getEnabledDataPacks",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) { it.setReturnRef(it.target?.getEnabledDataPacks(it.getRef(0) as World)) }
                .function("getDisabledDataPacks",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) { it.setReturnRef(it.target?.getDisabledDataPacks(it.getRef(0) as World)) }
                .function("isEnabledByFeature", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) { it.setReturnBool(it.target?.isEnabledByFeature(it.getRef(0) as Material, it.getRef(1) as World) ?: false) }
                .function("isEnabledByFeature", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) { it.setReturnBool(it.target?.isEnabledByFeature(it.getRef(0) as EntityType, it.getRef(1) as World) ?: false) }
                .function("isEnabledByFeature", returns(Type.Z).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.enumValue(it.getString(0))?.let { p0 ->
                        it.setReturnBool(it.target?.isEnabledByFeature(p0, it.getRef(1) as World) ?: false)
                    } ?: org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.enumValue(it.getString(0))?.let { p0 ->
                        it.setReturnBool(it.target?.isEnabledByFeature(p0, it.getRef(1) as World) ?: false)
                    }
                }
        }
    }
}
