package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Villager
import org.bukkit.entity.Zombie
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Zombie"])
@PlatformSide(Platform.BUKKIT)
object FnZombie {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Zombie::class.java)
                .function("isBaby", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isBaby) }
                .function("setBaby", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBaby(it.getBool(0))) }
                .function("isVillager", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isVillager) }
                .function("setVillager", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setVillager(it.getBool(0))) }
                .function("setVillagerProfession", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setVillagerProfession(it.getRef(0) as Villager.Profession)) }
                .function("isConverting", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isConverting) }
                .function("conversionTime", returnsObject().noParams()) { it.setReturnRef(it.target?.conversionTime) }
                .function("setConversionTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setConversionTime(it.getInt(0).toInt())) }
                .function("canBreakDoors", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.canBreakDoors()) }
                .function("setCanBreakDoors", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCanBreakDoors(it.getBool(0))) }
        }
    }
}
