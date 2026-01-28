package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.BookMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.BookMeta"])
@PlatformSide(Platform.BUKKIT)
object FnBookMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BookMeta::class.java)
                .function("hasTitle", returns(Type.Z).noParams()) { it.target?.hasTitle() }
                .function("title", returnsObject().noParams()) { it.target?.title }
                .function("setTitle", returnsObject().params(Type.OBJECT)) { it.target?.setTitle(it.getString(0)) }
                .function("hasAuthor", returns(Type.Z).noParams()) { it.target?.hasAuthor() }
                .function("author", returnsObject().noParams()) { it.target?.author }
                .function("setAuthor", returnsObject().params(Type.OBJECT)) { it.target?.setAuthor(it.getString(0)) }
                .function("hasGeneration", returns(Type.Z).noParams()) { it.target?.hasGeneration() }
                .function("generation", returnsObject().noParams()) { it.target?.generation }
                .function("setGeneration", returnsObject().params(Type.OBJECT)) { it.target?.setGeneration(it.getRef(0) as BookMeta.Generation) }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
                .function("getPage", returnsObject().params(Type.OBJECT)) { it.target?.getPage(it.getInt(0).toInt()) }
                .function("setPage", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.setPage(it.getInt(0).toInt(), it.getString(1)!!) }
                .function("pages", returnsObject().noParams()) { it.target?.pages }
                .function("setPages", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.setPages(*(it /* arguments removed */ as Array<String>))
                    } else {
                        it.target?.setPages(it.getRef(0) as List<String>)
                    }
                }
                .function("setPages", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.setPages(*(it /* arguments removed */ as Array<String>))
                    } else {
                        it.target?.setPages(it.getRef(0) as List<String>)
                    }
                }
                .function("addPage", returnsObject().noParams()) { it.target?.addPage(*(it /* arguments removed */ as Array<String>)) }
        }
    }
}
