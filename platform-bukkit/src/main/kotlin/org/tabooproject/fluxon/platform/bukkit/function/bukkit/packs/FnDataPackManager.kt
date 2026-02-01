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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
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
                .function("dataPacks", returnsObject().noParams()) { it.setReturnRef(it.target?.dataPacks) }
                .function("getDataPack", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getDataPack(it.getRef(0) as NamespacedKey)) }
                .function("getEnabledDataPacks", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getEnabledDataPacks(it.getRef(0) as World)) }
                .function("getDisabledDataPacks", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getDisabledDataPacks(it.getRef(0) as World)) }
                .function("isEnabledByFeature", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.isEnabledByFeature(var1, it.getRef(1) as World)
                        is EntityType -> it.target?.isEnabledByFeature(var1, it.getRef(1) as World)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 EntityType 类型")
                    })
                }
        }
    }
}
