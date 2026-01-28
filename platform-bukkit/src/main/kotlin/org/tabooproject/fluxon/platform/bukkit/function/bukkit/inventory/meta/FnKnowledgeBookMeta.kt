package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.KnowledgeBookMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.KnowledgeBookMeta"])
@PlatformSide(Platform.BUKKIT)
object FnKnowledgeBookMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(KnowledgeBookMeta::class.java)
                .function("hasRecipes", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasRecipes()) }
                .function("recipes", returnsObject().noParams()) { it.setReturnRef(it.target?.recipes) }
                .function("setRecipes", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRecipes(it.getRef(0) as List<NamespacedKey>)) }
                .function("addRecipe", returnsObject().noParams()) { it.setReturnRef(it.target?.addRecipe()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
