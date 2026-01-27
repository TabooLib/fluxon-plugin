package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.FurnaceRecipe
import org.bukkit.inventory.RecipeChoice
import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.inventory.FurnaceRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceRecipe {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceRecipe::class.java)
                .function("setInput", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is MaterialData -> it.target?.setInput(var1)
                            is Material -> it.target?.setInput(var1)
                            else -> throw IllegalArgumentException("参数必须是 MaterialData 或 Material 类型")
                        }
                    } else {
                        it.target?.setInput(it.getArgument(0) as Material, it.getNumber(1).toInt())
                    }
                }
                .function("setInputChoice", 1) { it.target?.setInputChoice(it.getArgument(0) as RecipeChoice) }
        }
    }
}
