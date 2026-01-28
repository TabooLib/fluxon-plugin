package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Villager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Villager"])
@PlatformSide(Platform.BUKKIT)
object FnVillager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Villager::class.java)
                .function("profession", returnsObject().noParams()) { it.target?.profession }
                .function("setProfession", returnsObject().params(Type.OBJECT)) { it.target?.setProfession(it.getRef(0) as Villager.Profession) }
                .function("villagerType", returnsObject().noParams()) { it.target?.villagerType }
                .function("setVillagerType", returnsObject().params(Type.OBJECT)) { it.target?.setVillagerType(it.getRef(0) as Villager.Type) }
                .function("villagerLevel", returnsObject().noParams()) { it.target?.villagerLevel }
                .function("setVillagerLevel", returnsObject().params(Type.OBJECT)) { it.target?.setVillagerLevel(it.getInt(0).toInt()) }
                .function("villagerExperience", returnsObject().noParams()) { it.target?.villagerExperience }
                .function("setVillagerExperience", returnsObject().params(Type.OBJECT)) { it.target?.setVillagerExperience(it.getInt(0).toInt()) }
                .function("sleep", returnsObject().params(Type.OBJECT)) { it.target?.sleep(it.getRef(0) as Location) }
                .function("wakeup", returnsObject().noParams()) { it.target?.wakeup() }
                .function("shakeHead", returnsObject().noParams()) { it.target?.shakeHead() }
                .function("zombify", returnsObject().noParams()) { it.target?.zombify() }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Villager.Type"])
@PlatformSide(Platform.BUKKIT)
object FnVillagerType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Villager.Type::class.java)
                .function("key", returnsObject().noParams()) { it.target?.key }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Villager.Profession"])
@PlatformSide(Platform.BUKKIT)
object FnVillagerProfession {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Villager.Profession::class.java)
                .function("key", returnsObject().noParams()) { it.target?.key }
        }
    }
}
