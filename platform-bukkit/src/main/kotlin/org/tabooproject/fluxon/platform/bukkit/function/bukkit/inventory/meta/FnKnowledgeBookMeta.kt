package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.KnowledgeBookMeta
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

@Requires(classes = ["org.bukkit.inventory.meta.KnowledgeBookMeta"])
@PlatformSide(Platform.BUKKIT)
object FnKnowledgeBookMeta {

    val TYPE = Type.fromClass(KnowledgeBookMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(KnowledgeBookMeta::class.java)
                .function("hasRecipes", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasRecipes() ?: false) }
                .function("recipes", returnsObject().noParams()) { it.setReturnRef(it.target?.recipes) }
                .function("setRecipes", returnsVoid().params(Type.OBJECT)) { it.target?.setRecipes(it.getRef(0) as List<NamespacedKey>) }
                .function("addRecipe", returnsVoid().params(Type.OBJECT)) { it.target?.addRecipe(it.getRef(0) as NamespacedKey) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
