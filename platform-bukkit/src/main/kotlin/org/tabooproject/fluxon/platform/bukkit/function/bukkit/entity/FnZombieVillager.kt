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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.ZombieVillager"])
@PlatformSide(Platform.BUKKIT)
object FnZombieVillager {

    val TYPE = Type.fromClass(ZombieVillager::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ZombieVillager::class.java)
                .function("setVillagerProfession",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnVillagerProfession.TYPE)) {
                    it.target?.setVillagerProfession(it.getRef(0) as Villager.Profession)
                }
                .function("setVillagerType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnVillagerType.TYPE)) { it.target?.setVillagerType(it.getRef(0) as Villager.Type) }
                .function("isConverting", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isConverting ?: false) }
                .function("conversionTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.conversionTime ?: 0) }
                .function("setConversionTime", returnsVoid().params(Type.I)) { it.target?.setConversionTime(it.getInt(0).toInt()) }
                .function("conversionPlayer",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnOfflinePlayer.TYPE).noParams()) { it.setReturnRef(it.target?.conversionPlayer) }
                .function("setConversionPlayer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnOfflinePlayer.TYPE)) {
                    it.target?.setConversionPlayer(it.getRef(0) as OfflinePlayer)
                }
        }
    }
}
