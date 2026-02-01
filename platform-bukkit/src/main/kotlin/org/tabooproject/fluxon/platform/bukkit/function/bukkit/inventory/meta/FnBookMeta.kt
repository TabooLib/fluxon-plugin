package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.BookMeta
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

@Requires(classes = ["org.bukkit.inventory.meta.BookMeta"])
@PlatformSide(Platform.BUKKIT)
object FnBookMeta {

    val TYPE = Type.fromClass(BookMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BookMeta::class.java)
                .function("hasTitle", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasTitle() ?: false) }
                .function("title", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.title) }
                .function("setTitle", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.setTitle(it.getString(0)) == true) }
                .function("hasAuthor", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasAuthor() ?: false) }
                .function("author", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.author) }
                .function("setAuthor", returnsVoid().params(Type.STRING)) { it.target?.setAuthor(it.getString(0)) }
                .function("hasGeneration", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasGeneration() ?: false) }
                .function("generation", returnsObject().noParams()) { it.setReturnRef(it.target?.generation) }
                .function("setGeneration", returnsVoid().params(Type.OBJECT)) { it.target?.setGeneration(it.getRef(0) as BookMeta.Generation) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("getPage", returns(Type.STRING).params(Type.I)) { it.setReturnRef(it.target?.getPage(it.getInt(0).toInt())) }
                .function("setPage", returnsVoid().params(Type.I, Type.STRING)) { it.target?.setPage(it.getInt(0).toInt(), it.getString(1)!!) }
                .function("pages", returnsObject().noParams()) { it.setReturnRef(it.target?.pages) }
                .function("setPages", returnsVoid().params(Type.LIST)) {
                    it.target?.setPages(it.getRef(0) as List<String>)
                }
                .function("setPages", returnsVoid().params(Type.OBJECT)) {
                    val pages = it.getRef(0)
                    if (pages is List<*>) {
                        it.target?.setPages(pages as List<String>)
                    } else {
                        it.target?.setPages(*(pages as Array<String>))
                    }
                }
                .function("addPage", returnsVoid().params(Type.OBJECT)) {
                    val pages = it.getRef(0)
                    if (pages is List<*>) {
                        it.target?.addPage(*(pages as List<String>).toTypedArray())
                    } else {
                        it.target?.addPage(*(pages as Array<String>))
                    }
                }
        }
    }
}
