package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.WritableBookMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.WritableBookMeta"])
@PlatformSide(Platform.BUKKIT)
object FnWritableBookMeta {

    val TYPE = Type.fromClass(WritableBookMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WritableBookMeta::class.java)
                .function("hasPages", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasPages() ?: false) }
                .function("getPage", returns(Type.STRING).params(Type.I)) { it.setReturnRef(it.target?.getPage(it.getInt(0).toInt())) }
                .function("setPage", returnsVoid().params(Type.I, Type.STRING)) { it.target?.setPage(it.getInt(0).toInt(), it.getString(1)!!) }
                .function("pages", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.pages) }
                .function("setPages", returnsVoid().params(Type.LIST)) {
                    it.target?.setPages(it.getRef(0) as List<String>)
                }
                .function("setPages", returnsVoid().params(org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY)) { it.target?.setPages(*(it.getRef(0) as Array<String>)) }
                .function("addPage", returnsVoid().params(Type.LIST)) { it.target?.addPage(*(it.getRef(0) as List<String>).toTypedArray()) }
                .function("addPage", returnsVoid().params(org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY)) { it.target?.addPage(*(it.getRef(0) as Array<String>)) }
                .function("pageCount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.pageCount ?: 0) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnWritableBookMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
