package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.KnowledgeBookMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnKnowledgeBookMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(KnowledgeBookMeta::class.java)
                .function("hasRecipes", 0) { it.target?.hasRecipes() }
                .function("recipes", 0) { it.target?.recipes }
                .function("setRecipes", 1) { it.target?.setRecipes(it.getArgument(0) as List<NamespacedKey>) }
                .function("addRecipe", 0) { it.target?.addRecipe() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
