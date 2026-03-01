package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Material
import org.bukkit.entity.Animals
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Animals"])
@PlatformSide(Platform.BUKKIT)
object FnAnimals {

    val TYPE = Type.fromClass(Animals::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Animals::class.java)
                .function("breedCause",returns(org.tabooproject.fluxon.util.StandardTypes.UUID).noParams()) { it.setReturnRef(it.target?.breedCause) }
                .function("setBreedCause", returnsVoid().params(Type.STRING)) { it.target?.setBreedCause(UUID.fromString(it.getString(0))) }
                .function("isLoveMode", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLoveMode ?: false) }
                .function("loveModeTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.loveModeTicks ?: 0) }
                .function("setLoveModeTicks", returnsVoid().params(Type.I)) { it.target?.setLoveModeTicks(it.getInt(0).toInt()) }
                .function("isBreedItem",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is ItemStack -> it.target?.isBreedItem(var1)
                        is Material -> it.target?.isBreedItem(var1)
                        else -> throw IllegalArgumentException("参数必须是 ItemStack 或 Material 类型")
                    } == true)
                }
        }
    }
}
