package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Villager
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

@Requires(classes = ["org.bukkit.entity.Villager"])
@PlatformSide(Platform.BUKKIT)
object FnVillager {

    val TYPE = Type.fromClass(Villager::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Villager::class.java)
                .function("profession",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnVillagerProfession.TYPE).noParams()) { it.setReturnRef(it.target?.profession) }
                .function("setProfession",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnVillagerProfession.TYPE)) { it.target?.setProfession(it.getRef(0) as Villager.Profession) }
                .function("villagerType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnVillagerType.TYPE).noParams()) { it.setReturnRef(it.target?.villagerType) }
                .function("setVillagerType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnVillagerType.TYPE)) { it.target?.setVillagerType(it.getRef(0) as Villager.Type) }
                .function("villagerLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.villagerLevel ?: 0) }
                .function("setVillagerLevel", returnsVoid().params(Type.I)) { it.target?.setVillagerLevel(it.getInt(0).toInt()) }
                .function("villagerExperience", returns(Type.I).noParams()) { it.setReturnInt(it.target?.villagerExperience ?: 0) }
                .function("setVillagerExperience", returnsVoid().params(Type.I)) { it.target?.setVillagerExperience(it.getInt(0).toInt()) }
                .function("sleep",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnBool(it.target?.sleep(it.getRef(0) as Location) == true)
                }
                .function("wakeup", returnsVoid().noParams()) { it.target?.wakeup() }
                .function("shakeHead", returnsVoid().noParams()) { it.target?.shakeHead() }
                .function("zombify",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnZombieVillager.TYPE).noParams()) { it.setReturnRef(it.target?.zombify()) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Villager\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnVillagerType {

    val TYPE = Type.fromClass(Villager.Type::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Villager.Type::class.java)
                .function("key", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Villager\$Profession"])
@PlatformSide(Platform.BUKKIT)
object FnVillagerProfession {

    val TYPE = Type.fromClass(Villager.Profession::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Villager.Profession::class.java)
                .function("key", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
        }
    }
}
