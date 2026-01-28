package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.WritableBookMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.WritableBookMeta"])
@PlatformSide(Platform.BUKKIT)
object FnWritableBookMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WritableBookMeta::class.java)
                .function("hasPages", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasPages()) }
                .function("getPage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getPage(it.getInt(0).toInt())) }
                .function("setPage", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.setPage(it.getInt(0).toInt(), it.getString(1)!!)) }
                .function("pages", returnsObject().noParams()) { it.setReturnRef(it.target?.pages) }
                .function("setPages", returnsObject().noParams()) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.setPages()
                    } else {
                        it.target?.setPages(it.getRef(0) as List<String>)
                    })
                }
                .function("setPages", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.setPages()
                    } else {
                        it.target?.setPages(it.getRef(0) as List<String>)
                    })
                }
                .function("addPage", returnsObject().noParams()) { it.setReturnRef(it.target?.addPage()) }
                .function("pageCount", returnsObject().noParams()) { it.setReturnRef(it.target?.pageCount) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
