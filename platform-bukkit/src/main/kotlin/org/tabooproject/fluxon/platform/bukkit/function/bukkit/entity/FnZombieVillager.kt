package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.OfflinePlayer
import org.bukkit.entity.Villager
import org.bukkit.entity.ZombieVillager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.ZombieVillager"])
@PlatformSide(Platform.BUKKIT)
object FnZombieVillager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ZombieVillager::class.java)
                .function("setVillagerProfession", returnsObject().params(Type.OBJECT)) { it.target?.setVillagerProfession(it.getRef(0) as Villager.Profession) }
                .function("setVillagerType", returnsObject().params(Type.OBJECT)) { it.target?.setVillagerType(it.getRef(0) as Villager.Type) }
                .function("isConverting", returns(Type.Z).noParams()) { it.target?.isConverting }
                .function("conversionTime", returnsObject().noParams()) { it.target?.conversionTime }
                .function("setConversionTime", returnsObject().params(Type.OBJECT)) { it.target?.setConversionTime(it.getInt(0).toInt()) }
                .function("conversionPlayer", returnsObject().noParams()) { it.target?.conversionPlayer }
                .function("setConversionPlayer", returnsObject().params(Type.OBJECT)) { it.target?.setConversionPlayer(it.getRef(0) as OfflinePlayer) }
        }
    }
}
