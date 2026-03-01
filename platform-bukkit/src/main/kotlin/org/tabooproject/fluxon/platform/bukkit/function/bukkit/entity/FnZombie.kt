package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Villager
import org.bukkit.entity.Zombie
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

@Requires(classes = ["org.bukkit.entity.Zombie"])
@PlatformSide(Platform.BUKKIT)
object FnZombie {

    val TYPE = Type.fromClass(Zombie::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Zombie::class.java)
                .function("isBaby", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBaby ?: false) }
                .function("setBaby", returnsVoid().params(Type.Z)) { it.target?.setBaby(it.getBool(0)) }
                .function("isVillager", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isVillager ?: false) }
                .function("setVillager", returnsVoid().params(Type.Z)) { it.target?.setVillager(it.getBool(0)) }
                .function("setVillagerProfession",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnVillagerProfession.TYPE)) { it.target?.setVillagerProfession(it.getRef(0) as Villager.Profession) }
                .function("isConverting", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isConverting ?: false) }
                .function("conversionTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.conversionTime ?: 0) }
                .function("setConversionTime", returnsVoid().params(Type.I)) { it.target?.setConversionTime(it.getInt(0).toInt()) }
                .function("canBreakDoors", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canBreakDoors() ?: false) }
                .function("setCanBreakDoors", returnsVoid().params(Type.Z)) { it.target?.setCanBreakDoors(it.getBool(0)) }
        }
    }
}
